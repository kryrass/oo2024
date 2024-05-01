
package ee.tlu.kodutoo.controller;
import ee.tlu.kodutoo.enitity.NumbriKomponent;
import ee.tlu.kodutoo.repository.NumbrikomponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumbrikomponentController2 {

    @Autowired
    NumbrikomponentRepository numbrikomponentRepository;

    @GetMapping("numbrikomponent")
    public List<NumbriKomponent> saaNumbrikomponent() {
        return numbrikomponentRepository.findAll();
    }

    @PostMapping("numbrikomponent")
    public List<NumbriKomponent> lisaNumbrikomponent(@RequestBody NumbriKomponent komponent) {
        numbrikomponentRepository.save(komponent);
        return numbrikomponentRepository.findAll();
    }

    @PutMapping("numbrikomponent/{index}")
    public List<NumbriKomponent> muudaNumbrikomponent(@RequestBody NumbriKomponent komponent) {
        numbrikomponentRepository.save(komponent);
        return numbrikomponentRepository.findAll();
    }

    @DeleteMapping("numbrikomponent/{id}")
    public List<NumbriKomponent> kustutaNumbriKomponent(@PathVariable Long id) {
    numbrikomponentRepository.deleteById(id);
        return numbrikomponentRepository.findAll(); // Return the list unchanged
    }


}
