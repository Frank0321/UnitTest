package tw.com.softleader.UnitTest.test1;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean isEnabledUser(User user){
        return user != null && user.isEnable();
    }

    public boolean isValidPassword(User user, String password){
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword.equals(user.getPasswordHash());
    }

    public boolean isValidUser(String id, String password){
        User user = userRepository.findById(id);
        return isEnabledUser(user) && isValidPassword(user, password);
    }
}
