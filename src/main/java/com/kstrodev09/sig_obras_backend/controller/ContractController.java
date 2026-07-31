package com.kstrodev09.sig_obras_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kstrodev09.sig_obras_backend.entity.ConstructionSite;
import com.kstrodev09.sig_obras_backend.entity.Contract;
import com.kstrodev09.sig_obras_backend.service.ContractService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public Contract findByContract(@RequestParam String contractNumber) {
        return contractService.findByContractNumber(contractNumber);
    }

    @GetMapping("/search")
    public List<Contract> findbyConstructionSiteId(@PathVariable Long constructionSiteId) {
        return contractService.findByConstructionSite(constructionSiteId);
    }

    @GetMapping("/by-construction-site/{constructionSiteId}")
    public List<Contract> findAll() {
        return contractService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contract created(@Valid @RequestBody Contract contract) {
        return contractService.save(contract);
    }

    @PutMapping("/{id}")
    public Contract update(@PathVariable Long id, @Valid @RequestBody Contract contract) {
        contract.setId(id);
        return contractService.save(contract);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        contractService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Contract findById(@PathVariable Long id) {
        return contractService.findById(id);
    }

}
