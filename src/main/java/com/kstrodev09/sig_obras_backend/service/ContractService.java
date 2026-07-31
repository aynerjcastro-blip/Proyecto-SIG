package com.kstrodev09.sig_obras_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.kstrodev09.sig_obras_backend.entity.Contract;
import com.kstrodev09.sig_obras_backend.repository.ContractRepository;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract findByContractNumber(String contractNumber) {
        return contractRepository.findByContractNumber(contractNumber)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado con número: " + contractNumber));
    }

    public List<Contract> findByConstructionSite(Long constructionSiteId) {
        return contractRepository.findByConstructionSiteId(constructionSiteId);
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    public Contract findById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado con id: " + id));
    }

}
