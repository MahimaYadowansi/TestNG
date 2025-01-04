package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
	 private Workbook workbook;

	    // Constructor to initialize the Excel file
	    public ExcelReader(String filePath) throws IOException {
	        FileInputStream fis = new FileInputStream(filePath);
	        workbook = new XSSFWorkbook(fis);
	    }

	    // Method to get data from a specific cell
	    public String getCellData(String sheetName, int rowNumber, int colNumber) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
	        }
	        Row row = sheet.getRow(rowNumber);
	        if (row == null) {
	            return ""; // Empty if row doesn't exist
	        }
	        Cell cell = row.getCell(colNumber);
	        if (cell == null) {
	            return ""; // Empty if cell doesn't exist
	        }
	        return cell.toString();
	    }

	    // Method to get total rows in a sheet
	    public int getRowCount(String sheetName) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
	        }
	        return sheet.getLastRowNum() + 1; // Index starts from 0
	    }

	    // Method to get total columns in a specific row
	    public int getColumnCount(String sheetName, int rowNumber) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
	        }
	        Row row = sheet.getRow(rowNumber);
	        if (row == null) {
	            return 0;
	        }
	        return row.getLastCellNum(); // Total columns
	    }

	    // Close the workbook
	    public void close() throws IOException {
	        workbook.close();
	    }
}
