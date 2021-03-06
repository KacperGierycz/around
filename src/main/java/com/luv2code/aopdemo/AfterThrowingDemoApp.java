package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring context
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);		

		// call method to find the accounts
		List<Account> theAccounts=null;
		
		try {
			// add a boolean flag to simulate exception
			boolean tripWhire=false;			
			theAccounts=theAccountDAO.findAccounts(tripWhire);
		}
		catch(Exception exc) {
			System.out.println("\n\nMain Program ... cought exception: "
					+exc);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("-----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
		
	}


}
