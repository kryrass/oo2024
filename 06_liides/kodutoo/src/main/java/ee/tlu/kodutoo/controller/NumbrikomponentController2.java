
package ee.tlu.kodutoo.controller;
import ee.tlu.kodutoo.enitity.NumbriKomponent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NumbrikomponentController2 {
    List<NumbriKomponent> numbriKomponendid = new ArrayList<>();

    @PostMapping("numbrikomponent")
    public List<NumbriKomponent> lisaNumbrikomponent(@RequestBody NumbriKomponent komponent) {
        numbriKomponendid.add(komponent);
        return numbriKomponendid;
    }

    @PutMapping("numbrikomponent/{index}")
    public List<NumbriKomponent> muudaNumbrikomponent(@PathVariable int index, @RequestBody NumbriKomponent komponent) {
        numbriKomponendid.set(index, komponent);
        return numbriKomponendid;
    }

    @DeleteMapping("numbrikomponent/{index}")
    public List<NumbriKomponent> kustutaNumbriKomponent(@PathVariable int index) {
        if (index >= 0 && index < numbriKomponendid.size()) {
            numbriKomponendid.remove(index);
            return numbriKomponendid;
        }

        return numbriKomponendid; // Return the list unchanged
    }


}
