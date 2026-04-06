package labs.example.fileOperations;
import java.util.ArrayList;



public class test {
    public static void main(String[] args) {

        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("James");
        nameList.add("Catherine");
        nameList.add("Bill");

        for (int index = 0; index < nameList.size(); index++) 
            System.out.println(nameList.get(index));
    }
}