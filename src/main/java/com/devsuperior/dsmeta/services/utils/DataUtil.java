package com.devsuperior.dsmeta.services.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static public LocalDate getMaxDate(String date) {
        if (date.isEmpty()) {
            return LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        } else {
            return LocalDate.parse(date, formatter);
        }
    }

    static  public LocalDate getMinDate(String minDate, LocalDate maxDate ){
        if (minDate.isEmpty()) {
            return maxDate.minusYears(1);
        } else {
            return LocalDate.parse(minDate, formatter);
        }
    }

}
