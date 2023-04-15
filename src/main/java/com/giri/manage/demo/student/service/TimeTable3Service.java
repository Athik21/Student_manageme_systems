package com.giri.manage.demo.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.TimeTable3;
import com.giri.manage.demo.student.repo.TimeTable3Repo;

@Service
public class TimeTable3Service {
	@Autowired
	private TimeTable3Repo repo;
	public TimeTable3Service(TimeTable3Repo repo) {
		this.repo=repo;
	}
	public TimeTable3 save(TimeTable3 timetable) {
		return repo.save(timetable);
	}
	
	public List<TimeTable3> getAll() {
		return repo.findAll();
	}
	public TimeTable3 getOne(int id) {
		return repo.findById(id).orElse(null);
	}
	public TimeTable3 gets(String days) {
		return repo.findByDays(days);
	}
}
