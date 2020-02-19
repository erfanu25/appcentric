package org.erfan.appcentric.mapper;

public interface ResultMapper<T,R> {
    R map(T entity);
}
