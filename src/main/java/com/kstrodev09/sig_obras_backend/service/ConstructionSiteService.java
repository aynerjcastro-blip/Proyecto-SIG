package com.kstrodev09.sig_obras_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kstrodev09.sig_obras_backend.entity.ConstructionSite;
import com.kstrodev09.sig_obras_backend.entity.ConstructionSiteState;
import com.kstrodev09.sig_obras_backend.entity.StatusHistory;
import com.kstrodev09.sig_obras_backend.repository.ConstructionSiteRepository;

@Service
public class ConstructionSiteService {

    private final ConstructionSiteRepository constructionSiteRepository;
    private final StatusHistoryService statusHistoryService;

    public ConstructionSiteService(ConstructionSiteRepository constructionSiteRepository,
            StatusHistoryService statusHistoryService) {
        this.constructionSiteRepository = constructionSiteRepository;
        this.statusHistoryService = statusHistoryService;
    }

    public List<ConstructionSite> findAll() {
        return constructionSiteRepository.findAll();
    }

    public ConstructionSite findById(Long id) {
        return constructionSiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra no encontrada con id: " + id));
    }

    public ConstructionSite save(ConstructionSite constructionSite) {
        return constructionSiteRepository.save(constructionSite);
    }

    public void deleteById(Long id) {
        constructionSiteRepository.deleteById(id);
    }

    public ConstructionSite updateState(Long id, ConstructionSiteState newState) {
        ConstructionSite site = findById(id);
        ConstructionSiteState oldState = site.getState();

        site.setState(newState);
        ConstructionSite updated = constructionSiteRepository.save(site);

        statusHistoryService.recordChange(updated, oldState, newState);

        return updated;
    }

    public List<StatusHistory> findHistory(Long id) {
        ConstructionSite site = findById(id);
        return statusHistoryService.findHistoryByConstructionSite(site);
    }
}