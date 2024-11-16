import org.example.RegularUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegularUserTest {
    @Test
    public void testReadData() {
        RegularUser user = new RegularUser("1", "john", "john@example.com", "12345");
        user.ReadData();
        assertEquals("Regular", user.getUsertype(), "User type should be Regular");
    }
}