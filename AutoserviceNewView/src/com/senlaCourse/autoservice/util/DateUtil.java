package com.senlaCourse.autoservice.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
    Logger logger = Logger.getLogger(DateUtil.class);
    private final SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");


    public Date create(String date) {
        Date dat = new Date();
        try {
            dat = DF.parse(date);
        } catch (ParseException e) {
            logger.error("Date is not correct", e);
        }
        return dat;
    }
}
