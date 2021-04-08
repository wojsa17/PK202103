package tt.com.pl.test.recipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tt.com.pl.test.common.SearchService;
import tt.com.pl.test.common.Service;

@Component
@RequiredArgsConstructor
public class RecipeService implements Service<Long, RecipeEntity>, SearchService<Long, RecipeEntity, RecipeParams> {

    @Getter
    private final RecipeRepository repository;
}
