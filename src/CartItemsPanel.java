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
    public CartItemsPanel(String[] data, CartPanel cartPanel, int type, int num) {
        initComponents();
        this.stock = Integer.parseInt(data[2]);
        this.id = Integer.parseInt(data[0]);
        this.type = type;
        this.cartPanel = cartPanel;
        stockLabel.setText("Stock: " + stock);
        prodID.setText(num + ".");
        prodName.setText(data[1]);
        priceLabel.setText("");

        switch (type) { //type 1 = unsaved | 2 = supply | 3 = inventory
            case 3 -> initInventory();
            case 2 -> initCart(); 
            case 1 -> initUnsaved();
        }
    }

    private void initUnsaved() {
        rightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png")));
        gradientBG.setForeground(new Color(0xaaaaaa));
        gradientBG.setBackground(new Color(0xffffff));
        stockLabel.setFont(new java.awt.Font(stockLabel.getFont().getFontName(),
                java.awt.Font.BOLD, stockLabel.getFont().getSize()));
        leftButton.setToolTipText("Return Supply");
        if (stock > 0) {
            //stockLabel.setForeground(new Color(0x55ff55));
            gradientBG.setForeground(new Color(0xaaaaff));
            stockLabel.setText("Adding: " + stock);
        } else if (stock < 0) {
            //stockLabel.setForeground(Color.red);
            gradientBG.setForeground(new Color(0xffaaaa));
            stockLabel.setText("Removing: " + -1 * stock);
        }
    }

    private void initCart() {
        buttons_panel.remove(leftButton);
        buttons_panel.remove(rightButton);
        middleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return.png")));
        middleButton.setToolTipText("Return Supply");
        gradientBG.setForeground(new Color(0x00ffff));
        gradientBG.setBackground(new Color(0x0072FF));
    }

    private void initInventory() {
        buttons_panel.remove(leftButton);
        buttons_panel.remove(rightButton);
        gradientBG.setForeground(new Color(0xFFCDC9));
        gradientBG.setBackground(new Color(0xFF6060));
    }

    private void ClickedFunction() {
        switch (type) { //type 1 = unsaved | 2 = supply | 3 = inventory
            case 3 ->
                inventoryAction();
            case 2 ->
                cartAction(); // cart items
            case 1 ->
                cartAction(); // unsaved items
        }
    }

    private void inventoryAction() {
        String[] data = {String.valueOf(id), prodName.getText(), "1"};
        for (String[] i : cartPanel.unsavedArray) {
            if (i[0].equals(String.valueOf(id))) {
                i[2] = String.valueOf(1 + Integer.parseInt(i[2]));
                cartPanel.ListData();
                return;
            }
        }
        cartPanel.unsavedArray.add(data);
        cartPanel.ListData();
    }

    private void cartAction() {
        String[] data = {String.valueOf(id), prodName.getText(), "-1"};
        for (String[] i : cartPanel.unsavedArray) {
            if (i[0].equals(String.valueOf(id))) {
                i[2] = String.valueOf(Integer.parseInt(i[2]) - 1);
                if (i[2].equals("0")) {
                    cartPanel.unsavedArray.remove(i);
                }
                cartPanel.ListData();
                return;
            }
        }
        cartPanel.unsavedArray.add(data);
        cartPanel.ListData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priceLabel = new javax.swing.JLabel();
        gradientBG = new gradientBG();
        stockLabel = new javax.swing.JLabel();
        prodName = new javax.swing.JLabel();
        prodID = new javax.swing.JLabel();
        buttons_panel = new javax.swing.JPanel();
        leftButton = new javax.swing.JButton();
        middleButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();

        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        priceLabel.setText("₱");
        priceLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        gradientBG.setForeground(new java.awt.Color(204, 204, 204));

        stockLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stockLabel.setText("Stock:");
        stockLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        prodName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodName.setText("Siomai");

        prodID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        prodID.setText("1.");

        buttons_panel.setOpaque(false);
        buttons_panel.setLayout(new java.awt.GridLayout(1, 3, 3, 0));

        leftButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return.png"))); // NOI18N
        leftButton.setToolTipText("Add Supply");
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        buttons_panel.add(leftButton);

        middleButton.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        middleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        middleButton.setToolTipText("Add to Cart Supplies");
        middleButton.setBorderPainted(false);
        middleButton.setContentAreaFilled(false);
        middleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        middleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                middleButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                middleButtonMouseExited(evt);
            }
        });
        middleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleButtonActionPerformed(evt);
            }
        });
        buttons_panel.add(middleButton);

        rightButton.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        rightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        rightButton.setToolTipText("Remove all");
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        buttons_panel.add(rightButton);

        javax.swing.GroupLayout gradientBGLayout = new javax.swing.GroupLayout(gradientBG);
        gradientBG.setLayout(gradientBGLayout);
        gradientBGLayout.setHorizontalGroup(
            gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(prodName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        gradientBGLayout.setVerticalGroup(
            gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(buttons_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(prodName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
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

    private void middleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleButtonActionPerformed
        ClickedFunction();
    }//GEN-LAST:event_middleButtonActionPerformed

    private void middleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_middleButtonMouseEntered
        middleButton.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_middleButtonMouseEntered

    private void middleButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_middleButtonMouseExited
        middleButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_middleButtonMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        gradientBG.lightenDarken(-20);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        gradientBG.lightenDarken(20);
    }//GEN-LAST:event_formMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        ClickedFunction();
    }//GEN-LAST:event_formMousePressed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        for (String[] i : cartPanel.unsavedArray) {
            if (i[0].equals(String.valueOf(id))) {
                cartPanel.unsavedArray.remove(i);
                cartPanel.ListData();
                return;
            }
        }
    }//GEN-LAST:event_rightButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttons_panel;
    private gradientBG gradientBG;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton middleButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel prodID;
    private javax.swing.JLabel prodName;
    private javax.swing.JButton rightButton;
    private javax.swing.JLabel stockLabel;
    // End of variables declaration//GEN-END:variables
}
