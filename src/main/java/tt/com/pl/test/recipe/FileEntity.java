package tt.com.pl.test.recipe;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "FILE")
public class FileEntity {
    @ManyToOne
    private RecipeEntity recipe;

    @Lob
    private byte[] content;
}
