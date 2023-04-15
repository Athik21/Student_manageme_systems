package com.giri.manage.demo.student.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.TimeSet;
import com.giri.manage.demo.student.repo.TimeSetRepo;

@Service
public class TimeSetService {
	@Autowired
	private TimeSetRepo repo;
	public TimeSetService() {
		
	}
	public Optional<TimeSet> finds(int fi) {
		return repo.findById(fi);
	}
	public TimeSet saves(TimeSet timeset) {
		return repo.save(timeset);
	}
	public List<TimeSet> get() {
		return repo.findAll();
	}
	public TimeSet getByIds(int id) {
		return repo.getByHour(id);
	}
	@Transactional
	public void del() {
		repo.deletes();
	}
}
