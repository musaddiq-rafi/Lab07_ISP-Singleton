import org.example.AdminUser;
import org.example.FileHandler;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdminUserTest {
    @Test
    public void testWriteData() {
        AdminUser user = new AdminUser("3", "admin", "admin@example.com", "adminPass");
        user.writeData("3,admin2,admin2@example.com,adminPass2", "admin");

        FileHandler fileHandler = new FileHandler();
        List<String[]> data = fileHandler.readFile("src/main/java/org/example/Admin.csv");
        assertTrue(data.stream().anyMatch(row -> row[1].equals("admin2")), "New admin user should be added");
    }

    @Test
    public void testUpdateUserDetails() {
        AdminUser user = new AdminUser("3", "admin", "admin@example.com", "adminPass");
        user.updateUserDetails("admin2", "3,admin2,admin2@example.com,adminPassUpdated");

        FileHandler fileHandler = new FileHandler();
        List<String[]> data = fileHandler.readFile("src/main/java/org/example/Admin.csv");
        assertTrue(data.stream().anyMatch(row -> row[3].equals("adminPassUpdated")), "Admin user details should be updated");
    }
}