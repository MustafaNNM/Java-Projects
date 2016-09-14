using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace tıklama_ile_doğru_çizdirme
{
    public partial class Form1 : Form
    {
        public Point ilk, ikinci;
        public Form1()
        {
            InitializeComponent();
            Console.WriteLine("girdi");
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            g.DrawLine(new Pen(Color.Azure), ilk, ikinci);
            g.Flush();
        }

        private void Form1_MouseDown_1(object sender, MouseEventArgs e)
        {
            ilk = e.Location;
        }

        private void Form1_MouseUp_1(object sender, MouseEventArgs e)
        {
            ikinci = e.Location;
            MessageBox.Show(ikinci.ToString());
            Invalidate();
        }

    }
}