package com.senlaCourse.autoservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private final SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
    public Date create (String date) throws ParseException {
       return  DF.parse(date);
    }
}
