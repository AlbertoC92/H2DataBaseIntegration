package com.core.codeChallengeAlbertoC92.test.mappers;

import com.core.codeChallengeAlbertoC92.test.data.DbParcels;
import com.core.codeChallengeAlbertoC92.test.data.DbShipment;
import com.core.codeChallengeAlbertoC92.test.model.Parcels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ParcelMapperTest {

    @InjectMocks
    private ParcelMapper parcelMapper;

    private DbParcels buildDbParcel() {
        DbParcels dbParcels = new DbParcels();
        dbParcels.setId(1);
        dbParcels.setHeight(120);
        dbParcels.setLength(50);
        dbParcels.setWeight(50);
        dbParcels.setWidth(2);
        DbShipment dbShipment = new DbShipment();
        dbShipment.setReference("AGC1234567");
        dbShipment.setParcels(new HashSet<DbParcels>());
        dbParcels.setShipment(dbShipment);

        return dbParcels;
    }


    @Test
    public void mapDbParcel_shouldReturnAParcel() {
        DbParcels dbParcels = buildDbParcel();

        Parcels parcels = parcelMapper.mappDbParcel(dbParcels);

        assertThat(parcels.getShipment(), is(dbParcels.getShipment().getReference()));
        assertThat(parcels.getHeight(), is(dbParcels.getHeight()));
        assertThat(parcels.getLength(), is(dbParcels.getLength()));
        assertThat(parcels.getWeight(), is(dbParcels.getWeight()));
        assertThat(parcels.getWidth(), is(dbParcels.getWidth()));

    }
}
