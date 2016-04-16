package com.epam.DBController.ConnectionPool;

@FunctionalInterface
public interface Proxy<T> {
    @Private
    T toSrc();
}
