package com.school.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.system.entity.Classes;
import com.school.management.system.service.ClassService;

@RestController
@RequestMapping("/schoolManagement/class")
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createClass(@RequestBody Classes classDetails){
		classService.save(classDetails);
		return new ResponseEntity<String>("Class Created Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllDetails")
	public ResponseEntity<List<Classes>> getClassDetails(){
		List<Classes> classDetails = classService.getDetails();
		return new ResponseEntity<List<Classes>>(classDetails, HttpStatus.OK);
	}	
	
	@GetMapping("/getDetails/{classId}")
	public ResponseEntity<Classes> getClassDetailsById(@PathVariable Long classId){
		Classes classDetails = classService.getDetailsById(classId);
		return new ResponseEntity<Classes>(classDetails, HttpStatus.OK);
	}
	
	@PutMapping("/updateDetails/{classId}")
	public ResponseEntity<Classes> updateClassDetailsById(@PathVariable Long classId, @RequestBody Classes classDetails){
		classDetails = classService.updateDetailsByClassId(classId, classDetails);
		return new ResponseEntity<Classes>(classDetails, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteAllDetails")
	public ResponseEntity<String> deleteClassDetails(){
		classService.deleteAllDetails();
		return new ResponseEntity<String>("deleted all class details", HttpStatus.OK);
	}	
	
	@GetMapping("/deleteDetails/{classId}")
	public ResponseEntity<String> deleteClassDetailsById(@PathVariable Long classId){
		classService.deleteDetailsById(classId);
		return new ResponseEntity<String>("deleted " + classId + " successfully", HttpStatus.OK);
	}	

}
