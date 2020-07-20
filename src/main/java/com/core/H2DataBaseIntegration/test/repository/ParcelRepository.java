package com.core.H2DataBaseIntegration.test.repository;

import com.core.H2DataBaseIntegration.test.data.DbParcels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<DbParcels, Integer> {
}
