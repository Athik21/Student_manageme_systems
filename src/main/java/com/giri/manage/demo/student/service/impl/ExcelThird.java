package com.giri.manage.demo.student.service.impl;

import java.util.List;

import com.giri.manage.demo.student.entity.ThirdYear;

public interface ExcelThird {
	List<ThirdYear> getExcelDataAsList();
	int saveExcelData(List<ThirdYear> invoices);
}
