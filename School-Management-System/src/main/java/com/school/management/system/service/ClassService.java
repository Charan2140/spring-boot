package com.school.management.system.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.system.entity.Classes;
import com.school.management.system.exception.ClassIdNotFoundException;
import com.school.management.system.repository.ClassRepository;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository classRepository;

	public void save(Classes classDetails) {
		classRepository.save(classDetails);	
	}

	public List<Classes> getDetails() {
		return classRepository.findAll();
	}

	public Classes getDetailsById(Long classId) {
		Classes classDetails = classRepository.findByClassId(classId);
		if(classDetails == null) {
			throw new ClassIdNotFoundException("No class found with " + classId);
		}else {
			return classDetails;
		}
		
	}

	public void deleteAllDetails() {
		classRepository.deleteAll();
		
	}

	public void deleteDetailsById(Long classId) {
		classRepository.deleteById(classId);
		
	}

	public Classes updateDetailsByClassId(Long classId, Classes classDetails) {
		Classes classDetailsFromRepo = classRepository.findByClassId(classId);
		classDetailsFromRepo.setClassId(Objects.isNull(classDetails.getClassId())?classDetails.getClassId():classDetailsFromRepo.getClassId());
		classDetailsFromRepo.setClassTeacherName(classDetails.getClassTeacherName()!=null?classDetails.getClassTeacherName():classDetailsFromRepo.getClassTeacherName());
		classDetailsFromRepo.setName(classDetails.getName()!=null?classDetails.getName():classDetailsFromRepo.getName());
		classDetailsFromRepo.setStrength(String.valueOf(classDetails.getStrength())!= null? classDetailsFromRepo.getStrength():classDetails.getStrength());
		classRepository.save(classDetailsFromRepo);
		return classDetailsFromRepo;
	}

}
