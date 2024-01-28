package demo;

public class DoString {

	public static void main(String[] args) {

	}

	public static void demoReplaceAll() {
		System.out.println("msedgedriverVersion: 120.0.2210.133 (5a3825c4628d0bef4e9a1ceca8987a524bbd379a)"
				.replaceAll("[(].*[)]", "").strip());
	}

}
