package tt.com.pl.test.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tt.com.pl.test.common.DeleteResource;
import tt.com.pl.test.common.SearchResource;
import tt.com.pl.test.common.SearchService;
import tt.com.pl.test.common.UpdateResource;

@RestController
@RequestMapping("api/recipe")
@RequiredArgsConstructor
public class UserResource implements SearchResource<Long, UserEntity, UserParams>, DeleteResource<Long, UserEntity>, UpdateResource<Long, UserEntity>{

    @Getter
    private final UserService service;

    @Override
    public SearchService<Long, UserEntity, UserParams> getSearchService() {
        return service;
    }

//    //I reg
//    create user
//    set to uactive
//    send mail
//
//    //II act
//    acivate


}
