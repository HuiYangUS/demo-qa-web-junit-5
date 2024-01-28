package unit;

import org.junit.jupiter.api.AfterEach;

public class Base {

	@AfterEach
	void afterTest() {
		System.out.println();
	}

}
