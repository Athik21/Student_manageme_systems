package com.giri.manage.demo.student.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.ThirdYear;
import com.giri.manage.demo.student.repo.StudentRepo_sec_year;
import com.giri.manage.demo.student.repo.StudentRepo_third_year;
import com.giri.manage.demo.student.service.impl.ExcelThird;

@Service
public class ExcelUploadThird implements ExcelThird {

	@Value("${app.upload.file3:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	StudentRepo_third_year repo;

	Workbook workbook;


	public List<ThirdYear> getExcelDataAsList() {

		List<String> list = new ArrayList<String>();

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Retrieving the number of sheets in the Workbook
		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("-------Sheet has '"+noOfColumns+"' columns------");

		// Using for-each loop to iterate over the rows and columns
		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
				list.add(cellValue);
			}
		}

		// filling excel data and creating list as List<Invoice>
		List<ThirdYear> invList = createList(list, noOfColumns);

		// Closing the workbook
		try {
			workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return invList;
	}

	private List<ThirdYear> createList(List<String> excelData, int noOfColumns) {

		ArrayList<ThirdYear> invList = new ArrayList<ThirdYear>();

		int i = noOfColumns;
		do {
			ThirdYear inv = new ThirdYear();
			inv.setRoll(excelData.get(i));
			inv.setName(excelData.get(i+1));
			inv.setDob(excelData.get(i+2));
			inv.setFather(excelData.get(i+3));
			inv.setMother(excelData.get(i+4));
			inv.setPar_num(excelData.get(i+5));
			inv.setYear("3");
			inv.setPhone(excelData.get(i+7));
			inv.setEmail(excelData.get(i+8));
			inv.setAadhar(excelData.get(i+9));
			inv.setCast(excelData.get(i+10));
			inv.setRegulation(excelData.get(i+11));
			inv.setSem(excelData.get(i+12));
			inv.setAddress(excelData.get(i+13));
			inv.setState(excelData.get(i+14));
			inv.setTaluk(excelData.get(i+15));
			inv.setDistrict(excelData.get(i+16));
			inv.setPincode(excelData.get(i+17));
			inv.setB_grp(excelData.get(i+18));
			inv.setGender(excelData.get(i+19));
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			inv.setUname(inv.getEmail());
			String encrypted = bcrypt.encode(inv.getRoll());
			inv.setPassw(encrypted);
			invList.add(inv);
			i = i + (noOfColumns);

		} while (i < excelData.size());
		return invList;
	}

	@Override
	public int saveExcelData(List<ThirdYear> invoices) {
		invoices = repo.saveAll(invoices);
		return invoices.size();
	}
}