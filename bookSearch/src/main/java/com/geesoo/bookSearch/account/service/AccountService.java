package com.geesoo.bookSearch.account.service;

import org.springframework.stereotype.Service;

import com.geesoo.bookSearch.account.dto.Account;

@Service
public interface AccountService {

	public Account save(Account account);
}
