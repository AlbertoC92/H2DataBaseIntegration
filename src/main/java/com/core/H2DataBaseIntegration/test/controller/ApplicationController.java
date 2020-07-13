package com.core.codeChallengeAlbertoC92.test.controller;

import com.core.codeChallengeAlbertoC92.test.data.DbShipment;
import com.core.codeChallengeAlbertoC92.test.model.Shipment;
import com.core.codeChallengeAlbertoC92.test.model.Tracking;
import com.core.codeChallengeAlbertoC92.test.model.TrackingResult;
import com.core.codeChallengeAlbertoC92.test.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ApplicationController")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping(value = "/register")
    private Shipment registerShipment(@RequestBody DbShipment dbShipment) {

        return applicationService.insertNewShipment(dbShipment);
    }

    @PutMapping(value = "/tackShipment")
    private TrackingResult trackShipment(@RequestBody Tracking tracking) {

        return applicationService.processShipment(tracking);
    }
}
