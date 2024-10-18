package com.packagesserviceapi.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackageContentResponse {

    private String recipientAddress;
    private String content;
    private Float weight;

}
