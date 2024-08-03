package tw.com.softleader.UnitTest.test1;

import tw.com.softleader.UnitTest.bean.User;

public interface UserRepository {
    User findById(String id);
}
