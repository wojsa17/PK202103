package tt.com.pl.test.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;

public interface DeleteResource<K, E extends Entity<K>> {

    Service<K, E> getService();

    @DeleteMapping(value = "/{id}")
    default ResponseEntity<?> create(@PathVariable("id") K id){

        try {
            if(Objects.isNull(id)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Id cannot be empty");
            } else if (!getService().exists(id)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Object not exists");
            }

            getService().delete(id);
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
