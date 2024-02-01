package utilities;

import java.io.FileInputStream;
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
		try {
			XSSFWorkbook dataWorkbook = new XSSFWorkbook(new FileInputStream(filePath));
			XSSFSheet dataSheet = dataWorkbook.getSheet(sheetName);
			// make sure excel sheet contains more than 1 row of data
			if (dataSheet.getLastRowNum() < 1)
				throw new Exception("No valid data.");
			// create data table
			List<Map<String, String>> dataTable = new ArrayList<>();
			// loop through all the rows in the excel sheet
			for (int i = 1; i <= dataSheet.getLastRowNum(); i++) {
				// get the current row
				XSSFRow row = dataSheet.getRow(i);
				// prepare data row for data table
				HashMap<String, String> targetDataRow = new HashMap<>();
				// store excel row as Map
				for (int j = 0; j < row.getLastCellNum(); j++) {
					String key = getStringValueFromCell(dataSheet.getRow(0).getCell(j));
					String value = getStringValueFromCell(dataSheet.getRow(i).getCell(j));
					targetDataRow.put(key, value);
				}
				// add target row to the data table
				dataTable.add(targetDataRow);
			}
			resultTable = dataTable.toArray();
			dataWorkbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultTable;
	}

	private static String getStringValueFromCell(XSSFCell cell) {
		DataFormatter formatter = new DataFormatter();
		formatter.setUseCachedValuesForFormulaCells(true);
		return formatter.formatCellValue(cell);
	}

}
