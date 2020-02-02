package amit.problems.recursion;

// Doesn't support if the number goes beyond Integer.MAX
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " -- " + fibonacci.generate(i));
        }
    }

    private int generate(int n) {
        return n == 0 || n == 1 ? n : generate(n - 1) + generate(n - 2);
    }
}
