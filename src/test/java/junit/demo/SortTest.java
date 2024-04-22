package junit.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import junit.base.BaseTest;

public class SortTest extends BaseTest {

	@Test
	void arrayTest() {
		int[] nums = new int[] {};
		System.out.println(nums.length);
		int[] numsTwo = new int[] { 1, 2, 3 };
		System.out.println("Two --> " + Arrays.toString(numsTwo));
		int[] numsThree = { 4, 5, 6 };
		System.out.println("Three --> " + Arrays.toString(numsThree));
	}

	@Test
	void arraySortTest() {
		int[] nums = { 7, 10, 8 };
		System.out.println("Unsorted: " + Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println("Sorted: " + Arrays.toString(nums));
	}

	@Test
	void arrayListSortTest() {
		List<Double> data = new ArrayList<>();
		data.add(3.3);
		data.add(9.7);
		data.add(6.6);
		System.out.println("Unsorted: " + data);
		Collections.sort(data);
		System.out.println("Sorted: " + data);
	}

	@Test
	void mapSortTest() {
		Map<String, Double> data = new HashMap<>();
		data.put("yellow", .9);
		data.put("red", .7);
		data.put("green", .2);
		System.out.println("Unsorted: " + data);
		TreeMap<String, Double> sortedData = new TreeMap<>();
		sortedData.putAll(data);
		System.out.println("Sorted: " + sortedData);
	}

}
