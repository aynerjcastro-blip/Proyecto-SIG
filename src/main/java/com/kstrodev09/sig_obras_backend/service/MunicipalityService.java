package com.kstrodev09.sig_obras_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kstrodev09.sig_obras_backend.entity.Municipality;
import com.kstrodev09.sig_obras_backend.repository.MunicipalityRepository;

@Service
public class MunicipalityService {

    private final MunicipalityRepository municipalityRepository;

    public MunicipalityService(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    public List<Municipality> findAll() {
        return municipalityRepository.findAll();
    }

    public Municipality findById(Long id) {
        return municipalityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Municipio no encontrado con id: " + id));
    }

    public Municipality save(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }

    public void deleteById(Long id) {
        municipalityRepository.deleteById(id);
    }

}
