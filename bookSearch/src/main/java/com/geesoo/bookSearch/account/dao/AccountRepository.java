package com.geesoo.bookSearch.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geesoo.bookSearch.account.dto.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{
	public Account findByuserName(String username);

}
