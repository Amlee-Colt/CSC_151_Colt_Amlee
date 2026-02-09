package src.labs.example.mammal;
public class Mammal {
    protected String hairColor;
    protected String eyeColor;
    protected String bodyTemp;
    protected String habitat;
    protected String name;

    public void setName(String name){
        this.name = name;
        return;
    }

    public void run(){

    }
    
    public void eat(){
    
    }

    public void sleep(){
    
    }

    public void scratch(){
    
    }

    public void stand(){
        System.out.println("The animal stands.");
    }

    
    public void walk(){
        System.out.println("The animal walks 3 units south, then 4 units east. This means that it is " + Math.pow(Math.pow(3,2) + Math.pow(4,2),0.5) + " units from its starting point.");
        System.out.println("The angle formed is " + Math.atan2(3, 4) * 180/Math.PI + " degrees");
    }

    public void sit() throws Exception {
        System.out.println("The animal is sitting.");
    return;

    }

    public void bark(){
        System.out.println("Woof!");
    }


    public void getMammalDetails(){
        System.out.println(this.hairColor + "\n" + this.eyeColor + "\n" + this.bodyTemp + "\n" + this.habitat);
    }

}
