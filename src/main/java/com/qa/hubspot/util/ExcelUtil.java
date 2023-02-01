package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static String TEST_DATA_SHEET_PATH = "src/main/java/com/qa/hubspot/testdata/crmtestdata.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	/**
	 * This method is used to fetch the data from excel test data sheet
	 * @param sheetName
	 * @return
	 */
	
	public static Object[][] getTestData(String sheetName)
	{
		
		try {
			FileInputStream file = new FileInputStream(TEST_DATA_SHEET_PATH);
			book=WorkbookFactory.create(file);
			sheet=book.getSheet(sheetName);
			
			Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				{
					data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				}
						
			}
			return data;
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

}
