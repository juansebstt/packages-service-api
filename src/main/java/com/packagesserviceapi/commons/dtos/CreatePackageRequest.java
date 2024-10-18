package com.packagesserviceapi.commons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
public class CreatePackageRequest {

    @NotBlank
    @NotNull
    private String recipientName;

    @NotNull(message = "Recipient email is required")
    @NotBlank(message = "Recipient email cannot be blank")
    @Email(message = "Recipient email should be valid")
    private String receiverEmail;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    @NotBlank
    @Min(15)
    private Integer weight;

}
