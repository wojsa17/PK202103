package tt.com.pl.test.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tt.com.pl.test.common.SearchService;
import tt.com.pl.test.common.Service;

@Component
@RequiredArgsConstructor
public class ProductService implements Service<Long, ProductEntity>, SearchService<Long, ProductEntity, ProductParams> {

    @Getter
    private final ProductRepository repository;
}
