package com.hospital.registration.service;

import com.hospital.common.service.BaseServiceImpl;
import com.hospital.registration.entity.Registration;
import com.hospital.registration.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService extends BaseServiceImpl<Registration, Long> {
    public RegistrationService(RegistrationRepository repository) {
        super(repository);
    }
}
