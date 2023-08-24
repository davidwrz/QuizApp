package au.davidwrz.quizapp.utils.mapper;

public interface EntityMapper<E, D> {
    E toEntity(D d);
}
