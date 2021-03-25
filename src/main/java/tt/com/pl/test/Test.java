package tt.com.pl.test;

import lombok.Getter;
import lombok.Setter;
import tt.com.pl.test.validator.Max;

@Setter
@Getter
public class Test {
    @Max(4)
    private String name;
}
