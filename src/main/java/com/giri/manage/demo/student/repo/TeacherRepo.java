package com.giri.manage.demo.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Teachers;

@Component
public interface TeacherRepo extends JpaRepository<Teachers, Integer>{
	Teachers findByName(String name);

	Optional<Teachers> findByUname(String uname);
    Teachers findByuname(String uname);
}
