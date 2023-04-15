package com.giri.manage.demo.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Cources;

@Component
public interface CourceRepo extends JpaRepository<Cources, Integer>{
	
}
