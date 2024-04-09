package ee.tlu.salat;

// Mis koosneb toiduainest ja temaga seotud kogusest toidu sees
// Klassikomplekt -> Kartul+omadused ja mitu grammi

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Toidukomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    ToiduaineEntity toiduaine;

    //@ManyToMany
    //List<ToiduaineEntity> toiduained;
    int kogus;

    // {id: 5, toiduaine: {nimetus: "Vorst"}, kogus: 100}
    // 5   |   "Vorst  |    100
}