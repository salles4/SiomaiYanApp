
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CartPanel extends javax.swing.JPanel {
    final int CARTNUMBER;
    /*
    public CartPanel() {
        initComponents();
        setScrollSpeed();
        syncDataToList();
        ListData();
        AssignWorker();
    }*/
    public CartPanel(int cartnum) {
        CARTNUMBER = cartnum;
        initComponents();
        setScrollSpeed();
        syncDataToList();
        ListData();
        AssignWorker();
        
    }
    // id of product : name of product : amount in array
    // index guide to these three arrays
    ArrayList<String[]> inventoryArray = new ArrayList<>();
    ArrayList<String[]> cartArray = new ArrayList<>();
    public ArrayList<String[]> unsavedArray = new ArrayList<>();
    private final String[] dataToGetinInventory = {"id", "name", "amount"};
    private final String[] dataToGetinCart = {"product_id", "name", "amount"};
    int ctr = 0;

    public final void syncDataToList() {
        SQLiteJava.SQLiteRS("select * from products", inventoryArray, dataToGetinInventory);
        SQLiteJava.SQLiteRS("select product_id, name, visible, c.amount from carts c "
                + "join products p on c.product_id = p.id where cart = "+CARTNUMBER+" order by p.id", cartArray, dataToGetinCart);
    }

    public final void ListData() {
        
        SuppliesPanel.removeAll();
        InventoryPanel.removeAll();
        //List all unsaved in supply list
        if (!unsavedArray.isEmpty()) {
            ScrollPanelLabel unsaved = new ScrollPanelLabel(this);
            unsaved.jLabel1.setText("Unsaved Cart "+CARTNUMBER+" Changes:");
            SuppliesPanel.add(unsaved);
            ctr = 0;
            for (String[] i : unsavedArray) {
                ctr++;
                SuppliesPanel.add(new CartItemsPanel(i, this, 1, ctr));
            }
            ScrollPanelLabel supplyList = new ScrollPanelLabel(this);
            supplyList.jLabel1.setText("Supplies:");
            supplyList.jButton1.setVisible(false);
            supplyList.jButton2.setVisible(false);
            SuppliesPanel.add(supplyList);
        }
        
        //List all supply of the cart in the supply list
        ctr = 0;
        for (String[] i : cartArray) {
            ctr++;
            SuppliesPanel.add(new CartItemsPanel(i, this, 2, ctr));
        }
        
        //list the inventory in inventory panel
        ctr = 0;
        for (String[] i : inventoryArray) {
            ctr++;
            InventoryPanel.add(new CartItemsPanel(i, this, 3, ctr));
        }

        InventoryPanel.revalidate();
        InventoryPanel.repaint();
        SuppliesPanel.revalidate();
        SuppliesPanel.repaint();
    }

    private void setScrollSpeed() {
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(55);
        //jScrollPane2.getVerticalScrollBar().setBlockIncrement(110);
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(55);
        //jScrollPane3.getVerticalScrollBar().setBlockIncrement(110);
    }

    //Assigned worker codes
    //AssignedWorkerData = id, name, number
    private final String[] workerDataGet = {"id", "name", "contact"};
    public final void AssignWorker(){
        String[] AssignedWorkerData = new String[3];
        assignWorkerPanel.removeAll();
        SQLiteJava.SQLiteRS("select * from accounts where cart = "+CARTNUMBER, AssignedWorkerData, workerDataGet);
        if (AssignedWorkerData[0] == null){
            assignWorkerPanel.add(new NoWorkerAssignedPanel(this));
        }else{
            assignWorkerPanel.add(new AssignedWorkerPanel(this, AssignedWorkerData));
        }
        assignWorkerPanel.repaint();
        assignWorkerPanel.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InventoryPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SuppliesPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imageTemplate1 = new ImageTemplate();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        gradientBG1 = new gradientBG();
        assignWorkerPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel3.setText("Search:");

        jLabel4.setText("Search:");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1039, 512));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText(" Inventory:");

        InventoryPanel.setLayout(new javax.swing.BoxLayout(InventoryPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(InventoryPanel);

        SuppliesPanel.setLayout(new javax.swing.BoxLayout(SuppliesPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(SuppliesPanel);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cart Supplies:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 441, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stick_only.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Cart Management");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Plate Number: 810DYB");

        gradientBG1.setBackground(new java.awt.Color(204, 204, 204));
        gradientBG1.setForeground(new java.awt.Color(255, 255, 255));

        assignWorkerPanel.setOpaque(false);
        assignWorkerPanel.setLayout(new javax.swing.BoxLayout(assignWorkerPanel, javax.swing.BoxLayout.Y_AXIS));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("No Assigned Worker");
        assignWorkerPanel.add(jLabel6);

        jButton1.setText("Assign Worker");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        assignWorkerPanel.add(jButton1);

        javax.swing.GroupLayout gradientBG1Layout = new javax.swing.GroupLayout(gradientBG1);
        gradientBG1.setLayout(gradientBG1Layout);
        gradientBG1Layout.setHorizontalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientBG1Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(assignWorkerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        gradientBG1Layout.setVerticalGroup(
            gradientBG1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBG1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(assignWorkerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gradientBG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientBG1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] opt = {"Assign", "Cancel"};
        AssignWorker work = new AssignWorker();
        int response = JOptionPane.showOptionDialog(this, work, "Move to Cart",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, opt, -1);
        if(response != JOptionPane.OK_OPTION){
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InventoryPanel;
    private javax.swing.JPanel SuppliesPanel;
    javax.swing.JPanel assignWorkerPanel;
    private gradientBG gradientBG1;
    private ImageTemplate imageTemplate1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
