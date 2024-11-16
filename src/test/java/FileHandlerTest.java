import org.example.FileHandler;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    @Test
    public void testReadFile() {
        FileHandler fileHandler = new FileHandler();
        List<String[]> data = fileHandler.readFile("src/main/java/org/example/RegularUser.csv");
        assertFalse(data.isEmpty(), "File should not be empty");
    }

    @Test
    public void testWriteFile() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.writeFile("src/main/java/org/example/TestUser.csv", "1,testuser,test@example.com,testpass", false);
        List<String[]> data = fileHandler.readFile("src/main/java/org/example/TestUser.csv");
        assertEquals(1, data.size(), "File should contain one entry");
    }

    @Test
    public void testUpdateFile() {
        FileHandler fileHandler = new FileHandler();
        List<String[]> data = fileHandler.readFile("src/main/java/org/example/RegularUser.csv");
        data.get(0)[1] = "updateduser";
        fileHandler.updateFile("src/main/java/org/example/TestUser.csv", data);
        List<String[]> updatedData = fileHandler.readFile("src/main/java/org/example/TestUser.csv");
        assertEquals("updateduser", updatedData.get(0)[1], "First entry should be updated");
    }

    @Test
    public void testRenameFile() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.renameFile("src/main/java/org/example/TestUser.csv", "src/main/java/org/example/RenamedUser.csv");
        List<String[]> data = fileHandler.readFile("src/main/java/org/example/RenamedUser.csv");
        assertFalse(data.isEmpty(), "Renamed file should not be empty");
    }
}