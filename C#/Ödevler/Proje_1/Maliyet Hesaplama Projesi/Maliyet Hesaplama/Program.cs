using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace Maliyet_Hesaplama
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Ham_madde_Factory ham_madde_factory=new Ham_madde_Factory();
            Ham_madde envanter = ham_madde_factory.makeHam_madde("bakır",1,"kg");
            MessageBox.Show(envanter.ToString());
            
            
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
             
        }
    }
}
