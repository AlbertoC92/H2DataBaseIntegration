package com.core.H2DataBaseIntegration.test.data;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parcels")
public class DbParcels implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "length")
    private int length;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reference")
    @NotNull
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private com.core.H2DataBaseIntegration.test.data.DbShipment shipment;

}
