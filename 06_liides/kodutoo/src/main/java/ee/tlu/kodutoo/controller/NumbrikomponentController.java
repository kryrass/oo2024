package ee.tlu.kodutoo.controller;


import ee.tlu.kodutoo.enitity.NumbriKomponent;
import ee.tlu.kodutoo.repository.NumbrikomponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class NumbrikomponentController {

    @Autowired
    NumbrikomponentRepository numbrikomponentRepository;

    // Bean ---> automaatselt loodav klass kui rakendus käivitub (new Class();)
    // @Autowired ---> samaväärne kui allolev constructor, tõmbab Repository siia sisse

    //public ToidukomponentController(ToidukomponentRepository toidukomponentRepository) {
    //    this.toidukomponentRepository = toidukomponentRepository;
    //}

    // Saaks andmebaasist päringuid teha.
    // INSERT INTO Toidukomponent VALUES("") --->  repository.save("");
    // DELETE FROM Toidukomponent WHERE id = 5  ---> repository.deleteById(5);
    // SELECT * FROM Toidukomponent  ---> repository.findAll();

    // http://localhost:8080/toidukomponendid
    @GetMapping("numbrikomponendid")
    public List<NumbriKomponent> getNumbrikomponents() {
        return numbrikomponentRepository.findAll();
    }

    // --> PathVariable: http://localhost:8080/toidukomponendid/4
    // RequestParam: http://localhost:8080/toidukomponendid?id=4
    @DeleteMapping("numbrikomponendid/{id}")
    public List<NumbriKomponent> deleteNumbrikomponent(@PathVariable Long id) {
        numbrikomponentRepository.deleteById(id);
        return numbrikomponentRepository.findAll();
    }

    @PostMapping("numbrikomponendid")
    public List<NumbriKomponent> addNumbrikomponent(@RequestBody NumbriKomponent numbrikomponent) {
        numbrikomponentRepository.save(numbrikomponent);
        return numbrikomponentRepository.findAll();
    }

}