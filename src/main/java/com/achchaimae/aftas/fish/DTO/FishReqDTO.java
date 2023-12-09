package com.achchaimae.aftas.fish.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class FishReqDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Average weight is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Average weight must be greater than 0")
    private Float averageWeight;

    @NotNull(message = "Level ID is required")
    private Integer level_code;

//    @NotNull(message = "Hunting ID is required")
//    private Integer hunting_Id;
}
