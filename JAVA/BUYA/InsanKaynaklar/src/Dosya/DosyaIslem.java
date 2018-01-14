package Dosya;
import KisiBilgi.*;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

import sirket.isyerBilgi;

public class DosyaIslem {
	


	public void openFile(IsciDugum node,String dosyaAdi){
		try {
			FileWriter fstream = new FileWriter(dosyaAdi);
			BufferedWriter out = new BufferedWriter(fstream);

			
			
			recursiveYaz(node,out);
			out.close();
			fstream.close();
		}
			catch (Exception e)
            {
                    System.err.println ("Error writing to file");
            }

	}

	private void recursiveYaz(IsciDugum node,BufferedWriter out)  {
		if(node!=null){
		try {			
			out.write("K"+node.getAdi()+"\t"+node.getEvAdresi()+"\t"+node.getE_posta()+"\t"+node.getUyrugu()+"\t"+node.getDogumYeri()+"\t"+node.getMedeniDurum()+
					"\t"+node.getYabanciDil()+"\t"+node.getIlgiAlan()+"\t"+node.getTelefon()+"\t"+node.getDogumTarihi()+"\t"+node.getReferanKisiler());
			
			out.newLine();
			
			if(node.getIsDeneyimi()!=null)
			{	
				for(int i=0; i<node.getIsDeneyimi().size(); i++){
					out.write("D"+node.getIsDeneyimi().elementAt(i).getIsyerAdi()+"\t"+node.getIsDeneyimi().elementAt(i).getIsyerAdresi()+"\t"+
					node.getIsDeneyimi().elementAt(i).getIsyerPozisyon()+"\t"+node.getIsDeneyimi().elementAt(i).getIsyerGorevi());
					out.newLine();
				}
			}
			if(node.getEgitimDurumu()!=null)
			{	
				for(int i=0; i<node.getEgitimDurumu().size(); i++){
				out.write("O"+node.getEgitimDurumu().elementAt(i).getOkulAdi()+"\t"+node.getEgitimDurumu().elementAt(i).getBolumu()+"\t"+
						node.getEgitimDurumu().elementAt(i).getBaslangicTarih()+"\t"+node.getEgitimDurumu().elementAt(i).getBitisTarih()+"\t"+node.getEgitimDurumu().elementAt(i).getNotOrtalama());
				out.newLine();
				}
			}
			recursiveYaz(node.getRightChild(),out);
			recursiveYaz(node.getLeftChild(),out);
		} catch (Exception e)
        {
            System.err.println ("Error writing to file");
    }

	}
	}
	public void okuEleman(String dosyaAdi,IsciBinaryTree node) {
	
		try{
		final BufferedReader in = new BufferedReader(new FileReader(dosyaAdi));
		String str;	
		str=in.readLine();
		while(str!=null)
		{
			if(str.charAt(0)=='K')
			{
				//TreeNode yeni=new TreeNode(null, 0);
				str=str.substring(1);
				//System.out.println(str);
				StringTokenizer token=new StringTokenizer(str,"\t");
				StringTokenizer token1 = null,token2 = null;
				Vector<EgitimDurum> egitim=new Vector<EgitimDurum>();
				Vector<IsDeneyimi> deneyim=new Vector<IsDeneyimi>();
				str=in.readLine();
				
				while(str!=null&&(str.charAt(0))!='K')
				{		
					switch (str.charAt(0)) {
						case 'O':
								{str=str.substring(1);
								token1=new StringTokenizer(str,"\t");
								EgitimDurum egit=new EgitimDurum(token1.nextToken(), token1.nextToken(),
																Integer.parseInt(token1.nextToken()), Integer.parseInt(token1.nextToken()),
																Double.parseDouble(token1.nextToken()));
								egitim.add(egit);
									//yeni.setOkul(token1.nextToken());
								}break;
						case 'D':{
								str=str.substring(1);
								token2=new StringTokenizer(str,"\t");
								IsDeneyimi is=new IsDeneyimi(token2.nextToken(), token2.nextToken(), token2.nextToken(), token2.nextToken());
									deneyim.add(is);
						}break;
						}
					str=in.readLine();
					
				}
				IsciDugum newNode=new IsciDugum(token.nextToken(),token.nextToken(),token.nextToken(),token.nextToken(),
												token.nextToken(),token.nextToken(),token.nextToken(),token.nextToken(),
												Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),
												token.nextToken(),deneyim,egitim);
				node.insert(newNode);
			}
			
			
			}
		}catch(final IOException e){
			System.out.println("Dosya Bulunamadi ve Bos tree olustu");
		}
}
	public Hashtable<String, isyerBilgi> okuSirket(String dosyaAdi)
	{
		Hashtable<String, isyerBilgi> hash=new Hashtable<String, isyerBilgi>();
		try {
			final BufferedReader in = new BufferedReader(new FileReader(dosyaAdi));
			String str;	
			while((str=in.readLine())!=null)
			{
				StringTokenizer token3=new StringTokenizer(str,"\t");
				//System.out.println(str);
				isyerBilgi newBilgi=new isyerBilgi();
				newBilgi.setIsYerAdi(token3.nextToken());
				newBilgi.setIsYerAdresi(token3.nextToken());
				newBilgi.setTelefon(token3.nextToken());
				newBilgi.setFaks(token3.nextToken());
				newBilgi.setIsYerEPosta(token3.nextToken());
				//newBilgi.disp();
				hash.put(newBilgi.getIsYerAdi(), newBilgi);
				
			}
		} catch (Exception e) {
			//System.out.println("ggeg");
		}
		return hash;
	}
	public void yazSirket(Hashtable<String, isyerBilgi> table, String dosyaAdi)
	{	
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter(dosyaAdi));
			Enumeration<isyerBilgi> e=table.elements();
			while(e.hasMoreElements())
			{
			isyerBilgi b=e.nextElement();
			out.write(b.getIsYerAdi()+"\t"+b.getIsYerAdresi()+"\t"+b.getTelefon()+"\t"+b.getFaks()+"\t"+b.getIsYerEPosta());
			out.newLine();
			}
			out.close();
		} catch (Exception e) {
		}
	}
	

}