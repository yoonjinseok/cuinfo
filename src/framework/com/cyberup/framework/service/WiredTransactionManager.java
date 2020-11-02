package com.cyberup.framework.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionInterceptor;

public class WiredTransactionManager implements PlatformTransactionManager, InitializingBean {
	protected List<PlatformTransactionManager> transactionManagers;
//	protected List<PlatformTransactionManager> reversed;

	/**
	 * TransactionManager 목록을 설정합니다. 이 때 commit이나 rollback을 위해서는
	 * transaction을 시작한 순서와는 반대로 해야 하기 때문에 reverse된 목록이 필요합니다.
	 *
	 * @param transactionManagers TransactionManager 목록
	 */
	public void setTransactionManagers(
			List<PlatformTransactionManager> transactionManagers) {
		this.transactionManagers = transactionManagers;
		
		System.out.println("transactionManagers : " + this.transactionManagers);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		Logger.getLogger(this.getClass()).debug("afterPropertiesSet()");
		
		if (this.transactionManagers == null || this.transactionManagers.size() == 0) {
			throw new IllegalArgumentException("Property 'transactionManagers' is required");
		}
	}

	/**
	 * 모든 TransactionManager들에게 commit을 시작하라는 명령을 내립니다.
	 * <p>
	 * commit을 수행하기 전 rollback이 되는 transaction이 있으면
	 * 모든 transaction을 rollback이 수행되도록 합니다.
	 *
	 * @see org.springframework.transaction.PlatformTransactionManager#commit(org.springframework.transaction.TransactionStatus)
	 */
	public void commit(TransactionStatus status) throws TransactionException {
		Logger.getLogger(this.getClass()).debug("commit(" + status + ")");
		
		try {
			WiredTransactionStatus wiredTransactionStatus = (WiredTransactionStatus) status;

			if (wiredTransactionStatus.isRollbackOnly()) {
				rollback(wiredTransactionStatus);
				Logger.getLogger(this.getClass()).debug("commit(" + status + ") rollback success.");
				return;
			}

			PlatformTransactionManager subTransactionManager = null;

			for (int index = 0; index < transactionManagers.size(); index = index + 1) {
				subTransactionManager = transactionManagers.get(index);
				subTransactionManager.commit(wiredTransactionStatus.getTransactionStatus(index));
			}
			
			Logger.getLogger(this.getClass()).debug("commit(" + status + ") success.");
		} catch (TransactionException e) {
			Logger.getLogger(this.getClass()).debug("commit(" + status + ") failed!");
			throw e;
		}
	}

	/**
	 * transaction을 시작합니다.
	 * <p>
	 * 모든 TransactionManager들에게 transaction을 시작하라는 명령을 내립니다.
	 * 각각의 PlatformTransactionManager는 트랜젝션에 대한 상태를 나타내는 객체를
	 * 리턴하게 되는데, 이 정보들을 담기 위해 {@link WiredTransactionStatus}를
	 * 생성한 후, 각각의 TransactionManager들이 생성한 transaction status 정보를
	 * 담아 {@link TransactionInterceptor}로 넘겨줍니다.
	 *
	 * @see org.springframework.transaction.PlatformTransactionManager#getTransaction(org.springframework.transaction.TransactionDefinition)
	 */
	public TransactionStatus getTransaction(TransactionDefinition definition)
			throws TransactionException {
		Logger.getLogger(this.getClass()).debug("getTransaction(" + definition + ")");
		
		WiredTransactionStatus status = new WiredTransactionStatus();

		for (PlatformTransactionManager transactionManager : transactionManagers) {
			TransactionStatus subStatus = transactionManager
					.getTransaction(definition);
			status.addSubTransactionStatus(subStatus);
		}

		return status;
	}

	/**
	 * 모든 TransactionManager들에게 rollback을 시도하라는 명령을 내립니다.
	 * <p>
	 * n번째 rollback이 실패해도 나머지 rollback이 무사히 수행될 수 있도록
	 * 하위 TransactionManager에서 실행하는 rollback 메소드는 try문으로 보호되어 있습니다.
	 *
	 * @see org.springframework.transaction.PlatformTransactionManager#rollback(org.springframework.transaction.TransactionStatus)
	 */
	public void rollback(TransactionStatus status) throws TransactionException {
		Logger.getLogger(this.getClass()).debug("rollback(" + status+ ")");
		
		WiredTransactionStatus wiredTransactionStatus = (WiredTransactionStatus) status;

		PlatformTransactionManager subTransactionManager = null;
		TransactionException reserved = null;

		for (int index = 0; index < transactionManagers.size(); index = index + 1) {
			subTransactionManager = transactionManagers.get(index);

			try {
				subTransactionManager.rollback(wiredTransactionStatus.getTransactionStatus(index));
			} catch (TransactionException te) {
				reserved = te;
			}
		}

		if (reserved != null) {
			Logger.getLogger(this.getClass()).debug("rollback(" + status+ ") failed!");
			throw reserved;
		}
		
		Logger.getLogger(this.getClass()).debug("rollback(" + status+ ") success.");
	}
}
