package com.giri.manage.demo.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.ThirdYear;

@Component
public interface StudentRepo_sec_year extends JpaRepository<SecondYear, Integer>{

	SecondYear findByRoll(String roll);
	@Modifying    
	@Query(
	            value = "truncate table sec_year",
	            nativeQuery = true
	            
	    )
	 int trunc();
	Optional<SecondYear> findByUname(String uname);
	SecondYear findByuname(String uname);
}
