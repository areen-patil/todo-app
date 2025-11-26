package test.java.com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoAppTest {
    @Test
    public void testAddTask() {
        ToDoApp app = new ToDoApp();
        app.addTask("Test Task");
        assertEquals(1, app.getTasks().size());
        assertEquals("Test Task", app.getTasks().get(0));
    }
}