package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.datalayer.AccountRepositoryV2;
import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;

@Service
public class AccountService implements IAccountService{
	
	@Autowired
	AccountRepositoryV2 repository;
	
	public AccountService() {
		
	}

	public Page<Account> getAll(Pageable pageable, AccountFillter fillter) {
		if (fillter.getUsername() != null || fillter.getEmail() != null  ) {
			return repository.findAllByUsernameOrEmail(pageable, fillter.getUsername(), fillter.getEmail());
		}
		
		return repository.findAll(pageable);
	}

	
	@Override
	public Account createAccount(Account account) {
//		return repository.createAccount(account);
		return null;
	}

	@Override
	public Account updateAccount(int id, CreateAccountForm account) {
//		return repository.updateAccount(id, account);
		return null;
	}
}
