/*
 * Decompiled with CFR 0_118.
 */
package edu.ege.tr.ssd.tester;

import edu.ege.tr.ssd.tester.MetricManager;
import edu.ege.tr.ssd.tester.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;

public class Client
implements Runnable,
Response.CompleteListener {
    private static final int MINIMUM_CONTENT_LENGTH = 5120;
    public static int CONCURRENT_REQUEST = 1;
    public static boolean log = true;
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(CONCURRENT_REQUEST);
    Phaser phaser = new Phaser();
    private HttpClient httpClient;
    private MetricManager metricManager;
    private UNIT type = UNIT.BIG;
    private static /* synthetic */ int[] $SWITCH_TABLE$edu$ege$tr$ssd$tester$Client$UNIT;

    public Client(MetricManager metricManger) throws Exception {
        this.metricManager = metricManger;
        if (log) {
            System.out.println("Client created");
        }
    }

    @Override
    public void onComplete(Result result) {
        if (!result.isFailed()) {
            if (result.getResponse().getStatus() == 200) {
                if (log) {
                    this.metricManager.success(result.getRequest().hashCode());
                    System.out.println("Success: " + result.getRequest().getURI());
                }
                return;
            }
            this.metricManager.failure(result.getRequest().hashCode());
            if (log) {
                System.err.println("Failure: " + result.getRequest().getURI());
            }
        }
    }

    @Override
    public void run() {
        this.clearSession();
        try {
            System.out.println("Preparing lists");
            List<String> loadURIs = this.loadURIs();
            List<String> subList = loadURIs.subList(0, 1000);
            System.out.println("Lists prepared");
            this.visit(subList);
            this.phaser.arriveAndAwaitAdvance();
            this.metricManager.updateUI();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> loadURIs() throws Exception {
        List<String> loadURIs = Paths.loadURIsFromIndex(String.valueOf(Paths.HOST) + "index.txt", this.httpClient);
        return loadURIs;
    }

    private void clearSession() {
        this.phaser = new Phaser();
        if (this.httpClient == null || this.httpClient.isStopped()) {
            try {
                this.executorService = Executors.newScheduledThreadPool(CONCURRENT_REQUEST);
                this.prepareHTTPClient();
                Thread.sleep(1000);
                this.metricManager.clear();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void visit(List<String> subList) {
        subList.forEach(uri -> {
            this.request(this.prepareURI(uri, UNIT.LIST, false));
        }
        );
        subList.forEach(uri -> {
            this.request(this.prepareURI(uri, UNIT.NORMAL, false));
        }
        );
        subList.forEach(uri -> {
            this.request(this.prepareURI(uri, UNIT.ICON, true));
        }
        );
    }

    public void request(String uri) {
        Runnable runnable = () -> {
            if (this.httpClient.isStopped()) {
                System.out.println(String.format("HTTP Client is stopped. Leaving requested %s", uri));
                return;
            }
            Request request = this.httpClient.newRequest(uri).timeout(MetricManager.TIME_OUT, TimeUnit.MILLISECONDS);
            this.metricManager.requested(request.hashCode());
            try {
                ContentResponse send;
                if (log) {
                    System.out.println(String.format("Requesting %s", uri));
                }
                if ((send = request.send()).getStatus() == 200 && send.getContent().length > 5120) {
                    this.metricManager.success(request.hashCode());
                } else {
                    this.metricManager.failure(request.hashCode());
                    String pathname = "error.txt";
                    this.save2File(send, pathname);
                    String message = "";
                    if (send.getStatus() != 200) {
                        message = String.valueOf(message) + " Status is not 200. ";
                    }
                    if (send.getContent().length < 5120) {
                        message = String.valueOf(message) + " Content is not big enough as expected.";
                    }
                    System.err.println(String.format("Error occured during request {%s} handling: %s ", uri, message));
                }
            }
            catch (Exception e) {
                this.metricManager.failure(request.hashCode());
                System.err.println("Error occured during request handling: " + e.getMessage() + " -> " + uri);
                e.printStackTrace();
            }
            this.phaser.arriveAndDeregister();
        };
        this.phaser.register();
        if (!this.httpClient.isStopped()) {
            this.executorService.schedule(runnable, 100, TimeUnit.MILLISECONDS);
        }
    }

    private void save2File(ContentResponse send, String pathname) throws FileNotFoundException, IOException {
        if (!new File(pathname).exists()) {
            FileOutputStream fos = new FileOutputStream(new File(pathname));
            fos.write(send.getContent());
            fos.close();
        }
    }

    private void prepareHTTPClient() throws Exception {
        this.httpClient = new HttpClient();
        this.httpClient.setMaxConnectionsPerDestination(CONCURRENT_REQUEST);
        this.httpClient.setConnectTimeout(MetricManager.TIME_OUT);
        this.httpClient.start();
        Thread.sleep(1000);
    }

    public void visitWellcomepage() {
        Paths.WELLCOME_URIs.stream().forEach(uri -> {
            this.request(this.prepareURI(uri));
        }
        );
    }

    public List<String> visitCategory() throws InterruptedException {
        List<String> randomCategoryItems = Paths.getRandomCategory();
        int i = 1;
        while (i < 3) {
            int from = Paths.IMAGE_COUNT_ON_EACH_PAGE * (i - 1);
            int to = Paths.IMAGE_COUNT_ON_EACH_PAGE * i - 1;
            IntStream.range(from, to).forEach(uri -> {
                this.request(this.prepareURI((String)randomCategoryItems.get(uri)));
            }
            );
            this.waitSome();
            this.visitImage(randomCategoryItems.subList(from, to));
            ++i;
        }
        return randomCategoryItems;
    }

    private void visitImage(String uri) {
        this.request(uri);
        Paths.RECC_URIs.get(uri).stream().forEach(rec -> {
            this.request(rec);
        }
        );
    }

    private List<String> visitImage(List<String> uris) {
        int i = (int)Paths.randomWithRange(0.0, uris.size());
        this.visitImage(uris.get(i));
        List<String> list = Paths.RECC_URIs.get(uris.get(i));
        list.forEach(reccUri -> {
            this.request(this.prepareURI(reccUri, true));
        }
        );
        return list;
    }

    private String prepareQuery(boolean isGray) {
        return this.prepareQuery(this.type, isGray);
    }

    private String prepareQuery(UNIT current, boolean isGray) {
        String pattern = "?width=%d&height=%d";
        String query = "";
        switch (Client.$SWITCH_TABLE$edu$ege$tr$ssd$tester$Client$UNIT()[current.ordinal()]) {
            case 1: {
                query = String.format(pattern, 1024, 768);
            }
            case 2: {
                query = String.format(pattern, 800, 600);
            }
            case 3: {
                query = String.format(pattern, 600, 600);
            }
            case 4: {
                query = String.format(pattern, 256, 256);
            }
        }
        if (isGray) {
            query = String.valueOf(query) + "&color=GRAY";
        }
        return query;
    }

    private String prepareURI(String uri, boolean isGray) {
        return String.valueOf(uri) + this.prepareQuery(isGray);
    }

    private String prepareURI(String uri, UNIT unit, boolean isGray) {
        return String.valueOf(uri) + this.prepareQuery(unit, isGray);
    }

    private String prepareURI(String uri) {
        return this.prepareURI(uri, false);
    }

    private void waitSome() throws InterruptedException {
        Thread.sleep(MetricManager.TIME_OUT);
    }

    public void forceStop() {
        try {
            this.executorService.shutdown();
            this.httpClient.stop();
            Thread.sleep(1000);
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
        while (!this.executorService.isShutdown() && !this.httpClient.isStopped()) {
            System.out.println(String.format("Waiting for stop of Executor:%b and HTTPClient:%b", this.executorService.isShutdown(), this.httpClient.isStopped()));
            try {
                Thread.sleep(1000);
                continue;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (log) {
            String message = String.format("Stopped: Executor:%b and HTTPClient:%b", this.executorService.isShutdown(), this.httpClient.isStopped());
            System.out.println(message);
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$edu$ege$tr$ssd$tester$Client$UNIT() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$edu$ege$tr$ssd$tester$Client$UNIT;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[UNIT.values().length];
        try {
            arrn[UNIT.BIG.ordinal()] = 1;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[UNIT.ICON.ordinal()] = 4;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[UNIT.LIST.ordinal()] = 3;
        }
        catch (NoSuchFieldError v3) {}
        try {
            arrn[UNIT.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError v4) {}
        $SWITCH_TABLE$edu$ege$tr$ssd$tester$Client$UNIT = arrn;
        return $SWITCH_TABLE$edu$ege$tr$ssd$tester$Client$UNIT;
    }

    /**
	 * @return the minimumContentLength
	 */
	public static int getMinimumContentLength() {
		return MINIMUM_CONTENT_LENGTH;
	}

	public static enum UNIT {
        BIG,
        NORMAL,
        LIST,
        ICON;
        

        private UNIT(String string2, int n2) {
        	
        }
    }

}

