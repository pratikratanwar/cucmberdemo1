package utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
public static HashMap<String, String> storeValues = new HashMap();

	public static List<HashMap<String,String>> data(String filepath, String sheetname){
		
		
		
		List<HashMap<String,String>> mydata= new ArrayList<>();
		try {
			FileInputStream fs= new FileInputStream(filepath);
			XSSFWorkbook workbook= new XSSFWorkbook(fs);
			XSSFSheet sheet= workbook.getSheet(sheetname);
			Row HeaderRow= sheet.getRow(0);
			for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
				Row currentRow= sheet.getRow(i);
				HashMap<String, String> currentHash= new HashMap<String, String>();
				for(int j=0; j< currentRow.getPhysicalNumberOfCells();j++)
				{
					Cell currentCell =currentRow.getCell(j);
					
					
					
				}
			
			
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
