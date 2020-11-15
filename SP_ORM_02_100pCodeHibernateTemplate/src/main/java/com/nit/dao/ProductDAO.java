package com.nit.dao;

import java.util.List;

import com.nit.bo.ProductBO;

public interface ProductDAO {
	
	public long saveProduct(ProductBO bo);
	
	public int getProduct(Long proid);
	
	public boolean updateProduct(ProductBO bo);
	
	public int deleteProduct(Long proid);
	
	public List<ProductBO> getProductsByRange(float start,float end);

}
