package com.giri.manage.demo.student.service.impl;

import java.util.List;

import com.giri.manage.demo.student.entity.FinalYear;

public interface ExcelFinal {
	List<FinalYear> getExcelDataAsList();
	int saveExcelData(List<FinalYear> invoices);
}
