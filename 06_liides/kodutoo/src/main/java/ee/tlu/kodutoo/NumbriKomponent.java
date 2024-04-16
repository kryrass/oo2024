package ee.tlu.kodutoo;
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
public class NumbriKomponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    KodutooEntity number;

    String asukoht;

}