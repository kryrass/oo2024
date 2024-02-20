public class ToDoItem {
    String nimi;
    String tähtaeg;
    String prioriteet;

    public ToDoItem(String nimi, String tähtaeg, String prioriteet) {
        this.nimi = nimi;
        this.tähtaeg = tähtaeg;
        this.prioriteet = prioriteet;
    }
    public String toString() {
        return "Ülesanne: " + nimi + ", Tähtaeg: " + tähtaeg + ", Prioriteet: " + prioriteet;
    }
}
