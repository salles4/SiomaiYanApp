/**
 *
 * @author Salles
 */
public class SoldInputPanel extends javax.swing.JPanel {
    
    int assignedAmount;
    public SoldInputPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SoldAmountField = new javax.swing.JTextField();
        AssignedAmountLabel = new javax.swing.JLabel();
        RemainStockField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        productImage = new ImageTemplate();
        jLabel5 = new javax.swing.JLabel();
        productTitleLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Assigned to Cart:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Sold Amount:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Remaining Stock:");

        SoldAmountField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        SoldAmountField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        SoldAmountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SoldAmountFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SoldAmountFieldKeyTyped(evt);
            }
        });

        AssignedAmountLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        AssignedAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AssignedAmountLabel.setText("100 ");

        RemainStockField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        RemainStockField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        RemainStockField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RemainStockFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RemainStockFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(AssignedAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoldAmountField, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(RemainStockField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AssignedAmountLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SoldAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(RemainStockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        productImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/product_img/default.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Cart Supply Management");

        productTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productTitleLabel.setText("Siomai (Pork)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(productTitleLabel))
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(productTitleLabel)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(79, 79, 79))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SoldAmountFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SoldAmountFieldKeyReleased
        if (SoldAmountField.getText().isBlank()) SoldAmountField.setText("0");
        
        int sold = Integer.parseInt(SoldAmountField.getText());
        if(sold > assignedAmount){
            javax.swing.JOptionPane.showMessageDialog(this, "Please input not exceeding assigned stock",
                    "Insufficient Stock",javax.swing.JOptionPane.WARNING_MESSAGE);
            SoldAmountField.setText("0");
            RemainStockField.setText(assignedAmount+"");
            return;
        }
        RemainStockField.setText(assignedAmount - sold + "");
        
        String soldStockText = SoldAmountField.getText();
        if (soldStockText.startsWith("0") && !soldStockText.equals("0")) {
            soldStockText = soldStockText.substring(1); 
            SoldAmountField.setText(soldStockText); 
        }
    }//GEN-LAST:event_SoldAmountFieldKeyReleased

    private void RemainStockFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RemainStockFieldKeyReleased
        if (RemainStockField.getText().isBlank()) RemainStockField.setText("0");
        int returnStock = Integer.parseInt(RemainStockField.getText());
        if(returnStock > assignedAmount){
            javax.swing.JOptionPane.showMessageDialog(this, "Please input not exceeding assigned stock",
                    "Insufficient Stock",javax.swing.JOptionPane.WARNING_MESSAGE);
            SoldAmountField.setText("0");
            RemainStockField.setText(assignedAmount + "");
            return;
        }
        SoldAmountField.setText(assignedAmount - returnStock+"");
        
        String remainStockText = RemainStockField.getText();
        if (remainStockText.startsWith("0") && !remainStockText.equals("0")) {
            remainStockText = remainStockText.substring(1); 
            RemainStockField.setText(remainStockText); 
        }
        
    }//GEN-LAST:event_RemainStockFieldKeyReleased

    private void SoldAmountFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SoldAmountFieldKeyTyped
        typedRegEx(evt);
    }//GEN-LAST:event_SoldAmountFieldKeyTyped

    private void RemainStockFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RemainStockFieldKeyTyped
        typedRegEx(evt);
    }//GEN-LAST:event_RemainStockFieldKeyTyped
    void typedRegEx(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel AssignedAmountLabel;
    javax.swing.JTextField RemainStockField;
    javax.swing.JTextField SoldAmountField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    ImageTemplate productImage;
    javax.swing.JLabel productTitleLabel;
    // End of variables declaration//GEN-END:variables
}
