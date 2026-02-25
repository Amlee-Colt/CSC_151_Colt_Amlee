package labs.example.loops;

public class Main {
    public static void main(String[] args) throws Exception{
    WhileLoop WhileLoop = new WhileLoop();
    ForLoop forLoops = new ForLoop();

    System.out.println("---------- \nWhileLoop:");

    WhileLoop.executeWhileLoop();

    System.out.println("---------- \nForLoop:");

    forLoops.executeForLoop();

    System.out.println("---------- \nSumTwoNumbers:");

    int sum = forLoops.sumTwoNumbers(5, 10);
    System.out.println("The sum is: " + sum);
    for (int i = 1; sum != 0; i++) {
        if (sum > 0) {
            System.out.println("Iteration " + i + ": Sum is " + --sum);
        } else {
            System.out.println("Iteration " + i + ": Sum is " + ++sum);
        }
    }

    System.out.println("---------- \nSumLoopCounter:");

    System.out.println("The sum of the loop counter is: \"" + forLoops.sumLoopCounter(10) + "\"");

    System.out.println("---------- \nMultiplicationTable:");

    forLoops.printMultiplicationTable(5);

    }
}
