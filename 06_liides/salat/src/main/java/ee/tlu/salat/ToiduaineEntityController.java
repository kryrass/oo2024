package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToiduaineEntityController {

    // ["Kartul", "Vorst"]
    // [{nimi: "Kartul, valk: 0}, {nimi: "Vorst}]
    List<ToiduaineEntity> toiduained = new ArrayList<>(); //imiteerime andmebaasi

 // localhost:8080/api/toiduained
    @GetMapping("toiduained")
    public List<ToiduaineEntity> saaToiduained() {
        return toiduained;
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
            return toiduained;
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaine);
        return toiduained;
    }


    @DeleteMapping("toiduained/{index}")
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }

    // localhost:8080/api/toiduained/Vorst/15/10/2
    //localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=15&rasv=5&sysivesik=1
    @PutMapping("toiduained")
    public List<ToiduaineEntity> muudaToiduaine(
            @RequestParam int index,
            @RequestParam String nimi,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.set(index, toiduaine);
        return toiduained;
    }


    @GetMapping("toiduained/{index}")
    public ToiduaineEntity saaYksToiduaine(@PathVariable int index) {
        return toiduained.get(index);
    }

    @GetMapping("toiduainete-koguaerv")
    public int toiduaineteKoguaerv(){
        return toiduained.size();
    }
}

// 404 - URL ehk API otspunkt on vale
// 4xx - Front-endi viga
// 5xx - back-endi viga (serveripoolne)