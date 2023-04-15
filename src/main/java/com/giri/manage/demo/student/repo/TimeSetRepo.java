package com.giri.manage.demo.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.TimeSet;

@Component
public interface TimeSetRepo extends JpaRepository<TimeSet, Integer>{
		@Modifying 
	    @Query(
	            value = "truncate table timeho",
	            nativeQuery = true
	    )
	    int deletes();
		TimeSet getByHour(int id);
}
