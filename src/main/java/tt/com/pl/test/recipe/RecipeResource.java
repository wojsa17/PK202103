package tt.com.pl.test.recipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tt.com.pl.test.common.CRUDResource;
import tt.com.pl.test.common.SearchService;

@RestController
@RequestMapping("api/recipe")
@RequiredArgsConstructor
public class RecipeResource implements CRUDResource<Long, RecipeEntity, RecipeParams> {

    @Getter
    private final RecipeService service;

    @Override
    public SearchService<Long, RecipeEntity, RecipeParams> getSearchService() {
        return service;
    }
}
