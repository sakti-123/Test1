package com.rs.fer.main;

import java.util.Iterator;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.service.FerService;

public class ExpenseReportMain {

	public static void main(String[] args) {
		FerService ferService = new FERServiceImpl();
		List<Expense> expenses = ferService.expenseReport(1, "Grocery", "29/10/2019", "30/11/2019");
		Iterator<Expense> iterator = expenses.iterator();
		Expense expense1 = null;
		while (iterator.hasNext()) {
			expense1 = iterator.next();
			System.out.println("expense id: " + expense1.getId() + ", expense type: " + expense1.getType() + ", date: "
					+ expense1.getDate() + ", price: " + expense1.getPrice() + ", no of items: "
					+ expense1.getNumberOfItems() + ", by whom: " + expense1.getByWhom());
		}
	}
}
