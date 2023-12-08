package com.achchaimae.aftas.Member;

import com.achchaimae.aftas.Hunting.Hunting;
import com.achchaimae.aftas.Member.Enum.IdentityDocumentType;
import com.achchaimae.aftas.Ranking.Ranking;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int num;
    private String name ;
    private String familtyName ;
    private LocalDate accessionDate;
    private String nationality;
    @Enumerated(EnumType.STRING )
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member",cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Hunting> huntings = new ArrayList<>();

    @OneToMany(mappedBy = "id.member",cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Ranking> rankings;
}
