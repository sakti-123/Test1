package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.service.FerService;

public class EditExpense {

	public static void main(String[] args) {
		FerService ferservice = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setByWhom("sakti");
		expense.setDate("30/10/2019");
		expense.setNumberOfItems(15);
		expense.setType("Grocery");
		expense.setPrice(1000);
		expense.setTotal(1200);
		expense.setId(1);
		expense.setUserId(1);

		boolean isExpenseEdited = ferservice.addExpense(expense);

		if (isExpenseEdited) {
			System.out.println("Expense Edited Successfully...");
		} else {
			System.out.println("Edit Operation Failed.Please Try Again...");
		}

	}

}