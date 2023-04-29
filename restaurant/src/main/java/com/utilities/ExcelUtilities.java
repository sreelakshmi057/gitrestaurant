package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {
	final static String currentDir = System.getProperty("user.dir");
	static String filePath = currentDir + ".//src/test//resources//restaurantdata.xlsx";

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fs;
	File file = new File(filePath);
	

	public void getNumberOfRows() throws IOException {
		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}
	public String readStringData(int rowNum, int colNum) throws IOException {

		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		String cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellValue;
	}
	public int readNumericData(int rowNum, int colNum) throws IOException {

		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		int cellValue = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellValue;
	}
	

}
