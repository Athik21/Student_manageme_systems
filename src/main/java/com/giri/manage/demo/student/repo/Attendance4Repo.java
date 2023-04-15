package com.giri.manage.demo.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Attendance4;

@Component
public interface Attendance4Repo extends JpaRepository<Attendance4, Integer>{

	List<Attendance4> findBySub(String sub);
	
	List<Attendance4> findByDatesAndSubAndHour(String dates, String sub, String hour);
	
}
