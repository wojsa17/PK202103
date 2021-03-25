package tt.com.pl.test.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Objects;

public interface SaveResource<K, E extends Entity<K>> {

    Service<K, E> getService();

    @PostMapping
    default ResponseEntity<?> create(@RequestBody @Valid E entity){

        try {
            if(Objects.nonNull(entity.getId()) && getService().exists(entity.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Object already exists");
            }

            getService().save(entity);
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
