package unit;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import utilities.MyTestUtils;

public class ExcelWriter {

	@Test
	void runCreateSheetTest() {
		String targetFilePath = "src/test/resources/test-data/demo/demo.xlsx";
		try {
			XSSFWorkbook demoWorkbook = new XSSFWorkbook();
			System.out.println("Before sheet creation: " + demoWorkbook.getNumberOfSheets());
			if (demoWorkbook.getNumberOfSheets() == 0)
				demoWorkbook.createSheet("school");
			System.out.println("After sheet creation: " + demoWorkbook.getNumberOfSheets());

			demoWorkbook.write(new FileOutputStream(targetFilePath));
			demoWorkbook.close();
			System.out.println("Test passed.");
		} catch (Exception e) {
			System.out.println("Test failed.");
			e.printStackTrace();
		}
	}

	@Test
	void runWriteTest() {
		// create a new directory if it does not exist
		String targetDirPath = "target/demo";
		if (!new File(targetDirPath).exists())
			new File(targetDirPath).mkdir();

		// create a new excel file from scratch
		String targetFilePath = String.format("target/demo/demo-%d.xlsx", MyTestUtils.getTimestamp());
		try {
			XSSFWorkbook demoWorkbook = new XSSFWorkbook();
			XSSFSheet schoolSheet = demoWorkbook.createSheet("school");

			// add new rows until 11th
			while (schoolSheet.getLastRowNum() < 10) {
				XSSFRow row = schoolSheet.createRow(schoolSheet.getLastRowNum() + 1);
				// create 3 cells each row
				for (int i = 0; i < 3; i++) {
					row.createCell(i);
				}
			}

			// setup headers
			schoolSheet.getRow(0).getCell(0).setCellValue("Date");
			schoolSheet.getRow(0).getCell(1).setCellValue("Name");
			schoolSheet.getRow(0).getCell(2).setCellValue("Score");

			String[] names = { "Jane Doe", "Robert Smith", "Tammy Hawk" };
			Random roll = new Random();

			// test data
			for (int i = 0; i < 10; i++) {
				schoolSheet.getRow(i + 1).getCell(0).setCellValue(LocalDate.now().toString());
				schoolSheet.getRow(i + 1).getCell(1).setCellValue(names[roll.nextInt(3)]);
				schoolSheet.getRow(i + 1).getCell(2).setCellValue(roll.nextInt(100) + 1 + "%");
			}

			schoolSheet.autoSizeColumn(0);
			schoolSheet.setColumnWidth(0, schoolSheet.getColumnWidth(0) + 100);
			schoolSheet.autoSizeColumn(1);
			schoolSheet.setColumnWidth(1, schoolSheet.getColumnWidth(1) + 200);
			schoolSheet.setColumnWidth(2, 1800);

			// last row contains value
			System.out.println("Final Row index: " + schoolSheet.getLastRowNum());
			// last cell does not contain value
			System.out.println("Final Cell index: " + schoolSheet.getRow(schoolSheet.getLastRowNum()).getLastCellNum());

			demoWorkbook.write(new FileOutputStream(targetFilePath));
			demoWorkbook.close();
			System.out.println("Test passed.");
		} catch (Exception e) {
			System.out.println("Test failed.");
			e.printStackTrace();
		}
	}

}
