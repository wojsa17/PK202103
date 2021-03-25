package tt.com.pl.test.common.specification;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@SpecificationProcessor(processor = EqualsProcessor.class)
public @interface Equals {
    String field() default StringUtils.EMPTY;
}
