using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsApplication1
{
    public class Etkinlik
    {
        public Etkinlik(String nextToken, String nextToken2, String nextToken3,
            String nextToken4, String nextToken5, String nextToken6,
            String nextToken7, String nextToken8)
        {
            // TODO Auto-generated constructor stub
        }
    
        public String Isim
        {
            get
            {
                return Isim;
            }
            set
            {
                Isim = value;
            }
        }

        public String Yer
        {
            get
            {
                return Yer;
            }
            set
            {
                Yer = value;
            }
        }

        public String Tarih
        {
            get
            {
                return Tarih;
            }
            set
            {
                Tarih = value;
            }
        }

        public double Fiyat
        {
            get
            {
                return Fiyat;
            }
            set
            {
                Fiyat = value;
            }
        }

        public String toString()
        {
            return "Isim:" + Isim + "Yer:" + Yer + "Tarih" + Tarih + "Fiyat:" + Fiyat;
        }
    }
}
