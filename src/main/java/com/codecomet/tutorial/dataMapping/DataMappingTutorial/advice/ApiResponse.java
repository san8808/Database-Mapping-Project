package com.codecomet.tutorial.dataMapping.DataMappingTutorial.advice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class ApiResponse<T>{

    private LocalDateTime timeStamp;
    private T date;
    private ApiError error;

    public ApiResponse() {
        this.timeStamp= LocalDateTime.now();
    }

    public ApiResponse(T date) {
        this();
        this.date = date;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
