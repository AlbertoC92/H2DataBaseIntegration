package com.core.codeChallengeAlbertoC92.test.repository;

import com.core.codeChallengeAlbertoC92.test.data.DbParcels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<DbParcels, Integer> {
}
