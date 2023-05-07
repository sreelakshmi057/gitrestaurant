package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public final static String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + ".//src/test//resources//restaurantdata.xlsx";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fs;
	File file = new File(filePath);

	public ExcelUtilities() {
		try {
			workbook = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading filepath");
		}
		sheet = workbook.getSheetAt(0);
	}

	public void getNumberOfRows() {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading file");
		}
		sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}

	public String readStringData(String sheetname, int rowNum, int colNum) {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading file");
		}
		sheet = workbook.getSheet(sheetname);
		String cellValue = sheet.getRow(rowNum - 1).getCell(colNum - 1).getStringCellValue();
		return cellValue;
	}

	public int readNumericData(String sheetname, int rowNum, int colNum) {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error during reading file");
		}
		sheet = workbook.getSheet(sheetname);
		int cellValue = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellValue;
	}
}
