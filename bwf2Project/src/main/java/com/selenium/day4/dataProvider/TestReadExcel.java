package com.selenium.day4.dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class TestReadExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//		Workbook wb = new XSSFWorkbook(new FileInputStream("c:\\ecshopTestCase.xlsx"));
		Workbook wb = new XSSFWorkbook( TestReadExcel.class.getClassLoader().getResourceAsStream("ecshopTestCase.xlsx"));
//		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
//			Sheet sheet = wb.getSheetAt(i);
//			System.out.println(wb.getSheetName(i));
//			for (Row row : sheet) {
//				System.out.println("rownum: " + row.getRowNum());
//				for (Cell cell : row) {
//					System.out.println(cell);
//				}
//			}
//		}
		DecimalFormat decimalFormat = new DecimalFormat("0");//
		Sheet sheet = wb.getSheet("loginTestCase");
//			System.out.println(wb.getSheetName(i));
			for (Row row : sheet) {
				System.out.print("第 " + (row.getRowNum()+1)+"行");
				for (Cell cell : row) {
//					System.out.print("第 " +cell.getColumnIndex()+"列！");
					if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
						System.out.print(decimalFormat.format(cell.getNumericCellValue()));
					else
						System.out.print(cell);
					System.out.print("\t");
				}
				System.out.println("");
			}
		
	}

}
