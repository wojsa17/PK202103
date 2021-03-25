package tt.com.pl.test.product;

import lombok.Getter;
import lombok.Setter;
import tt.com.pl.test.common.specification.Like;

@Getter
@Setter
public class ProductParams {
    @Like(field = "name")
    private String name;
}
