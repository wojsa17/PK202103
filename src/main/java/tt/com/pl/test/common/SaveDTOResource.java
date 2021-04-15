package tt.com.pl.test.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Objects;

public interface SaveDTOResource<K, E extends Entity<K>, DTO extends IDTO<K>> {

    ServiceDTO<K, E, DTO> getServiceDTO();

    @PostMapping(params = "page")
    default ResponseEntity<?> create(@RequestBody @Valid DTO entity){

        try {
            if(Objects.nonNull(entity.getId()) && getServiceDTO().exists(entity)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Object already exists");
            }

            getServiceDTO().save(entity);
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
