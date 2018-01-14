
public class Time {
	int day=0;
	int hour=0;
	int minute=0;
	int oncelik=0;

public int saati_dakikaya_cevir() {
	return day*24*60+60*hour+minute;
}


}
