package parameterization;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ParameterTestFromExcel {
@DataProvider(name="loginData")
	public Object[][] getData() throws IOException {
		
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
		Object[][] data=new Object[Rows-1][Cols];
		
		for(int i=0;i< Rows-1;i++)
		{
			for(int j=0;j<Cols;j++)
			{
				// it will give convert all data in string type and return data
				DataFormatter df=new DataFormatter();
				 data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				 
	//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()); // it give only string value
			}
			//System.out.println();
		}
		workbook.close();
		fis.close();
		return data;
		/*for(Object[] dataArr:data)
		{
			System.out.println(Arrays.toString(dataArr));
		}*/
		
		}
		

	}


