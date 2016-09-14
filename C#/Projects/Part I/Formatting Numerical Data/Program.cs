using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

// Now make use of some format tags.
namespace Formatting_Numerical_Data
{
    class Program
    {
        static int Main(string[] args)
        {
            Console.WriteLine("The value 99999 in various formats:");
            Console.WriteLine("c format: {0:c}", 99999);//c format: 99.999,00 YTL
            Console.WriteLine("d9 format: {0:d9}", 99999);//d9 format: 000099999
            Console.WriteLine("f3 format: {0:f3}", 99999);//f3 format: 99999,000
            Console.WriteLine("n format: {0:n}", 99999);//n format: 99.999,00
            // Notice that upper- or lowercasing for hex
            // determines if letters are upper- or lowercase.
            Console.WriteLine("E format: {0:E}", 99999);//E format: 9,999900E+004
            Console.WriteLine("e format: {0:e}", 99999);//e format: 9,999900E+004
            Console.WriteLine("X format: {0:X}", 99999);//X format: 1869F
            Console.WriteLine("x format: {0:x}", 99999);//x format: 1869F

            Console.ReadLine();

            //  Outputs:
            /*  The value 99999 in various formats:
                c format: 99.999,00 YTL
                d9 format: 000099999
                f3 format: 99999,000
                n format: 99.999,00
                E format: 9,999900E+004
                e format: 9,999900e+004
                X format: 1869F
                x format: 1869f
            */
            return 0;
        }
    }
}
