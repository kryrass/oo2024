package ee.tlu.salat.controller;

import ee.tlu.salat.entity.ToiduaineEntity;
import ee.tlu.salat.repository.ToiduaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ToiduaineEntityController {

    // ["Kartul", "Vorst"]
    // [{nimi: "Kartul, valk: 0}, {nimi: "Vorst}]

@Autowired
ToiduaineRepository toiduaineRepository;

    /* public ToiduaineEntityController(ToiduaineRepository toiduaineRepository){
        this.toiduaineRepository = toiduaineRepository;
    }*/

    //List<ToiduaineEntity> toiduained = new ArrayList<>(); //imiteerime andmebaasi

 // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
    }


    //localhost:8080/api/toiduained/Vorst/15/10/2
    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}")
    public List<ToiduaineEntity> lisaToiduaine(
            @PathVariable String nimi,
            @PathVariable int valk,
            @PathVariable int rasv,
            @PathVariable int sysivesik
    ) {
        if (valk + rasv + sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @PostMapping("toiduained")
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.getValk() + toiduaineEntity.getRasv() + toiduaineEntity.getSysivesik() > 100) {
            return toiduaineRepository.findAll();
        }
        //ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }


    @DeleteMapping("toiduained/{nimi}")
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

   // localhost:8080/api/toiduained/Vorst/15/10/2 < pathVariable
   // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=15&rasv=5&sysivesik=1 < requestParam

    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        //toiduaineRepository.set(index, toiduaine);
        toiduaineRepository.save(toiduaine); //täpselt sama mis post
        //hibernate kontrollib kas on juba sellise primaarvõtmega element andmebaasis
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduained/{index}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi) {
        return toiduaineRepository.findById(nimi).get();
    }

    @GetMapping("toiduainete-koguaerv")
    public int toiduaineteKoguaerv(){
        return toiduaineRepository.findAll().size();
    }

    @GetMapping("toiduained-valk-min/{minValk}")
    public List<ToiduaineEntity> toiduainedMinValk(@PathVariable int minValk) {
        return toiduaineRepository.findAllByValkGreaterThan(minValk);
    }

    @GetMapping("toiduained-sysivesik/{min}/{max}")
    public List<ToiduaineEntity> toiduainedSysivesik(@PathVariable int min, @PathVariable int max) {
        return toiduaineRepository.findAllBySysivesikBetween(min, max);
    }

}

// 404 - URL ehk API otspunkt on vale
// 4xx - Front-endi viga
// 5xx - back-endi viga (serveripoolne)