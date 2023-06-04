import com.formdev.flatlaf.FlatIntelliJLaf;
import java.sql.*;

public class MainJFrame extends javax.swing.JFrame {

    Connection conn;

    public MainJFrame() {
        conn = SQLiteJava.ConnDatabase();
        initComponents();
        
    }
    void CardSwitch(javax.swing.JButton button, javax.swing.JPanel panel){
        javax.swing.JButton[] tabs = {tab1, tab2};
        for (javax.swing.JButton i : tabs){
            if (i == button){
                i.setContentAreaFilled(true);
            }else{
                i.setContentAreaFilled(false);
            }
            i.repaint();
            
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
        imageTemplate1 = new ImageTemplate();
        tab1 = new javax.swing.JButton();
        tab2 = new javax.swing.JButton();
        CardPanel = new javax.swing.JPanel();
        Panel_1 = new javax.swing.JPanel();
        imageTemplate2 = new ImageTemplate();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gradientBG1.setBackground(new java.awt.Color(255, 51, 51));
        gradientBG1.setForeground(new java.awt.Color(153, 0, 0));

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        tab1.setText("jButton1");
        tab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab1ActionPerformed(evt);
            }
        });

        tab2.setText("jButton2");
        tab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tab2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientBG1Layout = new javax.swing.GroupLayout(gradientBG1);
        gradientBG1.setLayout(gradientBG1Layout);
        gradientBG1Layout.setHorizontalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageTemplate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBG1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tab2)
                    .addComponent(tab1))
                .addGap(31, 31, 31))
        );
        gradientBG1Layout.setVerticalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(tab1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CardPanel.setLayout(new java.awt.CardLayout());

        Panel_1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Panel_1Layout = new javax.swing.GroupLayout(Panel_1);
        Panel_1.setLayout(Panel_1Layout);
        Panel_1Layout.setHorizontalGroup(
            Panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 891, Short.MAX_VALUE)
        );
        Panel_1Layout.setVerticalGroup(
            Panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        CardPanel.add(Panel_1, "card2");

        imageTemplate2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/topPanel2.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Welcome, Name!");

        javax.swing.GroupLayout imageTemplate2Layout = new javax.swing.GroupLayout(imageTemplate2);
        imageTemplate2.setLayout(imageTemplate2Layout);
        imageTemplate2Layout.setHorizontalGroup(
            imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageTemplate2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imageTemplate2Layout.setVerticalGroup(
            imageTemplate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imageTemplate2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton tab1;
    private javax.swing.JButton tab2;
    // End of variables declaration//GEN-END:variables
}
