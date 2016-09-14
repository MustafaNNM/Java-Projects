using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Collections;

namespace Nokta
{
    public partial class Form1 : Form
    {
        int mod = 0;
        Boolean var_mı;//Nokta listede varmı
        int bulunan_noktanın_indexi = 0;
        private bool nokta_bırakılsın_mı = false;
        public List<Alan> noktalar = new List<Alan>();
        public int PropMod { get { return mod; } set { mod = value; } }

        public Form1()
        {
            InitializeComponent();
        }
        private void nokta_ekle(MouseEventArgs e)
        {
            var_mı = false;
            var_mı = noktayı_kontrol_et(e.Location);
            if (!var_mı)
            {
                Graphics g = this.CreateGraphics();
                Alan alan = new Alan(e.Location.X - 5, e.Location.Y - 5, 5, 5);
                Rectangle rect = new Rectangle(alan.PropX, alan.PropY, alan.PropGenislik, alan.PropYukseklik);
                noktalar.Add(alan);
                g.DrawRectangle(Pens.Red, rect);
                g.FillRectangle(new SolidBrush(Color.BlueViolet), rect);
            }
        }
        private void nokta_sil(MouseEventArgs e)
        {
            var_mı = false;
            var_mı = noktayı_kontrol_et(e.Location);
            if (var_mı)
            {
                Graphics g = this.CreateGraphics();
                g.Clear(BackColor);

                //mouse ile tıklanan nokta alan içerisindeyse siliniyor
                noktalar.RemoveAt(bulunan_noktanın_indexi);

                foreach (Alan alan in noktalar)
                {
                    Rectangle rect = new Rectangle(alan.PropX, alan.PropY, alan.PropGenislik, alan.PropYukseklik);
                    g.DrawRectangle(Pens.Red, rect);
                    g.FillRectangle(new SolidBrush(Color.BlueViolet), rect);
                }
            }
        }
        private void nokta_yer_degistir(MouseEventArgs me)
        {
            /*mouse ile tiklanan yerde nokta var ise silinecektir*/
            switch (var_mı)
            {
                case false:/*mouse ile tıklanan yerde nokta bulunamadıgı icin yer degistirme islemi yapilamamaktadir*/  break;
                case true:
                    Graphics g = this.CreateGraphics();
                    g.Clear(BackColor);

                    //mouse ile tıklanan nokta alan içerisindeyse yerideğiştiriliyor
                    Alan a = noktalar.ElementAt(bulunan_noktanın_indexi);
                    //Noktanın sadece lokasyonu değiştiriliyor
                    a.PropX = me.Location.X - 5;
                    a.PropY = me.Location.Y - 5;

                    foreach (Alan alan in noktalar)
                    {
                        Rectangle rect = new Rectangle(alan.PropX, alan.PropY, alan.PropGenislik, alan.PropYukseklik);
                        g.DrawRectangle(Pens.Red, rect);
                        g.FillRectangle(new SolidBrush(Color.BlueViolet), rect);

                    }
                    break;
            }
        }
        private Boolean noktayı_kontrol_et(Point location)
        {
            //Bulunup bulunmadığına dair değer döndürüyor
            //Nokta bulunduğu takdirde indexi tutuluyor
            foreach (Alan n in noktalar)
            {
                if ((location.X <= n.PropX + n.PropGenislik && location.X >= n.PropX) && (location.Y <= n.PropY + n.PropYukseklik && location.Y >= n.PropY))
                {
                    //index kaydediliyor
                    bulunan_noktanın_indexi = noktalar.IndexOf(n);
                    //Nokta bulunursa bir döndürülüyor
                    return true;
                }
            }
            return false;//Nokta bulunmazsa sıfır döndürüyor
        }
        private void Form1_MouseDown(object sender, MouseEventArgs e)
        {
            nokta_bırakılsın_mı = false;
            switch (PropMod)
            {
                case 0: nokta_ekle(e); break;
                case 1: nokta_sil(e); break;
                case 2: var_mı = false;
                    var_mı = noktayı_kontrol_et(e.Location);
                    break;
            }
        }
        private void Form1_MouseUp(object sender, MouseEventArgs me)
        {
            //Yer değiştirme modu etkinse noktanın yeri değiştirilir
            if (PropMod == 2)
            {
                nokta_yer_degistir(me);
            }
            nokta_bırakılsın_mı = true;
        }
        private void Form1_MouseMove(object sender, MouseEventArgs me)
        {
            //noktanın yerinin değiştiğinin gözlemlenmesi için kullanılmaktadır
            //noktanın bırakılmaması gerekiyorsa noktanın yeri değiştirilir
            if (!nokta_bırakılsın_mı)
            {
                //Yer değiştirme modu etkinse mouse ile beraber noktanın yeri değiştirilir
                if (PropMod == 2)
                {
                    nokta_yer_degistir(me);
                }
            }
        }
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            //Mod seçimi yapılmaktadır
            PropMod = comboBox1.SelectedIndex;
            /*
             * Default mod=0
             * 0 Nokta eklenmesi
             * 1 Nokta silinmesi
             * 2 Yer değiştirme
             */
        }
    }
}
