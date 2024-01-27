package com.school.management.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "Class")
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@Column(unique = true)
	private String name;
	private String classTeacherName;
	
	
	private int strength;
	private long classId;
}
