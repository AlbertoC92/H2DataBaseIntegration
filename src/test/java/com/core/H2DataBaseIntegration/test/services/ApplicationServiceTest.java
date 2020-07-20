package com.core.H2DataBaseIntegration.test.services;

import com.core.H2DataBaseIntegration.test.data.DbParcels;
import com.core.H2DataBaseIntegration.test.data.DbShipment;
import com.core.H2DataBaseIntegration.test.mappers.ShipmentMapper;
import com.core.H2DataBaseIntegration.test.model.Shipment;
import com.core.H2DataBaseIntegration.test.model.Tracking;
import com.core.H2DataBaseIntegration.test.model.TrackingResult;
import com.core.H2DataBaseIntegration.test.repository.ParcelRepository;
import com.core.H2DataBaseIntegration.test.repository.ShipmentRepository;
import com.core.H2DataBaseIntegration.test.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {

    @InjectMocks
    private ApplicationService applicationService;

    @Mock
    private ShipmentMapper shipmentMapper;

    @Mock
    private ShipmentRepository shipmentRepository;

    @Mock
    private ParcelRepository parcelRepository;

    private DbShipment buildDbShipment() {
        DbShipment dbShipment = new DbShipment();
        dbShipment.setReference("AGC123456");
        Set<DbParcels> parcelsList = new HashSet<DbParcels>();
        DbParcels dbParcels = new DbParcels();
        dbParcels.setWeight(30);
        dbParcels.setId(1);
        dbParcels.setWidth(24);
        parcelsList.add(dbParcels);
        dbShipment.setParcels(parcelsList);
        return dbShipment;
    }

    private Tracking buildTrackin() {
        Tracking tracking = new Tracking();
        tracking.setParcels(1);
        tracking.setReference("AGC098765");
        tracking.setStatus("DELIVERED");
        tracking.setWeight(20);

        return tracking;
    }

   /* @Test
    public void insertNewShipment_shouldSaveAShipmentIntoTheDataBase() {
        DbShipment dbShipment = buildDbShipment();

        when(shipmentRepository.findById(dbShipment.getReference())).thenReturn(null);

        Shipment shipment = applicationService.insertNewShipment(dbShipment);

        assertThat(shipment.getReference(), is(dbShipment.getReference()));
        verify(shipmentRepository).save(any(DbShipment.class));
    }*/

    @Test(expected = RuntimeException.class)
    public void insertNewShipment_shouldReturnAnExceptionWhenUserAlreadyExist() {
        DbShipment dbShipment = buildDbShipment();

        Shipment shipment = applicationService.insertNewShipment(dbShipment);
    }

    @Test
    public void processShipment_shouldReturnDelivered_whenShipmentReferenceExist() {
        Tracking tracking = buildTrackin();
        tracking.setWeight(40);
        DbShipment dbShipment = buildDbShipment();
        when(shipmentRepository.findById(tracking.getReference())).thenReturn(Optional.of(dbShipment));

        TrackingResult trackingResult = applicationService.processShipment(tracking);

        assertThat(trackingResult.getStatus(), is("CONCILLIATION_REQUEST"));
        assertThat(trackingResult.getReference(), is(tracking.getReference()));


    }

    @Test
    public void processShipment_shouldReturnNotNeeded_whenShipmentWightIsBiggerOrEqualThanTracking() {
        Tracking tracking = buildTrackin();
        DbShipment dbShipment = buildDbShipment();
        when(shipmentRepository.findById(tracking.getReference())).thenReturn(Optional.of(dbShipment));

        TrackingResult trackingResult = applicationService.processShipment(tracking);

        assertThat(trackingResult.getStatus(), is("NOT_NEEDED"));
        assertThat(trackingResult.getReference(), is(tracking.getReference()));


    }
}
