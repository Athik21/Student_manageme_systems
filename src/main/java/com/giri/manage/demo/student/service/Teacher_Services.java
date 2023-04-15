package com.giri.manage.demo.student.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.Teachers;
import com.giri.manage.demo.student.entity.ThirdYear;
import com.giri.manage.demo.student.repo.TeacherRepo;

@Service
public class Teacher_Services{
	@Autowired
	private TeacherRepo repo;
	public Teacher_Services(){
		
	}
	public List<Teachers> getDetails(){
		return repo.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	public Teachers findbyid(int id) {
		return repo.findById(id).get();
	}
	public void savetec(Teachers teacher) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		teacher.setUname(teacher.getEmail());
		String encrypted = bcrypt.encode(teacher.getTecid());
		teacher.setPassw(encrypted);
		repo.save(teacher);
	}
	public Teachers find(int id) {
		return repo.findById(id).orElse(null);
	}
	public Teachers findName(String name) {
		return repo.findByName(name);
	}
	public Teachers findbyuname(String uname) {
		return repo.findByuname(uname);
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
	public String auth(String uname,String password) {
		Optional<Teachers> got= repo.findByUname(uname);
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if(got.isPresent()) {
			Teachers sec =got.get();
			if(bcrypt.matches(password, sec.getPassw())) {
				if(uname.equals(sec.getUname())) {
					return "valid";
				}
			}
			else {
				return "invalid";
			}
		}
		return "notfound";
	}
	public String rollauth(String uname,String password,String roll) {
		Optional<Teachers> got= repo.findByUname(uname);
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if(got.isPresent()) {
			Teachers sec =got.get();
			if(bcrypt.matches(password, sec.getPassw())&&roll.equals(sec.getRoll())) {
				if(uname.equals(sec.getUname())) {
					return "valid";
				}
			}
			else {
				return "invalid";
			}
		}
		return "notfound";
	}
	public void saveimage(MultipartFile file,String uname) throws IOException {
		Teachers tec = repo.findByuname(uname);
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains("..")) {
			System.out.println("not a proper one");
		}
		tec.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		repo.save(tec);
	}
	public String change(String uname, String old, String newo) {
		Optional<Teachers> sec = repo.findByUname(uname);
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if(sec.isPresent()) {
			Teachers secs = sec.get();
			if(bcrypt.matches(old, secs.getPassw())) {
				String encrypted = bcrypt.encode(newo);
				secs.setPassw(encrypted);
				repo.save(secs);
				return "changed";
			}
			else {
				return "not";
			}
		}
		else {
			return "noo";
		}
	}
}
