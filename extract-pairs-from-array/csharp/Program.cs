using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArraySearch
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] d = { 1, 2, 3, 4, 5, 6, 7, 8 };

            ExtractPairsFromArray(d, 6);

            Console.ReadLine();
        }

        static void ExtractPairsFromArray(int[] array, int sum) {
            List<int> d = new List<int>();

            for (int i = 0; i < array.Length; i++) {
                var result = (sum - array[i]);
                if(d.Contains(result))
                    Console.WriteLine(String.Format("Found a pair {0}:{1}", array[i], result));
                else
                    d.Add(array[i]);
            }
        }
    }
}
