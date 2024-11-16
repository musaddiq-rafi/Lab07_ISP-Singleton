import org.example.FileHandler;
import org.example.PowerUser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PowerUserTest {
    @Test
    public void testWriteData() {
        PowerUser user = new PowerUser("2", "sarah", "sarah@example.com", "power123");
        user.writeData("2,sarah2,sarah2@example.com,power1234", "power");

        FileHandler fileHandler = new FileHandler();
        List<String[]> data = fileHandler.readFile("src/main/java/org/example/PowerUser.csv");
        assertTrue(data.stream().anyMatch(row -> row[1].equals("sarah2")), "New power user should be added");
    }
}