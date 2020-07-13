package com.core.codeChallengeAlbertoC92.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    private String reference;
    private Set<Parcels> parcels;
}
