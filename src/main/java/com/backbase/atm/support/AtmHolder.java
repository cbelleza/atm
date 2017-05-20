package com.backbase.atm.support;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.Body;
import org.springframework.stereotype.Component;

import com.backbase.atm.model.Atm;

/**
 * Holder to keep all ATMs
 * 
 * @author Carlos Alberto
 *
 */
@Component
public class AtmHolder {

    private List<Atm> atmList;

    public void setAtm(@Body final Atm[] atm) {
        this.atmList = Arrays.asList(atm);
    }

    public List<Atm> getAtmList() {
        return atmList;
    }
}