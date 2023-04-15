package com.giri.manage.demo.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.FinalYear;
import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.ThirdYear;

@Component
public interface StudentRepo_final_year extends JpaRepository<FinalYear, Integer>{

	FinalYear findByRoll(String roll);
	@Modifying    
	@Query(
	            value = "truncate table fi_year",
	            nativeQuery = true
	            
	    )
	 int trunc();
	Optional<FinalYear> findByUname(String uname);
	FinalYear findByuname(String uname);
}
