import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NetworkService implements Runnable {
   private final ServerSocket serverSocket;
   private final ExecutorService pool;

   public NetworkService(int port, int poolSize)
       throws IOException {
     serverSocket = new ServerSocket(port);
     pool = Executors.newCachedThreadPool();
   }

   public void run() { // run the service
     try {
       for (;;) {
    	 System.out.println("Waitin for connection");
         pool.execute(new Handler(serverSocket.accept()));//handler list gerekebilir
         
       }
     } catch (IOException ex) {
       pool.shutdown();
     }
   }
 }
