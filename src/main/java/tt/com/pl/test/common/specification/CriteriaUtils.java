package tt.com.pl.test.common.specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Objects;

class CriteriaUtils {

    static <T,Y> Path<Y> getPath(String field, Root<T> eventRoot) {
        Path<Y> path = null;
        for (String pathPart : field.split("\\.")) {
            if(Objects.isNull(path)){
                path = eventRoot.get(pathPart);
            } else {
                path = path.get(pathPart);
            }
        }
        return path;
    }
}
