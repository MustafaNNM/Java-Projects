using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Maliyet_Hesaplama
{
    class Ham_madde_list
    {
        //Degisgenler
        private List<Ham_madde> ham_maddeler = new List<Ham_madde>();

        //Constructorlar
        public Ham_madde_list() { 
        
        }

        //Set ve get metodlari
        public List<Ham_madde> Ham_maddeler { get { return ham_maddeler; } set { ham_maddeler = value; } }

        public string override_To_String()
        {
            StringBuilder s=new StringBuilder();

            s.Append("");

            foreach(Ham_madde h_m in Ham_maddeler){
                s.Append(h_m.override_ToString());
            }

            return s.ToString();
        }
    }
}
