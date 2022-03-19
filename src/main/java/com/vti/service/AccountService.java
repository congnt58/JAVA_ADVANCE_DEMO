package com.vti.service;

import java.util.List;

import com.vti.datalayer.AccountRepository;
import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;

public class AccountService {
	AccountRepository repository;
	
	public AccountService() {
		repository = new AccountRepository();
	}

	public List<Account> getAll(int page, int size, AccountFillter fillter) {
		
		return repository.getAll(page, size, fillter);
	}

	
	public Account createAccount(Account account) {
		return repository.createAccount(account);
	}
}
