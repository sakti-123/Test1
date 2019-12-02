package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FerService {

	boolean registration(User user);

	boolean login(String username, String password);

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean deleteExpense(int expenseid);

	boolean resetPassword(int userid, String currentPassword, String newPassword);

	Expense getExpense(int expenseid);

	List<Expense> getExpenses(int userid);

	List<Expense> expenseReport(int userid, String expensetype, String fromDate, String toDate);

	User getPersonalInfo(int userid);

	boolean updatePersonalInfo(User user);

}
