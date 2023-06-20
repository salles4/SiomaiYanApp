import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.sql.*;

public class MainJFrame extends javax.swing.JFrame {

    Connection conn;
    public MainJFrame() {
        conn = SQLiteJava.ConnDatabase();
        initComponents();
        nameTitleLabel.setText(accDetails.name);
        typeuserLabel.setText(accDetails.admin ? "Admin" : "Employee");
        tab2.setEnabled(accDetails.admin);
        
        CardSwitch(tab1, new ProductsPanel());
    }
    void CardSwitch(javax.swing.JButton button, javax.swing.JPanel panel){
        javax.swing.JButton[] tabs = {tab1, tab2, tab3, tab4};
        for (javax.swing.JButton i : tabs){
            if (i == button){
                i.setBackground(Color.GRAY);
            }else{
                i.setBackground(Color.WHITE);
            }
            i.repaint();
            i.revalidate();
            
            CardPanel.removeAll();
            CardPanel.add(panel);
            CardPanel.repaint();
            CardPanel.revalidate();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientBG1 = new gradientBG();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tab1 = new javax.swing.JButton();
        tab2 = new javax.swing.JButton();
        tab3 = new javax.swing.JButton();
        tab4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imageTemplate1 = new ImageTemplate();
        CardPanel = new javax.swing.JPanel();
        Panel_1 = new javax.swing.JPanel();
        imageTemplate2 = new ImageTemplate();
        nameTitleLabel = new javax.swing.JLabel();
        minExit = new ImageTemplate();
        minExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min = new javax.swing.JPanel();
        typeuserLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Siomai Yan!! App");
        setUndecorated(true);
        setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        gradientBG1.setBackground(new java.awt.Color(255, 51, 51));
        gradientBG1.setForeground(new java.awt.Color(153, 0, 0));

        jButton1.setText("Log Out");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(0, 1, 30, 14));

        tab1.setText("Products");
        tab1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab1.setFocusable(false);
        tab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1ActionPerformed(evt);
            }
        });
        jPanel1.add(tab1);

        tab2.setText("Accounts");
        tab2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab2.setFocusable(false);
        tab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab2ActionPerformed(evt);
            }
        });
        jPanel1.add(tab2);

        tab3.setText("Cart 1");
        tab3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab3.setFocusable(false);
        tab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab3ActionPerformed(evt);
            }
        });
        jPanel1.add(tab3);

        tab4.setText("Cart 2");
        tab4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab4.setFocusable(false);
        tab4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab4ActionPerformed(evt);
            }
        });
        jPanel1.add(tab4);

        jButton3.setText("Logs");
        jButton3.setFocusable(false);
        jPanel1.add(jButton3);

        jPanel2.setOpaque(false);

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_duced.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout gradientBG1Layout = new javax.swing.GroupLayout(gradientBG1);
        gradientBG1.setLayout(gradientBG1Layout);
        gradientBG1Layout.setHorizontalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gradientBG1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        gradientBG1Layout.setVerticalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        CardPanel.setLayout(new java.awt.CardLayout());

        Panel_1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Panel_1Layout = new javax.swing.GroupLayout(Panel_1);
        Panel_1.setLayout(Panel_1Layout);
        Panel_1Layout.setHorizontalGroup(
            Panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1059, Short.MAX_VALUE)
        );
        Panel_1Layout.setVerticalGroup(
            Panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        CardPanel.add(Panel_1, "card2");

        imageTemplate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/topPanel2.jpg"))); // NOI18N

        nameTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        nameTitleLabel.setText("Salles, Francis James E.");

        minExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/min_exit/stay_MinExit.png"))); // NOI18N
        minExit.setPreferredSize(new java.awt.Dimension(60, 30));
        minExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minExitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minExitMousePressed(evt);
            }
        });

        min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min.setOpaque(false);
        min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minMousePressed(evt);
            }
        });

        javax.swing.GroupLayout minLayout = new javax.swing.GroupLayout(min);
        min.setLayout(minLayout);
        minLayout.setHorizontalGroup(
            minLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        minLayout.setVerticalGroup(
            minLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout minExitLayout = new javax.swing.GroupLayout(minExit);
        minExit.setLayout(minExitLayout);
        minExitLayout.setHorizontalGroup(
            minExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minExitLayout.createSequentialGroup()
                .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
        );
        minExitLayout.setVerticalGroup(
            minExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        typeuserLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeuserLabel.setText("Admin");

        javax.swing.GroupLayout imageTemplate2Layout = new javax.swing.GroupLayout(imageTemplate2);
        imageTemplate2.setLayout(imageTemplate2Layout);
        imageTemplate2Layout.setHorizontalGroup(
            imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageTemplate2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeuserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minExit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        imageTemplate2Layout.setVerticalGroup(
            imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageTemplate2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(minExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(imageTemplate2Layout.createSequentialGroup()
                        .addComponent(nameTitleLabel)
                        .addGap(0, 0, 0)
                        .addComponent(typeuserLabel)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gradientBG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageTemplate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageTemplate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab1ActionPerformed
        CardSwitch(tab1, new ProductsPanel());
    }//GEN-LAST:event_tab1ActionPerformed

    private void tab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab2ActionPerformed
        CardSwitch(tab2, new AccountsPanel());
    }//GEN-LAST:event_tab2ActionPerformed

    private void tab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab3ActionPerformed
        CardSwitch(tab3, new CartPanel(1));
    }//GEN-LAST:event_tab3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    private java.awt.Point mouseDownCompCoords;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        java.awt.Point currCoords = evt.getLocationOnScreen();
        this.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        mouseDownCompCoords = evt.getPoint();
    }//GEN-LAST:event_formMousePressed
    private javax.swing.ImageIcon makeIcon(String path){
        return new javax.swing.ImageIcon(getClass().getResource("/img/min_exit/"+path));
    }
    private void minExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minExitMouseEntered
        minExit.setIcon(makeIcon("hover_Exit.png"));
    }//GEN-LAST:event_minExitMouseEntered

    private void minExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minExitMouseExited
        minExit.setIcon(makeIcon("stay_MinExit.png"));
    }//GEN-LAST:event_minExitMouseExited

    private void minMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseExited
        minExit.setIcon(makeIcon("stay_MinExit.png"));
    }//GEN-LAST:event_minMouseExited

    private void minMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseEntered
        minExit.setIcon(makeIcon("hover_Min.png"));
    }//GEN-LAST:event_minMouseEntered

    private void minExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minExitMouseClicked
        dispose();
    }//GEN-LAST:event_minExitMouseClicked

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        setState(MainJFrame.ICONIFIED);
    }//GEN-LAST:event_minMouseClicked

    private void minExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minExitMousePressed
        minExit.setIcon(makeIcon("pressed_Exit.png"));
    }//GEN-LAST:event_minExitMousePressed

    private void minMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMousePressed
        minExit.setIcon(makeIcon("pressed_Min.png"));
    }//GEN-LAST:event_minMousePressed

    private void tab4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tab4ActionPerformed
        CardSwitch(tab4, new CartPanel(2));
    }//GEN-LAST:event_tab4ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    break;
                }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JPanel Panel_1;
    private gradientBG gradientBG1;
    private ImageTemplate imageTemplate1;
    private ImageTemplate imageTemplate2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel min;
    private ImageTemplate minExit;
    private javax.swing.JLabel nameTitleLabel;
    private javax.swing.JButton tab1;
    private javax.swing.JButton tab2;
    private javax.swing.JButton tab3;
    private javax.swing.JButton tab4;
    private javax.swing.JLabel typeuserLabel;
    // End of variables declaration//GEN-END:variables
}
