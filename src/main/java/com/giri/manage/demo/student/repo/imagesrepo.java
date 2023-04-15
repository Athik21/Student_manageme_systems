package com.giri.manage.demo.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.giri.manage.demo.student.entity.Image;

@Component
public interface imagesrepo extends JpaRepository<Image, Integer>{

}
