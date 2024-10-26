package com.packagesserviceapi.controller.impl;

import com.packagesserviceapi.commons.dtos.CreatePackageRequest;
import com.packagesserviceapi.commons.dtos.CreatePackageResponse;
import com.packagesserviceapi.commons.dtos.PackageContentResponse;
import com.packagesserviceapi.commons.dtos.UpdatePackageRequest;
import com.packagesserviceapi.controller.PackageApi;
import com.packagesserviceapi.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageController implements PackageApi {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @Override
    public ResponseEntity<CreatePackageResponse> createPackage(CreatePackageRequest createPackageRequest, Long userId) {
        return ResponseEntity.ok(packageService.createPackage(createPackageRequest, userId));
    }

    @Override
    public ResponseEntity<Void> updatePackage(UpdatePackageRequest updatePackageRequest, Long trackingNumber) {
        packageService.updatePackage(updatePackageRequest, trackingNumber);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deletePackage(Long trackingNumber) {
        packageService.deletePackage(trackingNumber);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<PackageContentResponse> packageInformation(Long trackingNumber) {
        packageService.getPackageContent(trackingNumber);
        return ResponseEntity.ok(packageService.getPackageContent(trackingNumber));
    }
}
