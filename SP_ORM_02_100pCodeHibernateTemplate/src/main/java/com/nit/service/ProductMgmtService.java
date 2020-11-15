package com.nit.service;

import java.util.List;

import com.nit.bo.ProductBO;
import com.nit.dto.ProductDTO;

public interface ProductMgmtService {
	
	public String addProduct(ProductDTO dto);
	
	public String modifyProduct(ProductDTO dto);
	
	public String removeProduct(Long proid);
	
	public  List<ProductDTO> showProductListByRange(float start,float end);
	

}
