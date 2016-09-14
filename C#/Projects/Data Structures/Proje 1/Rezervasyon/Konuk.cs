using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Rezervasyon
{
    public class Konuk
    {
        public string ad
        {
            get
            {
                return ad;
            }
            set
            {
                ad = value;
            }
        }

        public string soyad
        {
            get
            {
                return soyad;
            }
            set
            {
                soyad = value;
            }
        }

        public string anadil
        {
            get
            {
                return anadil;
            }
            set
            {
                anadil = value;
            }
        }
    }

    public enum Languages
    {
        TR,
        ENG,
        GER,
        FRE,
        JAP,
        CHN,
        RUS
    }
}
