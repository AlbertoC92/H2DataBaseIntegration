package com.core.codeChallengeAlbertoC92.test.service;

import com.core.codeChallengeAlbertoC92.test.data.DbParcels;
import com.core.codeChallengeAlbertoC92.test.data.DbShipment;
import com.core.codeChallengeAlbertoC92.test.mappers.ShipmentMapper;
import com.core.codeChallengeAlbertoC92.test.model.Shipment;
import com.core.codeChallengeAlbertoC92.test.model.Tracking;
import com.core.codeChallengeAlbertoC92.test.model.TrackingResult;
import com.core.codeChallengeAlbertoC92.test.repository.ParcelRepository;
import com.core.codeChallengeAlbertoC92.test.repository.ShipmentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ApplicationService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private ParcelRepository parcelRepository;

    @Autowired
    private ShipmentMapper shipmentMapper;

    @SneakyThrows
    public Shipment insertNewShipment(DbShipment dbShipment) {
        DbShipment exist = shipmentRepository.findByReference(dbShipment.getReference());

        if (exist != null) {
            throw new RuntimeException("The reference number is already registered in our system");
        }

        dbShipment.setParcels(saveParcels(dbShipment));
        shipmentRepository.save(dbShipment);

        return shipmentMapper.mapDbShipment(dbShipment);
    }

    @SneakyThrows
    private Set<DbParcels> saveParcels(DbShipment dbShipment) {
        Set<DbParcels> parcelList = new HashSet<>();
        dbShipment.getParcels().stream().forEach(parcel -> {
            DbParcels newParcel = parcelRepository.save(parcel);
            newParcel.setShipment(dbShipment);
            parcelList.add(newParcel);
        });
        return parcelList;
    }

    @SneakyThrows
    public TrackingResult processShipment(Tracking tracking) {
        TrackingResult trackingResult = new TrackingResult();
        Optional<DbShipment> exist = shipmentRepository.findById(tracking.getReference());
        if (!exist.isPresent()) {
            return buildTrackingResult(tracking, "NOT_FOUND");
        }
        if (tracking.getWeight() == 0 || tracking.getParcels() == 0 || tracking.getStatus() == null) {
            return buildTrackingResult(tracking, "INCOMPLETE");
        }
        DbShipment dbShipment = exist.get();
        if (tracking.getStatus().equalsIgnoreCase("DELIVERED")) {
            return deliveredShipment(dbShipment, tracking);
        } else {
            return buildTrackingResult(tracking, "INCOMPLETE");
        }

    }

    @SneakyThrows
    private TrackingResult deliveredShipment(DbShipment dbShipment, Tracking tracking) {

        if (dbShipment.getParcels().size() != tracking.getParcels()) {
            return buildTrackingResult(tracking, "INCOMPLETE:Number of parcels in your tracking is bigger than the number of parcels in the shipment");
        }
        if (getTotalShipmentWeight(tracking.getReference()) < tracking.getWeight()) {
            return buildTrackingResult(tracking, "CONCILLIATION_REQUEST");
        } else {
            return buildTrackingResult(tracking, "NOT_NEEDED");
        }
    }

    @SneakyThrows
    private int getTotalShipmentWeight(String shipmentId) {
        Optional<DbShipment> exist = shipmentRepository.findById(shipmentId);
        int totalWeight;
        if (!exist.isPresent()) {
            throw new NullPointerException("The shipment you are looking for doesn't exist");
        }
        DbShipment dbShipment = exist.get();

        totalWeight = dbShipment.getParcels().stream().mapToInt(DbParcels::getWeight).sum();

        return totalWeight;
    }

    private TrackingResult buildTrackingResult(Tracking tracking, String status) {
        TrackingResult trackingResult = new TrackingResult();
        trackingResult.setReference(tracking.getReference());
        trackingResult.setStatus(status);
        return trackingResult;
    }
}
