package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;

public interface IAccountService {
	public Page<Account> getAll(Pageable pageable, AccountFillter fillter);

	Account createAccount(Account account);

	Account updateAccount(int id, CreateAccountForm account);
}
