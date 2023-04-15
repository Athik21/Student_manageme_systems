package com.giri.manage.demo.student;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.giri.manage.demo.student.entity.Attendance4;
import com.giri.manage.demo.student.entity.FinalYear;

public class ExcelExport {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	public ExcelExport() {
		super();
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Second_year_students");
	}
	private void writeHeaderRow() {
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(14);
		style.setFont(font);
		
		Row row = sheet.createRow(0);
		Cell cell1 = row.createCell(0);
		cell1.setCellValue("Roll Number:");
		Cell cell2 = row.createCell(1);
		cell2.setCellValue("Name:");
		Cell cell3 = row.createCell(2);
		cell3.setCellValue("DOB:");
		Cell cell4 = row.createCell(3);
		cell4.setCellValue("Father' Name:");
		Cell cell5 = row.createCell(4);
		cell5.setCellValue("Mother's Name:");
		Cell cell6 = row.createCell(5);
		cell6.setCellValue("Parent's Mobile:");
		Cell cell7 = row.createCell(6);
		cell7.setCellValue("Year:");
		Cell cell8 = row.createCell(7);
		cell8.setCellValue("Phone Number:");
		Cell cell9 = row.createCell(8);
		cell9.setCellValue("Email Id:");
		Cell cell10 = row.createCell(9);
		cell10.setCellValue("Aadhar Id:");
		Cell cell11 = row.createCell(10);
		cell11.setCellValue("Community:");
		Cell cell12 = row.createCell(11);
		cell12.setCellValue("Regulation:");
		Cell cell13 = row.createCell(12);
		cell13.setCellValue("Semester:");
		Cell cell14 = row.createCell(13);
		cell14.setCellValue("Address:");
		Cell cell15 = row.createCell(14);
		cell15.setCellValue("State:");
		Cell cell16 = row.createCell(15);
		cell16.setCellValue("Taluk/City:");
		Cell cell17 = row.createCell(16);
		cell17.setCellValue("District:");
		Cell cell18 = row.createCell(17);
		cell18.setCellValue("Pincode:");
		Cell cell19 = row.createCell(18);
		cell19.setCellValue("Blood Group:");
		Cell cell20 = row.createCell(19);
		cell20.setCellValue("Gender:");
		sheet.autoSizeColumn(0);sheet.autoSizeColumn(1);sheet.autoSizeColumn(2);sheet.autoSizeColumn(3);sheet.autoSizeColumn(4);sheet.autoSizeColumn(5);sheet.autoSizeColumn(6);sheet.autoSizeColumn(7);sheet.autoSizeColumn(8);sheet.autoSizeColumn(9);sheet.autoSizeColumn(10);sheet.autoSizeColumn(11);sheet.autoSizeColumn(12);sheet.autoSizeColumn(13);sheet.autoSizeColumn(14);sheet.autoSizeColumn(15);sheet.autoSizeColumn(16);sheet.autoSizeColumn(17);sheet.autoSizeColumn(18);sheet.autoSizeColumn(19);
		
	}
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		OutputStream stream = response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		stream.close();
	}
}
