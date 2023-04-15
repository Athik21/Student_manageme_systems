package com.giri.manage.demo.student.service;

import java.util.List;

import com.giri.manage.demo.student.entity.SecondYear;

public interface IExcelDataService {
	List<SecondYear> getExcelDataAsList();
	int saveExcelData(List<SecondYear> invoices);
}
