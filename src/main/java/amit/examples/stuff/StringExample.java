package amit.examples.stuff;

public class StringExample {

    public static void main(String[] args) {
        String hello = "Hello";
        System.currentTimeMillis();
        String hello1 = "Hello";
        System.out.println("Reference comparison: " + hello == hello1); //Returns false are two different references are compared
        System.out.println("Reference comparison: " + hello.equals(hello1)); // Returns true as actual objects are compared
    }
}
