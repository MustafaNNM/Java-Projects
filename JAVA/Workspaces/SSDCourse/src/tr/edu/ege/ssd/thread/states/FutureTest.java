package tr.edu.ege.ssd.thread.states;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		OneShotTask task = new OneShotTask();
		Future<String> submit = service.submit(task);
		System.out.println(String.format("Soon after submission, call result is {%s}", submit.get()));
		System.out.println(String.format("Soon after submission, rand is {%d}", task.getRand()));
		Thread.sleep(2000);
		System.out.println(String.format("Two seconds after submission, call result is {%s}", submit.get()));
		System.out.println(String.format("Two seconds after submission, rand is {%d}", task.getRand()));
	}

}

class OneShotTask implements Callable<String> {

	private int rand = 0;
	
	public int getRand() {
		return rand;
	}

	public void setRand(int rand) {
		this.rand = rand;
	}

	@Override
	public String call() throws Exception {
		rand = (int) Math.ceil(Math.random() * 1000) ;
		System.err.println(String.format("Waiting %d",rand));
		Thread.sleep(rand);
		return String.format("I've waited %d milisecond", rand);
	}
}
