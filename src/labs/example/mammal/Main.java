package src.labs.example.mammal;

public class Main {
    public static void main(String[] args) throws Exception{
        Mammal mammal = new Mammal();

        mammal.sit();
        Thread.sleep(15000);
        mammal.stand();
        mammal.bark();

        //mammal.walk();

    }
}
