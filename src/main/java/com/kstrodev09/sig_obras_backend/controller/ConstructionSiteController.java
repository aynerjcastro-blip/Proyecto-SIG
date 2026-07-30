package com.kstrodev09.sig_obras_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kstrodev09.sig_obras_backend.entity.ConstructionSite;
import com.kstrodev09.sig_obras_backend.entity.ConstructionSiteState;
import com.kstrodev09.sig_obras_backend.entity.StatusHistory;
import com.kstrodev09.sig_obras_backend.service.ConstructionSiteService;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class ConstructionSiteController {

    private final ConstructionSiteService constructionSiteService;

    public ConstructionSiteController(ConstructionSiteService constructionSiteService) {
        this.constructionSiteService = constructionSiteService;
    }

    @PutMapping("/construction-sites/{id}/status")
    public ConstructionSite updateStatus(@PathVariable Long id, @RequestBody ConstructionSiteState newState) {
        return constructionSiteService.updateState(id, newState);

    }

    @GetMapping("/construction-sites/{id}/history")
    public List<StatusHistory> findHistoryByConstructionSite(@PathVariable Long id) {
        return constructionSiteService.findHistory(id);
    }

    @GetMapping("/construction-sites")
    public List<ConstructionSite> findAll() {
        return constructionSiteService.findAll();
    }

    @GetMapping("/consttruction-sites/{id}")
    public ConstructionSite findById(@PathVariable Long id) {
        return constructionSiteService.findById(id);
    }

    @PostMapping("/construction-sites")
    @ResponseStatus(HttpStatus.CREATED)

    public ConstructionSite create(@RequestBody ConstructionSite constructionSite) {
        return constructionSiteService.save(constructionSite);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        constructionSiteService.deleteById(id);
    }
}
