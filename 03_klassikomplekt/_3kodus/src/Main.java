public class Main {
    public static void main(String[] args) {
        Kursus mataKursus = new Kursus("Sissejuhatus praktilisse matemaatikasse");
        Kursus fyysikaKursus = new Kursus("Füüsika alused");

        Opilane Priidik = new Opilane("Priidik");
        Opilane Maria = new Opilane("Maria");
        Opilane Kaarel = new Opilane("Kaarel");

        mataKursus.registreerunudOpilased(Priidik.getNimi());
        mataKursus.registreerunudOpilased(Maria.getNimi());
        fyysikaKursus.registreerunudOpilased(Kaarel.getNimi());

        mataKursus.dropOpilane(Maria.getNimi());

        mataKursus.vaataRegistreerunudOpilasi();
        fyysikaKursus.vaataRegistreerunudOpilasi();
    }
}
