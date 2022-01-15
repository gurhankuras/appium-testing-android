package app.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateService {
    final DateFormat format;

    public DateService(DateFormat format) {
        this.format = format;
    }

    public String afterNDaysFromToday(int days) {
        return afterNDays(new Date(), days);
    }

    private String afterNDays(Date date, int days) {
        Calendar c = Calendar.getInstance();

        c.setTime(date);
        c.add(Calendar.DATE, days);

        Date nDaysLaterFromDate = c.getTime();
        return format.format(nDaysLaterFromDate);
    }

    public String afterNDays(String formattedDate, int days) throws ParseException {
        var date = format.parse(formattedDate);
        return afterNDays(date, days);
    }


}
