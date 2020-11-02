package com.cyberup.framework.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

public class WiredTransactionStatus implements TransactionStatus {
	List<TransactionStatus> statusList = new ArrayList<TransactionStatus>();

	private boolean newTransaction;

	private boolean rollbackOnly;

	public boolean hasSavepoint() {
		Logger.getLogger(this.getClass()).debug("hasSavepoint()");
		
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCompleted() {
		Logger.getLogger(this.getClass()).debug("isCompleted()");
		
		for (TransactionStatus status : statusList) {
			if (!status.isRollbackOnly()) {
				return false;
			}
		}
		
		return true;
	}

	public boolean isNewTransaction() {
		Logger.getLogger(this.getClass()).debug("isNewTransaction()");
		
		return newTransaction;
	}

	public boolean isRollbackOnly() {
		Logger.getLogger(this.getClass()).debug("isRollbackOnly()");
		
		return (isLocalRollbackOnly() || isGlobalRollbackOnly());
	}

	/**
	 * Determine the rollback-only flag via checking this TransactionStatus.
	 * <p>Will only return "true" if the application called <code>setRollbackOnly</code>
	 * on this TransactionStatus object.
	 */
	public boolean isLocalRollbackOnly() {
		Logger.getLogger(this.getClass()).debug("isLocalRollbackOnly()");
		
		return this.rollbackOnly;
	}

	/**
	 * Template method for determining the global rollback-only flag of the
	 * underlying transaction, if any.
	 */
	public boolean isGlobalRollbackOnly() {
		Logger.getLogger(this.getClass()).debug("isGlobalRollbackOnly()");
		
		for (TransactionStatus status : statusList) {
			if (status.isRollbackOnly()) {
				return true;
			}
		}
		
		return false;
	}

	public void setRollbackOnly() {
		Logger.getLogger(this.getClass()).debug("setRollbackOnly()");
		
		this.rollbackOnly = true;
	}

	public Object createSavepoint() throws TransactionException {
		Logger.getLogger(this.getClass()).debug("createSavepoint()");
		
		// TODO Auto-generated method stub
		return null;
	}

	public void releaseSavepoint(Object savepoint) throws TransactionException {
		Logger.getLogger(this.getClass()).debug("releaseSavepoint("+savepoint+")");
		
		// TODO Auto-generated method stub

	}

	public void rollbackToSavepoint(Object savepoint)
			throws TransactionException {
		Logger.getLogger(this.getClass()).debug("rollbackToSavepoint("+savepoint+")");
		
		// TODO Auto-generated method stub

	}

	/**
	 * 새로운 TransactionStatus를 추가합니다.
	 * 
	 * @param subStatus transaction status 정보
	 */
	public void addSubTransactionStatus(TransactionStatus subStatus) {
		Logger.getLogger(this.getClass()).debug("addSubTransactionStatus("+subStatus+")");
		
		statusList.add(0, subStatus);
	}

	/**
	 * 원하는 위치에 있는 transaction status 정보를 알려줍니다.
	 * 
	 * @param index status가 있는 위치. 0-base
	 * @return transaction status 정보
	 */
	public TransactionStatus getTransactionStatus(int index) {
		Logger.getLogger(this.getClass()).debug("getTransactionStatus("+index+")");
		
		return statusList.get(index);
	}

	public void flush() {
		Logger.getLogger(this.getClass()).debug("flush()");
		
		for (TransactionStatus status : statusList) {
			status.flush();
		}
	}
}
