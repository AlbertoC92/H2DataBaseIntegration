package com.core.H2DataBaseIntegration.test.mappers;

import com.core.H2DataBaseIntegration.test.data.DbShipment;
import com.core.H2DataBaseIntegration.test.model.Parcels;
import com.core.H2DataBaseIntegration.test.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShipmentMapper {

    @Autowired
    private ParcelMapper parcelMapper;

    public Shipment mapDbShipment(DbShipment dbShipment) {
        Shipment shipment = new Shipment();
        Set<Parcels> parcelList = new HashSet<>();
        shipment.setReference(dbShipment.getReference());
        dbShipment.getParcels().forEach(parcel -> parcelList.add(parcelMapper.mappDbParcel(parcel)));
        shipment.setParcels(parcelList);

        return shipment;
    }
}
