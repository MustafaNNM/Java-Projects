using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Maliyet_Hesaplama
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            string a = textBox1.Text;
            Ham_madde.birim_maliyet =Convert.ToDouble(a);
            Maliyet_Hesapla();
        }
        private void Maliyet_Hesapla()
        {
            MessageBox.Show("tamam");
            //update() yaparak git
        }

        private void button1_Click(object sender, EventArgs e)
        {

            textBox1.Text = ""+ ++Ham_madde.birim_maliyet;//benim eventim
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
       
    }
}
