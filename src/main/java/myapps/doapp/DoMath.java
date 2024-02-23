package myapps.doapp;

public class DoMath {

	public static boolean search(int target, int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		boolean targetFound = false;
		for (int num : nums) {
			if (num == target) {
				targetFound = true;
				break;
			}
		}
		return targetFound;
	}

}
