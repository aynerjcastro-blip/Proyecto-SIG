package com.kstrodev09.sig_obras_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kstrodev09.sig_obras_backend.entity.ConstructionSite;
import com.kstrodev09.sig_obras_backend.entity.ConstructionSiteState;
import com.kstrodev09.sig_obras_backend.service.ConstructionSiteService;

@Controller
public class ConstructionSiteController {
    
    private final ConstructionSiteService constructionSiteService;

    public ConstructionSiteController(ConstructionSiteService constructionSiteService) {
        this.constructionSiteService = constructionSiteService;
    }
    

    @PutMapping("/construction-sites/{id}/status")
    public void recordChange(@PathVariable Long id, @RequestBody ConstructionSiteState previousState, @RequestBody ConstructionSiteState newState) {

    }
}
