import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

public class MainJFrame extends javax.swing.JFrame {

    Connection conn;
    public MainJFrame() {
        conn = SQLiteJava.ConnDatabase();
        initComponents();
        nameTitleLabel.setText(accDetails.name);
        typeuserLabel.setText(accDetails.admin ? "Admin" : "Employee");
        accountsTab.setEnabled(accDetails.admin);
        setProfileImage();

        //setButtons();
       
        CardSwitch(productsTab, new ProductsPanel());
    }
    private void setProfileImage(){
        if(new java.io.File("src/img/account/"+accDetails.accnumber+".jpg").exists()){
            imageTemplate3.setIcon(new javax.swing.ImageIcon("src/img/account/"+accDetails.accnumber+".jpg"));
        }
    }
    void setButtons(){
        if(accDetails.admin){
            buttonsPanel.remove(cartTab);
        }else{
            buttonsPanel.removeAll();
            buttonsPanel.add(cartTab);
            
        }
    }
    private void CardSwitch(javax.swing.JButton button, javax.swing.JPanel panel){
        javax.swing.JButton[] tabs = {productsTab, accountsTab, cart1Tab, cart2Tab, cartTab, homeTab};
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
        buttonsPanel = new javax.swing.JPanel();
        productsTab = new javax.swing.JButton();
        accountsTab = new javax.swing.JButton();
        cart1Tab = new javax.swing.JButton();
        cart2Tab = new javax.swing.JButton();
        logsTab = new javax.swing.JButton();
        cartTab = new javax.swing.JButton();
        homeTab = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imageTemplate1 = new ImageTemplate();
        CardPanel = new javax.swing.JPanel();
        Panel_1 = new javax.swing.JPanel();
        imageTemplate2 = new ImageTemplate();
        nameTitleLabel = new javax.swing.JLabel();
        typeuserLabel = new javax.swing.JLabel();
        imageTemplate3 = new ImageTemplate();
        jPanel1 = new javax.swing.JPanel();
        minExit = new ImageTemplate();
        minExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min = new javax.swing.JPanel();

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

        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new java.awt.GridLayout(8, 1, 30, 14));

        productsTab.setText("Products");
        productsTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productsTab.setFocusable(false);
        productsTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsTabActionPerformed(evt);
            }
        });
        buttonsPanel.add(productsTab);

        accountsTab.setText("Accounts");
        accountsTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountsTab.setFocusable(false);
        accountsTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsTabActionPerformed(evt);
            }
        });
        buttonsPanel.add(accountsTab);

        cart1Tab.setText("Cart 1");
        cart1Tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cart1Tab.setFocusable(false);
        cart1Tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart1TabActionPerformed(evt);
            }
        });
        buttonsPanel.add(cart1Tab);

        cart2Tab.setText("Cart 2");
        cart2Tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cart2Tab.setFocusable(false);
        cart2Tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cart2TabActionPerformed(evt);
            }
        });
        buttonsPanel.add(cart2Tab);

        logsTab.setText("Logs");
        logsTab.setFocusable(false);
        buttonsPanel.add(logsTab);

        cartTab.setText("Cart");
        cartTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartTab.setFocusable(false);
        cartTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartTabActionPerformed(evt);
            }
        });
        buttonsPanel.add(cartTab);

        homeTab.setText("Home");
        homeTab.setFocusable(false);
        homeTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeTabActionPerformed(evt);
            }
        });
        buttonsPanel.add(homeTab);

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
                            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
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
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGap(0, 509, Short.MAX_VALUE)
        );

        CardPanel.add(Panel_1, "card2");

        imageTemplate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/topPanel2.jpg"))); // NOI18N

        nameTitleLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        nameTitleLabel.setText("Salles, Francis James E.");

        typeuserLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeuserLabel.setText("Admin");

        imageTemplate3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/defprof.jpg"))); // NOI18N

        jPanel1.setOpaque(false);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(minExit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minExit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout imageTemplate2Layout = new javax.swing.GroupLayout(imageTemplate2);
        imageTemplate2.setLayout(imageTemplate2Layout);
        imageTemplate2Layout.setHorizontalGroup(
            imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageTemplate2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(imageTemplate3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeuserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        imageTemplate2Layout.setVerticalGroup(
            imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageTemplate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(imageTemplate2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameTitleLabel)
                .addGap(0, 0, 0)
                .addComponent(typeuserLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(imageTemplate2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void productsTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsTabActionPerformed
        CardSwitch(productsTab, new ProductsPanel());
    }//GEN-LAST:event_productsTabActionPerformed

    private void accountsTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsTabActionPerformed
        CardSwitch(accountsTab, new AccountsPanel());
    }//GEN-LAST:event_accountsTabActionPerformed

    private void cart1TabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart1TabActionPerformed
        CardSwitch(cart1Tab, new CartPanel(1));
    }//GEN-LAST:event_cart1TabActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int response = JOptionPane.showOptionDialog(this, "Are you sure you want to Log Out?",
                "Log Out?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, null, -1);
        if(response == JOptionPane.YES_OPTION){
            dispose();
            new LogIn().setVisible(true);
        }
        
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

    private void cart2TabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cart2TabActionPerformed
        CardSwitch(cart2Tab, new CartPanel(2));
    }//GEN-LAST:event_cart2TabActionPerformed

    private void cartTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartTabActionPerformed
        CardSwitch(cartTab, new EmployeePanel());
    }//GEN-LAST:event_cartTabActionPerformed

    private void homeTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeTabActionPerformed
        CardSwitch(homeTab, new HomePanel());
    }//GEN-LAST:event_homeTabActionPerformed

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
    private javax.swing.JButton accountsTab;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cart1Tab;
    private javax.swing.JButton cart2Tab;
    private javax.swing.JButton cartTab;
    private gradientBG gradientBG1;
    private javax.swing.JButton homeTab;
    private ImageTemplate imageTemplate1;
    private ImageTemplate imageTemplate2;
    private ImageTemplate imageTemplate3;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logsTab;
    private javax.swing.JPanel min;
    private ImageTemplate minExit;
    private javax.swing.JLabel nameTitleLabel;
    private javax.swing.JButton productsTab;
    private javax.swing.JLabel typeuserLabel;
    // End of variables declaration//GEN-END:variables
}
