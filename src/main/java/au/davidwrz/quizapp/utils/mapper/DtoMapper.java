package au.davidwrz.quizapp.utils.mapper;

public interface DtoMapper<E, D> {
    D toDto(E e);
}
