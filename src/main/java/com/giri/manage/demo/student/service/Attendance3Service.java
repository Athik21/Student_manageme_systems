package com.giri.manage.demo.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.Attendance3;
import com.giri.manage.demo.student.repo.Attendance3Repo;

@Service
public class Attendance3Service {
	@Autowired
	private Attendance3Repo repo;
	public Attendance3Service() {
		
	}
	public Optional<Attendance3> getById(int id){
		return repo.findById(id);
	}
	public List<Attendance3> findAll(){
		return repo.findAll();
	}
	public Attendance3 saves(Attendance3 att) {
		return repo.save(att);
	}
	public List<Attendance3> findBySubs(String sub){
		return repo.findBySub(sub);
	}
	public List<Attendance3> findByDS(String dates,String sub,String hour){
		return repo.findByDatesAndSubAndHour(dates,sub,hour);
	}
}
