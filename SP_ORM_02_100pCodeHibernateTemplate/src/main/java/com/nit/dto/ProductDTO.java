package com.nit.dto;

public class ProductDTO {
	private Long proId;
	private String pName;
	private Integer  qty;
	private Double price;
	public Long getProId() {
		return proId;
	}
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductBO [proId=" + proId + ", pName=" + pName + ", qty=" + qty + ", price=" + price + "]";
	}	
	
}
