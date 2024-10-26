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

    @Schema(description = "Receives the recipient address as a parameter")
    private String recipientAddress;

    @Schema(description = "Receives the recipient email as a parameter")
    private String recipientEmail;

    @Schema(description = "Receives the package content as a parameter")
    private String packageContent;

    @Schema(description = "Receives the package weight name as a parameter")
    private Float packageWeight;

}
