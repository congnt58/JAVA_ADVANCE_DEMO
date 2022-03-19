package com.vti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;
import com.vti.service.AccountService;

@RestController
@RequestMapping("/v1/api/accounts")
@CrossOrigin("*")
public class AccountController {
	AccountService acService;

	public AccountController() {
		acService = new AccountService();
	}

	@GetMapping
	public List<Account> getAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "20") int size, AccountFillter fillter) {

		List<Account> accounts = acService.getAll(page, size, fillter);

//		String logString = String.format("Get all account Page = %d, Size = %d , username = %s , email = %s",
//				page, size, fillter.getUsername(), fillter.getEmail());

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
	
	

}
