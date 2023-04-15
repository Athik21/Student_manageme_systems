package com.giri.manage.demo.student.service.impl;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploaderService {
	public void uploadFile(MultipartFile file);
}
