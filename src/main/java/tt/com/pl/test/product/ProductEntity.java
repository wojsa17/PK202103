package tt.com.pl.test.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tt.com.pl.test.common.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@SequenceGenerator(name = "PRODUCT_SEQ", allocationSize = 1000)
public class ProductEntity extends AbstractEntity<Long> {
    private String name;
}
