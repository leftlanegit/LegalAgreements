package com.jnit.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Customer {
	
	private int clientId;
	private boolean employerPlanning;
	private boolean irat;
	private boolean basicPlan;
	private boolean signaturePlan;
	private boolean preminumPlan;
	private String noticeDeliveryAdd;
	private String county;
	private String clientName;
	private String signature;
	private String address;
	private String email;
	private List<EmployerPlan> employerPlan;
	private List<Ira> ira;
	private String by;
	private String name;
	private String title;
	private SimpleDateFormat timeFormatter = new SimpleDateFormat("MM-dd-yyyy");

	public String getCurrentDate() {
		Date date = new Date();
		return timeFormatter.format(date);
	}

	public boolean isEmployerPlanning() {
		return employerPlanning;
	}

	public void setEmployerPlanning(boolean employerPlanning) {
		this.employerPlanning = employerPlanning;
	}

	public boolean isIrat() {
		return irat;
	}

	public void setIrat(boolean irat) {
		this.irat = irat;
	}

	public boolean isBasicPlan() {
		return basicPlan;
	}

	public void setBasicPlan(boolean basicPlan) {
		this.basicPlan = basicPlan;
	}

	public boolean isSignaturePlan() {
		return signaturePlan;
	}

	public void setSignaturePlan(boolean signaturePlan) {
		this.signaturePlan = signaturePlan;
	}

	public boolean isPreminumPlan() {
		return preminumPlan;
	}

	public void setPreminumPlan(boolean preminumPlan) {
		this.preminumPlan = preminumPlan;
	}

	public String getNoticeDeliveryAdd() {
		return noticeDeliveryAdd;
	}

	public void setNoticeDeliveryAdd(String noticeDeliveryAdd) {
		this.noticeDeliveryAdd = noticeDeliveryAdd;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<EmployerPlan> getEmployerPlan() {
		return employerPlan;
	}

	public void setEmployerPlan(List<EmployerPlan> employerPlan) {
		this.employerPlan = employerPlan;
	}

	public List<Ira> getIra() {
		return ira;
	}

	public void setIra(List<Ira> ira) {
		this.ira = ira;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	

}
