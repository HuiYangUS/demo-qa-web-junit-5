package junit.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void beforeTest() {
	System.out.println("Test starts:");
    }

    @AfterEach
    void afterTest() {
	System.out.println("Test completed.");
	System.out.println();
    }

}
