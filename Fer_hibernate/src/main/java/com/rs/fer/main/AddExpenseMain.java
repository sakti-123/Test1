package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.service.FerService;

public class AddExpenseMain {

	public static void main(String[] args) {

		FerService ferservice = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setByWhom("sakti");
		expense.setDate("29/11/2019");
		expense.setNumberOfItems(10);
		expense.setType("Fooding");
		expense.setPrice(5000);
		expense.setTotal(5500);
		expense.setUserId(1);

		boolean isExpenseAdded = ferservice.addExpense(expense);

		if (isExpenseAdded) {
			System.out.println("Expense Added Successfully...");
		} else {
			System.out.println("Expense Addition Failed.Please Try Again...");
		}

	}

}
