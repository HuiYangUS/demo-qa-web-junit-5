package tests.poi.demo;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws Exception {
		int rowNum = 0;
		int cellNum = 0;

		FileInputStream fileInput = new FileInputStream("path/to/file");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("sheetName");
		// row number as int
		XSSFRow row = sheet.getRow(rowNum);
		// cell number as int
		XSSFCell cell = row.getCell(cellNum);
		cell.getRawValue();
		workbook.close();
	}

}
