package com.nit.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	
	private Integer cusId;
	private String cusName;
	private String cusAddress;
	private Double billAmt;
	
	public Integer getCusId() {
		return cusId;
	}
	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public Double getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusAddress=" + cusAddress + ", billAmt="
				+ billAmt + "]";
	}
	
	
	

}
