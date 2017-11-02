package com.senlaCourse.annotation.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilConvertString {
    private final SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
    Logger logger = Logger.getLogger(UtilConvertString.class);

    public Object convert (String value, Class<?> type) {
        if (value == null){
            throw new IllegalArgumentException("Missing configuration value: " + value);
        }
        if (type == String.class) {
            return value;
        }
        if (type == Boolean.class){
            return Boolean.parseBoolean(value);
        }
        if (type == Integer.class){
            return Integer.parseInt(value);
        }
        if (type == Float.class){
            return Float.parseFloat(value);
        }
        if (type == Date.class) {
            try {
                return DF.parse(value);
            } catch (ParseException e) {
                logger.error("Error parse date", e);
            }
        }
        throw new IllegalArgumentException("Unknown configuration value type: " + type.getName());
    }
}
