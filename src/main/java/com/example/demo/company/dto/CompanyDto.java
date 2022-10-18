package com.example.demo.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record CompanyDto(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UUID id,
        @NotBlank @Min(2)
        String name,
        @NotBlank
        @Min(2)
        String vatId
) {

}
