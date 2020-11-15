package com.nit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.dto.CustomerDTO;
import com.nit.entity.Customer;
import com.nit.repo.CustomerCrudRepository;
import com.nit.repo.CustomerJPARepository;

@Service("service")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {

	@Autowired
	private CustomerCrudRepository custRepo;
	@Autowired
	private CustomerJPARepository custJPARepo;

	@Override
	public String registerGroupCustomers(List<CustomerDTO> listDTO) {

		List<Customer> itEntities = new ArrayList();
		List<Customer> returnedListEntities = null;
		String ids = null;

		listDTO.forEach(dto -> {
			Customer entity = new Customer();
			BeanUtils.copyProperties(dto, entity);
			itEntities.add(entity);
		});

		returnedListEntities = (List<Customer>) custRepo.saveAll(itEntities);
		ids = returnedListEntities.stream().map(e -> e.getCusId()).collect(Collectors.toList()).toString();

		return returnedListEntities != null ? "Record inserted having ids :: " + ids : "Records are not inserted";
	}

	@Override
	public void fetchRecordsSortedPaginated(int pageSize) {

		Pageable pageable = null;
		int recordsCount;
		int pageCount;

		recordsCount = (int) custJPARepo.count();
		System.out.println("RECORDS"+recordsCount);

		pageCount = recordsCount / pageSize;
		System.out.println("PAGE COUNT "+pageCount);
		
		pageCount = recordsCount % pageSize == 0 ? pageCount : ++pageCount;
        System.out.println("PAGE COUNT AFTER CALCULATION"+pageCount);
		for (int i = 0; i < pageCount; i++) {
			pageable = PageRequest.of(i, pageSize, Sort.by(Direction.ASC, "cusName"));
			Page page = custJPARepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("Page " + (i + 1) + " of " + page.getTotalPages());
		}

	}

}
