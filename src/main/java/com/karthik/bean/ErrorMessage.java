package com.karthik.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class ErrorMessage {

    private String message;
    private String description;
    private int statusCode;
    private Date timestamp;
    private Set<String> errors;
}
