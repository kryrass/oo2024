import java.util.ArrayList;
import java.util.List;

public class Kursus {
    private String kursuseNimi;
    private List<Opilane> registreerunudOpilased;

    public Kursus(String kursuseNimi) {
        this.kursuseNimi = kursuseNimi;
        this.registreerunudOpilased = new ArrayList<>();
    }
    Opilane opilane;

    public void registreerunudOpilased(String opilaseNimi) {
        registreerunudOpilased.add(new Opilane(opilaseNimi));
        System.out.println(opilaseNimi + " registreerus kursusele " + kursuseNimi);
    }

    public void dropOpilane(String opilaseNimi) {
        registreerunudOpilased.removeIf(opilane -> opilane.getNimi().equals(opilaseNimi));
        System.out.println(opilaseNimi + " on eemaldatud kursuselt " + kursuseNimi);
    }

    public void vaataRegistreerunudOpilasi() {
        System.out.println("Registreerinud õpilased " + kursuseNimi + " kursusele:");
        for (Opilane opilane : registreerunudOpilased) {
            System.out.println("- " + opilane.getNimi());
        }
    }
}