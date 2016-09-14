using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Basic_Input_and_Output
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("***** Basic Console I/O *****");
            GetUserData();
            Console.ReadLine();
        }

        private static void GetUserData()
        {
            //Get name and age.
            Console.WriteLine("Please enter your name: ");
            string userName = Console.ReadLine();
            Console.WriteLine("Please enter your age: ");
            string userAge = Console.ReadLine();

            // Change echo color, just for fun.
            ConsoleColor prevColor = Console.ForegroundColor;
            Console.ForegroundColor = ConsoleColor.Yellow;

            // Echo to the consol.
            Console.WriteLine("Hello {0}! You are {1} years old.",userName,userAge);

            // Restore previous color.
            Console.ForegroundColor = prevColor;
        }
    }
}
