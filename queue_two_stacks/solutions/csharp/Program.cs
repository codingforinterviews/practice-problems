using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QueueWithTwoStacks
{
    class Program
    {
        static void Main(string[] args)
        {
            QueueWithStack<int> s = new QueueWithStack<int>();

            Console.WriteLine("Enqueue 1");
            s.Enqueue(1);
            Console.WriteLine("Enqueue 3");
            s.Enqueue(3);
            Console.WriteLine("Enqueue 8");
            s.Enqueue(8);
            Console.WriteLine(String.Format("Dequeue : {0}", s.DeQueue()));
            Console.WriteLine(String.Format("Dequeue : {0}", s.DeQueue()));
            Console.WriteLine("Enqueue 4");
            s.Enqueue(4);
            Console.WriteLine(String.Format("Dequeue : {0}", s.DeQueue()));
            Console.WriteLine(String.Format("Dequeue : {0}", s.DeQueue()));
            Console.ReadKey();
        }
    }
}
