package ee.tlu.kodutoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class KodutooEntityController {

    @Autowired
    private KodutooRepository repository; // Autowire the repository

    @GetMapping("/numbrid")
    public List<KodutooEntity> saaNumbrid() {
        return repository.findAll();
    }

    //localhost:8080/api/numbrid/6/kuus/6
    /*@PostMapping("/numbrid/{id}/{nimi}/{number}") //body kaudu
    public List<KodutooEntity> lisaNumber(
            @PathVariable Long id,
            @PathVariable String nimi,
            @PathVariable int number
    ) {
        KodutooEntity entity = new KodutooEntity(id, nimi, number);
        repository.save(entity);
        return repository.findAll();
    }*/
    @PostMapping("/numbrid")
    public List<KodutooEntity> lisaNumber(@RequestBody KodutooEntity entity) {
        repository.save(entity);
        return repository.findAll();
    }




    @DeleteMapping("/numbrid/{id}")
    public void kustutaNumber(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/numbrid/{id}")
    public KodutooEntity uuendaNumber(@PathVariable Long id, @RequestBody KodutooEntity updatedEntity) {
        KodutooEntity existingEntity = repository.findById(id).orElse(null);
        if (existingEntity != null) {
            existingEntity.setNimi(updatedEntity.getNimi());
            existingEntity.setNumber(updatedEntity.getNumber());
            return repository.save(existingEntity);
        }
        return null; // kui entityt selle id-ga pole
    }

    @GetMapping("/summa")
    public int saaSumma() {
        List<KodutooEntity> entities = repository.findAll();
        int total = 0;
        for (KodutooEntity entity : entities) {
            total += entity.getNumber();
        }
        return total;
    }

    @GetMapping("/numbrid/{minNumber}")
    public List<KodutooEntity> numberMinNumbrid(@PathVariable int minNumber) {
        return repository.findAllByNumberLessThan(minNumber);
    }

    @GetMapping("/numbrid-keskmine/{min}/{max}")
    public List<KodutooEntity> numberKesk(@PathVariable int min, @PathVariable int max) {
        return repository.findAllByNumberBetween(min, max);
    }

}

