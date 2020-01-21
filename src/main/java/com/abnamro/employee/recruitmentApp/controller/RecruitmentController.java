package com.abnamro.employee.recruitmentApp.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abnamro.employee.recruitmentApp.service.RecruitmentServiceImpl;

@RestController
public class RecruitmentController {

	@PreDestroy
	public void preDestroy() {
		System.out.println("RecruitmentController preDestroy ");
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("RecruitmentController postConstruct ");
	}
	
	@Autowired
	RecruitmentServiceImpl service;
	
	@GetMapping("/recruit")
	public String recruit(@RequestParam String jobDesc,@RequestParam String tech) {
		System.out.println("Inside Rest aopi.!!");
		service.addJobOpening(jobDesc, tech);
		return "Recruted";
	}
}
