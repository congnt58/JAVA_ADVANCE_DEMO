package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;
import com.vti.service.IAccountService;

@RestController
@RequestMapping("/v1/api/accounts")
@CrossOrigin("*")
public class AccountController {
	
	@Autowired
	IAccountService acService;

	public AccountController() {
		
	}

	@GetMapping
	public Page<Account> getAll(Pageable pageable, AccountFillter fillter) {

		Page<Account> accounts = acService.getAll(pageable, fillter);

		String logString = pageable.toString();
		System.out.println("pageable = " + logString);

		return accounts;
	}

	@GetMapping("/{id}")
	public Account getAccountById(@PathVariable(value = "id") int id) {
		// Account account = acService.getAccountById(id);
		return null;
	}

	@PostMapping
	public Account createAccount(@RequestBody() CreateAccountForm form) {
		Account account = acService.createAccount(form.convertToAccount());
		return account;
	}
	
	
	@PutMapping(value = "/{id}")
	public Object updateAccount( @PathVariable(value = "id") int id, @RequestBody() CreateAccountForm form) {
		Account account = acService.updateAccount(id, form);
		
		if (account == null) {
			return "Update account that bai";
		}
		return account;
	}
	

}
