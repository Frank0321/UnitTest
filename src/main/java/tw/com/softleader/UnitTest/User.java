package tw.com.softleader.UnitTest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String passwordHash;
    private boolean enable;
}
