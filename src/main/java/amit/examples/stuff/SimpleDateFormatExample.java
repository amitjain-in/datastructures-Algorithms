package amit.examples.stuff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
    private final SimpleDateFormat dateFormatUnsafe = new SimpleDateFormat("dd-MMM-yyyy");
    private final ThreadLocal<SimpleDateFormat> dateFormatSafe = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd-MMM-yyyy");
        }
    };

    //No thread-safe
    public Date parseBuggy(String dateStr) throws ParseException {
        return dateFormatUnsafe.parse(dateStr);
    }

    //thread-safe and efficient
    public Date parseSafe(String dateStr) throws ParseException {
        return dateFormatSafe.get().parse(dateStr);
    }

    //thread-safe but inefficient as new formatter object is created for every parsing call
    public Date parseAlsoSafe(String dateStr) throws ParseException {
        return new SimpleDateFormat("dd-MMM-yyyy").parse(dateStr);
    }
}
