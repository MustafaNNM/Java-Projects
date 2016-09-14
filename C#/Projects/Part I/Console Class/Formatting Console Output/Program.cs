using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Formatting_Console_Output
{
    class Program
    {
        static void Main(string[] args)
        {
            // Jhon says...
            Console.WriteLine("{0}, Number {0}, Number {0}",9);

            // Prints:20, 10, 30
            Console.WriteLine("{1}, {0}, {2}", 10, 20, 30);

            Console.ReadLine();
        }
    }
}
