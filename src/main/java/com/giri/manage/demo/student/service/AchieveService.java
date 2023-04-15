package com.giri.manage.demo.student.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.giri.manage.demo.student.entity.Achievements;
import com.giri.manage.demo.student.entity.FinalYear;
import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.ThirdYear;
import com.giri.manage.demo.student.repo.AchieveRepo;

@Service
public class AchieveService {
	@Autowired
	private AchieveRepo repo;
	@Autowired
	private StudentService_final_year repo4;
	@Autowired
	private StudentService_sec_year repo2;
	@Autowired
	private StudentService_third_year repo3;
	public AchieveService() {
	}
	public List<Achievements> finds(String uname) {
		return repo.findByUname(uname);
	}
	public void saveimage(MultipartFile file,String uname,String desc) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains("..")) {
			System.out.println("not a proper one");
		}
		SecondYear sec = repo2.findByuname(uname);
		ThirdYear thi=repo3.findByuname(uname);
		FinalYear fin = repo4.findByuname(uname);
		Achievements achieve = new Achievements();
		if(sec!=null || thi!=null || fin!=null) {
			achieve.setUname(uname);
			achieve.setDesc(desc);
			achieve.setImg(Base64.getEncoder().encodeToString(file.getBytes()));
			repo.save(achieve);
		}
	}
}
