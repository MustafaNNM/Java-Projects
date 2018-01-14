/*
 * Decompiled with CFR 0_118.
 */
package edu.ege.tr.ssd.tester;

import edu.ege.tr.ssd.tester.MetricMonitor;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MetricManager {
    public static long TIME_OUT = 10000;
    private MetricMonitor monitor;
    private AtomicLong requested = new AtomicLong(0);
    private AtomicLong succesfull = new AtomicLong(0);
    private AtomicLong failure = new AtomicLong(0);
    private AtomicLong latency = new AtomicLong(0);
    private AtomicLong throughput = new AtomicLong(0);
    private long begin = 0;
    private ConcurrentHashMap<String, Long> ongoing = new ConcurrentHashMap();

    public MetricManager(MetricMonitor monitor) {
        this.monitor = monitor;
    }

    public void requested(int hash) {
        if (this.begin == 0) {
            this.begin = System.currentTimeMillis();
        }
        this.requested.incrementAndGet();
        this.ongoing.put(Integer.toString(hash), new Long(System.currentTimeMillis()));
    }

    public void success(int hash) {
        this.succesfull.incrementAndGet();
        String key = Integer.toString(hash);
        Long start = this.ongoing.get(key);
        long current = System.currentTimeMillis();
        long diff = current - start;
        this.latency.addAndGet(diff);
        this.ongoing.remove(key);
        diff = (current - this.begin) / 1000;
        diff = diff == 0 ? 1 : diff;
        this.throughput.set(this.succesfull.get() / diff);
        this.updateUI();
    }

    public void updateUI() {
        long scss = this.succesfull.intValue() == 0 ? 1 : this.succesfull.get();
        this.monitor.update(this.ongoing.size(), this.succesfull.get(), this.failure.get(), this.throughput.get(), this.latency.get() / scss);
    }

    public void failure(int hash) {
        this.failure.incrementAndGet();
        this.ongoing.remove(Integer.toString(hash));
        this.updateUI();
    }

    public boolean isOngoing() {
        if (this.ongoing.size() > 0) {
            return true;
        }
        return false;
    }

    public void clear() {
        this.begin = 0;
        this.latency.set(0);
        this.ongoing.clear();
        this.requested.set(0);
        this.succesfull.set(0);
        this.throughput.set(0);
        this.failure.set(0);
        this.updateUI();
    }
}

