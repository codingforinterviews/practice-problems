import java.util.*;
import java.lang.*;
import java.io.*;

class TargetSumPair
{
	public static boolean checkForSumPair(int[] iArr, int iSum)
	{
		if(iArr.length >= 2)
		{
			Set<Integer> set = new HashSet<Integer>();
			
			set.add(iArr[0]);
			for(int i = 1; i < iArr.length; i++)
			{
				if(set.contains(iSum - iArr[i]))
					return true;
				
				set.add(iArr[i]);
			}
		}
		return false;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] iArrTest1 = {5, 3, 4, 2, 8, -1, 15};
		int[] iArrTest2 = {3, 4, 5};

		System.out.println("Test1-> " + checkForSumPair(iArrTest1, 13));
		System.out.println("Test2-> " + checkForSumPair(iArrTest2, 13));
	}
}