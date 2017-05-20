package com.backbase.atm.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.backbase.atm.model.Atm;

/**
 * Camel router to receive ING ATMs an keep in application data
 * 
 * @author Carlos Alberto
 *
 */
@Component
public class AtmRouter extends RouteBuilder {

    private final String timer;
    private final String uri;

    public AtmRouter(@Value("${camel.timer}") final String timer, @Value("${camel.atm-uri}") final String uri) {
        this.timer = timer;
        this.uri = uri;
    }

    @Override
    public void configure() throws Exception {
        // Receive from ING Resful service, then convert and store in ATM Holder
        from(timer).to(uri).convertBodyTo(String.class, CharEncoding.UTF_8)
                .setBody(body().regexReplaceAll("\\)]}',", "")).unmarshal().json(JsonLibrary.Jackson, Atm[].class)
                .bean("atmHolder", "setAtm");
    }
}