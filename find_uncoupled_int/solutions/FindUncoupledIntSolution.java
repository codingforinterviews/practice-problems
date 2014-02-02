package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindUncoupledIntSolution {

	public static void main(String[] args) throws Exception {
		// read STDIN
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = toIntArray(br.readLine());
		br.close();

		// write STDOUT
		System.out.println(find(nums));
	}

	/*
	 * Computes the bitwise-XOR, ^, of all the elements of an array to find the
	 * unpaired element.
	 * 
	 * @param nums[] array of numbers to search in.
	 * 
	 * @return unpaired element
	 */
	public static int find(int[] nums) {
		int res = 0;
		for (int i : nums)
			res ^= i;

		return res;
	}

	public static int[] toIntArray(String line) {
		String[] nums = line.split(",");
		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
			res[i] = Integer.valueOf(nums[i].trim());

		return res;
	}

}
