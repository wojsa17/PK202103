package tt.com.pl.test.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SearchService<K, E extends Entity<K>, P> {

    JpaSpecificationExecutor<E> getRepository();

    default Specification<E> getSpecification(P params) {
        return SpecificationBuilder.<K,E,P>build(params);
    }

    default Page<E> search(P params, Pageable pageable) {
        return getRepository().findAll(getSpecification(params), pageable);
    }

    default List<E> search(P params) {
        return getRepository().findAll(getSpecification(params));
    }
}
