package com.packagesserviceapi.service.impl;

import com.packagesserviceapi.commons.dtos.CreatePackageRequest;
import com.packagesserviceapi.commons.dtos.CreatePackageResponse;
import com.packagesserviceapi.commons.dtos.PackageContentResponse;
import com.packagesserviceapi.commons.dtos.UpdatePackageRequest;
import com.packagesserviceapi.commons.entities.PackageModel;
import com.packagesserviceapi.repositories.PackageRepository;
import com.packagesserviceapi.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;

import java.util.Optional;

public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final StreamBridge streamBridge;

    @Autowired
    public PackageServiceImpl(PackageRepository packageRepository, StreamBridge streamBridge) {
        this.packageRepository = packageRepository;
        this.streamBridge = streamBridge;
    }


    @Override
    public CreatePackageResponse createPackage(CreatePackageRequest createPackageRequest, Long userId) {
        return Optional.of(createPackageRequest)
                .map(this::mapToEntity);
    }

    private PackageModel mapToEntity(CreatePackageRequest createPackageRequest) {
        return PackageModel.builder()
                .senderName(createPackageRequest.getSenderName())
                .senderEmail(createPackageRequest.getSenderEmail())
                .senderAddress(createPackageRequest.getSenderAddress())
                .senderPhone(createPackageRequest.getSenderPhone())
                .recipientName(createPackageRequest.getRecipientName())
                .recipientEmail(createPackageRequest.getRecipientEmail())
                .recipientAddress(createPackageRequest.getRecipientAddress())
                .recipientPhoneNumber(createPackageRequest.getRecipientPhoneNumber())
                .width(createPackageRequest.getPackageWidth())
                .height(createPackageRequest.getPackageHeight())
                .weight(createPackageRequest.getPackageWeight())
                .length(createPackageRequest.getPackageLength())
                .build();
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