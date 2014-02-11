package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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
	 * Computes the bitwise-XOR, ^, of all the elements of an array,
	 * to find the unpaired element in O(n) time.
	 * 
	 * @param nums[] array of elements to search in.
	 * 
	 * @return unpaired element
	 */
	public static int find(int[] nums) {
		int unpaired = 0;
		for (int i : nums)
			unpaired ^= i;

		return unpaired;
	}

	/*
	 * finds all the unpaired element in an array.
	 * 
	 * @param nums[] array of numbers to search in.
	 * 
	 * @return array of unpaired elements
	 */
	public static Integer[] findAll(int[] nums) {

		Set<Integer> unpaired = new HashSet<Integer>();
		for (int i : nums)
			if (!unpaired.add(i)) unpaired.remove(i);

		return unpaired.toArray(new Integer[unpaired.size()]);
	}
	
	private static int[] toIntArray(String line) {
		String[] nums = line.split(",");
		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
			res[i] = Integer.valueOf(nums[i].trim());

		return res;
	}

}
