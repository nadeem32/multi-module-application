package com.las.moduler.application.patientmodule.entity;

import com.las.moduler.application.basemodule.baseentity.BaseEntity;

import jakarta.persistence.Entity;

@Entity
public class Patient extends BaseEntity {
	private Long id;
	private String name;
	private String grade;
}
