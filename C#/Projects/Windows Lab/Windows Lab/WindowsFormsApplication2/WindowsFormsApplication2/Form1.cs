using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            k.MesajYolla += new mesajGonder(k_MesajYolla);//delegate'ye k_MesajYolla(string mesaj) metodu eklendi delegate'de event'a eklendi. 

            
        }

        Kasa k = new Kasa();
        
        void k_MesajYolla(string mesaj)
        {
            MessageBox.Show(mesaj);
        }


        private void button1_Click(object sender, EventArgs e)
        {
            k.islemYap();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            k.islemYap();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //timer1.Start();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
