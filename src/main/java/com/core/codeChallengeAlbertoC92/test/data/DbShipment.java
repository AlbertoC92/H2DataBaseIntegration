package com.core.codeChallengeAlbertoC92.test.data;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipment")
public class DbShipment implements Serializable {
    @Id
    @Column(name = "reference")
    private String reference;

    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<DbParcels> parcels;
}
