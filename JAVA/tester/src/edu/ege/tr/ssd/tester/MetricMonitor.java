/*
 * Decompiled with CFR 0_118.
 */
package edu.ege.tr.ssd.tester;

import edu.ege.tr.ssd.tester.Client;
import edu.ege.tr.ssd.tester.ClientLeader;
import edu.ege.tr.ssd.tester.MetricManager;
import edu.ege.tr.ssd.tester.Paths;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

public class MetricMonitor
extends ApplicationFrame {
    private static final long serialVersionUID = 1;
    private TimeSeries series;
    private DefaultValueDataset gaugeDataset;
    private double TIME_OUT = MetricManager.TIME_OUT;
    private MeterPlot latencyGauge;
    private JTextField jtxtRequest;
    private JTextField jtxtSuccess;
    private JTextField jtxtFailure;
    private JTextField jtxtLatency;
    private JTextField jtxtThroughput;
    private JTextField jtxtHost;
    private JButton jbtnStartStop;
    private ClientLeader leader;
    private JTextField jtxtConcurrent;

    public MetricMonitor(String title, ClientLeader leader) {
        super(title);
        this.leader = leader;
        StandardChartTheme theme = new StandardChartTheme("JFree/Shadow");
        Color color = new Color(173, 216, 230);
        theme.setPlotBackgroundPaint(color);
        theme.setChartBackgroundPaint(color.brighter());
        ChartFactory.setChartTheme(theme);
        this.series = new TimeSeries((Comparable)((Object)"Random Data"));
        TimeSeriesCollection timeSeriesDataset = new TimeSeriesCollection(this.series);
        JFreeChart lineChart = this.createLineChart(timeSeriesDataset);
        ChartPanel linePanel = new ChartPanel(lineChart);
        this.gaugeDataset = new DefaultValueDataset(0.0);
        JFreeChart gaugeChart = this.createGaugeChart(this.gaugeDataset);
        ChartPanel gaugeChartPanel = new ChartPanel(gaugeChart);
        JPanel jpnlPureMetrics = this.createPureMetricsPanel();
        JPanel content = new JPanel(new BorderLayout());
        content.add((Component)linePanel, "North");
        content.add((Component)gaugeChartPanel, "West");
        content.add((Component)jpnlPureMetrics, "South");
        this.setContentPane(content);
    }

    private JPanel createPureMetricsPanel() {
        Font titleFont = new Font("Arial", 2, 12);
        Font textFont = new Font("Arial", 1, 14);
        this.jtxtRequest = new JTextField("0");
        TitledBorder border = new TitledBorder("Request");
        this.jtxtRequest.setBorder(border);
        border.setTitleFont(titleFont);
        this.jtxtRequest.setFont(textFont);
        this.jtxtRequest.setEditable(false);
        this.jtxtSuccess = new JTextField("0");
        border = new TitledBorder("Success");
        this.jtxtSuccess.setBorder(border);
        border.setTitleFont(titleFont);
        this.jtxtSuccess.setFont(textFont);
        this.jtxtSuccess.setEditable(false);
        this.jtxtFailure = new JTextField("0");
        border = new TitledBorder("Failure");
        this.jtxtFailure.setBorder(border);
        border.setTitleFont(titleFont);
        this.jtxtFailure.setFont(textFont);
        this.jtxtFailure.setEditable(false);
        this.jtxtThroughput = new JTextField("0");
        border = new TitledBorder("Throughput");
        this.jtxtThroughput.setBorder(border);
        border.setTitleFont(titleFont);
        this.jtxtThroughput.setFont(textFont);
        this.jtxtThroughput.setEditable(false);
        this.jtxtLatency = new JTextField("0");
        border = new TitledBorder("Latency");
        border.setTitleFont(titleFont);
        this.jtxtLatency.setBorder(border);
        this.jtxtLatency.setFont(textFont);
        this.jtxtLatency.setEditable(false);
        this.jtxtConcurrent = new JTextField("2");
        border = new TitledBorder("Concurrent");
        this.jtxtConcurrent.setBorder(border);
        border.setTitleFont(titleFont);
        this.jtxtConcurrent.setMinimumSize(new Dimension(20, 20));
        JPanel jpnlController = new JPanel(new BorderLayout());
        this.jtxtHost = new JTextField();
        this.jtxtHost.setText(Paths.HOST);
        this.jbtnStartStop = new JButton("Start");
        this.jbtnStartStop.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (MetricMonitor.this.jbtnStartStop.getText().equals("Start")) {
                    try {
                        if (!Paths.HOST.equals(MetricMonitor.this.jtxtHost.getText())) {
                            Paths.HOST = MetricMonitor.this.jtxtHost.getText();
                            Paths.loadURIs();
                        }
                        if (Client.CONCURRENT_REQUEST != Integer.parseInt(MetricMonitor.this.jtxtConcurrent.getText())) {
                            Client.CONCURRENT_REQUEST = Integer.parseInt(MetricMonitor.this.jtxtConcurrent.getText());
                        }
                        MetricMonitor.this.leader.run();
                    }
                    catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    MetricMonitor.this.setStartable(false);
                } else {
                    MetricMonitor.this.leader.forceStop();
                    MetricMonitor.this.setStartable(true);
                }
            }
        });
        jpnlController.add((Component)this.jbtnStartStop, "East");
        jpnlController.add((Component)this.jtxtHost, "Center");
        JPanel jpnlPureMetrics = new JPanel(new GridLayout(3, 3));
        jpnlPureMetrics.add(this.jtxtRequest);
        jpnlPureMetrics.add(this.jtxtThroughput);
        jpnlPureMetrics.add(this.jtxtSuccess);
        jpnlPureMetrics.add(this.jtxtLatency);
        jpnlPureMetrics.add(this.jtxtFailure);
        jpnlPureMetrics.add(this.jtxtConcurrent);
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.add((Component)jpnlPureMetrics, "Center");
        outerPanel.add((Component)jpnlController, "South");
        return outerPanel;
    }

    private JFreeChart createLineChart(XYDataset dataset) {
        JFreeChart result = ChartFactory.createTimeSeriesChart("Latency Monitor", "Time", "Value", dataset, true, true, false);
        XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 10000.0);
        return result;
    }

    private void addLine(double value) {
        Millisecond now = new Millisecond();
        Number number = this.series.getValue(now);
        if (number == null) {
            this.series.addOrUpdate((RegularTimePeriod)now, value);
        }
    }

    private void setLatency(double value) {
        if (value < this.TIME_OUT) {
            this.gaugeDataset.setValue(value);
            this.latencyGauge.setNeedlePaint(Color.BLACK);
        } else {
            this.gaugeDataset.setValue(this.TIME_OUT);
            this.latencyGauge.setNeedlePaint(Color.RED);
        }
    }

    private JFreeChart createGaugeChart(ValueDataset valuedataset) {
        this.latencyGauge = new MeterPlot(valuedataset);
        this.latencyGauge.setRange(new Range(0.0, this.TIME_OUT));
        Color low = new Color(153, 204, 255);
        Color middle = new Color(255, 255, 153);
        Color high = new Color(255, 0, 0);
        this.latencyGauge.addInterval(new MeterInterval("Hummingbird", new Range(0.0, 1000.0), Color.BLACK, new BasicStroke(2.0f), low));
        this.latencyGauge.addInterval(new MeterInterval("Sparrow", new Range(1000.0, 2500.0), Color.BLACK, new BasicStroke(2.0f), middle));
        this.latencyGauge.addInterval(new MeterInterval("Stork", new Range(2500.0, this.TIME_OUT), Color.BLACK, new BasicStroke(2.0f), high));
        this.latencyGauge.setNeedlePaint(Color.black);
        this.latencyGauge.setDialBackgroundPaint(Color.white);
        this.latencyGauge.setDialOutlinePaint(Color.black);
        this.latencyGauge.setDialShape(DialShape.CHORD);
        this.latencyGauge.setMeterAngle(150);
        this.latencyGauge.setTickLabelsVisible(true);
        this.latencyGauge.setTickLabelFont(new Font("Arial", 1, 20));
        this.latencyGauge.setTickLabelPaint(Color.black);
        this.latencyGauge.setTickSize(5.0);
        this.latencyGauge.setTickPaint(Color.gray);
        this.latencyGauge.setValuePaint(Color.black);
        this.latencyGauge.setValueFont(new Font("Arial", 1, 20));
        JFreeChart jfreechart = new JFreeChart("Mean Latency", JFreeChart.DEFAULT_TITLE_FONT, this.latencyGauge, true);
        return jfreechart;
    }

    public synchronized void update(long request, long success, long failure, long throughput, long latency) {
        this.jtxtRequest.setText(Long.toString(request));
        this.jtxtSuccess.setText(Long.toString(success));
        this.jtxtFailure.setText(Long.toString(failure));
        this.jtxtThroughput.setText(Long.toString(throughput));
        this.jtxtLatency.setText(Long.toString(latency));
        this.addLine(latency);
        this.setLatency(latency);
    }

    public void setStartable(boolean b) {
        if (b) {
            this.jtxtHost.setEnabled(true);
            this.jbtnStartStop.setText("Start");
            this.jtxtConcurrent.setEnabled(true);
        } else {
            this.jtxtHost.setEnabled(false);
            this.jbtnStartStop.setText("Stop");
            this.jtxtConcurrent.setEnabled(false);
        }
    }

}

