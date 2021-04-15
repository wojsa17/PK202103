package tt.com.pl.test.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tt.com.pl.test.common.*;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductResource implements CRUDResource<Long, ProductEntity, ProductParams>, SaveDTOResource<Long, ProductEntity, ProductDTO> {

    @Getter
    private final ProductService service;

    @Override
    public SearchService<Long, ProductEntity, ProductParams> getSearchService() {
        return service;
    }

    @Override
    public ServiceDTO<Long, ProductEntity, ProductDTO> getServiceDTO() {
        return service;
    }
}
