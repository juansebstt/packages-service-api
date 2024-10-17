package com.packagesserviceapi.commons.dtos;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePackageRequest {

    private String recipientName;

    @Email
    private String receiverEmail;

    private String address;
    private String content;
    private Integer weight;
    
}
