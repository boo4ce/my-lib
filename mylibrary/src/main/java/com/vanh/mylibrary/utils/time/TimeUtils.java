package com.vanh.mylibrary.utils.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {
    private final long DAY_IN_TICKS = 86400000;

    private SimpleDateFormat dateFormat = null;
    private static TimeUtils instance = null;

    private TimeUtils() {

    }

    public static TimeUtils getInstance() {
        if(instance == null) {
            synchronized (TimeUtils.class) {
                if (instance == null)
                    instance = new TimeUtils();
            }
        }

        return instance;
    }

    private SimpleDateFormat getFormat() {
        if(dateFormat == null) changeFormat();

        return dateFormat;
    }

    public void changeFormat() {
        dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy | hh:mm a", Locale.getDefault());
    }

    public String convertDateToDateString(Date date) {
        return getFormat().format(date);
    }

    public String convertTicksStringToDateString(String timeInTicks) {
        String res = "Unknown";

        if(timeInTicks != null) {
            try {
                long ticks = Long.parseLong(timeInTicks);
                res = getFormat().format(new Date(ticks*1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    public String convertTicksToDateString(long timeInTicks) {
        String res = "Unknown";

        res = getFormat().format(timeInTicks);

        return res;
    }

    public Date getCurrentDate() {
        return new Date();
    }
}
