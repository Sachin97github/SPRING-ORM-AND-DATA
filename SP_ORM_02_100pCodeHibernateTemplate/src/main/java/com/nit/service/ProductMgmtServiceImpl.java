package com.nit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.bo.ProductBO;
import com.nit.dao.ProductDAO;
import com.nit.dto.ProductDTO;

@Service("prdMgmtService")
@Transactional
public class ProductMgmtServiceImpl implements ProductMgmtService {

	@Autowired
	private ProductDAO dao;
	
	@Override
	public String addProduct(ProductDTO dto) {
	    ProductBO bo=null;
	    Long proid=null;
	   
	    bo=new ProductBO();	
		BeanUtils.copyProperties(dto,bo);        
		proid=(long) dao.saveProduct(bo);
		
		if(proid!=null)
			return "Product added";
		else
			return "Product not added";		
	}

	@Override
	public String modifyProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProduct(Long proid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> showProductListByRange(float start, float end) {
		// TODO Auto-generated method stub
		return null;
	}

}
