package com.giri.manage.demo.student.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Curriculum;

@Component
public interface CurriculumRepo extends JpaRepository<Curriculum, Integer>{


	List<Curriculum> findBySemAndReg(String sem, String reg);

	List<Curriculum> findByYear(String sem);

}
