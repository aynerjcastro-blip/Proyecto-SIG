package com.kstrodev09.sig_obras_backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kstrodev09.sig_obras_backend.entity.ConstructionSite;
import com.kstrodev09.sig_obras_backend.entity.StatusHistory;


public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long> {
    
    List<StatusHistory> findByConstructionSiteOrderByChangeDateDesc(ConstructionSite constructionSite);
}
