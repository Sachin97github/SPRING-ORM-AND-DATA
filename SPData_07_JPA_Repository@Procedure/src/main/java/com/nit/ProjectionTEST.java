package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.repo.CustomerJPARepository;

@SpringBootApplication
public class ProjectionTEST {

	private static CustomerJPARepository custJPARepo;

	public static void main(String[] args) {
		ApplicationContext ctx = null;

		ctx = SpringApplication.run(ProjectionTEST.class, args);
		custJPARepo = ctx.getBean(CustomerJPARepository.class);
		System.out.println(custJPARepo.getClass().getName());

		try {
			// custJPARepo.getAllCustomers().forEach(System.out::println);
			// custJPARepo.getCustomerByAddress("Address10").forEach(System.out::println);
			// custJPARepo.getCustomersByBillAmt(700000D,800000D).forEach(System.out::println);
			// custJPARepo.getCustomersByAddresses("Address8","Address7","Address10").forEach(System.out::println);

			/*
			 * custJPARepo.getCustomerDetailsByBillRange(700000D, 800000D).forEach(row -> {
			 * System.out.println("Id " + row[0] + " Name " + row[1] + " Address " +
			 * row[2]); });
			 */
			
			/*
			 * Object data=custJPARepo.getCustomerInfoByCusId(145); Object
			 * data1[]=(Object[])data;
			 * System.out.println(data1[0]+" "+data1[1]+" "+data1[2]);
			 */
			                                    //UPDATE
			/*
			 * int updatedRows=custJPARepo.updateBillAmtByCity(5D,"Address10"); //Count -- how
			 * many Rows arre affected System.out.println(updatedRows);
			 */
	                                            //DELETE
			/*
			 * int deletedRow=custJPARepo.deleteCustomerById(136);
			 * System.out.println(deletedRow);
			*/
			//               native Query
			//custJPARepo.getCustomerByAddress("bpl").forEach(System.out::println);
			
		  //Native Query  procedure{ call GET_CUS_BY_ADDRESS(?)} 
			custJPARepo.getCusByAddressByProcedure("bpl").forEach(System.out::println);
			
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		((ConfigurableApplicationContext) ctx).close();

	}

}
