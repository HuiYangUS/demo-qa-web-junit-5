package unit.check;

import java.time.LocalDate;

public class Temp {

	public static void main(String[] args) {
		String[] dateData = LocalDate.now().toString().split("-");
		System.out.println(dateData.length);
		System.out.println(dateData[0]);
		System.out.println(dateData[1]);
		System.out.println(dateData[2]);
	}

}
