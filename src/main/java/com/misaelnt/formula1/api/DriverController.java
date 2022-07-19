package com.misaelnt.formula1.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.misaelnt.formula1.data.Driver;
import com.misaelnt.formula1.exception.error404.DriverNotFoundException;
import com.misaelnt.formula1.repository.DriverRepository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/drivers")
   ResponseEntity<List<Driver>> findAll() {
        return ResponseEntity.ok().body(driverRepository.findAll());
    }

    @GetMapping("/drivers/{id}")
    ResponseEntity<Driver> findDriver(@PathVariable Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException());
        return ResponseEntity.ok().body(driver);
    }
}
