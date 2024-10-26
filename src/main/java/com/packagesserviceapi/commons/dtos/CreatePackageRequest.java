package com.packagesserviceapi.commons.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePackageRequest {

    //Sender information DTO
    @NotBlank(message = "Sender name cannot be blank")
    @NotNull(message = "Sender name is required")
    @Schema(description = "Receives the sender name as a parameter")
    private String senderName;

    @NotNull(message = "Sender email is required")
    @Email(message = "Sender email should be valid")
    @Schema(description = "Receives the sender email as a parameter")
    private String senderEmail;

    @NotNull(message = "Sender address is required")
    @NotBlank(message = "Sender address cannot be blank")
    @Schema(description = "Receives the sender address as a parameter")
    private String senderAddress;

    @NotNull(message = "Sender phone is required")
    @NotBlank(message = "Sender phone cannot be blank")
    @Pattern(regexp = "^[+]?[0-9]{1,15}$", message = "Invalid phone number format")
    @Schema(description = "Receives the sender phone number as a parameter")
    private String senderPhone;

    // Recipient information DTO
    @NotNull(message = "Recipient name is required")
    @NotBlank(message = "Recipient name cannot be blank")
    @Schema(description = "Receives the recipient name as a parameter")
    private String recipientName;

    @NotNull(message = "Recipient name is required")
    @Email(message = "Recipient email should be valid")
    @Schema(description = "Receives the recipient email as a parameter")
    private String recipientEmail;

    @NotNull(message = "Recipient address is required")
    @NotBlank(message = "Recipient address cannot be blank")
    @Schema(description = "Receives the recipient address as a parameter")
    private String recipientAddress;

    @NotNull(message = "Recipient phone is required")
    @NotBlank(message = "Recipient phone cannot be blank")
    @Pattern(regexp = "^[+]?[0-9]{1,15}$", message = "Invalid phone number format")
    @Schema(description = "Receives the recipient phone number as a parameter")
    private String recipientPhoneNumber;

    //Package Dimensions DTO
    @NotNull(message = "Package width is required")
    @NotBlank(message = "Package width cannot be blank")
    @Min(value = 15, message = "Width must be at least 15 cm")
    @Schema(description = "Receives the package width as a parameter")
    private Float width;

    @NotNull(message = "Package height is required")
    @NotBlank(message = "Package height cannot be blank")
    @Min(value = 15, message = "Height must be at least 15 cm")
    @Schema(description = "Receives the package height as a parameter")
    private Float height;

    @NotNull(message = "Package length is required")
    @NotBlank(message = "Package length cannot be blank")
    @Min(value = 15, message = "Length must be at least 15 cm")
    @Schema(description = "Receives the package length as a parameter")
    private Float length;

    @NotNull(message = "Package weight is required")
    @NotBlank(message = "Package weight cannot be blank")
    @Min(value = 0, message = "Weight must be a positive value")
    @Schema(description = "Receives the package weight as a parameter")
    private Float weight;

    //Package created at x time DTO
    @Schema(description = "Creates the package at current time")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
