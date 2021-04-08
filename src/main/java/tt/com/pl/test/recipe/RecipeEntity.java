package tt.com.pl.test.recipe;

import lombok.Getter;
import lombok.Setter;
import tt.com.pl.test.common.AbstractEntity;
import tt.com.pl.test.user.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "RECIPE")
public class RecipeEntity extends AbstractEntity<Long> {

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "recipe", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<FileEntity> files = new ArrayList<>();
}
