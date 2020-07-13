package com.core.codeChallengeAlbertoC92.test.repository;

import com.core.codeChallengeAlbertoC92.test.data.DbShipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<DbShipment, String> {
    DbShipment findByReference(String reference);
}
