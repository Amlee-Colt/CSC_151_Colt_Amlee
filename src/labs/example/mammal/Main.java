package src.labs.example.mammal;

public class Main {
    public static void main(String[] args) throws Exception{
        Mammal mammal = new Mammal();
        Dog dog = new Dog();

        dog.sit();
        Thread.sleep(15000);
        mammal.stand();
        dog.bark();
        //mammal.walk();

    }
}
