package com.giri.manage.demo.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.manage.demo.student.entity.TimeTable3;

public interface TimeTable3Repo extends JpaRepository<TimeTable3, Integer>{

	TimeTable3 findByDays(String days);

}
