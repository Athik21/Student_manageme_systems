package com.giri.manage.demo.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.manage.demo.student.entity.TimeTable;

public interface TimeTableRepo extends JpaRepository<TimeTable, Integer>{

	TimeTable findByDays(String days);

}
