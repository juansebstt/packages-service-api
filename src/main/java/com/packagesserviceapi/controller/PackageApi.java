package com.packagesserviceapi.controller;

import com.packagesserviceapi.commons.constants.ApiPathConstants;
import com.packagesserviceapi.commons.dtos.CreatePackageRequest;
import com.packagesserviceapi.commons.dtos.CreatePackageResponse;
import com.packagesserviceapi.commons.dtos.PackageContentResponse;
import com.packagesserviceapi.commons.dtos.UpdatePackageRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.PACKAGE_ROUTE)
public interface PackageApi {

    @PostMapping(value = "/create")
    ResponseEntity<CreatePackageResponse> createPackage(
            @RequestBody @Valid CreatePackageRequest createPackageRequest,
            @RequestAttribute(name = "X-User-Id") Long userId
    );

    @PutMapping(value = "/update_package/{trackingNumber}")
    ResponseEntity<Void> updatePackage(
            @RequestBody @Valid UpdatePackageRequest updatePackageRequest,
            @PathVariable Long trackingNumber
    );

    @DeleteMapping(value = "/delete_package/{trackingNumber}")
    ResponseEntity<Void> deletePackage(
            @PathVariable Long trackingNumber
    );

    @GetMapping(value = "/package_information")
    ResponseEntity<PackageContentResponse> packageInformation(
            @RequestAttribute Long trackingNumber
    );
}
