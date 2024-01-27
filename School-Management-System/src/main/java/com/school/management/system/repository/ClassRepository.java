package com.school.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.system.entity.Classes;

public interface ClassRepository extends JpaRepository<Classes, Long> {

	Classes findByClassId(Long classId);

}
