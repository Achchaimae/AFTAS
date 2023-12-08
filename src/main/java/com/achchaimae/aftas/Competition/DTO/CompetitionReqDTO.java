package com.achchaimae.aftas.Competition.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CompetitionReqDTO {
    @NotBlank(message = "Code is required")
    private String code;
    @NotNull(message = "Date is required")
    private LocalDate date;
    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    private LocalTime endTime;
    @NotNull(message = "Number of participants is required")
    @Min(value = 0, message = "Number of participants must be a positive number")
    private Integer numberOfParticipants;
    @NotBlank(message = "Location is required")
    private String Location;
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    private Float amount ;
    @NotNull(message = "Ranking ID is required")
    private Integer ranking_id;
    @NotNull(message = "Hunting ID is required")
    private Integer hunting_id;

}
