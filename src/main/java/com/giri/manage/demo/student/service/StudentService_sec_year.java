package com.giri.manage.demo.student.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.giri.manage.demo.student.entity.Image;
import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.ThirdYear;
import com.giri.manage.demo.student.repo.StudentRepo_sec_year;
import com.giri.manage.demo.student.repo.StudentRepo_third_year;

@Service
public class StudentService_sec_year {
	@Autowired
	private StudentRepo_sec_year repo;
	public StudentService_sec_year() {
		
	}
	public List<SecondYear> getDetails() {
		return repo.findAll();
	}
	
	
	public SecondYear createById(int id) {
		return repo.findById(id).orElse(null);
	}
	public SecondYear findByRoll(String roll) {
		return repo.findByRoll(roll);
	}
	public SecondYear findByuname(String sec) {
		return repo.findByuname(sec);
	}
	public String auth(String uname,String password) {
		Optional<SecondYear> got= repo.findByUname(uname);
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if(got.isPresent()) {
			SecondYear sec =got.get();
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
	
	public SecondYear updateStudent(SecondYear student) {
		student.setYear("2");
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		student.setUname(student.getEmail());
		String encrypted = bcrypt.encode(student.getRoll());
		student.setPassw(encrypted);
		return repo.save(student);
	}
	public void deletebyid(int id) {
		repo.deleteById(id);
	}
	@Transactional
	public void delete() {
		repo.trunc();
	}
	public void saveStudent(SecondYear student) throws IOException{
		student.setYear("2");
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		student.setUname(student.getEmail());
		String encrypted = bcrypt.encode(student.getRoll());
		student.setPassw(encrypted);
		repo.save(student);

	}
	public void saveimage(MultipartFile file,String uname) throws IOException {
		SecondYear sec = repo.findByuname(uname);
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains("..")) {
			System.out.println("not a proper one");
		}
		sec.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		repo.save(sec);
	}
	public String change(String uname, String old, String newo) {
		Optional<SecondYear> sec = repo.findByUname(uname);
		if(sec.isPresent()) {
			SecondYear secs = sec.get();
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
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
