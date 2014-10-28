package com.clsa.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clsa.web.domain.Account;
import com.clsa.web.domain.TransactionInfo;
import com.clsa.web.domain.TransactionInfo.Status;
import com.clsa.web.services.interfaces.IService;

@Service
public class ServiceImplement implements IService {

	public static List<Account> accounts = getFromDatabase();

	@Override
	public TransactionInfo withdraw(String username, int withdraw) {
		TransactionInfo info = new TransactionInfo();
		for (Account account : accounts) {
			if (search(username)!=null) {
				if (account.getBalance() >= withdraw) {
					int remain = account.getBalance() - withdraw;
					info.setBalanca(remain);
					info.setTransactionStatus(Status.SUCCESS);
					info.setWithdraw(withdraw);
					info.setAccountId(username);
					search(username).setBalance(remain);
					return info;
				} else {
					info.setBalanca(account.getBalance());
					info.setTransactionStatus(Status.FAIL);
					info.setWithdraw(withdraw);
					info.setAccountId(username);
					return info;
				}
			}
		}
		info.setBalanca(0);
		info.setTransactionStatus(Status.NOT_FOUND);
		info.setWithdraw(0);
		info.setAccountId(null);
		return info;
	}

	private static List<Account> getFromDatabase() {
		
		List<Account> tempAccounts = new ArrayList<Account>();
		Account account = new Account();
		account.setBalance(1000000);
		account.setFullname("Ly Thuong Kiet");
		account.setUsername("user1");
		account.setPassword("user1");
		tempAccounts.add(account);
		return tempAccounts;
	}

	@Override
	public Account search(String username) {
	
		for (Account account : accounts) {
			if (account.getUsername().equals(username)) {
				return account;
			}
		}
		return null;
	}
}
