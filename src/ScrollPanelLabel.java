
import javax.swing.JOptionPane;

public class ScrollPanelLabel extends javax.swing.JPanel {

    CartPanel cartPanel;
    public ScrollPanelLabel() {
        initComponents();
    }
    public ScrollPanelLabel(CartPanel panel) {
        initComponents();
        this.cartPanel = panel;
        log = "Moved from/to the Cart #"+cartPanel.CARTNUMBER+":\n";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientBG1 = new gradientBG();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        gradientBG1.setBackground(new java.awt.Color(153, 153, 153));
        gradientBG1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placeholder Label");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton1.setText("Discard");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jButton2.setText("Save");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gradientBG1Layout = new javax.swing.GroupLayout(gradientBG1);
        gradientBG1.setLayout(gradientBG1Layout);
        gradientBG1Layout.setHorizontalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        gradientBG1Layout.setVerticalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cartPanel.unsavedArray.clear();
        cartPanel.ListData();
    }//GEN-LAST:event_jButton1ActionPerformed
    String log;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (String[] unsavedProduct : cartPanel.unsavedArray){ // id of product, name of product, amount in array
            
            int unsavedAmount = Integer.parseInt(unsavedProduct[2]);
            if (unsavedAmount != 0){
                SQLiteJava.SQLite("update products set amount = amount - "+unsavedAmount+" where id = " + unsavedProduct[0]);
                
                log = log +"\t"+ unsavedProduct[1]+" (ID:"+unsavedProduct[0]+") in "+"cart is adjusted by: "+unsavedAmount+"\n";
                SQLiteJava.LogProduct(unsavedProduct[0],"Adjusted in cart #"+cartPanel.CARTNUMBER+" supply by "+unsavedAmount);
                
                int updated = SQLiteJava.SQLiteExeUpdate("update carts set amount = amount + "+unsavedAmount+
                        " where cart = "+cartPanel.CARTNUMBER+" and product_id = " + unsavedProduct[0]);
                System.out.println(updated);
                if (updated < 1){
                    String[] toInsert = {unsavedProduct[0], unsavedProduct[2], cartPanel.CARTNUMBER+"" };
                    SQLiteJava.SQLitePrepare("insert into carts (product_id, amount, cart) values (?,?,?)", toInsert);
                }
            }
        }
        SQLiteJava.SQLiteLog(log, "Cart Supply");
        SQLiteJava.LogDisplay(log);
        SQLiteJava.SQLite("delete from carts where amount = 0");
        cartPanel.unsavedArray.clear();
        cartPanel.syncDataToList();
        cartPanel.ListData();
        cartPanel.repaint();
        cartPanel.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gradientBG gradientBG1;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
