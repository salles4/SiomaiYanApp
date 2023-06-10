
import java.awt.Color;
public class CartItemsPanel extends javax.swing.JPanel {
    int stock = 0;
    int id;
    int type = 0;
    CartPanel cartPanel;
    public CartItemsPanel() {
        initComponents();
    }
    //data[] = ID, Name, Stocks, 
    //!type 1 = unsaved | 2 = supply | 3 = inventory
    public CartItemsPanel(String[] data, CartPanel cartPanel, int type) {
        initComponents();
        this.stock = Integer.parseInt(data[2]);
        this.id = Integer.parseInt(data[0]);
        this.type = type;
        this.cartPanel = cartPanel;
        stockLabel.setText("Stock: "+ stock);
        prodName.setText(data[1]);
        prodID.setText(id+".");
        
        priceLabel.setText("");
        setBG();
        
    }
    private void ClickedFunction(){
        String[] data = {String.valueOf(id), prodName.getText(), "1"};
        for (String[] i : cartPanel.unsavedArray){
            if (i[0].equals(String.valueOf(id))){
                i[2] = String.valueOf(1 + Integer.parseInt(i[2]));
                cartPanel.ListData();
                return;
            }
        }
        cartPanel.unsavedArray.add(data);
        cartPanel.ListData();
        
    }
    private void setBG(){
        //type 1 = unsaved | 2 = supply | 3 = inventory
        switch (type){
            case 3 -> gradientBG.changeColor(new Color(0xff5555));
            case 2 -> gradientBG.changeColor(new Color(0x5555ff));
            case 1 -> {
                gradientBG.setForeground(Color.WHITE); 
                gradientBG.setBackground(Color.gray);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientBG = new gradientBG();
        jButton1 = new javax.swing.JButton();
        stockLabel = new javax.swing.JLabel();
        prodName = new javax.swing.JLabel();
        prodID = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        gradientBG.setForeground(new java.awt.Color(204, 204, 204));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButton1.setToolTipText("Add to Cart Supplies");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        stockLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stockLabel.setText("Stock:");
        stockLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        prodName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodName.setText("Siomai");

        prodID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        prodID.setText("1.");

        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        priceLabel.setText("₱");
        priceLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout gradientBGLayout = new javax.swing.GroupLayout(gradientBG);
        gradientBG.setLayout(gradientBGLayout);
        gradientBGLayout.setHorizontalGroup(
            gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prodName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );
        gradientBGLayout.setVerticalGroup(
            gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(gradientBGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prodID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prodName)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ClickedFunction();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton1MouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        gradientBG.lightenDarken(-20);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        gradientBG.lightenDarken(20);
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        ClickedFunction();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gradientBG gradientBG;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel prodID;
    private javax.swing.JLabel prodName;
    private javax.swing.JLabel stockLabel;
    // End of variables declaration//GEN-END:variables
}
