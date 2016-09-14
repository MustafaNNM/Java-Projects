using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Nokta
{
    //Noktanın kare şeklinde tutulmasını sağlayan yapı
    public class Alan
    {
        //Noktanın koordinatı
        int X;
        int Y;
        //Noktayı kare şeklinde temsiletmek için genişlik ve yükseklik
        int Genislik=5;
        int Yukseklik=5;
        //Constructer
        public Alan(int X,int Y,int Genislik,int Yukseklik)
        {
            PropX = X;
            PropY = Y;
            PropGenislik = Genislik;
            PropYukseklik = Yukseklik;
        }
        //Setter & Getter methots
        public int PropX { get { return X; } set { X = value; } }
        public int PropY { get { return Y; } set { Y = value; } }
        public int PropGenislik { get { return Genislik; } set { Genislik = value; } }
        public int PropYukseklik { get { return Yukseklik; } set { Yukseklik = value; } }
    }
}
