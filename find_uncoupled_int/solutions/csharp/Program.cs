using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UncoupledInteger
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items = { 5, 7, 1, 7, 6, 1, 6, 5, 9 };
            int uncoupled = FindUncoupled(items);
            //int uncoupled = FindUncoupledUsingXor(items);
            Console.WriteLine(String.Format("Uncoupled Integer is : {0}", uncoupled));
            Console.ReadKey();
        }
        static int FindUncoupledUsingXor(int[] items)
        {
            int xord = 0;
            for (int i = 0; i < items.Length; i++)
                xord ^= items[i];

            return xord;
        }
        static int FindUncoupled(int[] items)
        {
            for(var i = 0; i< items.Length; i++) {
                //flag that tells us if we found the same item in the array
                bool found = false;
                //start i + 1 and search the rest of the items in the array, probably could replace with an efficient array search
                for (int j = i+1; j < items.Length; j++){
                    if (items[i] == items[j])
                    {
                        //swap the item found with item right after the current item
                        Swap(items, i+1, j);
                        //increment the i as we know that we have a pair
                        i++;
                        //set flag to true to tell the outer loop that we did find a match
                        found = true;
                    }
                }
                //have we found a match, if not assume that is the only uncoupled integer in array and since assumption is there can only be one
                // we dont need to search anything just return the current item
                if(!found)
                    return items[i];
            }
            //if we go here then the last item is the uncoupled integer
            return items.Last();
        }
        static void Swap(int[] data, int i, int j)
        {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
}
