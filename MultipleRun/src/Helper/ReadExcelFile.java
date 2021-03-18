package Helper;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	static String[][] dataArray = new String[4][4];
	
	@SuppressWarnings({ "resource", "unused" })
	public static Object[][] readExcel(String fileName,String sheetName) throws IOException
	{
		
		
		// Step 1 : Read Excel file
		//File file=new File(System.getProperty("user.dir")+"\\"+fileName);
		File file=new File(System.getProperty("user.dir")+"\\"+"src\\com\\testdata\\"+fileName);
		//// E:\Eclipse\MultipleRun\src\com\testdata
		FileInputStream fi=new FileInputStream(file);
		// Step 2 Read Work book
		
		
		Workbook ws=new XSSFWorkbook(fi);
		// Step 3 Read Sheet
		Sheet sh=ws.getSheet(sheetName);
		
		// Step 4 Read Total rows
		
		// 	getFirstRowNum will return actual first row index (0 basis) present in Excel, if there is any empty row then it will ignore
		// getLastRowNum will return actual last row index(0 basis) present in Excel
		int totalRows=sh.getLastRowNum();//- sh.getFirstRowNum(); // 1-0 =1	
		
		 
		// Step 5 using For loop, get all cell values and put it in on Two D Array
		for(int i=1;i<=totalRows;i++)
		{
			// Get Rows 
			Row r=sh.getRow(i);
			
			//Last Celll number 2
			
			for(int j=0;j<r.getLastCellNum();j++)
			{
				int columcount=r.getLastCellNum();
				// get Cell values and convert in to String and store it on 2 D array
				
				if(!(r.getCell(j).toString().equals(null)))
						{
				dataArray[i][j]=r.getCell(j).toString();
				System.out.print("---> "+dataArray[i][j]);
				//System.out.print("\t");
			             }
				else
				{
					dataArray[i][j]="";
				}
			}
			
			System.out.println("***************************************");
			
		}
		return dataArray;
		

	}
}

