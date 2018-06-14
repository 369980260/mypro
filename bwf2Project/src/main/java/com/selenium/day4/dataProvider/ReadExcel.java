package com.selenium.day4.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static Object[][] readDataFromExcel(String excelName, String sheetName) {
		DecimalFormat decimalFormat = new DecimalFormat("0");
		Object[][] dataObject = null;
		InputStream is = null;
		Workbook xwb = null;
		try {
			is = ReadExcel.class.getClassLoader().getResourceAsStream(excelName);
			xwb = new XSSFWorkbook(is);
			Sheet sheet = xwb.getSheet(sheetName);
			int lastRowNum = sheet.getLastRowNum();// row=4
			int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();// cell=3
			dataObject = new Object[lastRowNum][lastCellNum];
			int i = 0;
			for (Row row : sheet) {
				int k = 0;
				if (i > 0) {
					for (Cell cell : row) {
						String str = "";
						// System.out.print("第 " +cell.getColumnIndex()+"列！");
						if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
							str = String.valueOf(decimalFormat.format(cell.getNumericCellValue()));
						else
							str = String.valueOf(cell);
						if (str.equalsIgnoreCase("<empty>")) {
							str = "";
						}
						dataObject[i-1][k] = str;
						k++;
					}
				}

				i++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				xwb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataObject;
	}

	public static void main(String[] args) throws Exception {
		// Object[][] data=ReadExcel.readDataFromExcel("c:\\\\ecshopTestCase.xlsx");
		Object[][] data = ReadExcel.readDataFromExcel("ecshopTestCase.xlsx", "regTestCase");
		// System.out.println(data[data.length - 1].length);
		for (int i = 0; i < data.length; i++) {
			for (int k = 0; k < data[data.length - 1].length; k++) {
				System.out.println(data[i][k]);
			}
		}
	}

}
