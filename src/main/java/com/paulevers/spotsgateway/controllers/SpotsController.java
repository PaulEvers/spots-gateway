package com.paulevers.spotsgateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotsController {
    @GetMapping("/spots")
    String spots() {
        return "All Spots.";
    }
}
