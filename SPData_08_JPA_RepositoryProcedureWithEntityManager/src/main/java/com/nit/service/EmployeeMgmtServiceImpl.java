package com.nit.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("EmpService")
@Transactional
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	@Autowired
	  private EntityManager manager;
	
	@Override
	public void getEmpInfo(int no) {
		
		//Get Session Object
		Session ses=manager.unwrap(Session.class);
		
		//Function return value
		float sal=ses.doReturningWork(new ReturningWork<Float>(){

			@Override
			public Float execute(Connection con) throws SQLException {
                         
				CallableStatement cs= con.prepareCall("{?= call EMP_DETAILS(?,?,?,?)}");
			  //Register Out Parameter Return parameter also comes under Out Parameter
				cs.registerOutParameter(1,java.sql.Types.FLOAT);
				cs.registerOutParameter(3,java.sql.Types.VARCHAR);
				cs.registerOutParameter(4,java.sql.Types.VARCHAR);
			    cs.registerOutParameter(5,java.sql.Types.INTEGER);
			    
			    //Set "In" parameter value 
				cs.setInt(2,7499);	
				cs.execute();
					
				//now you can acess out parameter values  By there Index
				System.out.println("Name :: "+cs.getString(3));
				System.out.println("Name :: "+cs.getString(4));
				 System.out.println("Name :: "+cs.getInt(5));
				
				 return cs.getFloat(1);
			  }//Execute Function 
			});//AnnonymousInnerClass
		System.out.println("Sal :: "+sal);
		
	}

}
