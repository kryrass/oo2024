package ee.tlu.kodutoo.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "number")
public class KodutooEntity {
    @Id
    private Long id;
    private String nimi;
    private int number;


    public KodutooEntity() {
    }


    public KodutooEntity(Long id, String nimi, int number) {
        this.id = id;
        this.nimi = nimi;
        this.number = number;
    }
}


