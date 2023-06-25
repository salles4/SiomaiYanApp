
import java.awt.Color;
import javax.swing.JOptionPane;


public class EmployeeItemPanel extends javax.swing.JPanel {
    
    EmployeePanel employeePanel;
    String id;
    //data = {"name",  "amount", "sold", "return", "product_id"}
    public EmployeeItemPanel(String[] data, int num, EmployeePanel employeePanel) {
        initComponents();
        nameLabel.setText(data[0]);
    /*    AssignedStockLabel.setText("Assigned: "+data[1]);
        SoldStockLabel.setText("Sold: "+data[2]);
        ReturnStockLabel.setText("Returning: "+data[3]); */
        AssignedStockLabel.setText(data[1]);
        SoldStockLabel.setText(data[2]);
        ReturnStockLabel.setText(data[3]);
        numLabel.setText(num+1+".");
        if(new java.io.File("src/img/product_img/"+data[4]+".jpg").exists()){
            imageLabel.setIcon(new javax.swing.ImageIcon("src/img/product_img/"+data[4]+".jpg")); // NOI18N
        }       
        this.employeePanel = employeePanel;
        id = data[4];
    }
    private void initData(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientBG1 = new gradientBG();
        imageLabel = new ImageTemplate();
        nameLabel = new javax.swing.JLabel();
        AssignedStockLabel = new javax.swing.JLabel();
        SoldStockLabel = new javax.swing.JLabel();
        ReturnStockLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        numLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        gradientBG1.setBackground(new java.awt.Color(204, 204, 255));
        gradientBG1.setForeground(new java.awt.Color(255, 73, 73));
        gradientBG1.setFocusable(false);
        gradientBG1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradientBG1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradientBG1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gradientBG1MousePressed(evt);
            }
        });

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/defIMG.png"))); // NOI18N

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameLabel.setText("jLabel1");

        AssignedStockLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AssignedStockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AssignedStockLabel.setText("21");

        SoldStockLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        SoldStockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SoldStockLabel.setText("20");

        ReturnStockLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ReturnStockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReturnStockLabel.setText("20");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButton1.setText("●●●");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        numLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numLabel.setText("12.");

        javax.swing.GroupLayout gradientBG1Layout = new javax.swing.GroupLayout(gradientBG1);
        gradientBG1.setLayout(gradientBG1Layout);
        gradientBG1Layout.setHorizontalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(numLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(AssignedStockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SoldStockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReturnStockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        gradientBG1Layout.setVerticalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(AssignedStockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SoldStockLabel)
                .addComponent(ReturnStockLabel))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBG1Layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(numLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void gradientBG1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradientBG1MouseEntered
        gradientBG1.lightenDarken(-40);
        jButton1.setForeground(new Color(0xDDDDDD));
    }//GEN-LAST:event_gradientBG1MouseEntered

    private void gradientBG1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradientBG1MouseExited
        gradientBG1.lightenDarken(40);
        jButton1.setForeground(Color.black);
    }//GEN-LAST:event_gradientBG1MouseExited
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        soldPopUp();
    }//GEN-LAST:event_formMousePressed

    private void gradientBG1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradientBG1MousePressed
        soldPopUp();
    }//GEN-LAST:event_gradientBG1MousePressed
    private void soldPopUp(){
        SoldInputPanel soldPop = new SoldInputPanel();
        
        soldPop.AssignedAmountLabel.setText(AssignedStockLabel.getText()+"  ");
        soldPop.assignedAmount = Integer.parseInt(AssignedStockLabel.getText());
        soldPop.SoldAmountField.setText(SoldStockLabel.getText());
        soldPop.RemainStockField.setText(ReturnStockLabel.getText());
        soldPop.productTitleLabel.setText(nameLabel.getText());
        if(new java.io.File("src/img/product_img/"+id+".jpg").exists())
            soldPop.productImage.setIcon(new javax.swing.ImageIcon("src/img/product_img/"+id+".jpg")); // NOI18N
        
        int response = JOptionPane.showOptionDialog(employeePanel, soldPop, "", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, null, -1);
        
        if (response == JOptionPane.OK_OPTION){
            String sold = soldPop.SoldAmountField.getText();
            SQLiteJava.SQLite("update carts set sold = "+sold+" where product_id = "+id+" and cart = "+employeePanel.CARTASSIGNED);
            employeePanel.initData();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssignedStockLabel;
    private javax.swing.JLabel ReturnStockLabel;
    private javax.swing.JLabel SoldStockLabel;
    private gradientBG gradientBG1;
    private ImageTemplate imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel numLabel;
    // End of variables declaration//GEN-END:variables
}
