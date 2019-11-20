package com.mercury.excelData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataValidation {
	public static XSSFWorkbook wb;
	public static XSSFSheet s;
	public static String getRowStringCellValue;
	public static long getRowIntegerCellValue;
	public static String excelFilePath = "E:\\merurytoursInputData\\mercury.xlsx";

	public void ExcelData(String excellFilePath) throws IOException {
		FileInputStream input = new FileInputStream("E:\\merurytoursInputData\\mercury.xlsx");
		wb = new XSSFWorkbook(input);

	}

	public String getStringExcelData(String sheetName, int rowNumber, int cellNumber) throws IOException {
		s = wb.getSheet(sheetName);
		getRowStringCellValue = s.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return getRowStringCellValue;
	}
	
	public long getIntegerExcelData(String sheetName, int rowNumber, int cellNumber) throws IOException {
		s= wb.getSheet(sheetName);
		getRowIntegerCellValue = (long) s.getRow(rowNumber).getCell(cellNumber).getNumericCellValue();
		return getRowIntegerCellValue;
	}
}
