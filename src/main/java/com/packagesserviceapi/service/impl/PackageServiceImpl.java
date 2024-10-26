package com.packagesserviceapi.service.impl;

import com.packagesserviceapi.commons.constants.TopicConstants;
import com.packagesserviceapi.commons.dtos.CreatePackageRequest;
import com.packagesserviceapi.commons.dtos.CreatePackageResponse;
import com.packagesserviceapi.commons.dtos.PackageContentResponse;
import com.packagesserviceapi.commons.dtos.UpdatePackageRequest;
import com.packagesserviceapi.commons.entities.PackageModel;
import com.packagesserviceapi.repositories.PackageRepository;
import com.packagesserviceapi.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
                .map(this::mapToEntity)
                .map(packageRepository::save)
                .map(savedPackage -> new CreatePackageResponse(savedPackage.getTrackingNumber()))
                .map(this::savedPackageEvent)
                .orElseThrow(() -> new RuntimeException("Error creating a package"));
    }

    private CreatePackageResponse savedPackageEvent(CreatePackageResponse createPackageResponse) {

        Optional.of(createPackageResponse)
                .map(givenPackage -> this.streamBridge.send(TopicConstants.PACKAGE_CREATED_TOPIC, createPackageResponse))
                .map(bool -> createPackageResponse);

        return createPackageResponse;
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

        return Optional.of(trackingNumber)
                .map(this::getPackageById)
                .map(this::mapToPackageContent)
                .orElseThrow();
    }

    private PackageContentResponse mapToPackageContent(PackageModel packageModel) {

        return PackageContentResponse.builder()
                .recipientName(packageModel.getRecipientName())
                .recipientAddress(packageModel.getRecipientAddress())
                .recipientEmail(packageModel.getRecipientEmail())
                .packageContent(packageModel.getPackageContent())
                .packageWeight(packageModel.getWeight())
                .build();
    }

    private PackageModel getPackageById(Long trackingNumber ) {

        return this.packageRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Error getting package by trackingNumber"));

    }

    @Override
    public void updatePackage(UpdatePackageRequest updatePackageRequest, Long trackingNumber) {

        Optional.of(trackingNumber)
                .map(this::getPackageById)
                .map(existingPackage -> updatePackageFields(existingPackage, updatePackageRequest))
                .map(packageRepository::save)
                .orElseThrow(() -> new RuntimeException("Error updating package"));
    }

    private PackageModel updatePackageFields(PackageModel existingPackage, UpdatePackageRequest updatePackageRequest) {

        return PackageModel.builder()
                .recipientName(updatePackageRequest.getRecipientName())
                .recipientAddress(existingPackage.getRecipientAddress())
                .recipientEmail(existingPackage.getRecipientEmail())
                .recipientPhoneNumber(existingPackage.getRecipientPhoneNumber())
                .build();
    }

    @Override
    public void deletePackage(Long trackingNumber) {
        
        Optional.of(trackingNumber)
                .map(this::getPackageById)
                .ifPresent(packageRepository::delete);

    }
}
