package au.davidwrz.quizapp.utils;

public interface DtoEntityMapper<T, V> {

    T toDto(V v);

    V toEntity(T t);
}
