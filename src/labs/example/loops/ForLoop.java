package labs.example.loops;

public class ForLoop {

    public void executeForLoop() {

        for (int count = 0; count < 20; count++) {
            System.out.println("Count: " + count);
        }
        System.out.println("There were 20 iterations. The ForLoop is now complete.");
    }

    public int sumTwoNumbers(int a, int b) {
        return a + b;
    }

    public int sumLoopCounter(int a) {
        int sum = 0;
        for (int counter = 0; counter <= Math.abs(a); counter++) {
            sum += (counter);
        }
        return sum;
    }

    public void printMultiplicationTable(int number) {
        for (int i = 0; i <= 12; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}
