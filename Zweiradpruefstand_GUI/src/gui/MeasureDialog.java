package gui;

import data.Bike;
import data.Config;
import data.DialData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import measure.MeasurementWorker;
import measure.MeasurementWorker.Status;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

/**
 *
 * @author emil
 */
public class MeasureDialog extends javax.swing.JDialog {
    
    private boolean finished;
    
    private final DefaultValueDataset velo = new DefaultValueDataset(0);
    private final DefaultValueDataset rpm = new DefaultValueDataset(0);
    
    private MyMeasurementWorker worker;

    /**
     * Creates new form MeasureDialog
     */
    public MeasureDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        setTitle("Messung läuft...");
        setLocationRelativeTo(null);
        setResizable(false);
        setMinimumSize(new Dimension(620, 450));
        
        initComponents();
        jPanDial.remove(jFrameRPM);
        jPanDial.remove(jFrameSpeed);
        
        createDial(velo, "km/h", jFrameSpeed, 0, 150, 10);
        if (Bike.getInstance().isMeasRpm()) {
            rpm.setValue(0);
            createDial(rpm, "U/min x 1000", jFrameRPM, 0, 13, 1);
        } else {
            jPanDial.remove(jFrameRPM);
        }
        
        handleMeasurementChain();
        
    }
    
    private void handleMeasurementChain() {
        jpbMeasure.setIndeterminate(true);
        worker = new MyMeasurementWorker();
        worker.setStatus(Status.WAIT);
        worker.execute();
    }
    
    private void createDial(DefaultValueDataset set, String title, JInternalFrame frame, int min, int max, int tick) {
        
        DialPlot plot = new DialPlot(set);
        plot.setDialFrame(new StandardDialFrame());
        plot.addLayer(new DialPointer.Pointer());

        /*
        DialTextAnnotation annotation = new DialTextAnnotation(title);
        annotation.setFont(new Font(null, Font.BOLD, 17));
        if (Config.getInstance().isDark()) {
            annotation.setPaint(new GradientPaint(new Point(), Color.WHITE, new Point(), Color.WHITE));
        } else {
            annotation.setPaint(new GradientPaint(new Point(), Color.BLACK, new Point(), Color.BLACK));
        }
        plot.addLayer(annotation);
         */
        GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
        DialBackground dialbackground = new DialBackground(gradientpaint);
        
        dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
        plot.setBackground(dialbackground);
        
        StandardDialScale scale = new StandardDialScale(min, max, -120, -300, tick, 4);
        scale.setTickRadius(0.88);
        scale.setTickLabelOffset(0.20);
        scale.setTickLabelFormatter(NumberFormat.getIntegerInstance());
        plot.addScale(0, scale);
        
        JFreeChart chart = new JFreeChart(plot);
        if (Config.getInstance().isDark()) {
            chart.setBackgroundPaint(new GradientPaint(new Point(), Color.DARK_GRAY, new Point(), Color.DARK_GRAY));
        } else {
            chart.setBackgroundPaint(new GradientPaint(new Point(), Color.WHITE, new Point(), Color.WHITE));
        }
        
        chart.setTitle(title);
        if (Config.getInstance().isDark()) {
            chart.getTitle().setPaint(new GradientPaint(new Point(), Color.WHITE, new Point(), Color.WHITE));
        } else {
            chart.getTitle().setPaint(new GradientPaint(new Point(), Color.BLACK, new Point(), Color.BLACK));
        }
        ChartPanel chartPanel = new ChartPanel(chart);
        
        jPanDial.add(chartPanel);

        /*
        frame.setUI(null);
        frame.add(new ChartPanel(new JFreeChart(plot)));
        frame.pack();
        frame.setSize(500, 500);
         */
    }

    //Sets Appearance like at the Main-GUI
    public void setAppearance(boolean dark) {
        if (dark == true) {
            jPanControls.setBackground(Color.darkGray);
            jPanDial.setBackground(Color.darkGray);
            jPanMain.setBackground(Color.darkGray);
            jPanStatus.setBackground(Color.darkGray);
            jPanStatusColour.setBackground(Color.darkGray);
            jPanStatusText.setBackground(Color.darkGray);
            jFrameRPM.setBackground(Color.darkGray);
            jFrameSpeed.setBackground(Color.darkGray);
            
            jLabelCount.setForeground(Color.white);
            jLabelStatus.setForeground(Color.white);
            jLabelStatusT.setForeground(Color.white);
        } else {
            jPanControls.setBackground(Color.white);
            jPanDial.setBackground(Color.white);
            jPanMain.setBackground(Color.white);
            jPanStatus.setBackground(Color.white);
            jPanStatusColour.setBackground(Color.white);
            jPanStatusText.setBackground(Color.white);
            jFrameRPM.setBackground(Color.white);
            jFrameSpeed.setBackground(Color.white);
            
            jLabelCount.setForeground(Color.black);
            jLabelStatus.setForeground(Color.black);
            jLabelStatusT.setForeground(Color.black);
        }
    }
    
    public boolean isFinished() {
        return finished;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanMain = new javax.swing.JPanel();
        jPanStatus = new javax.swing.JPanel();
        jPanStatusText = new javax.swing.JPanel();
        jLabelCount = new javax.swing.JLabel();
        jpbMeasure = new javax.swing.JProgressBar();
        jLabelStatusT = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jPanStatusColour = new javax.swing.JPanel();
        jPanDial = new javax.swing.JPanel();
        jFrameSpeed = new javax.swing.JInternalFrame();
        jFrameRPM = new javax.swing.JInternalFrame();
        jPanControls = new javax.swing.JPanel();
        jbutCancel = new javax.swing.JButton();
        jbutFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanMain.setLayout(new java.awt.BorderLayout());

        jPanStatus.setBackground(new java.awt.Color(255, 255, 255));
        jPanStatus.setLayout(new java.awt.GridLayout(2, 1));

        jPanStatusText.setBackground(new java.awt.Color(255, 255, 255));
        jPanStatusText.setLayout(new java.awt.GridBagLayout());

        jLabelCount.setText("Anzahl der Messpunkte: ");
        jLabelCount.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanStatusText.add(jLabelCount, gridBagConstraints);

        jpbMeasure.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jpbMeasure.setIndeterminate(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanStatusText.add(jpbMeasure, gridBagConstraints);

        jLabelStatusT.setText("Status: ");
        jLabelStatusT.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanStatusText.add(jLabelStatusT, gridBagConstraints);

        jLabelStatus.setText("HOCHSCHALTEN");
        jLabelStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanStatusText.add(jLabelStatus, gridBagConstraints);

        jPanStatus.add(jPanStatusText);

        jPanStatusColour.setBackground(new java.awt.Color(255, 255, 255));
        jPanStatusColour.setLayout(new java.awt.GridLayout(1, 0));
        jPanStatus.add(jPanStatusColour);

        jPanMain.add(jPanStatus, java.awt.BorderLayout.NORTH);

        jPanDial.setBackground(new java.awt.Color(255, 255, 255));
        jPanDial.setLayout(new java.awt.GridLayout(1, 0));

        jFrameSpeed.setVisible(true);
        jFrameSpeed.getContentPane().setLayout(new java.awt.GridLayout(1, 1));
        jPanDial.add(jFrameSpeed);

        jFrameRPM.setVisible(true);
        jFrameRPM.getContentPane().setLayout(new java.awt.GridLayout(1, 1));
        jPanDial.add(jFrameRPM);

        jPanMain.add(jPanDial, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanMain, java.awt.BorderLayout.CENTER);

        jPanControls.setBackground(new java.awt.Color(255, 255, 255));

        jbutCancel.setText("Abbrechen");
        jbutCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutCancelActionPerformed(evt);
            }
        });
        jPanControls.add(jbutCancel);

        jbutFinish.setText("Fertigstellen");
        jbutFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutFinishActionPerformed(evt);
            }
        });
        jPanControls.add(jbutFinish);

        getContentPane().add(jPanControls, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutFinishActionPerformed
        finished = true;
        dispose();
    }//GEN-LAST:event_jbutFinishActionPerformed

    private void jbutCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutCancelActionPerformed
        int answ = JOptionPane.showConfirmDialog(this, "Möchten Sie die Messung abbrechen?", "Abbruch der Messung", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (answ == JOptionPane.YES_OPTION) {
            worker.cancel(true);
            finished = false;
            dispose();
        }
    }//GEN-LAST:event_jbutCancelActionPerformed
    
    private class MyMeasurementWorker extends MeasurementWorker {
        
        @Override
        protected void done() {
        }
        
        @Override
        protected void process(List<DialData> chunks) {
            for (DialData dd : chunks) {
                
            }
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the MAC OS X look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (System.getProperty("os.name").contains("Mac OS X")) {
                    if ("MAC OS X".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                } else {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MeasureDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            MeasureDialog dialog = new MeasureDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jFrameRPM;
    private javax.swing.JInternalFrame jFrameSpeed;
    private javax.swing.JLabel jLabelCount;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelStatusT;
    private javax.swing.JPanel jPanControls;
    private javax.swing.JPanel jPanDial;
    private javax.swing.JPanel jPanMain;
    private javax.swing.JPanel jPanStatus;
    private javax.swing.JPanel jPanStatusColour;
    private javax.swing.JPanel jPanStatusText;
    private javax.swing.JButton jbutCancel;
    private javax.swing.JButton jbutFinish;
    private javax.swing.JProgressBar jpbMeasure;
    // End of variables declaration//GEN-END:variables
}
