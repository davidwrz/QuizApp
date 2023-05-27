package au.davidwrz.quizapp.utils.mapper;

public interface DtoMapper<E,D>{
    E toDto(E e);
}
