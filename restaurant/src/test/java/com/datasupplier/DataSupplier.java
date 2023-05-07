package com.datasupplier;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider(name="waiter")
	public Object[][] dataSupplierWaiter() {
		Object[][] data = new Object[2][4];
		data[0][0] = "AAN";
		data[0][1] = "1234567890";
		data[0][2] = "aan@gmail.com";
		data[0][3] = "MNC";
		data[1][0] = "AAN";
		data[1][1] = "1234567890";
		data[1][2] = "aan@gmail.com";
		data[1][3] = "MNC";
		return data;
	}

	@DataProvider(name="waiteredit")
	public Object[][] dataSupplierWaiterEdit() {
		Object[][] data = new Object[2][4];
		data[0][0] = "AAN";
		data[0][1] = "1452367895";
		data[0][2] = "aan@gmail.com";
		data[0][3] = "MNC";
		data[1][0] = "AAN";
		data[1][1] = "1452367895";
		data[1][2] = "aan@gmail.com";
		data[1][3] = "MNC";
		return data;
	}

	@DataProvider(name="waiterdelete")
	public Object[] dataSupplierWaiterDelete() {
		Object[] data = new Object[] {"1452367895"};
		return data;
	}
	
	@DataProvider(name="customer")
	public Object[][] dataSupplierCustomer() {
		Object[][] data = new Object[2][4];
		data[0][0] = "AAC";
		data[0][1] = "1234567567";
		data[0][2] = "aac@gmail.com";
		data[0][3] = "10";
		data[1][0] = "AAC";
		data[1][1] = "1234567567";
		data[1][2] = "aac@gmail.com";
		data[1][3] = "10";
		return data;
	}

	@DataProvider(name="customeredit")
	public Object[][] dataSupplierCustomerEdit() {
		Object[][] data = new Object[2][4];
		data[0][0] = "AAC";
		data[0][1] = "7888888888";
		data[0][2] = "aac@gmail.com";
		data[0][3] = "10";
		data[1][0] = "AAC";
		data[1][1] = "7888888888";
		data[1][2] = "aac@gmail.com";
		data[1][3] = "10";
		return data;
	}

	@DataProvider(name="customerdelete")
	public Object[] dataSupplierCustomerDelete() {
		Object[] data = new Object[] {"7888888888"};
		return data;
	}
	
	@DataProvider(name="supplier")
	public Object[][] dataSupplier() {
		Object[][] data = new Object[2][4];
		data[0][0] = "AANNA";
		data[0][1] = "1478529631";
		data[0][2] = "anna@gmail.com";
		data[0][3] = "FIRST SUPPLIER";
		data[1][0] = "AANNA";
		data[1][1] = "1478529631";
		data[1][2] = "anna@gmail.com";
		data[1][3] = "FIRST SUPPLIER";
		return data;
	}

	@DataProvider(name="supplieredit")
	public Object[][] dataSupplierEdit() {
		Object[][] data = new Object[2][4];
		data[0][0] = "AANNA";
		data[0][1] = "8597461238";
		data[0][2] = "anna@gmail.com";
		data[0][3] = "FIRST SUPPLIER";
		data[1][0] = "AANNA";
		data[1][1] = "8597461238";
		data[1][2] = "anna@gmail.com";
		data[1][3] = "FIRST SUPPLIER";
		return data;
	}

	@DataProvider(name="supplierdelete")
	public Object[] dataSupplierDelete() {
		Object[] data = new Object[] {"8597461238"};
		return data;
	}
	
}