package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateParser {
    private DateParser() {
    }

    public static Date parse(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        return sdf.parse(s);
    }

    public static String format(Date d) {
        if (d == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
}