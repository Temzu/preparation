package com.temzu.preparation.lesson_5.repositories;

public interface IRepository<T> {
    void save(T e);

    void delete(T e);

    T findById(long id);
}
