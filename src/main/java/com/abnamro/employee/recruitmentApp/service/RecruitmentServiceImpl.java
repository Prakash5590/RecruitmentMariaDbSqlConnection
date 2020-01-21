package com.abnamro.employee.recruitmentApp.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abnamro.employee.recruitmentApp.dao.RecruitmentDaoImpl;

@Service
public class RecruitmentServiceImpl implements RecruitmentService{

	@PreDestroy
	public void preDestroy() {
		System.out.println("RecruitmentServiceImpl preDestroy ");
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("RecruitmentServiceImpl postConstruct ");
	}

	@Autowired
	RecruitmentDaoImpl dao;
	
	@Override
	public String addJobOpening(String jobId, String desciption) {
		System.out.println("Insode Service Imple Layer ");
		dao.saveNewJob(jobId, desciption);
		return "Job Posted!!";
	}

}
