package tt.com.pl.test.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tt.com.pl.test.common.SearchService;
import tt.com.pl.test.common.Service;
import tt.com.pl.test.common.ServiceDTO;

@Getter
@Component
@RequiredArgsConstructor
public class ProductService implements ServiceDTO<Long, ProductEntity, ProductDTO>, Service<Long, ProductEntity>, SearchService<Long, ProductEntity, ProductParams> {
    private final ProductRepository repository;
    private final ProductMapper mapper;
}
