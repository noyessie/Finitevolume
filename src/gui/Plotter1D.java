package gui;


import gui.plot.Graph;
import java.awt.Color;
import java.util.Iterator;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import point.interfaces.IPoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KevinJio
 */
public class Plotter1D {
    protected XYSeries series[];
    
    protected Graph[] graph;
    protected XYSeriesCollection xyseriescollection = new XYSeriesCollection();
    
    public Plotter1D(Graph[] g){
        this.graph = g;
        init();
    }
    
    protected void init(){
        series = new XYSeries[graph.length];
        for(int i=0 ; i< graph.length ; i++){
            Graph g = graph[i];
            series[i] = new XYSeries(g.getName());
            Iterator<IPoint> h = g.getFunction().iterator();
            while(h.hasNext()){
                IPoint p = h.next();
                series[i].add(p.get(IPoint.X), g.getFunction().valueOf(p) );
            }
            xyseriescollection.addSeries(series[i]);
        }
    }

    public Graph[] getGraph() {
        return graph;
    }

    public void setGraph(Graph[] graph) {
        this.graph = graph;
    }
    
    public void plot(){
        plot("graphe" , "SplineRenderer");
    }
    
    public void plot(String panelName , String fonctionName){
        JFrame f = new JFrame(panelName);
        f.setSize(700,500);
        f.add(createChartPanel1(fonctionName));
        f.pack();
        f.setVisible(true);
    }
    
    private ChartPanel createChartPanel1(String grapheName)
                {
                    
                      
                        XYSplineRenderer xysplinerenderer = new XYSplineRenderer();
                        ValueAxis valueAxis = new NumberAxis("X");
                        valueAxis.setRange(0.0, 1.0);
                        ValueAxis valueAxisy = new NumberAxis("Y");
                        valueAxis.setRange(0.0, 1.0);
                        XYPlot xyplot;
                        xyplot = new XYPlot(xyseriescollection, valueAxis, valueAxisy, xysplinerenderer);
                        xyplot.setBackgroundPaint(Color.lightGray);
                        xyplot.setDomainGridlinePaint(Color.white);
                        xyplot.setRangeGridlinePaint(Color.white);
                        xyplot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));
                        JFreeChart jfreechart = new JFreeChart(grapheName, JFreeChart.DEFAULT_TITLE_FONT, xyplot, true);
                        jfreechart.setBackgroundPaint(Color.white);
                        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
                        return chartpanel;
                }
    
    
}
