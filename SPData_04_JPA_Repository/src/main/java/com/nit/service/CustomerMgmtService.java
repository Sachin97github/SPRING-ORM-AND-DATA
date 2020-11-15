package com.nit.service;

import java.util.List;

import com.nit.dto.CustomerDTO;

public interface CustomerMgmtService {
	
	public String registerGroupCustomers(List<CustomerDTO> listEntity);
	
	public void fetchRecordsSortedPaginated(int pageSize);
	
	
}
