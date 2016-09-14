using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Formatting_Numerical_Data_Beyond_Console_Applications
{
    class Program
    {
        static void Main(string[] args)
        {
            // Using string.Format() to format a string literal.
            string userMessage = string.Format("100000 in hex is {0:x}", 100000);/*100000 in hex is 186a0*/

            Console.WriteLine(userMessage);
            Console.ReadLine();
        }
    }
}
