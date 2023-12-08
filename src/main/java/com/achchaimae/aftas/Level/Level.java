package com.achchaimae.aftas.Level;

import com.achchaimae.aftas.Fish.Fish;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Level implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int code;
    private String description;
    private Integer points;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "level",cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Fish>  fishes;
}
