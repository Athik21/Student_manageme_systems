package com.giri.manage.demo.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Curriculum;
import com.giri.manage.demo.student.repo.CurriculumRepo;

@Component
public class CurriculumService {
	@Autowired
	private CurriculumRepo repo;

	public CurriculumService(CurriculumRepo repo) {
		super();
		this.repo = repo;
	}
	
	public List<Curriculum> findall() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "sem"));
	}
	public List<Curriculum> findBySem(String sem,String reg){
		return repo.findBySemAndReg(sem,reg);
	}
	public List<Curriculum> findByYear(String sem){
		return repo.findByYear(sem);
	}
	public Curriculum add(Curriculum second) {
		return repo.save(second);
	}
	public void deletes(int id) {
		repo.deleteById(id);
	}
	public Optional<Curriculum> finds(int id) {
		return repo.findById(id);
	}
	
}
