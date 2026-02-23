package labs.example.loops;

public class WhileLoop {

    public static void executeWhileLoop() {

        int count = 1;
        while (count <= 10) {
            count++;
        }
        System.out.println("There were " + (count-1) + " iterations. The loop is now complete.");
    }
}

