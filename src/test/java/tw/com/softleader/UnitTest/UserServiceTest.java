package tw.com.softleader.UnitTest;

import org.junit.Before;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private static final String PASSWORD = "password";
    private static final User ENABLED_USER = User.builder()
                                                .id("user_id")
                                                .passwordHash("hash")
                                                .enable(true)
                                                .build();
    private static final User DISABLED_USER = User.builder()
                                                .id("disabled_user_id")
                                                .passwordHash("disabled_user_password_hash")
                                                .enable(false)
                                                .build();

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Before
    void setup(){
        this.userRepository = createUserRepository();
        this.passwordEncoder = createPasswordEncoder();
        this.userService = new UserService(this.userRepository, this.passwordEncoder);
    }



    private PasswordEncoder createPasswordEncoder() {
        PasswordEncoder mock = mock(PasswordEncoder.class);
        when(mock.encode(anyString())).thenReturn("any password hash");
        when(mock.encode(PASSWORD)).thenReturn(ENABLED_USER.getPasswordHash());
        return mock;
    }

    private UserRepository createUserRepository() {
        UserRepository mock = mock(UserRepository.class);
        when(mock.findById(ENABLED_USER.getId())).thenReturn(ENABLED_USER);
        when(mock.findById(DISABLED_USER.getId())).thenReturn(DISABLED_USER);
        return mock;
    }
}
