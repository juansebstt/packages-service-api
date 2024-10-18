package com.packagesserviceapi.repositories;

import com.packagesserviceapi.commons.entities.PackageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepository extends JpaRepository<PackageModel, Long> {

    Optional<PackageModel> findByTrackingNumber(Long packageName);

}
