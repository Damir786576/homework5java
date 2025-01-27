package com.example.stream.exception;

public class EmployeeStorageIsFullExcepiton extends RuntimeException {
    public EmployeeStorageIsFullExcepiton(String message) {
        super(message);
    }
}
