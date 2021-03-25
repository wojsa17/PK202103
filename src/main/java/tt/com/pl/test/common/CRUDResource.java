package tt.com.pl.test.common;

public interface CRUDResource<K, E extends Entity<K>, P> extends SearchResource<K, E, P>, DeleteResource<K, E>, UpdateResource<K, E>, SaveResource<K, E> {
}
