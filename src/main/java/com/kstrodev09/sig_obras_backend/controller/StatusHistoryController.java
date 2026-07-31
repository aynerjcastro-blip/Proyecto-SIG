package com.kstrodev09.sig_obras_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kstrodev09.sig_obras_backend.service.StatusHistoryService;

@RestController
public class StatusHistoryController {
    private final StatusHistoryService statusHistoryService;
    public StatusHistoryController(StatusHistoryService statusHistoryService){
        this.statusHistoryService = statusHistoryService;
    }
    
}
