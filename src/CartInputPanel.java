public class CartInputPanel extends javax.swing.JPanel {

    /**
     *  Product is from the inventory
     */
    public final static int FROMINVENTORY = 1;

    /**
     * Product is from the cart
     */
    public final static int FROMCART = 2;
    int stock;
    public CartInputPanel(String productName,int amountToCompare, int type) {
        initComponents();
        prodName.setText(productName);
        stockLabel.setText(amountToCompare+"");
        stock = amountToCompare;
        switch (type){
            case FROMINVENTORY -> {
                TypeofStockLabel.setText("Stock in Inventory:");
                AmountToLabel.setText("Amount to supply:");
            }
            case FROMCART -> {
                TypeofStockLabel.setText("Stock in Cart");
                AmountToLabel.setText("Amount to return:");
            }
        }
    }
    public void setFieldText(String text){
        AmountTextField.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TypeofStockLabel = new javax.swing.JLabel();
        AmountToLabel = new javax.swing.JLabel();
        AmountTextField = new javax.swing.JTextField();
        prodName = new javax.swing.JLabel();
        imageTemplate1 = new ImageTemplate();
        stockLabel = new javax.swing.JLabel();

        TypeofStockLabel.setText("Inventory Stock:");

        AmountToLabel.setText("Amount to add:");

        AmountTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        AmountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmountTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AmountTextFieldKeyTyped(evt);
            }
        });

        prodName.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        prodName.setText("Siomai");

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boxInk32.png"))); // NOI18N

        stockLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stockLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stockLabel.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(prodName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AmountToLabel)
                            .addComponent(TypeofStockLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(prodName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeofStockLabel)
                    .addComponent(stockLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountToLabel)
                    .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AmountTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))
                || AmountTextField.getText().length() >= 11) {
            getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_AmountTextFieldKeyTyped

    private void AmountTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmountTextFieldKeyReleased
        if(AmountTextField.getText().isBlank()){
            return;
        }
        if (stock < Integer.parseInt(AmountTextField.getText())){
            javax.swing.JOptionPane.showMessageDialog(this, "Please input not exceeding your stock",
                    "Insufficient Stock",javax.swing.JOptionPane.WARNING_MESSAGE);
            AmountTextField.setText("");
        }
    }//GEN-LAST:event_AmountTextFieldKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JTextField AmountTextField;
    private javax.swing.JLabel AmountToLabel;
    private javax.swing.JLabel TypeofStockLabel;
    private ImageTemplate imageTemplate1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel prodName;
    private javax.swing.JLabel stockLabel;
    // End of variables declaration//GEN-END:variables
}
