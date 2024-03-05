import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Korrutamine {

    // 1. punkt: korrutamine ja ruutjuur
    public static double korrutamineJaRuutjuur(double arv1, double arv2) {
        double tulemus1 = arv1 * arv2;
        return Math.sqrt(tulemus1);
    }

    // 2. punkt: arv=juur
    public static double korrutaJaVotaJuurt(double[] arvud, int juur) {
        double korrutis = 1.0;
        for (double arv : arvud) {
            korrutis *= arv;
        }
        double tulemus2 = Math.pow(korrutis, 1.0 / juur);
        return tulemus2;
    }


    // 3. punkt: palga koefitsiendid
    public static double korrutaPalgaKoefitsiendid(double algPalk, double[] koefitsiendid) {
        double tulemus3 = algPalk;
        for (double koefitsient : koefitsiendid) {
            tulemus3 *= (1 + koefitsient); // korrutab algpalga muutujat iga koefitsiendiga.
        }
        return tulemus3;
    }

    //3. punkt 2. osa, palgad korrutatud kahese koefitsiendiga
    // kirjutab palgad aastate kaupa faili, võttes arvesse algset ja kahekordse koefitsiendiga palgatõusu
    public static void arvutaPalgad(double algPalk, double[] koefitsiendid) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("PalgaMuutus.txt"));

        double palk = algPalk;
        double korrutatudPalk = algPalk;

        // Kirjutame algpalga
        writer.write("Algpalgaks on: " + algPalk);
        writer.newLine();

        // palkade muutumine igal aastal
        for (int i = 0; i < koefitsiendid.length; i++) {
            // Arvutame uue palga vastavalt koefitsientidele
            palk *= (1 + koefitsiendid[i]);
            // Arvutame kahega korrutatud palga (koefitsiendid kahekordistatult)
            korrutatudPalk *= (1 + 2 * koefitsiendid[i]);

            // Kirjutame andmed faili üle
            writer.write("Aasta " + (i + 1) + ": Algne palk = " + palk + ", Uus korrutatud palk = " + korrutatudPalk);
            writer.newLine();
        }

        writer.close();
        System.out.println("Palga muutumise andmed on edukalt salvestatud faili PalgaMuutus.txt");
    }
}