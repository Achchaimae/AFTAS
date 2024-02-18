package com.achchaimae.aftas.level.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LevelReqDTO {
    @NotNull(message = "Code is required")
    private Integer code;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Points is required")
    @Min(value = 0, message = "Points must be a positive number")
    private Integer points;

}
