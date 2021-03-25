package tt.com.pl.test.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Service<K, E extends Entity<K>> {

    JpaRepository<E, K> getRepository();

    default Optional<E> findById(K key) {
        return getRepository().findById(key);
    }

    default void delete(K key) {
        getRepository().deleteById(key);
    }

    default E save(E entity) {
        return getRepository().save(entity);
    }

    default boolean exists(K key) {
        return getRepository().existsById(key);
    }
}
