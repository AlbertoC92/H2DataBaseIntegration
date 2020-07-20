package com.core.H2DataBaseIntegration.test.repository;

import com.core.H2DataBaseIntegration.test.data.DbShipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<DbShipment, String> {
    DbShipment findByReference(String reference);
}
