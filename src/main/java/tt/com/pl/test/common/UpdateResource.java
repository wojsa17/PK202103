package tt.com.pl.test.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Objects;

public interface UpdateResource<K, E extends Entity<K>> {

    Service<K, E> getService();

    @PutMapping
    default ResponseEntity<?> update(@RequestBody @Valid E entity){

        try {
            if(Objects.isNull(entity.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Id cannot be empty");
            } else if (!getService().exists(entity.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Object not exists");
            }

            getService().save(entity);
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
