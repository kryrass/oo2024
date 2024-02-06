//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Kodus: 3 funkt , milles on kasutatud vähemalt
        // 4 erinevat tüüpi:
        // void, string, int, char, long, double, float, boolean
        //tagastab int parameetriks boolean //naide
        //tagastab void parameetriks boolean, int
        //tagastab string parameetriks string

        // teha igast funk 2 erineva sisendiga väljakutset

        double kogumaksumus1 = arvutaTaksoMaksumus(3);
        System.out.println(kogumaksumus1);
        double kogumaksumus2 = arvutaTaksoMaksumus(2);
        System.out.println(kogumaksumus2);
        String hinnang1 = temperatuuriHinnang(-1.2);
        System.out.println(hinnang1);
        String hinnang2 = temperatuuriHinnang(2.2);
        System.out.println(hinnang2);
        prindiForTsykkel("Pikk sõna");
        prindiForTsykkel("Lyh");

    }

    //siia funktsioonid

    private static double arvutaTaksoMaksumus(int tunnid) { //
        return 3 + 0.9*tunnid;
    }

    private static String temperatuuriHinnang(double temp) {
        if (temp < 0) {
            return "Vesi on jääs";
        } else {
            return "On vesi";
        }
    }

    private static void prindiForTsykkel(String tahtedeArv) {
        for (int i = 0; i < tahtedeArv.length(); i++) {
            System.out.println(i);
        }
    }

}