package com.kstrodev09.sig_obras_backend.controller;

import org.springframework.stereotype.Controller;

import com.kstrodev09.sig_obras_backend.service.ContractService;

@Controller
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService){
        this.contractService = contractService;
    }

    
}
