import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Scrollbar;
import java.awt.Image;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.Label;
 //appleta düzenleyici dinleyicisi ekleniyor(kaydýrma çubuklarý clasýna ekleniyor)
public class KaydirmaCubuklari extends Applet implements AdjustmentListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Scrollbar YatayKaydir=new Scrollbar(); //yatay kaydýrma nesnesi ekleniyor
    Label BoyutYaz=new Label(); //Metin alaný ekleme
    
    int YeniEn, YeniBoy, ResimEn, ResimBoy;

    public void init() { // applet çalýþtýðýnda clasýn çalýþacak ilk fonksiyonu

        setLayout(null); //elemanlarýn yerleþim düzenini biz belirleyeceðiz


        //kaydýrma çubuðunun yatay oýlduðunu belirliyor
        YatayKaydir.setOrientation(Scrollbar.HORIZONTAL);
        YatayKaydir.setLocation(10, 10);
        YatayKaydir.setSize(250, 20);
        add(YatayKaydir);

        //kaydýrma çubuðunun dinleyicisi aktif ediliyor
        YatayKaydir.addAdjustmentListener(this);

        YatayKaydir.setValue(YatayKaydir.getMaximum()); //kaydýrma çubuðunun baþlangýç deðeri

        BoyutYaz.setLocation(280, 10);
        BoyutYaz.setSize(20, 20);
        add(BoyutYaz);

    }

    public void adjustmentValueChanged(AdjustmentEvent Tetikleyici){

  //Boyut yaz etiketinin içerisine bu fonksiyonunu çaðýran nesnenin deðerini alýyoruz
        BoyutYaz.setText(Integer.toString(Tetikleyici.getValue()));
        
  //resmin maximum eni * kaydýrma çubuðunun gelen deðeri / kaydýrma çubuðunu maxsimum deðeri
        YeniEn=(ResimEn*Tetikleyici.getValue())/YatayKaydir.getMaximum();

  //resmin maximum boyu * kaydýrma çubuðunun gelen deðeri / kaydýrma çubuðunu maxsimum deðeri
         YeniBoy=(ResimBoy*Tetikleyici.getValue())/YatayKaydir.getMaximum();
        repaint(); //tetikleyiciden sonra paint fonksiyonunun yeniden çalýþtýrýlýp resmin yeniden çizilmesi saðlanýyor
    }
    public void paint(Graphics Ekran){

        //resim nesnesi oluþturuluyor belli bir adresten alýnýyor
        Image Resim=getImage(getDocumentBase(), "chandler.jpg");

        //resmin eni ve boyu alýnýyor
        ResimEn=Resim.getWidth(this);
        ResimBoy=Resim.getHeight(this);

        //resmin yeni eni yoksa veya sýfýrdan küçükse orjinal boyutunu al
        YeniEn=(YeniEn<=0)?ResimEn:YeniEn;
        YeniBoy=(YeniBoy<=0)?ResimBoy:YeniBoy;


        //resmi çiz
        Ekran.drawImage(Resim, 10, 30, YeniEn, YeniBoy, this);
    }

}