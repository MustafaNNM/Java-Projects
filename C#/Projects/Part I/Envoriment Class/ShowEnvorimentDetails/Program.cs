using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ShowEnvorimentDetails
{
    class Program
    {
        static int Main(string[] args)
        {
            // Get arguments using System.Envoriment.
            string[] theArgs = Environment.GetCommandLineArgs();

            foreach(string arg in theArgs)
            {
                Console.WriteLine("Arg: {0}",arg);
            }

            // Helper method within the Program class.
            ShowEnvorimentDetails();

            Console.ReadLine();
            return -1;
        }

        private static void ShowEnvorimentDetails()
        {
            // Print out the drives on this machine,
            // and other interesting details.
            foreach(string drive in Environment.GetLogicalDrives())
            {
                Console.WriteLine("Drive: {0}",drive);
            }

            Console.WriteLine("OS: {0}",Environment.OSVersion);
            Console.WriteLine("Number of processors: {0}",Environment.ProcessorCount);
            Console.WriteLine(".NET Version :{0}",Environment.Version);
        }
    }
}
