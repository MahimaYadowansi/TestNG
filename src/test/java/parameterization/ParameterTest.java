package parameterization;

import java.util.Objects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterTest {

	@Test(dataProvider="getData")
	public void doLogIn(String username, String password)
	{
		System.out.println(username+"----"+password);	}
	
	//to get data from excel
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[12][2];
		
		// this is done bye manually
		data[0][0]="username";
		data[0][1]="password";
		
		data[1][0]="mahima56@gmail.com";
		data[1][1]="dhh";
		
		data[2][0]="mahima7643@gmail.com";
		data[2][1]="yui";
		
		data[3][0]="mahi4678@gmail.com";
		data[3][1]="gghg";
		
		data[4][0]="abc@gmail.com";
		data[4][1]="ty67";
		
		
		data[5][0]="def@gmail.com";
		data[5][1]="g57";
		
		
		data[6][0]="mahima4575444@gmail.com";
		data[6][1]="dff";
		
		data[7][0]="mahima@gmail.com";
		data[7][1]="sdgh";
		
		data[8][0]="klm@gmail.com";
		data[8][1]="5678";
		
		data[9][0]="tik@gmail.com";
		data[9][1]="ty67";
		
		data[10][0]="mahima@gmail.com";
		data[10][1]="ty67";
		
		data[11][0]="mahima@gmail.com";
		data[11][1]="ty67";
		
	
		
		
		return data;
		
		
		
	}
}
