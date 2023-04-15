package com.giri.manage.demo.student;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.giri.manage.demo.student.entity.Attendance;
import com.giri.manage.demo.student.entity.Attendance3;
import com.giri.manage.demo.student.entity.Attendance4;
import com.giri.manage.demo.student.entity.FinalYear;
import com.giri.manage.demo.student.entity.SecondYear;

public class UserExcel4 {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	private List<FinalYear> secondyear;
	private List<Attendance4> att2;
	
	public UserExcel4(List<FinalYear> secondyear,List<Attendance4> att2) {
		super();
		this.secondyear = secondyear;
		this.att2 = att2;
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
		Row row2 = sheet.createRow(1);
		Row row3 = sheet.createRow(2);
		Cell cellp = row3.createCell(0);
		cellp.setCellValue("ROLL NUMBER");
		cellp.setCellStyle(style);
		int cells = 1,cells2=1;
		int store = 1,store2=1;
		Cell celln = row.createCell(0);
		celln.setCellValue("DATE:");
		celln.setCellStyle(style);
		Cell cellm = row.createCell(0);
		cellm = row2.createCell(1);
		cellm.setCellValue("HOUR:");
		cellm.setCellStyle(style);
		sheet.autoSizeColumn(0);
		for(Attendance4 att:att2) {
			Cell cell = row.createCell(cells++);
			String[] st = att.getDates().split(" ");
			cell.setCellValue(st[0]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(store++);
		}
		for(Attendance4 att:att2) {
			Cell cell = row2.createCell(cells2++);
			cell.setCellValue(att.getHour());
			cell.setCellStyle(style);
			sheet.autoSizeColumn(store2++);
		}
	}
	private void writeDataRows() {
		int createrow=2;
		Cell cellss = null;
		Row rows = null;
		for(FinalYear sec:secondyear) {
			if(sec.getId()==1) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA());}}	
			if(sec.getId()==2) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getB());}}
			if(sec.getId()==3) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getC());}}
			if(sec.getId()==4) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getD());}}
			if(sec.getId()==5) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getE());}}
			if(sec.getId()==6) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getF());}}
			if(sec.getId()==7) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getG());}}
			if(sec.getId()==8) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getH());}}
			if(sec.getId()==9) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getI());}}
			if(sec.getId()==10) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getJ());}}
			if(sec.getId()==11) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getK());}}
			if(sec.getId()==12) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getL());}}
			if(sec.getId()==13) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getM());}}
			if(sec.getId()==14) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getN());}}
			if(sec.getId()==15) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getO());}}
			if(sec.getId()==16) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getP());}}
			if(sec.getId()==17) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getQ());}}
			if(sec.getId()==18) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getR());}}
			if(sec.getId()==19) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getS());}}
			if(sec.getId()==20) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getT());}}
			if(sec.getId()==21) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getU());}}
			if(sec.getId()==22) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getV());}}
			if(sec.getId()==23) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getW());}}
			if(sec.getId()==24) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getX());}}
			if(sec.getId()==25) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getY());}}
			if(sec.getId()==26) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getZ());}}
			if(sec.getId()==27) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA1());}}
			if(sec.getId()==28) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA2());}}
			if(sec.getId()==29) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA3());}}
			if(sec.getId()==30) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA4());}}
			if(sec.getId()==31) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA5());}}
			if(sec.getId()==32) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA6());}}
			if(sec.getId()==33) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA7());}}
			if(sec.getId()==34) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA8());}}
			if(sec.getId()==35) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA9());}}
			if(sec.getId()==36) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA10());}}
			if(sec.getId()==37) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA11());}}
			if(sec.getId()==38) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA12());}}
			if(sec.getId()==39) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA13());}}
			if(sec.getId()==40) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA14());}}
			if(sec.getId()==41) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA15());}}
			if(sec.getId()==42) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA16());}}
			if(sec.getId()==43) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA17());}}
			if(sec.getId()==44) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA18());}}
			if(sec.getId()==45) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA19());}}
			if(sec.getId()==46) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA20());}}
			if(sec.getId()==47) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA21());}}
			if(sec.getId()==48) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA22());}}
			if(sec.getId()==49) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA23());}}
			if(sec.getId()==50) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA24());}}
			if(sec.getId()==51) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA25());}}
			if(sec.getId()==52) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA26());}}
			if(sec.getId()==53) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA27());}}
			if(sec.getId()==54) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA28());}}
			if(sec.getId()==55) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA29());}}
			if(sec.getId()==56) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA30());}}
			if(sec.getId()==57) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA31());}}
			if(sec.getId()==58) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA32());}}
			if(sec.getId()==59) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA33());}}
			if(sec.getId()==60) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA34());}}
			if(sec.getId()==61) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA35());}}
			if(sec.getId()==62) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA36());}}
			if(sec.getId()==63) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA37());}}
			if(sec.getId()==64) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA38());}}
			if(sec.getId()==65) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA39());}}
			if(sec.getId()==66) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA40());}}
			if(sec.getId()==67) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA41());}}
			if(sec.getId()==68) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA42());}}
			if(sec.getId()==69) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA43());}}
			if(sec.getId()==70) {createrow++;rows = sheet.createRow(createrow);int columnvalue=1;cellss = rows.createCell(0);cellss.setCellValue(sec.getRoll());for(Attendance4 att3:att2){cellss = rows.createCell(columnvalue++);cellss.setCellValue(att3.getA44());}}
		}
	}
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRows();
		OutputStream stream = response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		stream.close();
	}
}
