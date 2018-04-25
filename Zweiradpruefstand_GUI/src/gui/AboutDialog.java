/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;

/**
 *
 * @author emil
 */
public class AboutDialog extends javax.swing.JDialog {

    /**
     * Creates new form about
     */
    public AboutDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jLabelVersionNumber.setText("1.0");
        setTitle("Zweiradprüfstand - About");
        setLocationRelativeTo(null);
        setSize(new Dimension(800, 600));
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

        jPanHeader = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jPanInfo = new javax.swing.JPanel();
        jLabelDevelopers = new javax.swing.JLabel();
        jLabelWarning = new javax.swing.JLabel();
        jPanAuthor = new javax.swing.JPanel();
        jPanVersion = new javax.swing.JPanel();
        jLabelVersionNumber = new javax.swing.JLabel();
        jLabelVersionText = new javax.swing.JLabel();
        jPanAuthor2 = new javax.swing.JPanel();
        jLabelAuthor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanHeader.setLayout(new java.awt.BorderLayout());

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo128.png"))); // NOI18N
        jLabelTitle.setText("Zweiradprüfstand");
        jLabelTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanHeader.add(jLabelTitle, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanHeader, java.awt.BorderLayout.PAGE_START);

        jPanInfo.setLayout(new java.awt.GridBagLayout());

        jLabelDevelopers.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabelDevelopers.setText("<html>  <center> <b>Diplomanden: </b> <br>  Berger Emil - Software<br>  Ehmann Julian - Elektronik<br>  Sammer Daniel - Mechanik<br>  </center>");
        jLabelDevelopers.setAutoscrolls(true);
        jLabelDevelopers.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanInfo.add(jLabelDevelopers, new java.awt.GridBagConstraints());

        jLabelWarning.setText("<html> <left> Die Nutzung des Prüfstandes geschieht auf eigene Gefahr! <br> Die Diplomanden übernehmen keine Haftung für eventuell entstandene Sach- oder Personenschäden. <br> Der Nutzer des prüfstandes erhält eine lebenslange Lizenz zur Benutzung der Software. <br> Alle Rechte an der Software verbleiben bei Berger Emil. <br> Alle Rechte der Elektronik verbleiben bei Ehmann Julian.");
        jLabelWarning.setBorder(javax.swing.BorderFactory.createTitledBorder("Warnung"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanInfo.add(jLabelWarning, gridBagConstraints);

        getContentPane().add(jPanInfo, java.awt.BorderLayout.CENTER);

        jPanAuthor.setLayout(new java.awt.BorderLayout());

        jPanVersion.setLayout(new java.awt.BorderLayout());

        jLabelVersionNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanVersion.add(jLabelVersionNumber, java.awt.BorderLayout.EAST);

        jLabelVersionText.setText("Version:");
        jLabelVersionText.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanVersion.add(jLabelVersionText, java.awt.BorderLayout.WEST);

        jPanAuthor.add(jPanVersion, java.awt.BorderLayout.CENTER);

        jLabelAuthor.setText("© Emil Berger 2018-2019");
        jLabelAuthor.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanAuthor2.add(jLabelAuthor);

        jPanAuthor.add(jPanAuthor2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanAuthor, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AboutDialog dialog = new AboutDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAuthor;
    private javax.swing.JLabel jLabelDevelopers;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelVersionNumber;
    private javax.swing.JLabel jLabelVersionText;
    private javax.swing.JLabel jLabelWarning;
    private javax.swing.JPanel jPanAuthor;
    private javax.swing.JPanel jPanAuthor2;
    private javax.swing.JPanel jPanHeader;
    private javax.swing.JPanel jPanInfo;
    private javax.swing.JPanel jPanVersion;
    // End of variables declaration//GEN-END:variables
}