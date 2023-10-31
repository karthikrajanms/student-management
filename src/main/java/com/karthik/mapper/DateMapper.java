/*
package com.karthik.mapper;


import com.karthik.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.LocalDate;

//@Mapper(componentModel = "spring")
@Named("dateMapper")
@Mapper(componentModel = "spring")
public interface DateMapper {

    @Named("localDateToString")
    default String localDateToString(LocalDate date) {
        return date != null ? date.toString() : null;
    }

    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String date) {
        //return date != null ? LocalDate.parse(date) : null;
         return date != null ? DateUtils.convertStringToLocalDate(date) : null;
    }
}
*/
