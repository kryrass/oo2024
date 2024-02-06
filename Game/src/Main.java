import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int kaardiKorgus = 5;
        int kaardiLaius = 10;

        int mangijaXCoord = saaKoordinaat(random, kaardiLaius);
        int mangijaYCoord = saaKoordinaat(random, kaardiKorgus);
        char mangijaSymbol = 'x';

        int draakonXCoord = saaKoordinaat(random, kaardiLaius);
        int draakonYCoord = saaKoordinaat(random, kaardiKorgus);
        char draakonSymbol = 'D';

        int orkXCoord = saaKoordinaat(random, kaardiLaius);
        int orkYCoord = saaKoordinaat(random, kaardiKorgus);
        char orkSymbol = 'O';

        Scanner scanner = new Scanner(System.in);

        prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);

        String sisend = scanner.nextLine();

        while (!sisend.equals("end")) {
            prindiKaart(kaardiKorgus, kaardiLaius, mangijaXCoord, mangijaYCoord, mangijaSymbol, draakonXCoord, draakonYCoord, draakonSymbol, orkXCoord, orkYCoord, orkSymbol);

            switch (sisend) {
                case "w" -> mangijaYCoord--;
                case "s" -> mangijaYCoord++;
                case "a" -> mangijaXCoord--;
                case "d" -> mangijaXCoord++;
            }

            sisend = scanner.nextLine();
        }

        System.out.println();
    }

    private static void prindiKaart(int kaardiKorgus, int kaardiLaius, int mangijaXCoord, int mangijaYCoord, char mangijaSymbol, int draakonXCoord, int draakonYCoord, char draakonSymbol, int orkXCoord, int orkYCoord, char orkSymbol) {
        for (int y = 0; y < kaardiKorgus; y++) {
            char symbol = ' ';
            for (int x = 0; x < kaardiLaius; x++) {
                if (y == 0 || y == kaardiKorgus - 1) {
                    System.out.print('-');
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius - 1) {
                    System.out.print('|');
                    symbol = '|';
                } else {
                    if (x == mangijaXCoord && y == mangijaYCoord) {
                        symbol = mangijaSymbol;
                    } else {
                        if (x == draakonXCoord && y == draakonYCoord) {
                            symbol = draakonSymbol;
                        } else {
                            if (x == orkXCoord && y == orkYCoord) {
                                symbol = orkSymbol;
                            } else {
                                symbol = ' ';
                            }
                        }
                    }
                    System.out.print(symbol);
                }
            }
            System.out.println();
        }
    }

    private static int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
