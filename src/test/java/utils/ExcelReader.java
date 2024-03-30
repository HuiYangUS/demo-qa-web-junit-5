package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader extends TestDataReader {

    public static Object[] getData(String fileName, String sheetName) {
	Object[] resultTable = null;
	String filePath = DIR_PATH + fileName + ".xlsx";
	XSSFWorkbook dataWorkbook = load(filePath);
	XSSFSheet dataSheet = dataWorkbook.getSheet(sheetName);
	if (dataSheet.getLastRowNum() < 1)
	    throw new RuntimeException("No header data is available.");
	// Create data table
	List<Map<String, String>> dataTable = new ArrayList<>();
	// Loop through all the rows in the excel sheet
	for (int i = 1; i <= dataSheet.getLastRowNum(); i++) {
	    // Get the current row
	    XSSFRow row = dataSheet.getRow(i);
	    // Prepare data row for data table
	    Map<String, String> targetDataRow = new HashMap<>();
	    // Convert each excel row as <Map>
	    for (int j = 0; j < row.getLastCellNum(); j++) {
		String key = getStringValueFromCell(dataSheet.getRow(0).getCell(j));
		String value = getStringValueFromCell(dataSheet.getRow(i).getCell(j));
		targetDataRow.put(key, value);
	    }
	    // Add target row to the data table
	    dataTable.add(targetDataRow);
	}
	resultTable = dataTable.toArray();
	try {
	    dataWorkbook.close();
	} catch (IOException e) {
	    throw new RuntimeException("This workbook failed to close.", e);
	}
	return resultTable;
    }

    private static String getStringValueFromCell(XSSFCell cell) {
	DataFormatter formatter = new DataFormatter();
	formatter.setUseCachedValuesForFormulaCells(true);
	return formatter.formatCellValue(cell);
    }

    private static XSSFWorkbook load(String filePath) {
	try {
	    return new XSSFWorkbook(new FileInputStream(filePath));
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

}
