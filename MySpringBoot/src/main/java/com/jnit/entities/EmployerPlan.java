package com.jnit.entities;

import com.jnit.entities.Customer;

public class EmployerPlan extends Customer{
	private String planName;
	private String planId;
	private String planSponsor;
	private String planCustodian;
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanSponsor() {
		return planSponsor;
	}
	public void setPlanSponsor(String planSponsor) {
		this.planSponsor = planSponsor;
	}
	public String getPlanCustodian() {
		return planCustodian;
	}
	public void setPlanCustodian(String planCustodian) {
		this.planCustodian = planCustodian;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	
	

}
