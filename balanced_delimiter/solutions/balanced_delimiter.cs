using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class balanced_delimiter
{
    static readonly Dictionary<char, char> delimiterLookup = new Dictionary<char, char>()
     {
         { '(', ')'},
         { '[', ']'},
         { '{', '}'}
     };

    static void Main(string[] args)
    {
        const string delimiters = "([])";
        Console.WriteLine(IsBalanced(delimiters));
    }

    public static bool IsBalanced(string delimiters)
    {
        var delimiterCharArray = delimiters.ToCharArray();
        var delimiterStack = new Stack<string>();

        foreach (var delimiter in delimiterCharArray)
        {
            if (IsOpener(delimiter))
            {
                delimiterStack.Push(delimiter.ToString());
            }
            else if (!IsOpener(delimiter))
            {
                if (!IsMatchingCloser(delimiter, delimiterStack.Pop())) return false;
            }
            else
            {
                throw new InvalidDataException("Wrong input!");
            }
        }

        return !delimiterStack.Any();
    }

    private static bool IsMatchingCloser(char possibleMathcingCloser, string opener)
    {
        return delimiterLookup.FirstOrDefault(d => d.Key == Convert.ToChar(opener)).Value == possibleMathcingCloser;
    }

    private static bool IsOpener(char delimiter)
    {
        return delimiterLookup.ContainsKey(delimiter);
    }
}

