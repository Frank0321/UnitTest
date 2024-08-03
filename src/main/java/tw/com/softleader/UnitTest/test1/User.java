package tw.com.softleader.UnitTest.test1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private String id;
    private String passwordHash;
    private boolean enable;
}
