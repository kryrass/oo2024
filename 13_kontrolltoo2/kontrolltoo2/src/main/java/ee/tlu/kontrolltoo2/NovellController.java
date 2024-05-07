package ee.tlu.kontrolltoo2;

//Võimalda novelle võtta andmebaasist,
// lisada andmebaasi kui ka kustutada andmebaasist.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class NovellController {

    @Autowired
    NovellRepository novellRepository;

    @GetMapping("novellid")
    public List<Novell> getNovellid() {
        return novellRepository.findAll();
    }

    @PostMapping("novellid")
    public List<Novell> postNovell(@RequestBody Novell novell) {
        novellRepository.save(novell);
        return novellRepository.findAll();
    }

    @DeleteMapping("novellid/{id}")
    public List<Novell> deleteNovell(@PathVariable Long id) {
        novellRepository.deleteById(id);
        return novellRepository.findAll();
    }

    @GetMapping("novellid/vanim")
    public Novell vanimNovellAastaga() {
        return novellRepository.findFirstByOrderByAastaAsc();
    }


    @GetMapping("/novellid/lyhim")
    public Novell leiaLyhimNovell() {
        return novellRepository.findNovellWithShortestSisu();
    }

    @GetMapping("/novellid/{aasta}")
    public List<Novell> uuemadNovellidKui(@PathVariable int aasta) {
        return novellRepository.findByAastaGreaterThan(aasta);
    }
}
