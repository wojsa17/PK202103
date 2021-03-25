package tt.com.pl.test.common.specification;

import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.Objects;

import static tt.com.pl.test.common.specification.CriteriaUtils.getPath;

class BeforeProcessor implements Processor<Before> {

    @Setter
    private Before annotation;

    @Override
    @SneakyThrows
    public <E, P> Specification<E> process(Specification<E> specification, Field field, P params) {
        Comparable value = Comparable.class.cast(field.get(params));

        return (Specification<E>) (eventRoot, criteriaQuery, criteriaBuilder) ->
                Objects.isNull(value) ? null : criteriaBuilder.lessThan(getPath(annotation.field(), eventRoot), value);
    }
}
