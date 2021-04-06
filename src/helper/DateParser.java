package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateParser {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private DateParser() {
    }

    public static Date parse(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        return sdf.parse(s);
    }

    public static String format(Date d) {
        if (d == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(d);
    }
}