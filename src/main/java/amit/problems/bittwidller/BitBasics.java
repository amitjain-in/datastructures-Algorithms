package amit.problems.bittwidller;

public class BitBasics {

    public static void main(String[] args) {
        int a = 10;
        System.out.println("a = " + a + " in binary a =" + Integer.toBinaryString(a));
        System.out.println("XOR a ^ a = " + (a ^ a));//returns 0
        System.out.println("AND a & a = " + (a & a));//returns itself
        System.out.println("OR  a | a = " + (a | a));//returns itself
        System.out.println("shift left a << 1 = " + (a << 1) + " in  binary " + Integer.toBinaryString (a << 1)); //also a X 2
        System.out.println("shift right a >> 1 = " + (a >> 1)  + " in  binary " + Integer.toBinaryString (a >> 1)); //also a / 2
    }
}
