package solutions;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinChangeSolutionTest {

	@Test
	public void testCoinChangeSolutionRecursive() {

		int coins[] = { 1, 2, 3 };
		assertEquals(4, CoinChangeSolution.countRecursive(coins, coins.length, 4));

		coins = new int[] { 1, 2, 3 };
		assertEquals(5, CoinChangeSolution.countRecursive(coins, coins.length, 5));

		coins = new int[] { 2, 5, 3, 6 };
		assertEquals(5, CoinChangeSolution.countRecursive(coins, coins.length, 10));
	}

	@Test
	public void testCoinChangeSolutionOptimal() {

		int coins[] = { 1, 2, 3 };
		assertEquals(4, CoinChangeSolution.countOptimal(coins, 4));

		coins = new int[] { 1, 2, 3 };
		assertEquals(5, CoinChangeSolution.countOptimal(coins, 5));

		coins = new int[] { 2, 5, 3, 6 };
		assertEquals(5, CoinChangeSolution.countOptimal(coins, 10));
	}

	@Test
	public void testCoinChangeSolutionRecursiveSpeed() {

		int coins[] = { 2, 5, 3, 6, 10, 7, 8, 12, 17, 19, 20 };
		assertEquals(227491942,
		    CoinChangeSolution.countRecursive(coins, coins.length, 250));
	}

	@Test
	public void testCoinChangeSolutionOptimalSpeed() {

		int coins[] = { 2, 5, 3, 6, 10, 7, 8, 12, 17, 19, 20 };
		assertEquals(227491942, CoinChangeSolution.countOptimal(coins, 250));
	}

}
