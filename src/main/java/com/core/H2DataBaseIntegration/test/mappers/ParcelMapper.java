package com.core.H2DataBaseIntegration.test.mappers;

import com.core.H2DataBaseIntegration.test.data.DbParcels;
import com.core.H2DataBaseIntegration.test.model.Parcels;
import org.springframework.stereotype.Service;

@Service
public class ParcelMapper {

    public Parcels mappDbParcel(DbParcels dbParcels) {
        Parcels parcels = new Parcels();
        parcels.setLength(dbParcels.getLength());
        parcels.setHeight(dbParcels.getHeight());
        parcels.setWidth(dbParcels.getWidth());
        parcels.setWeight(dbParcels.getWeight());
        parcels.setShipment(dbParcels.getShipment().getReference());

        return parcels;
    }
}
