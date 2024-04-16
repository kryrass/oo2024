package ee.tlu.salat.entity;

// Mis koosneb toiduainest ja temaga seotud kogusest toidu sees
// Klassikomplekt -> Kartul+omadused ja mitu grammi

import ee.tlu.salat.entity.ToiduaineEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Toidukomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.ALL)

    ToiduaineEntity toiduaine;


    int kogus;

    // {id: 5, toiduaine: {nimetus: "Vorst"}, kogus: 100}
    // 5   |   "Vorst  |    100
}