
package com.backbase.atm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backbase.atm.controller.api.AtmRestController;
import com.backbase.atm.model.Atm;
import com.backbase.atm.support.AtmHolder;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest
public class AtmApplicationTests {

    @Autowired
    private AtmHolder atmHolder;

    @Autowired
    private AtmRestController atmApiController;

    @Before
    public void startUp() {
        while (atmHolder.getAtmList().size() == 0) {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
            }
        }
    }

    @Test
    public void findAllAtms() {
        final Optional<String> criteria = Optional.ofNullable(null);

        // Call ATM API
        final ResponseEntity<List<Atm>> response = atmApiController.findAll(criteria);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // ATMs
        final List<Atm> atmList = response.getBody();
        assertThat(atmList).isNotEmpty().doesNotContainNull().doesNotHaveDuplicates();
    }

    @Test
    public void filterAtmsByCity() {
        final Optional<String> criteria = Optional.of("city::Beilen");

        // Call ATM API
        final ResponseEntity<List<Atm>> response = atmApiController.findAll(criteria);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // ATMs by filter
        final List<Atm> atmList = response.getBody();
        assertThat(atmList).isNotEmpty().doesNotContainNull().doesNotHaveDuplicates();
    }
}
