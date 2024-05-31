package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DashboardModel;

@RestController
@RequestMapping("dashboard")
public class DashBoardController {
	

	@GetMapping("/getDashboardDetails")
	public String getDashboardDetails( @RequestBody DashboardModel dashboardModel) {
		
		
		return null;
	}
	
}