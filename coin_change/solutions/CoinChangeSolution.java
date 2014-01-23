package solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinChangeSolution {

	public static void main(String[] args) throws Exception {
		// read STDIN
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] coins = getCoins(br.readLine());
		int amt = Integer.valueOf(br.readLine());

		// write STDOUT
		System.out.println(countOptimal(coins, amt));
	}

	/*
	 * Calculates the number of many ways can we make the change from a list of
	 * coins.
	 * 
	 * @param coins[] array of change in coins
	 * 
	 * @param amt amt to make change from
	 * 
	 * @return number of solutions
	 */
	public static int countOptimal(int[] coins, int amt) {

		// solutions[i] contains the no. of solutions for value i.
		// We build from bottom up using the base case (n = 0)
		int solutions[] = new int[amt + 1];
		solutions[0] = 1;
		for (Integer i : coins)
			for (int j = i; j <= amt; j++)
				solutions[j] += solutions[j - i];

		return solutions[amt];
	}

	private static int[] getCoins(String line) {
		String[] nums = line.split(", ");
		int[] coins = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
			coins[i] = Integer.valueOf(nums[i]);

		return coins;
	}

	public static int countRecursive(int coins[], int c, int sum) {

		if (sum == 0)
			return 1;
		if (sum < 0)
			return 0;
		if (c <= 0 && sum >= 1)
			return 0;

		return countRecursive(coins, c - 1, sum)
		    + countRecursive(coins, c, sum - coins[c - 1]);
	}

	public static void print() {
		// TODO:
	}

}
