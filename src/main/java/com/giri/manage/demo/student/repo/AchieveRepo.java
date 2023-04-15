package com.giri.manage.demo.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Achievements;
import com.giri.manage.demo.student.entity.FinalYear;
import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.ThirdYear;

@Component
public interface AchieveRepo extends JpaRepository<Achievements, Integer>{

	List<Achievements> findByUname(String uname);

}
