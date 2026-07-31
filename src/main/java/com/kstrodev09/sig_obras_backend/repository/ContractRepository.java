package com.kstrodev09.sig_obras_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kstrodev09.sig_obras_backend.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByConstructionSiteId(Long constructionSiteId);

    Optional<Contract> findByContractNumber(String contractNumber);
}
