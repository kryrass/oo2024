package ee.tlu.kodutoo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KodutooEntity {
    private Long id;
    private String nimi;
    private int number;

    public KodutooEntity(Long id, String nimi, int number) {
        this.id = id;
        this.nimi = nimi;
        this.number = number;
    }
}
