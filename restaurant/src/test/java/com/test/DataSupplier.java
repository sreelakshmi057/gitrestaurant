package com.test;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider
	public String[] dataSupplier() {
		
		String[] data= new String[] {"APPLE_SREE"};
		return data;
	}
	
	@DataProvider
	public String[] dataSupplierEdit() {
		
		String[] data= new String[] {"APPLE1_SREE"};
		return data;
	}
	
	@DataProvider
	public String[] dataSupplierDelete() {
		
		String[] data= new String[] {"APPLE1_SREE"};
		return data;
	}
	
	@DataProvider
	public String[] dataExpense() {
		
		String[] data= new String[] {"APPLE_EXPENSE"};
		return data;
	}
	
	@DataProvider
	public String[] dataExpenseEdit() {
		
		String[] data= new String[] {"APPLE1_EXPENSE"};
		return data;
	}
	
	@DataProvider
	public String[] dataExpenseDelete() {
		
		String[] data= new String[] {"APPLE1_EXPENSE"};
		return data;
	}
}
