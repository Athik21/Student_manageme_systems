package com.giri.manage.demo.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Professional;

@Component
public interface ProfessionalRepo extends JpaRepository<Professional, Integer>{
	List<Professional> findByYear(String sem);

	List<Professional> findBySemAndReg(String sem, String reg);

}
