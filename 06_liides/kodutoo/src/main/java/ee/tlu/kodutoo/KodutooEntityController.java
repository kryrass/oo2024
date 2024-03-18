package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/kodutoo")
public class KodutooEntityController {

    List<KodutooEntity> entities = new ArrayList<>();

    @GetMapping
    public List<KodutooEntity> saaEntityd() {
        return entities;
    }

    @PostMapping("/{id}/{nimi}/{number}")
    public List<KodutooEntity> lisaNumber(
            @PathVariable Long id,
            @PathVariable String nimi,
            @PathVariable int number
    ) {
        KodutooEntity entity = new KodutooEntity(id, nimi, number);
        entities.add(entity);
        return entities;
    }

    @DeleteMapping("/{id}")
    public void kustutaEntity(@PathVariable Long id) {
        entities.removeIf(e -> e.getId().equals(id));
    }

    @PutMapping("/{id}/{nimi}/{number}")
    public KodutooEntity uuendaEntity(@PathVariable Long id, @PathVariable String nimi, @PathVariable int number) {
        for (KodutooEntity entity : entities) {
            if (entity.getId().equals(id)) {
                entity.setNimi(nimi);
                entity.setNumber(number);
                return entity;
            }
        }
        return null; // Kui antud id-ga objekti ei leita
    }


    @GetMapping("/summa")
    public int saaSumma() {
        int total = 0;
        for (KodutooEntity entity : entities) {
            total += entity.getNumber();
        }
        return total;
    }
}
