using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Processing_Command_Line_Arguments2
{
    class Program
    {
        static int Main(string[] args)
        {
            //Process any incoming args using foreach.
            foreach (string arg in args)
            {
                Console.WriteLine("Arg: {0}",arg);
            }

            Console.ReadLine();
            return -1;
        }
    }
}
