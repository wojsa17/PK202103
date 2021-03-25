package tt.com.pl.test.validator;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Objects;

public final class ValidatorExecutor {

    @SneakyThrows
    public static void valid(Object object) {
        if(Objects.nonNull(object)) {
            Class<?> clazz = object.getClass();

            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                processMax(object, declaredField);
            }
        }
    }

    private static void processMax(Object object, Field declaredField) throws IllegalAccessException {
        Max max = declaredField.getAnnotation(Max.class);
        if(Objects.nonNull(max)){
            Object value = declaredField.get(object);

            if(String.class.isInstance(value)) {
                int length = String.class.cast(value).length();
                if(length > max.value()){
                    throw new IllegalArgumentException("Too long");
                }

            } else if (Long.class.isInstance(value)) {
                Long length = Long.class.cast(value);
                if(length > max.value()){
                    throw new IllegalArgumentException("Too long");
                }
            } else if (Double.class.isInstance(value)) {
                Double length = Double.class.cast(value);
                if(length > max.value()){
                    throw new IllegalArgumentException("Too long");
                }
            }
        }
    }
}
