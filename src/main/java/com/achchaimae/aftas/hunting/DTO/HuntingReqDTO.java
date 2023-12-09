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

    @NotNull(message = "Fish ID is required")
    private Integer fish_Id;

    @NotNull(message = "Member ID is required")
    private Integer member_Id;

    @NotNull(message = "Competition ID is required")
    private Integer competition_Id;
}
