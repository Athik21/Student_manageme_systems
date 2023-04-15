package com.giri.manage.demo.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.TimeTable4;
import com.giri.manage.demo.student.repo.TimeTable4Repo;

@Service
public class TimeTable4Service {
	@Autowired
	private TimeTable4Repo repo;
	public TimeTable4Service(TimeTable4Repo repo) {
		this.repo=repo;
	}
	public TimeTable4 save(TimeTable4 timetable) {
		return repo.save(timetable);
	}
	
	public List<TimeTable4> getAll() {
		return repo.findAll();
	}
	public TimeTable4 getOne(int id) {
		return repo.findById(id).orElse(null);
	}
	public TimeTable4 gets(String days) {
		return repo.findByDays(days);
	}
}
