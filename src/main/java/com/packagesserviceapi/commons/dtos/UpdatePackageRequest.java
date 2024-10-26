package com.packagesserviceapi.commons.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePackageRequest {

    @Schema(description = "Recipient's name (optional). Leave blank if no update is needed.")
    private String recipientName;

    @Schema(description = "Recipient's address (optional). Leave blank if no update is needed.")
    private String recipientAddress;

    @Email(message = "Recipient email should be valid")
    @Schema(description = "Recipient's email (optional). Leave blank if no update is needed.")
    private String recipientEmail;

    @Schema(description = "Recipient's phone number (optional). Leave blank if no update is needed.")
    private String recipientPhoneNumber;

}
