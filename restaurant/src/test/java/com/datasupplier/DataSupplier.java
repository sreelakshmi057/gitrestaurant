package com.datasupplier;

import org.testng.annotations.DataProvider;

import com.utilities.ExcelUtilities;

public class DataSupplier {
 
	ExcelUtilities excelUtil = new ExcelUtilities();
	@DataProvider(name="waiter")
	public Object[][] dataSupplierWaiter() {
		Object[][] data = new Object[2][4];
		data[0][0] = excelUtil.readStringData("waiter_dataprovider", 2, 2);
		data[0][1] = excelUtil.readStringData("waiter_dataprovider", 3, 2);
		data[0][2] = excelUtil.readStringData("waiter_dataprovider", 4, 2);
		data[0][3] = excelUtil.readStringData("waiter_dataprovider", 5, 2);
		data[1][0] = excelUtil.readStringData("waiter_dataprovider", 6, 2);
		data[1][1] = excelUtil.readStringData("waiter_dataprovider", 7, 2);
		data[1][2] = excelUtil.readStringData("waiter_dataprovider", 8, 2);
		data[1][3] = excelUtil.readStringData("waiter_dataprovider", 9, 2);
		return data;
	}

	@DataProvider(name="waiteredit")
	public Object[][] dataSupplierWaiterEdit() {
		Object[][] data = new Object[2][4];
		data[0][0] = excelUtil.readStringData("waiter_dataprovider", 11, 2);
		data[0][1] = excelUtil.readStringData("waiter_dataprovider", 12, 2);
		data[0][2] = excelUtil.readStringData("waiter_dataprovider", 13, 2);
		data[0][3] = excelUtil.readStringData("waiter_dataprovider", 14, 2);
		data[1][0] = excelUtil.readStringData("waiter_dataprovider", 15, 2);
		data[1][1] = excelUtil.readStringData("waiter_dataprovider", 16, 2);
		data[1][2] = excelUtil.readStringData("waiter_dataprovider", 17, 2);
		data[1][3] = excelUtil.readStringData("waiter_dataprovider", 18, 2);
		return data;
	}

	@DataProvider(name="waiterdelete")
	public Object[] dataSupplierWaiterDelete() {
		Object[] data = new Object[] {excelUtil.readStringData("waiter_dataprovider", 20, 2)};
		return data;
	}
	
	@DataProvider(name="customer")
	public Object[][] dataSupplierCustomer() {
		Object[][] data = new Object[2][4];
		data[0][0] = excelUtil.readStringData("customer_dataprovider", 2, 2);
		data[0][1] = excelUtil.readStringData("customer_dataprovider", 3, 2);
		data[0][2] = excelUtil.readStringData("customer_dataprovider", 4, 2);
		data[0][3] = excelUtil.readStringData("customer_dataprovider", 5, 2);
		data[1][0] = excelUtil.readStringData("customer_dataprovider", 6, 2);
		data[1][1] = excelUtil.readStringData("customer_dataprovider", 7, 2);
		data[1][2] = excelUtil.readStringData("customer_dataprovider", 8, 2);
		data[1][3] = excelUtil.readStringData("customer_dataprovider", 9, 2);
		return data;
	}

	@DataProvider(name="customeredit")
	public Object[][] dataSupplierCustomerEdit() {
		Object[][] data = new Object[2][4];
		data[0][0] = excelUtil.readStringData("customer_dataprovider", 11, 2);
		data[0][1] = excelUtil.readStringData("customer_dataprovider", 12, 2);
		data[0][2] = excelUtil.readStringData("customer_dataprovider", 13, 2);
		data[0][3] = excelUtil.readStringData("customer_dataprovider", 14, 2);
		data[1][0] = excelUtil.readStringData("customer_dataprovider", 15, 2);
		data[1][1] = excelUtil.readStringData("customer_dataprovider", 16, 2);
		data[1][2] = excelUtil.readStringData("customer_dataprovider", 17, 2);
		data[1][3] = excelUtil.readStringData("customer_dataprovider", 18, 2);
		return data;
	}

	@DataProvider(name="customerdelete")
	public Object[] dataSupplierCustomerDelete() {
		Object[] data = new Object[] {excelUtil.readStringData("customer_dataprovider", 20, 2)};
		return data;
	}
	
	@DataProvider(name="supplier")
	public Object[][] dataSupplier() {
		Object[][] data = new Object[2][4];
		data[0][0] = excelUtil.readStringData("supplier_dataprovider", 2, 2);
		data[0][1] = excelUtil.readStringData("supplier_dataprovider", 3, 2);
		data[0][2] = excelUtil.readStringData("supplier_dataprovider", 4, 2);
		data[0][3] = excelUtil.readStringData("supplier_dataprovider", 5, 2);
		data[1][0] = excelUtil.readStringData("supplier_dataprovider", 6, 2);
		data[1][1] = excelUtil.readStringData("supplier_dataprovider", 7, 2);
		data[1][2] = excelUtil.readStringData("supplier_dataprovider", 8, 2);
		data[1][3] = excelUtil.readStringData("supplier_dataprovider", 9, 2);
		return data;
	}

	@DataProvider(name="supplieredit")
	public Object[][] dataSupplierEdit() {
		Object[][] data = new Object[2][4];
		data[0][0] = excelUtil.readStringData("supplier_dataprovider", 11, 2);
		data[0][1] = excelUtil.readStringData("supplier_dataprovider", 12, 2);
		data[0][2] = excelUtil.readStringData("supplier_dataprovider", 13, 2);
		data[0][3] = excelUtil.readStringData("supplier_dataprovider", 14, 2);
		data[1][0] = excelUtil.readStringData("supplier_dataprovider", 15, 2);
		data[1][1] = excelUtil.readStringData("supplier_dataprovider", 16, 2);
		data[1][2] = excelUtil.readStringData("supplier_dataprovider", 17, 2);
		data[1][3] = excelUtil.readStringData("supplier_dataprovider", 18, 2);
		return data;
	}

	@DataProvider(name="supplierdelete")
	public Object[] dataSupplierDelete() {
		Object[] data = new Object[] {excelUtil.readStringData("supplier_dataprovider", 20, 2)};
		return data;
	}
	
}