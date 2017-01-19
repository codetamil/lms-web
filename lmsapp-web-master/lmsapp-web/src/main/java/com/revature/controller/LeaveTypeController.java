package com.revature.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.LeaveType;
import com.revature.service.LeaveTypeService;

@CrossOrigin
@RestController
@RequestMapping("/leavetypes")
public class LeaveTypeController {
	LeaveTypeService leaveTypeService = new LeaveTypeService();

	@GetMapping("/{id}")
	public LeaveType findById(@PathVariable("id") Long id) {
		return leaveTypeService.findById(id);
	}

	@GetMapping("/")
	public List<LeaveType> list() {
		return leaveTypeService.list();
	}

	@PutMapping("/{id}/activate")
	public void activate(@PathVariable("id") Long id) {
		leaveTypeService.activate(id);
	}

	@PutMapping("/{id}/deactivate")
	public void deActivate(@PathVariable("id") Long id) {
		leaveTypeService.deActivate(id);
	}
}
