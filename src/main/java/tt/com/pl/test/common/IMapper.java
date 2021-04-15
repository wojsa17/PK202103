package tt.com.pl.test.common;

public interface IMapper<K, ENTITY extends Entity<K> , DTO> {
    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
