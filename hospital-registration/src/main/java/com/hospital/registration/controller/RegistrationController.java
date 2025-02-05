package com.hospital.registration.controller;

import com.hospital.registration.dto.RegistrationDTO;
import com.hospital.registration.entity.Registration;
import com.hospital.registration.service.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public RegistrationDTO save(@RequestBody RegistrationDTO registrationDTO) {
        Registration registration = modelMapper.map(registrationDTO, Registration.class);
        Registration saved = registrationService.save(registration);
        return modelMapper.map(saved, RegistrationDTO.class);
    }

    @GetMapping("/{id}")
    public RegistrationDTO getById(@PathVariable Long id) {
        Optional<Registration> registration = registrationService.findById(id);
        return registration.map(r -> modelMapper.map(r, RegistrationDTO.class)).orElse(null);
    }

    @GetMapping
    public Page<RegistrationDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        Page<Registration> registrations = registrationService.findAll(PageRequest.of(page, size));
        return registrations.map(r -> modelMapper.map(r, RegistrationDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        registrationService.deleteById(id);
    }
}
