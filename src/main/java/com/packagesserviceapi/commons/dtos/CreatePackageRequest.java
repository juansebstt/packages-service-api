package com.packagesserviceapi.commons.dtos;

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

    @NotBlank(message = "Sender name cannot be blank")
    @NotNull(message = "Sender name is required")
    private String senderName;

    @NotNull(message = "Sender email is required")
    @Email(message = "Sender email should be valid")
    private String senderEmail;

    @NotNull(message = "Sender address is required")
    @NotBlank(message = "Sender address cannot be blank")
    private String senderAddress;

    @NotNull(message = "Sender phone is required")
    @NotBlank(message = "Sender phone cannot be blank")
    @Pattern(regexp = "^[+]?[0-9]{1,15}$", message = "Invalid phone number format")
    private String senderPhone;

    // Recipient information
    @NotNull(message = "Recipient name is required")
    @NotBlank(message = "Recipient name cannot be blank")
    private String recipientName;

    @NotNull(message = "Recipient name is required")
    @Email(message = "Recipient email should be valid")
    private String recipientEmail;

    @NotNull(message = "Recipient address is required")
    @NotBlank(message = "Recipient address cannot be blank")
    private String recipientAddress;

    @NotNull(message = "Recipient phone is required")
    @NotBlank(message = "Recipient phone cannot be blank")
    @Pattern(regexp = "^[+]?[0-9]{1,15}$", message = "Invalid phone number format")
    private String recipientPhoneNumber;

    //Package Dimensions
    @NotNull(message = "Package width is required")
    @NotBlank(message = "Package width cannot be blank")
    @Min(value = 15, message = "Width must be at least 15 cm")
    private Float width;

    @NotNull(message = "Package height is required")
    @NotBlank(message = "Package height cannot be blank")
    @Min(value = 15, message = "Height must be at least 15 cm")
    private Float height;

    @NotNull(message = "Package length is required")
    @NotBlank(message = "Package length cannot be blank")
    @Min(value = 15, message = "Length must be at least 15 cm")
    private Float length;

    @NotNull(message = "Package weight is required")
    @NotBlank(message = "Package weight cannot be blank")
    @Min(value = 0, message = "Weight must be a positive value")
    private Float weight;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
