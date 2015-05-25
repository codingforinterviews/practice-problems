using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class TargetSum
{
    static void Main(string[] args)
    {
        // Testing it out
        int[] numbers = new int[]{-2, -1, 0, 1, 5, 20, 30};
        int total = 25;
        Console.WriteLine(IsTargetSum(numbers, total));
    }

    private static bool IsTargetSum(int[] numbers, int total)
    {
        var targetSum = 0;
        var index = 0;
        numbers = numbers.OrderByDescending(n => n).ToArray();

        while (targetSum != 2)
        {
            if (numbers[index] < total || (numbers[index] == total && targetSum == 1))
            {
                total = total - numbers[index];
                targetSum++;
            }
            index++;
        }
        
        return targetSum == 2;
    }
}
