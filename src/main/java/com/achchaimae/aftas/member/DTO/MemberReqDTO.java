package com.achchaimae.aftas.member.DTO;

import com.achchaimae.aftas.member.Enum.IdentityDocumentType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberReqDTO {
    private int num;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Family name is required")
    private String familyName;
    @NotNull(message = "Accession date is required")
    private LocalDate accessionDate;
    @NotBlank(message = "Nationality is required")
    private String nationality;
    @NotNull(message = "Identity document type is required")
    private IdentityDocumentType identityDocumentType;
    @NotBlank(message = "Identity number is required")
    private String identityNumber;
    private Integer huntingId;
    private Integer rankingId;
}
