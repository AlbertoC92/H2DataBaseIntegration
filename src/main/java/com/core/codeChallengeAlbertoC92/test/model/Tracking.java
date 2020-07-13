package com.core.codeChallengeAlbertoC92.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tracking {

    private String status;
    private int parcels;
    private int weight;
    private String reference;

}
