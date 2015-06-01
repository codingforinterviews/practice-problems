using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SortingAlgorithms
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] items =  {5,9,1,4,2,3,6,8,7};

            //perform sort
            BubbleSort(items);
            //InsertionSort(items);
            //SelectionSort(items);
            for (var i = 0; i < items.Length; i++)
                Console.WriteLine(items[i]);

            Console.ReadKey();
        }

        #region sorting algorithms
        static void BubbleSort(int[] items)
        {
            for(var i = 0; i< items.Length; i++) {
                for (int j = 0; j < items.Length - 1; j++) {
                    if (items[j] > items[j+1])
                        Swap(items, j, j+1);
                }
            }
        }

        static void InsertionSort(int[] items)
        {
            for (var i = 0; i < items.Length - 1; i++) {
                int j = i + 1;

                //walk back to left and find the appropriate insertion point
                while ( (j > 0) && (items[j-1] > items[j])) {
                    Swap(items, j - 1, j);
                    j--;
                }
            }
        }

        static void SelectionSort(int[] items) {

            for (int i = 0; i < items.Length - 1; i++) {
                int minPos = GetMinPos(items, i+1);
                if (i != minPos)
                    Swap(items, i, minPos);
            }
        }

        static void QuickSort(int[] items) {

        }
        #endregion


        static int GetMinPos(int[] data, int start) {
            int minPos = start;

            for (int pos = start + 1; pos < data.Length; pos++) {
                if (data[pos] < data[minPos])
                    minPos = pos;
            }
            return minPos;
        }

        static void Swap(int[] data, int i, int j)  {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
}
