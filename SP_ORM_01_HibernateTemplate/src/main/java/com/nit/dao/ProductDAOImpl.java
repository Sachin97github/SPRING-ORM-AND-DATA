package com.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nit.bo.ProductBO;

@Repository("prdDao")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public long saveProduct(ProductBO bo) {
        Long idval;
        idval=(long) ht.save(bo);
        return idval;        	
	}

	@Override
	public int getProduct(Long proid) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean updateProduct(ProductBO bo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteProduct(Long proid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductBO> getProductsByRange(float start, float end) {
		// TODO Auto-generated method stub
		return null;
	}


}
