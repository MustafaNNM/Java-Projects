using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Maliyet_Hesaplama
{
    class Ham_madde_Factory
    {
        public Ham_madde makeHam_madde(){
            return new Ham_madde();
        }
        public Ham_madde makeHam_madde(string ad, double birim_maliyet, string olcum_birimi)
        {
            return new Ham_madde(ad,birim_maliyet,olcum_birimi);
        }
    }
}
