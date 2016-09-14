using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Maliyet_Hesaplama
{
    class Ham_madde
    {
        //Degiskenler
        public delegate void Maliyet_degisti(string urun_adi, double maliyet);
        public event Maliyet_degisti Maliyet_olay;
        public static double birim_maliyet = 0;
        private Birimler.Kategori_No kategori_no = Birimler.Kategori_No.enum_default_no;
        private Enum olcum_birimi = Birimler.Default.adet;
        private string ad = "";

        //Constructors
        public Ham_madde(string ad, double birim_maliyet, Birimler.Kategori_No kategori_no, Enum olcum_birimi)
        {
            Ad = ad;
            Birim_Maliyet = birim_maliyet;
            Kategori_no = kategori_no;
            Olcum_Birimi = olcum_birimi;
        }

        public Ham_madde()
        {

        }

        //Set get metotlari
        public double Birim_Maliyet { get { return birim_maliyet; } set { birim_maliyet = value; Maliyet_olay.Invoke(Ad, Birim_Maliyet); } }
        public Birimler.Kategori_No Kategori_no { get { return kategori_no; } set { kategori_no = value; } }
        public Enum Olcum_Birimi { get { return olcum_birimi; } set { olcum_birimi = value; } }
        public string Ad { get { return ad; } set { ad = value; } }

        public string override_ToString()
        {
            return "Ad :" + ad + "Birim maliyet: " + birim_maliyet + "Olcum Birimi: " + olcum_birimi;
        }

    }
}
