package ee.tlu.kontrolltoo2;

//Loo klass (entity) novell andmete hoidmiseks (pealkiri, sisu, aasta, primaarvõtmeks
// pane kas nimetus või automaatselt genereeritud ID – valik on sinu).
// Tee novelli jaoks nii Repository kui ka Controller ning loo andmebaasiühendus.

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Novell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pealkiri;
    private String sisu;
    private int aasta;

    @ManyToOne
    private Raamat raamat;
}