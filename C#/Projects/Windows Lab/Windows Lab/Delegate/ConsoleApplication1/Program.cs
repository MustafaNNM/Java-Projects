using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("***** Delegates as event enablers *****\n");
            ////// First, make a Car object.
            ////Car c1 = new Car("SlugBug", 100, 10);
            ////// Now, tell the car which method to call
            ////// when it wants to send us messages.
            ////c1.RegisterWithCarEngine(new CarEngineHandler(OnCarEngineEvent));
            ////// Speed up (this will trigger the events).
            ////Console.WriteLine("***** Speeding up *****");
            ////for (int i = 0; i < 6; i++)
            ////    c1.Accelerate(20);


            Kasa k = new Kasa();

            k.kaydetMethod(new KasaDegisikligi(kasaDurumuDegisikligi));
            //k.kaydetMethod(new KasaDegisikligi(kasaDurumuDegisikligi2));

            k.kaydetVergiHesaplaMethodu(new VergiHesapla(vergiHesapla));

            k.kasayaGirisYap(100);

            k.kasayaGirisYap(150);

            Console.ReadLine();

        }

        public static decimal vergiHesapla(decimal miktar)
        {
            decimal kdv = new decimal(0.25);

            return miktar * kdv;                
        }

        public static void kasaDurumuDegisikligi(string mesaj)
        {
            Console.WriteLine("\n***** Message From Kasa Object *****");
            Console.WriteLine("=> {0}", mesaj);
            Console.WriteLine("***********************************\n");
        }


        public static void kasaDurumuDegisikligi2(string mesaj)
        {
            Console.WriteLine("\n***** Muhasebeye Haber Verildi *****");
            Console.WriteLine("=> {0}", mesaj);
            Console.WriteLine("***********************************\n");
        }

        public static void OnCarEngineEvent(string msg)
        {
            Console.WriteLine("\n***** Message From Car Object *****");
            Console.WriteLine("=> {0}", msg);
            Console.WriteLine("***********************************\n");
        }
    }
}
