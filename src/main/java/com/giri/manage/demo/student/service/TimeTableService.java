package com.giri.manage.demo.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.TimeTable;
import com.giri.manage.demo.student.repo.TimeTableRepo;

@Service
public class TimeTableService {
	@Autowired
	private TimeTableRepo repo;
	public TimeTableService(TimeTableRepo repo) {
		this.repo=repo;
	}
	public TimeTable save(TimeTable timetable) {
		return repo.save(timetable);
	}
	
	public List<TimeTable> getAll() {
		return repo.findAll();
	}
	public TimeTable gets(String days){
		
		return repo.findByDays(days);
	}
	public TimeTable getOne(int id) {
		return repo.findById(id).orElse(null);
	}
	
}
