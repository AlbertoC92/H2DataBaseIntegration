package com.core.H2DataBaseIntegration.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingResult {

    private String reference;
    private String status;
}
