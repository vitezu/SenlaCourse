package com.senlaCourse.autoservice.util;

import org.apache.log4j.Logger;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    Logger logger = Logger.getLogger(DateUtil.class);
    private final SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat DF1 = new SimpleDateFormat("hh:mm");


    public Date create(String date) {
        Date dat = new Date();
        try {
            dat = DF.parse(date);
        } catch (ParseException e) {
            logger.error("Date is not correct", e);
        }
        return dat;
    }

    public Date convertToDate (Long time) {
        Date dat = new Date();
        try {
            dat = DF.parse(DF.format(time));
        } catch (ParseException e) {
            logger.error("Date is not correct", e);
        }
        return dat;
    }

    public Date createTime(String time) {
       Date tim = new Date();
        try {
            tim = DF1.parse(time);
        } catch (ParseException e) {
            logger.error("Date is not correct", e);
        }
        return tim;
    }
}
