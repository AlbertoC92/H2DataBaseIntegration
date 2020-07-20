package com.core.H2DataBaseIntegration.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parcels {

    private int weight;
    private int width;
    private int height;
    private int length;
    private String shipment;
}
