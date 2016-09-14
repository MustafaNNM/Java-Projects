using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Maliyet_Hesaplama
{
    class Birimler
    {
        public Default enum_default;
        public Uzunluk enum_uzunluk;
        public Alan enum_alan;
        public Hacim enum_hacim;
        public Zaman enum_zaman;
        public Elektrik enum_elektrik;
        public Litre enum_litre;
        public Kutle enum_kutle;
        public Kategori_No enum_kategori_no_atayicisi;//Kategorinin numarası

        public enum Kategori_No
        {
            enum_default_no = 0,
            enum_uzunluk_no = 1,
            enum_alan_no = 2,
            enum_hacim_no = 3,
            enum_zaman_no = 4,
            enum_elektrik_no = 5,
            enum_litre_no = 6,
            enum_kutle_no = 7
        }

        public enum Default
        {
            adet
        }

        public enum Uzunluk
        {
            km,hm,dam,m,dm,cm,mm
        }

        public enum Alan
        {
            km2,hm2,dam2,m2,dm2,cm2,mm2
        }

        public enum Hacim
        {
            km3,hm3,dam3,m3,dm3,cm3,mm2
        }

        public enum Zaman
        {
            yy,mo,dd,hh,mm,s
        }

        public enum Elektrik
        {
            kw,hw,daw,w,dw,cw,mw
        }
        public enum Litre
        {
            kl,hl,dal,l,dl,cl,ml
        }
        public enum Kutle
        {
            kg,hg,dag,g,dg,cg,mg
        }
    }
}
