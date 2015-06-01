using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PerfectNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            var numbers = GetPerfectNumbers(100000);

            foreach (int number in numbers)
                Console.Write(number + ",");

            Console.ReadLine();
        }
        static List<Int32> GetPerfectNumbers(int n)
        {
            List<Int32> perfectNumbers = new List<Int32>();

            for (int i = 1; i <= n; i++)
            {
                int j = 1;
                int sum = 0;

                while (j < i)
                {
                    if (i % j == 0)
                        sum = sum + j;
                    j++;
                }
                if (sum == i)
                    perfectNumbers.Add(i);
            }
            return perfectNumbers;
        }

    }
}
