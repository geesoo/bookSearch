package com.geesoo.bookSearch.account.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geesoo.bookSearch.account.dao.AccountRepository;
import com.geesoo.bookSearch.account.dto.Account;
import com.geesoo.bookSearch.account.service.AccountService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByuserName(username);
		List<GrantedAuthority> authorities = new ArrayList<>(); 
		authorities.add(new	SimpleGrantedAuthority(account.getRole())); 
		
		return new User(account.getUserName(),account.getPassWord(),authorities);
	}

	@Override
	public Account save(Account account) {
		account.setPassWord(passwordEncoder.encode(account.getPassWord()));
		return accountRepository.save(account);
	}

}
