package com.clsa.web.domain;

import java.io.Serializable;

public class TransactionInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum Status{FAIL,SUCCESS,NOT_FOUND}
	Status transactionStatus;
	
	String accountId;
	int withdraw;
	int balanca;
	
	public Status getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(Status transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public int getBalanca() {
		return balanca;
	}
	public void setBalanca(int balanca) {
		this.balanca = balanca;
	}
	
	
	
}
