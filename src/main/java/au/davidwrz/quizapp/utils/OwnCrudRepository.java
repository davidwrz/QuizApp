package au.davidwrz.quizapp.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OwnCrudRepository<T, ID> extends JpaRepository<T, ID> {

    List<T> findAll();
    Optional<T> findById(ID id);
    void deleteById(ID id);
    <S extends T> S save(S entity);
}
