package com.backbase.atm.controller.api;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.atm.model.Atm;
import com.backbase.atm.support.AtmHolder;

/**
 * Define ATM Restful service
 * 
 * @author Carlos Alberto
 *
 */
@RestController
@RequestMapping("/api/v1/atms")
public class AtmRestController {

    private final AtmHolder atmHolder;

    public AtmRestController(final AtmHolder atmHolder) {
        this.atmHolder = atmHolder;
    }

    @GetMapping
    public ResponseEntity<List<Atm>> findAll(final Optional<String> filter) {
        List<Atm> atmList = null;

        // Find using filter
        if (filter.isPresent()) {
            atmList = findByFilter(filter.get());
        } else {
            // Find all
            atmList = atmHolder.getAtmList();
        }

        // Case there's content
        if (!atmList.isEmpty()) {
            return ResponseEntity.ok(atmList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    private List<Atm> findByFilter(final String filter) {
        // For future use, we could create new criteria splitting them by |
        // symbol
        String[] filterPipe = StringUtils.split(filter, "|");

        if (filterPipe == null) {
            filterPipe = new String[] { filter };
        }

        // Get criteria key / value
        final Properties filterProperties = StringUtils.splitArrayElementsIntoProperties(filterPipe, "::");

        // Filter Atms using criteria
        final List<Atm> atmList = atmHolder.getAtmList().stream()
                .filter(atm -> atm.getAddress().getCity().equalsIgnoreCase(
                        filterProperties.get("city") == null ? "" : filterProperties.get("city").toString()))
                .collect(Collectors.toList());

        return atmList;
    }
}