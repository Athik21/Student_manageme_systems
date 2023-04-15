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

import com.giri.manage.demo.student.entity.FinalYear;
import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.ThirdYear;
import com.giri.manage.demo.student.repo.StudentRepo_final_year;
import com.giri.manage.demo.student.repo.StudentRepo_third_year;

@Service
public class StudentService_final_year {
	@Autowired
	private StudentRepo_final_year repo;
	public StudentService_final_year() {
		
	}
	public List<FinalYear> getDetails() {
		return repo.findAll();
	}
	
	public FinalYear saveStudent(FinalYear student) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		student.setUname(student.getEmail());
		String encrypted = bcrypt.encode(student.getRoll());
		student.setPassw(encrypted);
		student.setYear("4");
		return repo.save(student);
	}
	public FinalYear findByRoll(String roll) {
		return repo.findByRoll(roll);
	}
	public FinalYear createById(int id) {
		return repo.findById(id).get();
	}
	public FinalYear updateStudent(FinalYear student) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		student.setUname(student.getEmail());
		String encrypted = bcrypt.encode(student.getRoll());
		student.setPassw(encrypted);
		student.setYear("4");
		return repo.save(student);
	}
	public void deletebyid(int id) {
		repo.deleteById(id);
	}
	@Transactional
	public void delete() {
		repo.trunc();
	}
	public String auth(String uname,String password) {
		Optional<FinalYear> got= repo.findByUname(uname);
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if(got.isPresent()) {
			FinalYear sec =got.get();
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
	public void saveimage(MultipartFile file,String uname) throws IOException {
		FinalYear sec = repo.findByuname(uname);
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains("..")) {
			System.out.println("not a proper one");
		}
		sec.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		repo.save(sec);
	}
	public String change(String uname, String old, String newo) {
		Optional<FinalYear> sec = repo.findByUname(uname);
		if(sec.isPresent()) {
			FinalYear secs = sec.get();
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
	public FinalYear findByuname(String sec) {
		return repo.findByuname(sec);
	}
}
