package com.packagesserviceapi.repositories;

import com.packagesserviceapi.commons.entities.PackageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackageRepository extends JpaRepository<PackageModel, Long> {

    Optional<PackageModel> findByTrackingNumber(Long packageTrackingNumber);

}
