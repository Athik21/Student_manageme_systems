package com.giri.manage.demo.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.Attendance4;
import com.giri.manage.demo.student.repo.Attendance4Repo;

@Service
public class Attendance4Service {
	@Autowired
	private Attendance4Repo repo;
	public Attendance4Service() {
		
	}
	public Optional<Attendance4> getById(int id){
		return repo.findById(id);
	}
	public List<Attendance4> findAll(){
		return repo.findAll();
	}
	public Attendance4 saves(Attendance4 att) {
		return repo.save(att);
	}
	public List<Attendance4> findBySubs(String sub){
		return repo.findBySub(sub);
	}
	public List<Attendance4> findByDS(String dates,String sub,String hour){
		return repo.findByDatesAndSubAndHour(dates,sub,hour);
	}
}
