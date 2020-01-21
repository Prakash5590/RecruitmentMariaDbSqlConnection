package com.abnamro.employee.recruitmentApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecruitmentDaoImpl implements RecruitmentDao{
	
	@Autowired
	Connection conn;
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("RecruitmentDaoImpl preDestroy ");
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("RecruitmentDaoImpl postConstruct ");
	}

	@Override
	public String saveNewJob(String job_decription, String technology) {
		System.out.println("Inside RecruitmentDaoImpl ");
		try {
			PreparedStatement s = conn.prepareStatement("insert into jobs(job_decription,technology) values(?,?)");
			s.setString(1, job_decription);
			s.setString(2, technology);
			s.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Job Saved !!";
	}

}
