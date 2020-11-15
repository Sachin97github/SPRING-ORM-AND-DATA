package com.nit.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PRODUCT")
public class ProductBO {
	@Id
	@Column(name="proid")
	@GeneratedValue(strategy = GenerationType.AUTO)
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
