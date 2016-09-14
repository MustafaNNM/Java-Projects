using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    public delegate void KasaDegisikligi(string mesaj);

    public delegate decimal VergiHesapla(decimal miktar);

    public class Kasa
    {

        private KasaDegisikligi kasaDegisikligiMethodListesi;

        public void kaydetMethod(KasaDegisikligi k)
        {
            kasaDegisikligiMethodListesi += k;
        }

        private VergiHesapla vergiHesapMethodu;

        public void kaydetVergiHesaplaMethodu(VergiHesapla v)
        {
            vergiHesapMethodu = v;                
        }



        decimal kasaToplami = 0;

        public void kasayaGirisYap(decimal miktar)
        {

            if (vergiHesapMethodu != null)
            {
                miktar += vergiHesapMethodu(miktar);
            }

            kasaToplami += miktar;

            if (kasaDegisikligiMethodListesi != null)
            {
                kasaDegisikligiMethodListesi("Kasaya Giriş Yapıldı:" + miktar + " Toplam tutar:" + kasaToplami);
                //kasaDegisikligiMethodListesi.Invoke("Kasaya Giriş Yapıldı:" + miktar + " Toplam tutar:" + kasaToplami);
            }
                
        }
    }
}
