package amit.problems.simple;

/**
 * Swap without a variable
 */
public class Swap {

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1() {//Using maths
        int a = 10;
        int b = 5;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " b = " + b);
    }

    private static void method2() {//Using XOR
        int a = 10;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println("a = " + a + " b = " + b);
    }
}
