package tt.com.pl.test.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tt.com.pl.test.common.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "USER")
public class UserEntity extends AbstractEntity<Long> {
    private boolean activated;
}
