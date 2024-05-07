package ee.tlu.kontrolltoo2;

import ee.tlu.kontrolltoo2.Novell;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Raamat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimetus;
    private double hind;
    private int lehekulgedeArv;

    @OneToMany(mappedBy = "raamat")
    private List<Novell> novellid;
}