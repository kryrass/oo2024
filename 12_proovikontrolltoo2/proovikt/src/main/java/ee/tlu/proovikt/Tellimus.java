package ee.tlu.proovikt;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Tellimus {
    @Id@GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    private String tellija;

    @ManyToMany
    private List<Toode> tooted;
}
