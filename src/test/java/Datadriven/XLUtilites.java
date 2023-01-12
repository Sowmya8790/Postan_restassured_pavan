package Datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilites {
	
	 public static FileInputStream filein;
	 public static FileOutputStream fileout;
	 public static XSSFWorkbook wbook;
	 public static XSSFSheet wsheet;
	 public static XSSFRow row;
	 public static XSSFCell col;
	private static XSSFCell cell;
	 
	 
	 public static int getrowcount(String fpath, String wsheetname) throws IOException {
		 
		 filein = new FileInputStream(fpath);
		 wbook = new XSSFWorkbook(filein);
		 wsheet = wbook.getSheet(wsheetname);
		 int rowcount = wsheet.getLastRowNum();
		 wbook.close();
		 filein.close();	 
		return rowcount;
		 
		 
	 }
	 
	 public static int getcolcount(String path, String wsheetname, int rowcount) throws IOException {
		 
		 filein = new FileInputStream(path);
		 wbook = new XSSFWorkbook(filein);
		 wsheet = wbook.getSheet(wsheetname);
		 int colcount = wsheet.getRow(rowcount).getLastCellNum();
		 wbook.close();	
		 filein.close();
		return colcount;		 
		 
	 }
	 
	 public static String getcelldata(String path, String wsheetname, int rowcount, int colcount) throws IOException {
		 
		 filein = new FileInputStream(path);
		 wbook = new XSSFWorkbook(filein);
		 wsheet = wbook.getSheet(wsheetname);
		 row = wsheet.getRow(rowcount);
		 cell = row.getCell(colcount);
		 String data;
		 
		 try
		 {
			 DataFormatter formatter = new DataFormatter();
			 String cellData = formatter.formatCellValue(cell);
			 return cellData;
			 
		 }
		 catch (Exception e)
		 {
			 data = "";
		 }
		 
		 wbook.close();
		 filein.close();
		 
		return data;
		 
		 
	 }
	 
	 public static void Setcelldata(String path, String wsheetname, int rowcount, int colcount, String data) throws IOException {
		 
		 filein = new FileInputStream(path);
		 wbook = new XSSFWorkbook(filein);
		 wsheet= wbook.getSheet(wsheetname);
		row = wsheet.getRow(rowcount);
		col = row.createCell(colcount);
		col.setCellValue(data);
		fileout = new FileOutputStream(path);
		wbook.write(fileout);
		wbook.close();
		filein.close();
		fileout.close();
		
		 
		 
	 }
	 

}
