package com.giri.manage.demo.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.Cources;
import com.giri.manage.demo.student.entity.Curriculum;
import com.giri.manage.demo.student.repo.CourceRepo;

@Service
public class CourceService {
	@Autowired
	private CourceRepo repo;
	public CourceService() {
		
	}
	public List<Cources> fetchAll() {
		return repo.findAll();
	}
}
