import java.util.Random;

public class Draakon {
    int xCoord; // deklareerin (loob + mälukoht)
    int yCoord; // parem klõps tema peal -> refactor -> rename
    char symbol;

    // constructor
    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        xCoord = saaKoordinaat(random, kaardiLaius); // initsialiseerin (annan esimest korda väärtuse)
        yCoord = saaKoordinaat(random, kaardiKorgus);
        symbol = 'D';
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }

}