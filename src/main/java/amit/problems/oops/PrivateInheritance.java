package amit.problems.oops;

public class PrivateInheritance {

    public static void main(String[] args) {
        Sub sub = new Sub(190);

    }

    static class Base {
        private Base() {
            System.out.println("In Base default constructor");
        }
    }

    static class Sub extends Base {

        public Sub(int n) {

        }
    }
}
