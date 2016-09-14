
package izmirhavasicaklik;

public class StandartSapmaHesaplama {
    public static double StandardSapma(int[][] GunlukSicaklikDegerler,int N,int ay)
    {

        double Std=0.0;
        double Sum=0.0,Ortalama=0.0;
        N=N-1;
        for(int i=0; i<N; i++)
            Ortalama=Ortalama+GunlukSicaklikDegerler[ay][i];
        Ortalama=Ortalama/N;
        for(int i=0; i<N; i++)
            Sum=Sum+((GunlukSicaklikDegerler[ay][i]-Ortalama)*(GunlukSicaklikDegerler[ay][i]-Ortalama));
        Std=Math.sqrt(Sum/N);
        return Std;


    }
}
