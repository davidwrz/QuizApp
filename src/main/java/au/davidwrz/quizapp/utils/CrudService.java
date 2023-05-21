package au.davidwrz.quizapp.utils;

import java.util.List;

public interface CrudService<T, V> {

    void add(T t);

    void deleteById(V id);

    List<T> findAll();

    T findById(V v);
}
