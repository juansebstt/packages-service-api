package com.packagesserviceapi.commons.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackageContentResponse {

    @Schema(description = "Receives the recipient name as a parameter")
    private String recipientName;
    private String recipientAddress;
    private String recipientEmail;
    private String content;
    private Float weight;

}
