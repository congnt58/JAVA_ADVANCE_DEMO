package com.vti.datalayer;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Account;

@Repository
@Primary
public interface AccountRepositoryV2 extends JpaRepository<Account, Integer> {

	Account findByUsername(String username);

	List<Account> findAllByUsername(String username);

	Page<Account> findAllByUsernameOrEmail(Pageable pageable, String username, String email);


}
