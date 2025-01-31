package com.las.moduler.application.patientmodule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.las.moduler.application.basemodule.baseentity.GenericController;
import com.las.moduler.application.patientmodule.dto.PatientDTO;
import com.las.moduler.application.patientmodule.entity.Patient;
import com.las.moduler.application.patientmodule.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/patient/")
@Tag(name = "Documents", description = "APIs for managing documents")
public class PatientController extends GenericController<Patient, PatientDTO, Long>  {
	
	
	public PatientController(PatientService service) {
        super(service);
    }

	
	@GetMapping("test")
    @Operation(summary = "Patient Module APIs Test")
	public String testApi() {	
		return "I am running fine";
	}

}
