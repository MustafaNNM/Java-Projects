
public class Meeting {

Time start_time=new Time();
Time finish_time=new Time();
int bulusma_suresi_miktari;
public int bulusma_suresi_miktarini_hesapla() {
	return 60*(finish_time.hour-start_time.hour)+finish_time.minute-start_time.minute;
}
}
