package com.kstrodev09.sig_obras_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kstrodev09.sig_obras_backend.entity.ConstructionSite;
import com.kstrodev09.sig_obras_backend.entity.ConstructionSiteState;
import com.kstrodev09.sig_obras_backend.entity.StatusHistory;
import com.kstrodev09.sig_obras_backend.repository.StatusHistoryRepository;

@Service
public class StatusHistoryService {

    private final StatusHistoryRepository statusHistoryRepository;

    public StatusHistoryService(StatusHistoryRepository statusHistoryRepository) {
        this.statusHistoryRepository = statusHistoryRepository;
    }

    public void recordChange(ConstructionSite constructionSite,
            ConstructionSiteState previousState,
            ConstructionSiteState newState) {
        StatusHistory history = StatusHistory.builder()
                .constructionSite(constructionSite)
                .previousState(previousState)
                .currentState(newState)
                .changeDate(LocalDateTime.now())
                .build();

        statusHistoryRepository.save(history);
    }

    public List<StatusHistory> findHistoryByConstructionSite(ConstructionSite constructionSite) {
        return statusHistoryRepository.findByConstructionSiteOrderByChangeDateDesc(constructionSite);
    }
}