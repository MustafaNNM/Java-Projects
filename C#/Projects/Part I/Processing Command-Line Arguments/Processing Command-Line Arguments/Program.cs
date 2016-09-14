using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Processing_Command_Line_Arguments
{
    class Program
    {
        static int Main(string[] args)
        {
            //Process any incoming args.
            for (int i = 0; i < args.Length; i++)
            {
                Console.WriteLine("Arg:{0}",args[i]);
            }

            Console.ReadLine();
            return -1;
        }
    }
}
