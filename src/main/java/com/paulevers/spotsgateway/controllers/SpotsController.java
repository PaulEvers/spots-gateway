package com.paulevers.spotsgateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotsController {

    @GetMapping(value = "/spots")
    public String spots() {
        return "Hi";
    }
}
