package com.giri.manage.demo.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giri.manage.demo.student.entity.TimeTable4;

public interface TimeTable4Repo extends JpaRepository<TimeTable4, Integer>{

	TimeTable4 findByDays(String days);

}
