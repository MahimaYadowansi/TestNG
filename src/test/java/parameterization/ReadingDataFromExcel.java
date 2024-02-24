package parameterization;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadingDataFromExcel {

	public static void main(String[] args) throws Exception {
		File excelFile=new File("./src/test/resources/Book1.xlsx");
		System.out.println(excelFile.exists());
		//to read from file
		FileInputStream fis=new FileInputStream(excelFile);
		//convert raw data(fis) into excel workbook format
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//add sheet
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//to get row(total numbers of row includes heading)
		//System.out.println (sheet.getPhysicalNumberOfRows());
		// no. of row excluding heading
		System.out.println(sheet.getLastRowNum());	
		
		//iterating throw the row and col
		int Rows=sheet.getPhysicalNumberOfRows();
		int Cols=sheet.getRow(0).getLastCellNum(); //number of col in 1st row
		for(int i=1;i< Rows;i++)
		{
			for(int j=0;j<Cols;j++)
			{
				// it will give convert all data in string type and return data
				DataFormatter df=new DataFormatter();
				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
	//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()); // it give only string value
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	}

}
