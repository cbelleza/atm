package com.backbase.atm.controller.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backbase.atm.model.Atm;
import com.backbase.atm.support.AtmHolder;

/**
 * Dispose data to ATMs web page
 * 
 * @author Carlos Alberto
 *
 */
@Controller
public class AtmController {

    private final AtmHolder atmHolder;

    public AtmController(final AtmHolder atmHolder) {
        this.atmHolder = atmHolder;
    }

    @RequestMapping("/atms")
    public String atms(final Model model) {
        // Order ATMs by (city, houseNumber)
        final List<Atm> atmList = atmHolder.getAtmList().stream()
                .sorted((p1, p2) -> p1.getAddress().getCity().compareTo(p2.getAddress().getCity()))
                .sorted((p1, p2) -> p1.getAddress().getHouseNumber().compareTo(p2.getAddress().getHouseNumber()))
                .collect(Collectors.toList());

        model.addAttribute("atms", atmList);
        return "atm";
    }
}