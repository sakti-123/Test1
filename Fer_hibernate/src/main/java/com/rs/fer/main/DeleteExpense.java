package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.service.FerService;

public class DeleteExpense {
	public static void main(String[] args) {
		FerService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		boolean isDeleted = ferService.deleteExpense(4);
		if (isDeleted) {
			System.out.println("Expense Deleted Successfully...");
		} else {
			System.out.println("Delete Operation failded.Try again...");
		}
	}
}
