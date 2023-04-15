package com.giri.manage.demo.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Attendance;

@Component
public interface AttendanceRepo extends JpaRepository<Attendance, Integer>{

	List<Attendance> findBySub(String sub);

	List<Attendance> findByDatesAndSubAndHour(String dates, String sub, String hour);
	
}
