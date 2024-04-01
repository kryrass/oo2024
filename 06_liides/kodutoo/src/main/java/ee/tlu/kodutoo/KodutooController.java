
package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KodutooController {

    List<Integer> numbrid = new ArrayList<>();

    @GetMapping("/numbrid")
    public List<Integer> saaNumbrid() {
        return numbrid;
    }

    @PostMapping("/numbrid/{number}")
    public List<Integer> lisaNumber(@PathVariable Integer number) {
        numbrid.add(number);
        return numbrid;
    }

    @DeleteMapping("/numbrid/{number}")
    public List<Integer> kustutaNumber(@PathVariable int number) {
        numbrid.remove(Integer.valueOf(number));
        return numbrid;
    }

    @GetMapping("/numbrite-koguarv")
    public int numbriteKoguarv() {
        return numbrid.size();
    }

    @GetMapping("/numbrite-kogusumma")
    public int numbriteKogusumma() {
        int summa = 0;
        for (int number : numbrid) {
            summa += number;
        }
        return summa;
    }

    @GetMapping("/numbrite-keskmine")
    public double numbriteKeskmine() {
        if (numbrid.isEmpty()) {
            return 0;
        }

        int summa = 0;
        for (int number : numbrid) {
            summa += number;
        }
        return (double) summa / numbrid.size();
    }
}
