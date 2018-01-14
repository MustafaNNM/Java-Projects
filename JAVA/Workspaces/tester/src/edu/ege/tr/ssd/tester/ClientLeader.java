/*
 * Decompiled with CFR 0_118.
 */
package edu.ege.tr.ssd.tester;

import edu.ege.tr.ssd.tester.Client;
import edu.ege.tr.ssd.tester.MetricManager;
import edu.ege.tr.ssd.tester.MetricMonitor;
import edu.ege.tr.ssd.tester.Paths;
import java.io.IOException;
import java.io.PrintStream;
import org.jfree.ui.RefineryUtilities;

public class ClientLeader {
    private MetricManager metricManager;
    private MetricMonitor monitor;
    private Client client;

    public ClientLeader() throws Exception {
        this.monitor = new MetricMonitor("Throughput vs Latency", this);
        this.monitor.pack();
        RefineryUtilities.centerFrameOnScreen(this.monitor);
        this.monitor.setVisible(true);
        this.metricManager = new MetricManager(this.monitor);
        this.initClients();
    }

    public static void main(String[] args) throws IOException, Exception {
        if (args.length > 0) {
            Paths.HOST = args[0];
        }
        new edu.ege.tr.ssd.tester.ClientLeader();
    }

    private void initClients() throws Exception, InterruptedException {
        this.client = new Client(this.metricManager);
    }

    public void forceStop() {
        this.client.forceStop();
        this.monitor.setStartable(true);
    }

    public void run() throws InterruptedException {
        System.out.println("Starting...");
        Thread t = new Thread(this.client);
        t.start();
    }
}

