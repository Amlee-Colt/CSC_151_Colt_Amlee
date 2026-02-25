package labs.example.loops;

public class WhileLoop {

    public void executeWhileLoop() {

        int count = 1;
        while (count <= 10) {
            count++;
        }
        System.out.println("There were " + (count-1) + " iterations. The WhileLoop is now complete.");
    }
}

