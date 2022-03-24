package com.vti.datalayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Account;
import com.vti.entity.fillter.AccountFillter;
import com.vti.entity.form.CreateAccountForm;
import com.vti.untils.HibernateUntil;

@Repository
public class AccountRepository {

	public List<Account> getAll(int page, int size, AccountFillter fillter) {

		Session session = null;

		try {
			session = HibernateUntil.getFactory().openSession();

			String hql = "FROM Account a";
			

			if (fillter.getUsername() != null && fillter.getEmail() != null) {
				hql = String.format("FROM Account a WHERE a.username = '%s' ", fillter.getUsername());
				hql += "OR a.email LIKE '%" + fillter.getEmail() +"%'";
			} else if (fillter.getUsername() != null) {
				hql = String.format("FROM Account a WHERE a.username = '%s'", fillter.getUsername());
			} else if (fillter.getEmail() != null) {
				//hql = String.format("FROM Account a WHERE a.email LIKE %s", fillter.getEmail());
				hql = "FROM Account a WHERE a.email LIKE '%" + fillter.getEmail() +"%'";
			}
			
			System.err.println( String.format("HQL=> %s ", hql));
			
			int offset = (page - 1) * size;

			Query<Account> query = session.createQuery(hql, Account.class);

			query.setFirstResult(offset);
			query.setMaxResults(size);

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account createAccount(Account account) {
		Session session = null;

		try {
			session = HibernateUntil.getFactory().openSession();
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
			return account;
		}finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	public Account updateAccount(int id, CreateAccountForm account) {
		Session session = null;

		try {
			session = HibernateUntil.getFactory().openSession();
			Account accountUpdate = session.get(Account.class, id);
			if (accountUpdate == null) {
				return null; // khong tim thay id thi return null
			}
			
			session.beginTransaction();
			
			if (account.getEmail() != null) {
				accountUpdate.setEmail(account.getEmail());
			}
			if(account.getFullname() != null) {
				accountUpdate.setFullName(account.getFullname());
			}
			if (account.getUsername() != null) {
				accountUpdate.setUsername(account.getUsername());
			}
			
			session.save(accountUpdate);
			session.getTransaction().commit();
			return accountUpdate;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
