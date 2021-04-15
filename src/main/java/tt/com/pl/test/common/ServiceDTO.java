package tt.com.pl.test.common;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceDTO<K, E extends Entity<K>, DTO extends IDTO<K>> {

    JpaRepository<E, K> getRepository();
    IMapper<K, E, DTO> getMapper();

    default Optional<DTO> findDTOById(K key) {
        return getRepository().findById(key).map(getMapper()::toDTO);
    }

    default DTO save(DTO dto) {
        return getMapper().toDTO(getRepository().save(getMapper().toEntity(dto)));
    }

    default boolean exists(DTO key) {
        return getRepository().existsById(key.getId());
    }
}
