package com.las.moduler.application.patientmodule.service;

import org.springframework.stereotype.Service;

import com.las.moduler.application.basemodule.baseentity.GenericService;
import com.las.moduler.application.patientmodule.dto.PatientDTO;
import com.las.moduler.application.patientmodule.entity.Patient;
@Service
public class PatientService extends GenericService<Patient, PatientDTO, Long> {

	

	public PatientService() {
        super(Patient.class, PatientDTO.class);
    }

	
	
}
