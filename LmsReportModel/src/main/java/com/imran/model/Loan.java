package com.imran.model;

import java.util.Date;

public class Loan {
	
	private long id;	
	private String caseNo;
	private String loanName;
	private String loanType;
	private String branchName;
	private Date date;
	private Double amount;
	
	
	
	
	public Loan(long id, String caseNo, String loanName, String loanType, String branchName, Date date, Double amount) {
		super();
		this.id = id;
		this.caseNo = caseNo;
		this.loanName = loanName;
		this.loanType = loanType;
		this.branchName = branchName;
		this.date = date;
		this.amount = amount;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	

	
}
