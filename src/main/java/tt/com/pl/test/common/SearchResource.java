package tt.com.pl.test.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface SearchResource<K, E extends Entity<K>, P> {

    SearchService<K, E, P> getSearchService();

    @GetMapping
    default List<E> search(P params) {
        return getSearchService().search(params);
    }

    @GetMapping(params = "page")
    default Page<E> search(P params, Pageable pageable) {
        return getSearchService().search(params, pageable);
    }
}
