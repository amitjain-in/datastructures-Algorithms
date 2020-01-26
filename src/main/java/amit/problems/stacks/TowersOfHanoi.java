package amit.problems.stacks;

public class TowersOfHanoi {

    public static void main(String[] args) {
        simpleHanoi(4, 'A', 'C', 'B');
    }

    private static void simpleHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
        if(n == 1) {
            System.out.println("Moved [" + n + "] from " + fromPeg + " to " + toPeg);
            return;
        }
        simpleHanoi(n-1, fromPeg, toPeg, auxPeg);
        System.out.println("Moved [" + n + "] from " + fromPeg + " to " + toPeg);
        simpleHanoi(n-1, auxPeg, toPeg, fromPeg);
    }
}
