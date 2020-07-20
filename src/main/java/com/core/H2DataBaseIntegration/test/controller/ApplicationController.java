package com.core.H2DataBaseIntegration.test.controller;

import com.core.H2DataBaseIntegration.test.data.DbShipment;
import com.core.H2DataBaseIntegration.test.model.Shipment;
import com.core.H2DataBaseIntegration.test.model.Tracking;
import com.core.H2DataBaseIntegration.test.model.TrackingResult;
import com.core.H2DataBaseIntegration.test.service.ApplicationService;
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
