package com.rs.fer.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements FerService {

	public boolean registration(User user) {

		int noOfRecInserted = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			noOfRecInserted = (Integer) session.save(user);
			transaction.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return noOfRecInserted > 0;
	}

	public boolean login(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User u where u.username = ? and u.password = ?");
			query.setParameter(0, username);
			query.setParameter(1, password);

			List list = query.list();
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {

				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public boolean addExpense(Expense expense) {
		return saveOrEditExpense(expense);
	}

	private boolean saveOrEditExpense(Expense expense) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(expense);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public boolean editExpense(Expense expense) {
		return saveOrEditExpense(expense);
	}

	public boolean deleteExpense(int expenseId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Expense expense = (Expense) session.load(Expense.class, new Integer(expenseId));
			session.delete(expense);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = (User) session.load(User.class, userId);
			if (currentPassword.equals(user.getPassword())) {
				user.setPassword(newPassword);
				transaction.commit();
				return true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public Expense getExpense(int expenseId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Expense expense = null;
		try {
			transaction = session.beginTransaction();
			expense = (Expense) session.load(Expense.class, expenseId);
			System.out.println(" expense type: " + expense.getType() + ", date: " + expense.getDate() + ", price: "
					+ expense.getPrice() + ", no of items: " + expense.getNumberOfItems() + ", total: "
					+ expense.getTotal() + " by whom: " + expense.getByWhom());

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return expense;
	}

	public List<Expense> getExpenses(int userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Expense e where e.userId=?");
			query.setParameter(0, userId);

			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return expenses;
	}

	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Expense> expenseReport = new ArrayList<Expense>();
		try {
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from Expense e where e.userId = ? and e.type = ? and e.date between ? and ?");
			query.setParameter(0, userId);
			query.setParameter(1, expenseType);
			query.setParameter(2, fromDate);
			query.setParameter(3, toDate);

			return query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return expenseReport;
	}

	public User getPersonalInfo(int userId) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		User user = null;

		try {
			transaction = session.beginTransaction();

			user = (User) session.get(User.class, userId);
			Address address = user.getAddress();
			System.out.println(user.getFirstName() + ", " + user.getMiddleName() + ", " + user.getEmail() + ", "
					+ user.getMobile() + ", " + user.getEmail() + ", " + user.getUsername() + ", " + user.getPassword()
					+ ", " + address.getId() + ", " + address.getLineOne() + ", " + address.getLineTwo() + " , "
					+ address.getCity() + ", " + address.getState() + ", " + address.getZip());
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	public boolean updatePersonalInfo(User user) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

}
