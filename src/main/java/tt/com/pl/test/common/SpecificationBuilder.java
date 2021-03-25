package tt.com.pl.test.common;

import lombok.SneakyThrows;
import org.springframework.data.jpa.domain.Specification;
import tt.com.pl.test.common.specification.Processor;
import tt.com.pl.test.common.specification.SpecificationProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SpecificationBuilder {

    private static Map<Annotation, Processor> processors = new ConcurrentHashMap<>();

    public static <K, E extends Entity<K>, P> Specification<E> build(P params) {

        Specification<E> specification = Specification.where(null);
        if(Objects.nonNull(params)) {
            Field[] declaredFields = params.getClass().getDeclaredFields();

            for (Field declaredField : declaredFields) {
                specification = process(declaredField, params, specification);
            }
        }

        return specification;
    }

    @SneakyThrows
    private static <K, E extends Entity<K>, P> Specification<E> process(Field field, P params, Specification<E> specification) {
        List<Annotation> annotations = Arrays.stream(field.getDeclaredAnnotations())
                .filter(a -> a.getClass().getInterfaces()[0].isAnnotationPresent(SpecificationProcessor.class))
                .collect(Collectors.toList());

        for (Annotation annotation : annotations) {
            field.setAccessible(true);
            specification = getProcessor(annotation).process(specification, field, params);
        }

        return specification;
    }

    @SneakyThrows
    private static Processor getProcessor(Annotation annotation) {
        Processor processor = processors.get(annotation);

        if(Objects.isNull(processor)){
            Class<? extends Processor> clazz = annotation.getClass().getInterfaces()[0].getAnnotation(SpecificationProcessor.class).processor();
            Constructor<? extends Processor> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            processor = declaredConstructor.newInstance();
            processor.setAnnotation(annotation);
            processors.put(annotation, processor);
        }

        return processor;
    }
}
