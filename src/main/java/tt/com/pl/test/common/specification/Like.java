package tt.com.pl.test.common.specification;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static tt.com.pl.test.common.specification.Like.Type.BOTH;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@SpecificationProcessor(processor = LikeProcessor.class)
public @interface Like {
    Type type() default BOTH;
    String field() default StringUtils.EMPTY;

    enum Type {
        AFTER {
            @Override
            String toPredicate(String value) {
                return value + "%";
            }
        },
        BEFORE {
            @Override
            String toPredicate(String value) {
                return "%" + value;
            }
        },
        BOTH {
            @Override
            String toPredicate(String value) {
                return  "%" + value + "%";
            }
        };

        abstract String toPredicate(String value);
    }
}
