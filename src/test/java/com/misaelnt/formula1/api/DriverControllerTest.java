package com.misaelnt.formula1.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.misaelnt.formula1.data.Driver;
import com.misaelnt.formula1.exception.error404.DriverNotFoundException;
import com.misaelnt.formula1.repository.DriverRepository;

@ExtendWith(MockitoExtension.class)
public class DriverControllerTest {
    
    private static final String DRIVER_NOT_FOUND_EXCEPTION_MESSAGE = "The driver was not found.";
    @Mock
    DriverRepository driverRepository;

    DriverController driverController;

    @BeforeEach
    private void setUp() {
        driverController = new DriverController(driverRepository);
    }

    @Test
    public void findAll_expectDependenciesToBeCalled() throws Exception {
        List<Driver> drivers = new ArrayList<>();
        Driver driver1 = new Driver(2L, "George", "Russel", null);
        Driver driver2 = new Driver(3L, "Lando", "Norris", null);

        drivers.add(driver1);
        drivers.add(driver2);

        when(driverRepository.findAll()).thenReturn(drivers);

        ResponseEntity<List<Driver>> responseEntity = driverController.findAll();

        assertThat(responseEntity.getStatusCode(), Matchers.is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), Matchers.is(drivers));
    }

    @Test
    public void findDriver_withValidId_shouldReturnExistingDriver() throws Exception {
        Long driverId = 1L;
        Driver driver = new Driver(2L, "George", "Russel", null);

        when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));

        ResponseEntity<Driver> responseEntity = driverController.findDriver(driverId);

        verify(driverRepository).findById(driverId);
        assertThat(responseEntity.getStatusCode(), Matchers.is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), Matchers.is(driver));
    }

    @Test
    public void findDriver_withUnkownId_shouldThrowNotFoundException() throws Exception {
        Long driverId = 1L;

        when(driverRepository.findById(driverId)).thenReturn(Optional.empty());
        DriverNotFoundException exception = assertThrows(DriverNotFoundException.class, () -> {
            driverController.findDriver(driverId);
        });

        assertThat(exception.getMessage(), equalTo(DRIVER_NOT_FOUND_EXCEPTION_MESSAGE));
    }
}
