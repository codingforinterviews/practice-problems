using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QueueWithTwoStacks
{
    public class QueueWithStack<T> 
    {
        private Stack<T> _data = new Stack<T>();
        private Stack<T> _dataTemp = new Stack<T>();

        public int Length { get { return _data.Count(); } }
       
        public void Enqueue(T item)
        {
            _data.Push(item);
        }

        public T DeQueue()
        {
            //pop all items from _data and push it to _dataTemp
            while (_data.Count() != 0)
                _dataTemp.Push(_data.Pop());

            //Since queue is first in first out, pop from _dataTemp should return us the first item that was originally enqueued.
            T ret = _dataTemp.Pop();

            //pop rest of the items from _dataTemp and push it into _data
            while(_dataTemp.Count() != 0)
                _data.Push(_dataTemp.Pop());

            return ret;
        }
    }
}
