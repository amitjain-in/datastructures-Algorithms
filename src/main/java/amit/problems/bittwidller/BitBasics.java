package amit.problems.bittwidller;

public class BitBasics {

    @SuppressWarnings({"ConstantConditions", "PointlessBitwiseExpression"})
    public static void main(String[] args) {
        bitPlay();
        numbers();
        int a = 10;
        System.out.println("a = " + a + " in binary a =" + Integer.toBinaryString(a));
        System.out.println("XOR a ^ a = " + (a ^ a));//returns 0
        System.out.println("AND a & a = " + (a & a));//returns itself
        System.out.println("OR  a | a = " + (a | a));//returns itself
        System.out.println("shift left a << 1 = " + (a << 1) + " in  binary " + Integer.toBinaryString(a << 1)); //also a X 2
        System.out.println("shift right a >> 1 = " + (a >> 1) + " in  binary " + Integer.toBinaryString(a >> 1)); //also a / 2
    }

    private static void numbers() {
        int rb = 7; //2^5 - 1
        //This is why ring buffer size needs to be power 2. Masking is faster than module operation. In modulo assignments we lose the 1 and they are slower
        for (int i = 0; i <= rb * 2; i++) {
            System.out.println(i + " & " + rb + " = " + (i & rb) + " vs " + i + " % " + rb + " = " + (i % rb));
        }
    }

    private static void bitPlay() {
        int intMax = Integer.MAX_VALUE;
        int one  = 1;
        for(int i = 1; i <  31; i++) {
            System.out.println((intMax >> i) + " " + (intMax >>> i) + " " + (one << i));
        }
    }
}
