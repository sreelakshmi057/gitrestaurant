package com.datasupplier;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider
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

	@DataProvider
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

	@DataProvider
	public Object[] dataSupplierWaiterDelete() {

		Object[] data = new Object[] {"1452367895"};
		return data;
	}
}
