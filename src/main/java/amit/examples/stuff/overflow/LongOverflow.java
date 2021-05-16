package amit.examples.stuff.overflow;

import java.text.DecimalFormat;

public class LongOverflow {

    public static void main(String[] args) {
        long a = 4_294_967_297L;
        System.out.println(a * a);//8_589_934_593 //9_223_372_036_854_775_807L. Actual 1.8446744e+19
                                            //4_294_967_297L
        System.out.println(DecimalFormat.getInstance().format(Long.MAX_VALUE));
    }
}
