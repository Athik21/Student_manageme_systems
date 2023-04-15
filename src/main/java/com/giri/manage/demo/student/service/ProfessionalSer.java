package com.giri.manage.demo.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giri.manage.demo.student.entity.Curriculum;
import com.giri.manage.demo.student.entity.Professional;
import com.giri.manage.demo.student.repo.ProfessionalRepo;

@Service
public class ProfessionalSer {
	@Autowired
	private ProfessionalRepo repo;
	
	public ProfessionalSer() {
		
	}
	public List<Professional> findBySem(String sem, String reg){
		return repo.findBySemAndReg(sem,reg);
	}public List<Professional> findByYear(String sem){
		return repo.findByYear(sem);
	}
	public Professional add(Professional third) {
		return repo.save(third);
		
	}
	public void deletes(int id) {
		repo.deleteById(id);
		
	}
	public Optional<Professional> finds(int id) {
		return repo.findById(id);
	}
}
