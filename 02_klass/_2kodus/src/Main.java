public class Main {
    public static void main(String[] args) {
        // Loome mõned ülesanded
        ToDoItem ülesanne1 = new ToDoItem("Kodutöö esitamine", "20. veebruar 2024", "Kõrge");
        ToDoItem ülesanne2 = new ToDoItem("Ostunimekirja täitmine", "26. veebruar 2024", "Keskmine");
        ToDoItem ülesanne3 = new ToDoItem("Jõusaal", "Iga päev", "Madal");
        ToDoItem ülesanne4 = new ToDoItem("Pesu pesemine", "21. veebruar 2024", "Kõrge");

        // Väljastame loodud ülesanded
        System.out.println(ülesanne1);
        System.out.println(ülesanne2);
        System.out.println(ülesanne3);
        System.out.println(ülesanne4);
    }
}