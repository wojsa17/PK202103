package tt.com.pl.test.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tt.com.pl.test.common.IDTO;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ProductDTO implements Serializable, IDTO<Long> {
    private Long id;
    private String name;
    private String category;
}
