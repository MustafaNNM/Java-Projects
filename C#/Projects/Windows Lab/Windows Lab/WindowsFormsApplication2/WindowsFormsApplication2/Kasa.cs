using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WindowsFormsApplication2
{
    //fonksiyonlar calistirir
    //gereken parametreleri kendisi gonderir.
    public delegate void mesajGonder(string mesaj);//calistirilacak fonksiyonlara argumanlarini gonderir
    

    class Kasa
    {

        public event mesajGonder MesajYolla;//parametreyi alip delegateye gonderir

        public void islemYap()
        {
            if (MesajYolla != null)
            {
                MesajYolla("İşlem Yapıldı");//"İşlem Yapıldı" argumani gönderiliyor
                //delegate calistirmasi gereken fonksiyonlari çalıştirip argumanlarını veriyor
            }
        }


    }
}
