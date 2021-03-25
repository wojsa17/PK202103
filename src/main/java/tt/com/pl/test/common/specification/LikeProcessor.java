package tt.com.pl.test.common.specification;

import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;

import static tt.com.pl.test.common.specification.CriteriaUtils.getPath;

class LikeProcessor implements Processor<Like> {

    @Setter
    private Like annotation;

    @Override
    @SneakyThrows
    public <E, P> Specification<E> process(Specification<E> specification, Field field, P params) {
        String value = (String) field.get(params);

        return (Specification<E>) (eventRoot, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(getPath(annotation.field(), eventRoot), annotation.type().toPredicate(value));
    }
}
