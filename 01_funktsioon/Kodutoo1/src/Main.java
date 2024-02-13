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

        //paarisVoiPaaritu
        int number1 = 5;
        int number2 = 14;

        System.out.println(number1 + " on " + paarisVoiPaaritu(number1));
        System.out.println(number2 + " on " + paarisVoiPaaritu(number2));

        //arvutaKeskmine
        double num1 = 12.5;
        double num2 = 9.5;

        double keskmine = arvutaKeskmine(num1, num2);
        System.out.println("Keskmine väärtus on: " + keskmine);

        //Kas arv on positiivne
        int number3 = 5;
        int number4 = -10;

        System.out.println(number3 + " on positiivne: " + onPositiivne(number3));
        System.out.println(number4 + " on positiivne: " + onPositiivne(number4));


    }

    //siia funktsioonid

    private static String paarisVoiPaaritu(int number) {
        if (number % 2 == 0) {
            return "Paaris";
        } else {
            return "Paaritu";
        }
    }

    private static double arvutaKeskmine(double a, double b) {
        return (a + b) / 2;
    }

    private static boolean onPositiivne(int number) {
        return number > 0;
    }


}