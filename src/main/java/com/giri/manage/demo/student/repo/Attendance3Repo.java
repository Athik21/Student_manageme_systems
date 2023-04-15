package com.giri.manage.demo.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Attendance3;

@Component
public interface Attendance3Repo extends JpaRepository<Attendance3, Integer>{

	List<Attendance3> findBySub(String sub);

	List<Attendance3> findByDatesAndSubAndHour(String dates, String sub, String hour);
	
}
