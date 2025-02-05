package com.hospital.registration.repository;

import com.hospital.common.repository.BaseRepository;
import com.hospital.registration.entity.Registration;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends BaseRepository<Registration, Long> {
}
