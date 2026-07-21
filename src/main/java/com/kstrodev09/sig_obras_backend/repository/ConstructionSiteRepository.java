package com.kstrodev09.sig_obras_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kstrodev09.sig_obras_backend.entity.ConstructionSite;
import com.kstrodev09.sig_obras_backend.entity.Municipality;

public interface ConstructionSiteRepository extends JpaRepository<ConstructionSite, Long> {

    List<ConstructionSite> findByMunicipality(Municipality municipality);
    List<ConstructionSite> findByState(ConstructionSite state);

    
    
}
