package com.core.codeChallengeAlbertoC92.test.mappers;

import com.core.codeChallengeAlbertoC92.test.data.DbParcels;
import com.core.codeChallengeAlbertoC92.test.data.DbShipment;
import com.core.codeChallengeAlbertoC92.test.model.Shipment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.HashSet;

@RunWith(MockitoJUnitRunner.class)
public class ShipmentMapperTest {

    @InjectMocks
    private ShipmentMapper shipmentMapper;


    private DbShipment buildDbShipment() {
        DbShipment dbShipment = new DbShipment();
        dbShipment.setReference("AGC1234567");
        dbShipment.setParcels(new HashSet<DbParcels>());
        return dbShipment;
    }

    @Test
    public void mapDbShipment_shouldReturnAShipment() {
        DbShipment dbShipment = buildDbShipment();

        Shipment shipment = shipmentMapper.mapDbShipment(dbShipment);

        assertThat(shipment.getReference(), is(dbShipment.getReference()));
        assertThat(shipment.getParcels(), is(dbShipment.getParcels()));
    }
}
