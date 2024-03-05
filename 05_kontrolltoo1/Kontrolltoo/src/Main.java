import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//geomeetriline keskmine

//1. koosta klass ja tema sisse funktsioon, mis korrutab parameetritena antud kaks arvu ning võtab neist ruutjuure (math.sqrt). katseta.
// 2. koosta klassi sisse teine funktsioon, kuhu võib arve rohkem sisestada, need antakse ette kogumina. arvud korrutatakse kokku ning võetakse niimitmes juur
// (astendaja pöördväärtus, math.pow), kuimitu arvu oli.
// 3. failis on viie aasta kohta koefitsiendid, kui palju igal aastal palk muutus (ise koosta testandmed). samuti esimese aasta palk.
// anna nii alg- kui ka lõppsumma klassi sees asuvatesse muutujatesse.
// 3.5.  seejärel väljasta teise faili palk igal aastal neist ning võrdlusena kõrvale palk,
// kui palk oleks tõusnud iga aasta järel eelmistest koefitsentidest 2 korda kiiremini (kõik koefitsendid kahega korrutatult).

public class Main {
    public static void main(String[] args) throws IOException {

        // 1. punkt: korrutamine ja ruutjuur
        double arv1 = 3;
        double arv2 = 12;
        double tulemus1 = Korrutamine.korrutamineJaRuutjuur(arv1, arv2);
        System.out.println("Korrutatud arvude ruutjuur: " + tulemus1);

        // 2. punkt: arv=juur
        double[] arvud = {3, 5, 9, 2};
        int juur = arvud.length;
        double tulemus2 = Korrutamine.korrutaJaVotaJuurt(arvud, juur);
        System.out.println("Arvude korrutis juurest " + juur + " on " + tulemus2);

        // 3. punkt:  loe Palga koefitsiendid
        BufferedReader br = new BufferedReader(new FileReader("PalgaLugemine.txt"));
        double algPalk = Double.parseDouble(br.readLine()); // Esimene rida on algpalga väärtus
        String rida;
        double[] koefitsiendid = new double[5]; //5 koefitsienti
        int i = 0; // i on täisarvu muutuja
        while ((rida = br.readLine()) != null) {
            koefitsiendid[i++] = Double.parseDouble(rida); // iga uue reaga suureneb massiivi indeks, kuhu järgmine koefitsient salvestatakse.
        }
        br.close();

        System.out.println("Algpalk on: " + algPalk);
        System.out.println("Koefitsiendid on: " + Arrays.toString(koefitsiendid));

        // Korrutame palga koefitsiendid kokku
        double tulemus3 = Korrutamine.korrutaPalgaKoefitsiendid(algPalk, koefitsiendid);
        System.out.println("Palga muutus koefitsientidega: " + tulemus3);

        //3. punkt 2. osa
        Korrutamine.arvutaPalgad(algPalk, koefitsiendid); //arvutab ja salvestab palgad aastate kaupa faili uut ja vanade palkadega

    }
}
