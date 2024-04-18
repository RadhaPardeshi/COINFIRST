package com.GenericTtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.netty.handler.ipfilter.IpFilterRule;

public class ExcelUtility {
	/**
	 * This method is used to read the data from Excel file
	 * @author DELL 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int rowNo , int cellNo ) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value=sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
  
	
	/**
	 * This method is used to read data from particular row /last row
	 * @param sheetName
	 * @param rowNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getTotalRowcount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int value = sh.getLastRowNum();
		return value;
	}
	
	/**
	 * This method is used to write data in excel file
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcelSheet(String sheetName,int rownum,int cellnum,String data,Boolean t) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		
		
		if(t)
		{
		 wb.getSheet(sheetName).createRow(rownum).createCell(cellnum).setCellValue(data);	
		}
		else
		{
			wb.getSheet(sheetName).getRow(rownum).createCell(cellnum).setCellValue(data);
		}
		
		/*Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rownum).getCell(cellnum).setCellValue(data);*/
		
		FileOutputStream fos=new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fos);
		wb.close();
		
	}
	/**
	 * This method is used to read data in excel file using Collection concept
	 * @param sheetName
	 * @param cellcount
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleData(String sheetName,int cellcount) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		 HashMap<String, String> map=new HashMap<String, String>();
		 
		 for (int i = 0; i < rowcount ; i++) {
			String key=sh.getRow(i).getCell(cellcount).getStringCellValue();
			String value=sh.getRow(i).getCell(cellcount+1).getStringCellValue();
			map.put(key, value);
		}
		 return map;
	}
	

}
