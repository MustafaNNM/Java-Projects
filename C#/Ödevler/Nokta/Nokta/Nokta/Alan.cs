using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Nokta
{
    public class Alan
    {
        int X;
        int Y;
        int Genislik;
        int Yukseklik;
        public Alan(int X,int Y,int Genislik,int Yukseklik)
        {
            PropX = X;
            PropY = Y;
            PropGenislik = Genislik;
            PropYukseklik = Yukseklik;
        }
        public int PropX { get { return X; } set { X = value; } }
        public int PropY { get { return Y; } set { Y = value; } }
        public int PropGenislik { get { return Genislik; } set { Genislik = value; } }
        public int PropYukseklik { get { return Yukseklik; } set { Yukseklik = value; } }
    }
}
