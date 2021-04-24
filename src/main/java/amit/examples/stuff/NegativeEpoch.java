package amit.examples.stuff;

import java.util.Date;

public class NegativeEpoch {

    public static void main(String[] args) {
        //Note this will display time based on your local timezone.
        System.out.println("Date: " + new Date(0)); //Date: Thu Jan 01 05:30:00 IST 1970
        System.out.println("Date: " + new Date(-100_000)); //Date: Thu Jan 01 05:28:20 IST 1970
        System.out.println("Date: " + new Date(-200_000)); //200 secs. Date: Thu Jan 01 05:26:40 IST 1970
        System.out.println("Date: " + new Date(-1_000_000)); //1000 secs. Date: Thu Jan 01 05:13:20 IST 1970
        System.out.println("Date: " + new Date(new Date().getTime() * -1)); //Reverse time from 1970 till now in opposite direction.
    }
}
