/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author hdani
 */
public class Play extends javax.swing.JFrame {
    private ArrayList<JLabel> labels;

    /**
     * Creates new form Play
     */
    public Play() {
        initComponents();
        this.setLocationRelativeTo(null);
        generarLabels();
        generarLabelsPlayer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        panelCuadricula = new javax.swing.JPanel();
        panelCuadriculaPlayer = new javax.swing.JPanel();
        tituloPanel = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        tituloPanel2 = new javax.swing.JPanel();
        tituloLabel2 = new javax.swing.JLabel();
        player2Panel = new javax.swing.JPanel();
        player3Panel = new javax.swing.JPanel();
        player4Panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        textoPanel = new javax.swing.JPanel();
        textoLabel = new javax.swing.JLabel();
        comandoInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        historialPanel = new javax.swing.JPanel();
        historialLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(0, 0, 102));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCuadricula.setBackground(new java.awt.Color(0, 0, 102));
        panelCuadricula.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout panelCuadriculaLayout = new javax.swing.GroupLayout(panelCuadricula);
        panelCuadricula.setLayout(panelCuadriculaLayout);
        panelCuadriculaLayout.setHorizontalGroup(
            panelCuadriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelCuadriculaLayout.setVerticalGroup(
            panelCuadriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        bg.add(panelCuadricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 61, -1, -1));

        panelCuadriculaPlayer.setBackground(new java.awt.Color(0, 0, 102));
        panelCuadriculaPlayer.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout panelCuadriculaPlayerLayout = new javax.swing.GroupLayout(panelCuadriculaPlayer);
        panelCuadriculaPlayer.setLayout(panelCuadriculaPlayerLayout);
        panelCuadriculaPlayerLayout.setHorizontalGroup(
            panelCuadriculaPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panelCuadriculaPlayerLayout.setVerticalGroup(
            panelCuadriculaPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        bg.add(panelCuadriculaPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        tituloPanel.setBackground(new java.awt.Color(102, 102, 102));

        tituloLabel.setFont(new java.awt.Font("Engravers MT", 3, 24)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("MY SEA");
        tituloLabel.setToolTipText("");

        javax.swing.GroupLayout tituloPanelLayout = new javax.swing.GroupLayout(tituloPanel);
        tituloPanel.setLayout(tituloPanelLayout);
        tituloPanelLayout.setHorizontalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tituloPanelLayout.setVerticalGroup(
            tituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(tituloPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 500, 30));

        tituloPanel2.setBackground(new java.awt.Color(102, 102, 102));
        tituloPanel2.setPreferredSize(new java.awt.Dimension(127, 37));

        tituloLabel2.setFont(new java.awt.Font("Engravers MT", 3, 24)); // NOI18N
        tituloLabel2.setForeground(new java.awt.Color(255, 255, 255));
        tituloLabel2.setText("Enemy");

        javax.swing.GroupLayout tituloPanel2Layout = new javax.swing.GroupLayout(tituloPanel2);
        tituloPanel2.setLayout(tituloPanel2Layout);
        tituloPanel2Layout.setHorizontalGroup(
            tituloPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloPanel2Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(tituloLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        tituloPanel2Layout.setVerticalGroup(
            tituloPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(tituloPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 500, 30));

        javax.swing.GroupLayout player2PanelLayout = new javax.swing.GroupLayout(player2Panel);
        player2Panel.setLayout(player2PanelLayout);
        player2PanelLayout.setHorizontalGroup(
            player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        player2PanelLayout.setVerticalGroup(
            player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(player2Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, -1, 70));

        javax.swing.GroupLayout player3PanelLayout = new javax.swing.GroupLayout(player3Panel);
        player3Panel.setLayout(player3PanelLayout);
        player3PanelLayout.setHorizontalGroup(
            player3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        player3PanelLayout.setVerticalGroup(
            player3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(player3Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 190, -1, -1));

        javax.swing.GroupLayout player4PanelLayout = new javax.swing.GroupLayout(player4Panel);
        player4Panel.setLayout(player4PanelLayout);
        player4PanelLayout.setHorizontalGroup(
            player4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        player4PanelLayout.setVerticalGroup(
            player4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(player4Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 300, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        bg.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 410, -1, -1));

        textoPanel.setBackground(new java.awt.Color(0, 102, 204));
        textoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 153, 153)));
        textoPanel.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout textoPanelLayout = new javax.swing.GroupLayout(textoPanel);
        textoPanel.setLayout(textoPanelLayout);
        textoPanelLayout.setHorizontalGroup(
            textoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );
        textoPanelLayout.setVerticalGroup(
            textoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        bg.add(textoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, 500, 170));

        comandoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comandoInputActionPerformed(evt);
            }
        });
        bg.add(comandoInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 710, 340, 30));

        jButton1.setText("Enviar");
        bg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 710, 120, 30));

        javax.swing.GroupLayout historialPanelLayout = new javax.swing.GroupLayout(historialPanel);
        historialPanel.setLayout(historialPanelLayout);
        historialPanelLayout.setHorizontalGroup(
            historialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        historialPanelLayout.setVerticalGroup(
            historialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historialLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        bg.add(historialPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 480, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comandoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comandoInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comandoInputActionPerformed

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
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Play().setVisible(true);
            }
        });
    }
    
    private void generarLabels(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        int x = 0;
        int y = 0;
        for (int i = 0; i < 20; i++){
            x = 0;
            for(int j = 0; j < 20; j++){
                // Label de dígitos
                JLabel label = new JLabel("", SwingConstants.CENTER);     
                label.setFont(new Font("Verdana", Font.PLAIN, 18));
                label.setBounds(x, y, 25, 25);
                label.setOpaque(true);
                label.setBackground(Color.blue);
                label.setBorder(blackline);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelCuadricula.add(label);
                //labels.add(label);
                x += 25;
            }
            y += 25;
        }    
    }

     private void generarLabelsPlayer(){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        int x = 0;
        int y = 0;
        for (int i = 0; i < 20; i++){
            x = 0;
            for(int j = 0; j < 20; j++){
                // Label de dígitos
                JLabel label = new JLabel("", SwingConstants.CENTER);     
                label.setFont(new Font("Verdana", Font.PLAIN, 18));
                label.setBounds(x, y, 25, 25);
                label.setOpaque(true);
                label.setBackground(Color.blue);
                label.setBorder(blackline);
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelCuadriculaPlayer.add(label);
                label.addMouseListener(new MouseAdapter(){  
                    public void mouseClicked(MouseEvent e){
                        label.setText("X");
                    }
                });
                //labels.add(label);
                x += 25;
            }
            y += 25;
        }    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JTextField comandoInput;
    private javax.swing.JLabel historialLabel;
    private javax.swing.JPanel historialPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelCuadricula;
    private javax.swing.JPanel panelCuadriculaPlayer;
    private javax.swing.JPanel player2Panel;
    private javax.swing.JPanel player3Panel;
    private javax.swing.JPanel player4Panel;
    private javax.swing.JLabel textoLabel;
    private javax.swing.JPanel textoPanel;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JLabel tituloLabel2;
    private javax.swing.JPanel tituloPanel;
    private javax.swing.JPanel tituloPanel2;
    // End of variables declaration//GEN-END:variables
}
