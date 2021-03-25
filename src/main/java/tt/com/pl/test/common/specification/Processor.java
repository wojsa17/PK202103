package tt.com.pl.test.common.specification;

import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;

public interface Processor<A> {
    <E, P> Specification<E> process(Specification<E> specification, Field field, P params);

    void setAnnotation(A annotation);
}
