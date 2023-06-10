
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Salles
 */
public class ItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form ItemPanel
     */
    int stock = 0;
    int id;
    double warn = 0;
    public ItemPanel() {
        initComponents();
    }
    //data[] = ID, Name, Stocks, Price,
    public ItemPanel(String[] data) {
        initComponents();
        this.stock = Integer.parseInt(data[2]);
        this.id = Integer.parseInt(data[0]);
        warn = Double.parseDouble(data[4]);
        setBG();
        stockLabel.setText("Stock: "+ stock);
        prodName.setText(data[1]);
        prodID.setText("ID#"+id);
        if(data[3] != null){
            priceLabel.setText("₱"+data[3]);
        }else{
            priceLabel.setText("");
        }
        minStock.setText("Warning at: "+data[4]);
        
    }
    private void setBG(){
        if(stock < warn){ //2 <20
            gradientBG.changeColor(new Color(0xff5555));
            stockLabel.setForeground(Color.red);
            stockLabel.setFont(new java.awt.Font(stockLabel.getFont().getFontName(), java.awt.Font.BOLD, stockLabel.getFont().getSize()));
        }else if(stock>warn){// 2 > 20
            gradientBG.changeColor(Color.green);
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
        minStock = new javax.swing.JLabel();

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton1.setText("●●●");
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

        prodID.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        prodID.setText("ID#123123");

        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        priceLabel.setText("₱");
        priceLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        minStock.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        minStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        minStock.setText("Warning at:");
        minStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout gradientBGLayout = new javax.swing.GroupLayout(gradientBG);
        gradientBG.setLayout(gradientBGLayout);
        gradientBGLayout.setHorizontalGroup(
            gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBGLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prodName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gradientBGLayout.createSequentialGroup()
                        .addComponent(prodID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minStock, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(stockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        gradientBGLayout.setVerticalGroup(
            gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBGLayout.createSequentialGroup()
                .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gradientBGLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prodName)
                        .addGap(0, 0, 0)
                        .addComponent(prodID))
                    .addGroup(gradientBGLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(gradientBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(gradientBGLayout.createSequentialGroup()
                                .addComponent(stockLabel)
                                .addGap(0, 0, 0)
                                .addComponent(minStock)))))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void createDetailsFrame(){
        DetailsPage details = new DetailsPage();
        details.setLocationRelativeTo(this);
        details.setVisible(true);
        details.stockAmt = stock;
        details.productName = prodName.getText();
        details.setTitle("Product: " + prodName.getText());
        details.setProductDetails();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createDetailsFrame();
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
        createDetailsFrame();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gradientBG gradientBG;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel minStock;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel prodID;
    private javax.swing.JLabel prodName;
    private javax.swing.JLabel stockLabel;
    // End of variables declaration//GEN-END:variables
}
