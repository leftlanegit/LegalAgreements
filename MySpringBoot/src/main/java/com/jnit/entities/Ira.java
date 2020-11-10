package com.jnit.entities;

import java.math.BigInteger;

import com.jnit.entities.Customer;

public class Ira extends Customer {
	private String iraCustodian;
	private String iraAccno;
	private BigInteger iraId;
	public String getIraCustodian() {
		return iraCustodian;
	}
	public void setIraCustodian(String iraCustodian) {
		this.iraCustodian = iraCustodian;
	}
	public String getIraAccno() {
		return iraAccno;
	}
	public void setIraAccno(String iraAccno) {
		this.iraAccno = iraAccno;
	}
	public BigInteger getIraId() {
		return iraId;
	}
	public void setIraid(BigInteger iraid) {
		this.iraId = iraId;
	}
	
	

}
