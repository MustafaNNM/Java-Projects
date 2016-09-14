using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsApplication1
{
    public class Etkinlik_Listesi
    {
        public Etkinlik_Listesi()
        {
        }

        public Etkinlik Etkinlik
        {
            get
            {
                return Etkinlik;
            }
            set
            {
                Etkinlik = value;
            }
        }

        public String toString()
        {
            return ""+Etkinlik;
        }
    }
}
