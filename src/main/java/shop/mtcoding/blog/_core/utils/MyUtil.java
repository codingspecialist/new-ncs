package shop.mtcoding.blog._core.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtil {

    public static String localDateToString(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
