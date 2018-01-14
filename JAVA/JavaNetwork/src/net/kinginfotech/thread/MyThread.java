package net.kinginfotech.thread;
import java.util.Random;

public class MyThread implements Runnable {
    String name;
    int time;
    Random r = new Random();
    
    public MyThread(String x){
    	name = x;
    	time = r.nextInt(1000);
    }
	
	@Override
	public void run() {
		 try{
			 System.out.printf("%s us sleeping for %d\n", name, time);
			 Thread.sleep(time);
			 System.out.printf("%s is done \n", name); 
		 }catch(Exception e){
			 System.out.println(e); 
		 }
	}

}
