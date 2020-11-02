package com.cyberup.service.admin;

import java.util.List;
import java.util.Properties;

import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.InvalidIsolationLevelException;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.jta.JtaTransactionObject;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;

public class TestJtaTransactionManager extends JtaTransactionManager {

	@Override
	public void afterPropertiesSet() throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("afterPropertiesSet");
		super.afterPropertiesSet();
	}

	@Override
	protected void applyIsolationLevel(JtaTransactionObject txObject,
			int isolationLevel) throws InvalidIsolationLevelException,
			SystemException {
		Logger.getLogger(this.getClass()).debug("applyIsolationLevel");
		// TODO Auto-generated method stub
		super.applyIsolationLevel(txObject, isolationLevel);
	}

	@Override
	protected void applyTimeout(JtaTransactionObject txObject, int timeout)
			throws SystemException {
		Logger.getLogger(this.getClass()).debug("applyTimeout");
		// TODO Auto-generated method stub
		super.applyTimeout(txObject, timeout);
	}

	@Override
	protected UserTransaction buildUserTransaction(
			TransactionManager transactionManager) {
		Logger.getLogger(this.getClass()).debug("buildUserTransaction");
		// TODO Auto-generated method stub
		return super.buildUserTransaction(transactionManager);
	}

	@Override
	protected void checkUserTransactionAndTransactionManager()
			throws IllegalStateException {
		Logger.getLogger(this.getClass()).debug("checkUserTransactionAndTransactionManager");
		// TODO Auto-generated method stub
		super.checkUserTransactionAndTransactionManager();
	}

	@Override
	public Transaction createTransaction(String name, int timeout)
			throws NotSupportedException, SystemException {
		Logger.getLogger(this.getClass()).debug("createTransaction");
		// TODO Auto-generated method stub
		return super.createTransaction(name, timeout);
	}

	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition) {
		Logger.getLogger(this.getClass()).debug("doBegin");
		// TODO Auto-generated method stub
		super.doBegin(transaction, definition);
	}

	@Override
	protected void doCommit(DefaultTransactionStatus status) {
		Logger.getLogger(this.getClass()).debug("doCommit");
		// TODO Auto-generated method stub
		super.doCommit(status);
	}

	@Override
	protected JtaTransactionObject doGetJtaTransaction(UserTransaction ut) {
		Logger.getLogger(this.getClass()).debug("doGetJtaTransaction");
		// TODO Auto-generated method stub
		return super.doGetJtaTransaction(ut);
	}

	@Override
	protected Object doGetTransaction() {
		Logger.getLogger(this.getClass()).debug("doGetTransaction");
		return super.doGetTransaction();
	}

	@Override
	protected void doJtaBegin(JtaTransactionObject txObject,
			TransactionDefinition definition) throws NotSupportedException,
			SystemException {
		Logger.getLogger(this.getClass()).debug("doJtaBegin");
		// TODO Auto-generated method stub
		super.doJtaBegin(txObject, definition);
	}

	@Override
	protected void doJtaResume(JtaTransactionObject txObject,
			Object suspendedTransaction) throws InvalidTransactionException,
			SystemException {
		Logger.getLogger(this.getClass()).debug("doJtaResume");
		// TODO Auto-generated method stub
		super.doJtaResume(txObject, suspendedTransaction);
	}

	@Override
	protected Object doJtaSuspend(JtaTransactionObject txObject)
			throws SystemException {
		Logger.getLogger(this.getClass()).debug("doJtaSuspend");
		// TODO Auto-generated method stub
		return super.doJtaSuspend(txObject);
	}

	@Override
	protected void doRegisterAfterCompletionWithJtaTransaction(
			JtaTransactionObject txObject,
			List<TransactionSynchronization> synchronizations)
			throws RollbackException, SystemException {
		Logger.getLogger(this.getClass()).debug("doRegisterAfterCompletionWithJtaTransaction");
		// TODO Auto-generated method stub
		super.doRegisterAfterCompletionWithJtaTransaction(txObject, synchronizations);
	}

	@Override
	protected void doResume(Object transaction, Object suspendedResources) {
		Logger.getLogger(this.getClass()).debug("doResume");
		// TODO Auto-generated method stub
		super.doResume(transaction, suspendedResources);
	}

	@Override
	protected void doRollback(DefaultTransactionStatus status) {
		Logger.getLogger(this.getClass()).debug("doRollback");
		// TODO Auto-generated method stub
		super.doRollback(status);
	}

	@Override
	protected void doSetRollbackOnly(DefaultTransactionStatus status) {
		Logger.getLogger(this.getClass()).debug("doSetRollbackOnly");
		// TODO Auto-generated method stub
		super.doSetRollbackOnly(status);
	}

	@Override
	protected Object doSuspend(Object transaction) {
		Logger.getLogger(this.getClass()).debug("doSuspend");
		// TODO Auto-generated method stub
		return super.doSuspend(transaction);
	}

	@Override
	protected TransactionManager findTransactionManager(UserTransaction ut) {
		Logger.getLogger(this.getClass()).debug("findTransactionManager");
		// TODO Auto-generated method stub
		return super.findTransactionManager(ut);
	}

	@Override
	protected Object findTransactionSynchronizationRegistry(UserTransaction ut,
			TransactionManager tm) throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("findTransactionSynchronizationRegistry");
		// TODO Auto-generated method stub
		return super.findTransactionSynchronizationRegistry(ut, tm);
	}

	@Override
	protected UserTransaction findUserTransaction() {
		Logger.getLogger(this.getClass()).debug("findUserTransaction");
		// TODO Auto-generated method stub
		return super.findUserTransaction();
	}

	@Override
	public Properties getJndiEnvironment() {
		Logger.getLogger(this.getClass()).debug("getJndiEnvironment");
		// TODO Auto-generated method stub
		return super.getJndiEnvironment();
	}

	@Override
	public JndiTemplate getJndiTemplate() {
		Logger.getLogger(this.getClass()).debug("getJndiTemplate");
		// TODO Auto-generated method stub
		return super.getJndiTemplate();
	}

	@Override
	public TransactionManager getTransactionManager() {
		Logger.getLogger(this.getClass()).debug("getTransactionManager");
		// TODO Auto-generated method stub
		return super.getTransactionManager();
	}

	@Override
	public UserTransaction getUserTransaction() {
		Logger.getLogger(this.getClass()).debug("getUserTransaction");
		// TODO Auto-generated method stub
		return super.getUserTransaction();
	}

	@Override
	protected void initTransactionSynchronizationRegistry() {
		Logger.getLogger(this.getClass()).debug("initTransactionSynchronizationRegistry");
		// TODO Auto-generated method stub
		super.initTransactionSynchronizationRegistry();
	}

	@Override
	protected void initUserTransactionAndTransactionManager()
			throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("initUserTransactionAndTransactionManager");
		// TODO Auto-generated method stub
		super.initUserTransactionAndTransactionManager();
	}

	@Override
	protected boolean isExistingTransaction(Object transaction) {
		Logger.getLogger(this.getClass()).debug("isExistingTransaction");
		// TODO Auto-generated method stub
		return super.isExistingTransaction(transaction);
	}

	@Override
	protected TransactionManager lookupTransactionManager(
			String transactionManagerName) throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("lookupTransactionManager");
		// TODO Auto-generated method stub
		return super.lookupTransactionManager(transactionManagerName);
	}

	@Override
	protected Object lookupTransactionSynchronizationRegistry(
			String registryName) throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("lookupTransactionSynchronizationRegistry");
		// TODO Auto-generated method stub
		return super.lookupTransactionSynchronizationRegistry(registryName);
	}

	@Override
	protected UserTransaction lookupUserTransaction(String userTransactionName)
			throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("lookupUserTransaction");
		// TODO Auto-generated method stub
		return super.lookupUserTransaction(userTransactionName);
	}

	@Override
	protected void registerAfterCompletionWithExistingTransaction(
			Object transaction,
			List<TransactionSynchronization> synchronizations) {
		Logger.getLogger(this.getClass()).debug("registerAfterCompletionWithExistingTransaction");
		// TODO Auto-generated method stub
		super.registerAfterCompletionWithExistingTransaction(transaction,
				synchronizations);
	}

	@Override
	protected TransactionManager retrieveTransactionManager()
			throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("retrieveTransactionManager");
		// TODO Auto-generated method stub
		return super.retrieveTransactionManager();
	}

	@Override
	protected Object retrieveTransactionSynchronizationRegistry()
			throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("retrieveTransactionSynchronizationRegistry");
		// TODO Auto-generated method stub
		return super.retrieveTransactionSynchronizationRegistry();
	}

	@Override
	protected UserTransaction retrieveUserTransaction()
			throws TransactionSystemException {
		Logger.getLogger(this.getClass()).debug("retrieveUserTransaction");
		// TODO Auto-generated method stub
		return super.retrieveUserTransaction();
	}

	@Override
	public void setAllowCustomIsolationLevels(boolean allowCustomIsolationLevels) {
		Logger.getLogger(this.getClass()).debug("setAllowCustomIsolationLevels");
		// TODO Auto-generated method stub
		super.setAllowCustomIsolationLevels(allowCustomIsolationLevels);
	}

	@Override
	public void setAutodetectTransactionManager(
			boolean autodetectTransactionManager) {
		Logger.getLogger(this.getClass()).debug("setAutodetectTransactionManager");
		// TODO Auto-generated method stub
		super.setAutodetectTransactionManager(autodetectTransactionManager);
	}

	@Override
	public void setAutodetectUserTransaction(boolean autodetectUserTransaction) {
		Logger.getLogger(this.getClass()).debug("setAutodetectUserTransaction");
		// TODO Auto-generated method stub
		super.setAutodetectUserTransaction(autodetectUserTransaction);
	}

	@Override
	public void setCacheUserTransaction(boolean cacheUserTransaction) {
		Logger.getLogger(this.getClass()).debug("setCacheUserTransaction");
		// TODO Auto-generated method stub
		super.setCacheUserTransaction(cacheUserTransaction);
	}

	@Override
	public void setJndiEnvironment(Properties jndiEnvironment) {
		Logger.getLogger(this.getClass()).debug("setJndiEnvironment");
		// TODO Auto-generated method stub
		super.setJndiEnvironment(jndiEnvironment);
	}

	@Override
	public void setJndiTemplate(JndiTemplate jndiTemplate) {
		Logger.getLogger(this.getClass()).debug("setJndiTemplate");
		// TODO Auto-generated method stub
		super.setJndiTemplate(jndiTemplate);
	}

	@Override
	public void setTransactionManager(TransactionManager transactionManager) {
		Logger.getLogger(this.getClass()).debug("setTransactionManager");
		// TODO Auto-generated method stub
		super.setTransactionManager(transactionManager);
	}

	@Override
	public void setTransactionManagerName(String transactionManagerName) {
		Logger.getLogger(this.getClass()).debug("setTransactionManagerName");
		// TODO Auto-generated method stub
		super.setTransactionManagerName(transactionManagerName);
	}

	@Override
	public void setTransactionSynchronizationRegistryName(
			String transactionSynchronizationRegistryName) {
		Logger.getLogger(this.getClass()).debug("setTransactionSynchronizationRegistryName");
		// TODO Auto-generated method stub
		super.setTransactionSynchronizationRegistryName(transactionSynchronizationRegistryName);
	}

	@Override
	public void setUserTransaction(UserTransaction userTransaction) {
		Logger.getLogger(this.getClass()).debug("setUserTransaction");
		// TODO Auto-generated method stub
		super.setUserTransaction(userTransaction);
	}

	@Override
	public void setUserTransactionName(String userTransactionName) {
		Logger.getLogger(this.getClass()).debug("setUserTransactionName");
		// TODO Auto-generated method stub
		super.setUserTransactionName(userTransactionName);
	}

	@Override
	protected boolean shouldCommitOnGlobalRollbackOnly() {
		Logger.getLogger(this.getClass()).debug("shouldCommitOnGlobalRollbackOnly");
		// TODO Auto-generated method stub
		return super.shouldCommitOnGlobalRollbackOnly();
	}

	@Override
	public boolean supportsResourceAdapterManagedTransactions() {
		Logger.getLogger(this.getClass()).debug("supportsResourceAdapterManagedTransactions");
		// TODO Auto-generated method stub
		return super.supportsResourceAdapterManagedTransactions();
	}

	@Override
	protected boolean useSavepointForNestedTransaction() {
		Logger.getLogger(this.getClass()).debug("useSavepointForNestedTransaction");
		// TODO Auto-generated method stub
		return super.useSavepointForNestedTransaction();
	}

}
