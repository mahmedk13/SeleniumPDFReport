package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataUtils {
	
	@DataProvider
	public Object[][] getData(Method m) throws IOException{
		
		File f = new File("./src/test/resources/TestData/TestData.xlsx");	
		FileInputStream fis = new FileInputStream(f);	
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(m.getName()); //wb.getSheet("searchHotel")
		int totalRowNum = sh.getPhysicalNumberOfRows(); //2
		System.out.println("total rows are: "+totalRowNum);
		int totalColNum = sh.getRow(0).getLastCellNum();
		System.out.println("total cols are: "+totalColNum);
		
		Object[][] data = new Object[totalRowNum-1][totalColNum]; //[1][4]
		
		for(int i=1; i<totalRowNum; i++) {
			for(int j =0; j<totalColNum; j++) {
				
				data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
				//data[0][0]
				//data[0][1]
			}
		}
		
		
		
		
		return data;
		
	}
	

}
