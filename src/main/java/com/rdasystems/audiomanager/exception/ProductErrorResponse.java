package com.rdasystems.audiomanager.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductErrorResponse {
    private int status;
    private  String message;
    private LocalDateTime time;
}
