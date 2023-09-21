package com.karthik.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public LocalDate convertStringToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonConstants.DATE_FORMAT);
        return LocalDate.parse(date, formatter);
    }
}
