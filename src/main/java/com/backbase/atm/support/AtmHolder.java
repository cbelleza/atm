package com.backbase.atm.support;

import java.util.ArrayList;
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

    private final List<Atm> atmList = new ArrayList<Atm>();

    public void setAtm(@Body final Atm[] atm) {
        atmList.addAll(Arrays.asList(atm));
    }

    public List<Atm> getAtmList() {
        return atmList;
    }
}