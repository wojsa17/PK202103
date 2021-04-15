package tt.com.pl.test.recipe;


import lombok.Getter;
import lombok.Setter;
import tt.com.pl.test.common.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "FILE")
public class FileEntity extends AbstractEntity<Long> {
    @ManyToOne
    private RecipeEntity recipe;

    @Lob
    private byte[] content;
}
