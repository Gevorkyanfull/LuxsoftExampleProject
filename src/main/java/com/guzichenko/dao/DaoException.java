package com.guzichenko.dao;

public class DaoException extends Throwable {
    public Long id;
    public String message;

    public DaoException(Long id, String message) {
        this.id = id;
        this.message = message;
    }
}
