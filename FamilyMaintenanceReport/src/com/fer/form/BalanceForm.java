package com.fer.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class BalanceForm extends ActionForm {

	private String actionType;
	private float amount;
	private Date date;
	private String type;

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
