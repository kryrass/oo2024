public class Info {
    String nimetus;
    int ram;
    String graafikakaart;

    public Info(String nimetus, int ram, String graafikakaart) {
        this.nimetus = nimetus;
        this.ram = ram;
        this.graafikakaart = graafikakaart;
    }
    public void muudaNimetus(String uusNimetus){
        nimetus = uusNimetus;
    }
}
