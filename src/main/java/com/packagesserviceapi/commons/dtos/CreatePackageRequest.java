package com.packagesserviceapi.commons.dtos;

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
public class CreatePackageRequest {

    @NotBlank
    @NotNull
    private String recipientName;

    @NotNull
    @NotBlank
    @Email
    private String receiverEmail;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    @NotBlank
    private Integer weight;

}
