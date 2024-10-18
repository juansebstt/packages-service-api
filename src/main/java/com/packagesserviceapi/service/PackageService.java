package com.packagesserviceapi.service;

import com.packagesserviceapi.commons.dtos.CreatePackageRequest;
import com.packagesserviceapi.commons.dtos.CreatePackageResponse;
import com.packagesserviceapi.commons.dtos.PackageContentResponse;
import com.packagesserviceapi.commons.dtos.UpdatePackageRequest;

public interface PackageService {

    CreatePackageResponse createPackage(CreatePackageRequest createPackageRequest, Long userId);

    PackageContentResponse getPackageContent(Long trackingNumber);

    void updatePackage(UpdatePackageRequest updatePackageRequest, Long trackingNumber);

    void deletePackage(Long trackingNumber);

}
