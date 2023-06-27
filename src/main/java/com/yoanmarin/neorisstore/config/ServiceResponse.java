package com.yoanmarin.neorisstore.config;

import lombok.Data;

@Data
public class ServiceResponse<T> {
    private boolean error;
    private String message;
    private T response;
}
