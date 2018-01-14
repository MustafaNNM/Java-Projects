/*
 * Decompiled with CFR 0_118.
 */
package edu.ege.tr.ssd.tester;

import edu.ege.tr.ssd.tester.ImageRetriever;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ImageCollector
implements Runnable {
    static String PATH = "C:\\Users\\MehmetAkif-PC\\Downloads\\bihap";
    private BlockingQueue<String> queue;
    private boolean stop = false;

    public ImageCollector(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.parseImageURIs();
        this.stop = true;
    }

    private void parseImageURIs() {
        BufferedReader br = null;
        try {
            System.out.println(String.format("Parsing images from file %s", PATH));
            br = new BufferedReader(new FileReader(String.valueOf(PATH) + "ress.txt"));
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("##");
                String uri = split[0];
                boolean offer = false;
                while (!offer) {
                    offer = this.queue.offer(uri);
                    if (offer) continue;
                    Thread.sleep(5000);
                }
                System.out.println(String.format("\t%s put in queue ", uri));
            }
            br.close();
            System.out.println(String.format("%d images parsed", this.queue.size()));
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                br.close();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public boolean isStop() {
        return this.stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100, true);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        ImageCollector collector = new ImageCollector(queue);
        service.scheduleAtFixedRate(collector, 1, 1, TimeUnit.SECONDS);
        String uri = null;
        while ((uri = queue.take()) != null && !collector.isStop()) {
            service.schedule(new ImageRetriever(uri), 1, TimeUnit.SECONDS);
        }
        System.out.println("Finished.!!");
    }
}

