package com.achchaimae.aftas.Fish;

import com.achchaimae.aftas.Hunting.Hunting;
import com.achchaimae.aftas.Level.Level;
import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Fish implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    private  Float averageWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_code")
    private Level level;

    @OneToMany(mappedBy = "fish" , cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Hunting> huntings;
}
