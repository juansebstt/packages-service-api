package com.packagesserviceapi.service.impl;

import com.packagesserviceapi.commons.dtos.CreatePackageRequest;
import com.packagesserviceapi.commons.dtos.CreatePackageResponse;
import com.packagesserviceapi.commons.dtos.PackageContentResponse;
import com.packagesserviceapi.commons.dtos.UpdatePackageRequest;
import com.packagesserviceapi.repositories.PackageRepository;
import com.packagesserviceapi.service.PackageService;
import org.springframework.cloud.stream.function.StreamBridge;

public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final StreamBridge streamBridge;

    public PackageServiceImpl(PackageRepository packageRepository, StreamBridge streamBridge) {
        this.packageRepository = packageRepository;
        this.streamBridge = streamBridge;
    }


    @Override
    public CreatePackageResponse createPackage(CreatePackageRequest createPackageRequest, Long userId) {
        return null;
    }

    @Override
    public PackageContentResponse getPackageContent(Long trackingNumber) {
        return null;
    }

    @Override
    public void updatePackage(UpdatePackageRequest updatePackageRequest, Long trackingNumber) {

    }

    @Override
    public void deletePackage(Long trackingNumber) {

    }
}
