package com.kstrodev09.sig_obras_backend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.kstrodev09.sig_obras_backend.entity.Municipality;
import com.kstrodev09.sig_obras_backend.service.MunicipalityService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/municipalities")

public class MunicipalityController {
    private final MunicipalityService municipalityService;

    public MunicipalityController(MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    /*
     * Find all municipalities
     * @return List of municipalities   
     */
    @GetMapping("path")
    public List<Municipality> findAll() {
        return municipalityService.findAll();
    }

    /*
     * Find a municipality by ID
     * @param id the ID of the municipality to find
     * @return the municipality with the specified ID
     */

    @GetMapping("{id}")
    public Municipality findById(@PathVariable Long id) {
        return municipalityService.findById(id);
    }



    /*
     * Create a new municipality
     * @param municipality the municipality to create
     * @return the created municipality
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Municipality create(@Valid @RequestBody Municipality municipality) {
        return municipalityService.save(municipality);
    }

    /*
     * Update an existing municipality
     * @param id the ID of the municipality to update
     * @param municipality the municipality with updated information
     * @return the updated municipality
     */
    @PutMapping("/{id}")
    public Municipality update(@PathVariable Long id, @Valid @RequestBody Municipality municipality) {
        municipality.setId(id);
        return municipalityService.save(municipality);

    }
    /*
     * Delete a municipality by ID
     * @param id the ID of the municipality to delete
     */
    

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        municipalityService.deleteById(id);
    }



}
