package ee.tlu.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class RaamatController {

    @Autowired
    NovellRepository novellRepository;

    @Autowired
    RaamatRepository raamatRepository;

    @GetMapping("koik-raamatud")
    public List<Raamat> getAllRaamatud() {
        return raamatRepository.findAll();
    }

    @PostMapping("koik-raamatud")
    public List<Raamat> postAllRaamatud(@RequestBody Raamat raamat) {
        raamatRepository.save(raamat);
        return raamatRepository.findAll();
    }

    @DeleteMapping("koik-raamatud/{id}")
    public List<Raamat> deleteAllRaamat(@PathVariable Long id) {
        raamatRepository.deleteById(id);
        return raamatRepository.findAll();
    }

    @GetMapping("raamat-novell/{id}")
    public List<Novell> getRaamatNovell(@PathVariable Long id) {
        return novellRepository.findByRaamat_Id(id);
    }

}
