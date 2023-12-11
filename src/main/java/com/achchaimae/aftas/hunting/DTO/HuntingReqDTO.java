package com.achchaimae.aftas.hunting.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class HuntingReqDTO {
    @NotNull(message = "ID is required")
    private Integer id;

    @NotNull(message = "Number of fish is required")
    @Min(value = 0, message = "Number of fish must be a positive number")
    private Integer numberOfFish;

    @NotBlank(message = "Fish ID is required")
    private String fish_Id;

    @NotNull(message = "Member ID is required")
    private Integer member_Id;

    @NotBlank(message = "Competition ID is required")
    private String competition_Id;
}
