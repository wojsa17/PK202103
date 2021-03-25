package tt.com.pl.test.common.specification;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@SpecificationProcessor(processor = AfterProcessor.class)
public @interface After {
    String field() default StringUtils.EMPTY;
}