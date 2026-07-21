package com.kstrodev09.sig_obras_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kstrodev09.sig_obras_backend.entity.Municipality;


public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {

    Optional<Municipality> findByDaneCode(String daneCode);
}

