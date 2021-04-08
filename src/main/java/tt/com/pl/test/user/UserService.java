package tt.com.pl.test.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tt.com.pl.test.common.SearchService;
import tt.com.pl.test.common.Service;

@Component
@RequiredArgsConstructor
public class UserService implements Service<Long, UserEntity>, SearchService<Long, UserEntity, UserParams> {

    @Getter
    private final UserRepository repository;
}
