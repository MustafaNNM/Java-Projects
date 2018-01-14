import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Scrollbar;
import java.awt.Image;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.Label;
 //appleta d�zenleyici dinleyicisi ekleniyor(kayd�rma �ubuklar� clas�na ekleniyor)
public class KaydirmaCubuklari extends Applet implements AdjustmentListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Scrollbar YatayKaydir=new Scrollbar(); //yatay kayd�rma nesnesi ekleniyor
    Label BoyutYaz=new Label(); //Metin alan� ekleme
    
    int YeniEn, YeniBoy, ResimEn, ResimBoy;

    public void init() { // applet �al��t���nda clas�n �al��acak ilk fonksiyonu

        setLayout(null); //elemanlar�n yerle�im d�zenini biz belirleyece�iz


        //kayd�rma �ubu�unun yatay o�ldu�unu belirliyor
        YatayKaydir.setOrientation(Scrollbar.HORIZONTAL);
        YatayKaydir.setLocation(10, 10);
        YatayKaydir.setSize(250, 20);
        add(YatayKaydir);

        //kayd�rma �ubu�unun dinleyicisi aktif ediliyor
        YatayKaydir.addAdjustmentListener(this);

        YatayKaydir.setValue(YatayKaydir.getMaximum()); //kayd�rma �ubu�unun ba�lang�� de�eri

        BoyutYaz.setLocation(280, 10);
        BoyutYaz.setSize(20, 20);
        add(BoyutYaz);

    }

    public void adjustmentValueChanged(AdjustmentEvent Tetikleyici){

  //Boyut yaz etiketinin i�erisine bu fonksiyonunu �a��ran nesnenin de�erini al�yoruz
        BoyutYaz.setText(Integer.toString(Tetikleyici.getValue()));
        
  //resmin maximum eni * kayd�rma �ubu�unun gelen de�eri / kayd�rma �ubu�unu maxsimum de�eri
        YeniEn=(ResimEn*Tetikleyici.getValue())/YatayKaydir.getMaximum();

  //resmin maximum boyu * kayd�rma �ubu�unun gelen de�eri / kayd�rma �ubu�unu maxsimum de�eri
         YeniBoy=(ResimBoy*Tetikleyici.getValue())/YatayKaydir.getMaximum();
        repaint(); //tetikleyiciden sonra paint fonksiyonunun yeniden �al��t�r�l�p resmin yeniden �izilmesi sa�lan�yor
    }
    public void paint(Graphics Ekran){

        //resim nesnesi olu�turuluyor belli bir adresten al�n�yor
        Image Resim=getImage(getDocumentBase(), "chandler.jpg");

        //resmin eni ve boyu al�n�yor
        ResimEn=Resim.getWidth(this);
        ResimBoy=Resim.getHeight(this);

        //resmin yeni eni yoksa veya s�f�rdan k���kse orjinal boyutunu al
        YeniEn=(YeniEn<=0)?ResimEn:YeniEn;
        YeniBoy=(YeniBoy<=0)?ResimBoy:YeniBoy;


        //resmi �iz
        Ekran.drawImage(Resim, 10, 30, YeniEn, YeniBoy, this);
    }

}