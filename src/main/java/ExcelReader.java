import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("./src/test/resources/TestData/TestData.xlsx");	
		FileInputStream fis = new FileInputStream(f);	
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("searchFlight");
		int totalRowNum = sh.getPhysicalNumberOfRows();
		System.out.println("total rows are: "+totalRowNum);
		int totalColNum = sh.getRow(0).getLastCellNum();
		System.out.println("total cols are: "+totalColNum);
		
		for(int i=0; i<totalRowNum; i++) {
			for(int j =0; j<totalColNum; j++) {
				//sh.getRow(0).getCell(0).getStringCellValue
				//sh.getRow(0).getCell(1).getStringCellValue
				//sh.getRow(0).getCell(2).getStringCellValue
				//sh.getRow(0).getCell(3).getStringCellValue
				
				//sh.getRow(1).getCell(0).getStringCellValue
				//sh.getRow(1).getCell(1).getStringCellValue
				//sh.getRow(1).getCell(2).getStringCellValue
				//sh.getRow(1).getCell(3).getStringCellValue
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		
		
		
		
		
	}

}
