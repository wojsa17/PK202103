package tt.com.pl.test.product;

import org.mapstruct.Mapper;
import tt.com.pl.test.common.IMapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends IMapper<Long, ProductEntity, ProductDTO> {
}
