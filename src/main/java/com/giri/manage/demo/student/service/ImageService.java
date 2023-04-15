package com.giri.manage.demo.student.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.giri.manage.demo.student.entity.Image;
import com.giri.manage.demo.student.repo.imagesrepo;



@Service
public class ImageService {
	@Autowired
	private imagesrepo repo;
	public ImageService(imagesrepo repo) {
		this.repo = repo;
	}
	public void savess(MultipartFile file, String name) throws IOException {
		Image i = new Image();
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains("..")) {
			System.out.println("not a proper one");
		}
		i.setName(name);
		i.setLogo(Base64.getEncoder().encodeToString(file.getBytes()));
		
		repo.save(i);
	}
	public List<Image> getAll() {
		
		return repo.findAll();
	}
}
