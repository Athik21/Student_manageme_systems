package com.giri.manage.demo.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.Attendance;
import com.giri.manage.demo.student.repo.AttendanceRepo;

@Service
public class AttendanceService {
	@Autowired
	private AttendanceRepo repo;
	public AttendanceService() {
		
	}
	public Optional<Attendance> getById(int id){
		return repo.findById(id);
	}
	public List<Attendance> findAll(){
		return repo.findAll();
	}
	public Attendance saves(Attendance att) {
		return repo.save(att);
	}
	public List<Attendance> findBySubs(String sub){
		return repo.findBySub(sub);
	}
	public List<Attendance> findByDS(String dates,String sub,String hour){
		return repo.findByDatesAndSubAndHour(dates,sub,hour);
	}
}
