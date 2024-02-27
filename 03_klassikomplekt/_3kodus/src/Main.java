public class Main {
    public static void main(String[] args) {
        Kursus mataKursus = new Kursus("Sissejuhatus praktilisse matemaatikasse");
        Kursus fyysikaKursus = new Kursus("Füüsika alused");

        Opilane priidik = new Opilane("Priidik");
        Opilane maria = new Opilane("Maria");
        Opilane kaarel = new Opilane("Kaarel");

        mataKursus.registreerunudOpilased(priidik.getNimi());
        mataKursus.registreerunudOpilased(maria.getNimi());
        fyysikaKursus.registreerunudOpilased(kaarel.getNimi());

        mataKursus.dropOpilane(maria.getNimi());

        mataKursus.vaataRegistreerunudOpilasi();
        fyysikaKursus.vaataRegistreerunudOpilasi();
    }
}
