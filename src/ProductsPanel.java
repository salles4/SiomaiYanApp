
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Salles
 */
public class ProductsPanel extends javax.swing.JPanel {


    public ProductsPanel() {
        initComponents();
        ListProducts();
        setScrollSpeed();
    }
    private void setScrollSpeed(){
        ScrollPane.getVerticalScrollBar().setUnitIncrement(55);
        //ScrollPane.getVerticalScrollBar().setBlockIncrement(110);
    }
    final String[] SORTSTRINGS = {"stock_diff", "price", "name", "id"};
    final String[] ORDER = {"asc","desc"};
    public final void ListProducts(){
        int SortedBy = jComboBox1.getSelectedIndex();
        int ascDesc = jComboBox2.getSelectedIndex();
        //SQLiteJava.SQLiteRS("select * from products order by "+SORTSTRINGS[SortedBy]+" "+ORDER[ascDesc], this);
        
        String searchText = textSearchField.getText().toLowerCase().strip();
        if(!searchText.isEmpty()){
            SQLiteJava.SQLiteRS("SELECT * FROM products WHERE LOWER(name) LIKE '" + searchText + "%' OR "
                    + "LOWER(name) LIKE '%" + searchText + "%' ORDER BY CASE WHEN LOWER(name) LIKE '"
                            + searchText +"%' THEN 0 ELSE 1 END, "+SORTSTRINGS[SortedBy]+" "+ORDER[ascDesc] , this);
        }else{
            SQLiteJava.SQLiteRS("select * from products order by "+SORTSTRINGS[SortedBy]+" "+ORDER[ascDesc], this);
        }
        revalidate();
        repaint();
    }
    private void AddProduct(String[] data){
        AddModifyProduct addProd = new AddModifyProduct();
        
        if (data!= null) AddSetText(addProd, data);
        
        addProd.IDField.setText(Integer.parseInt(SQLiteJava.SQLiteSelect
        ("select id from products order by id desc limit 1"))+1+"");
        
        int response = JOptionPane.showOptionDialog(this, addProd, "Add Product", JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.PLAIN_MESSAGE, null, null, -1);
        
        if (response == JOptionPane.OK_OPTION){
            String[] dataIn = {
                addProd.ProdNameField.getText(),
                addProd.StockField.getText(),
                addProd.WarningField.getText(),
                addProd.priceField.getText(),
                addProd.brandField.getText(),
                String.valueOf(addProd.categoryField.getSelectedIndex()),
                String.valueOf(addProd.retailerField.getSelectedIndex())
            };
            boolean blanked = false;
            for (int i = 0; i < dataIn.length; i++){
                if (dataIn[i].isBlank()){
                    if(i == 3 || i == 4){
                        continue;
                    }
                    blanked = true;
                }
            }
            if (blanked) {
                JOptionPane.showMessageDialog(this, "Fill all required fields.",
                    "", JOptionPane.WARNING_MESSAGE);
                AddProduct(dataIn);
                return;
            }
            SQLiteJava.SQLitePrepare("insert into products "
                    + "(name,amount,min_stock,price) values (?,?,?,?);"
                    + "insert into product_details (product_id,brand,category,retailer)"
                    + "values (select id from products order by id desc limit 1,?,?,? ", data);
        }
    }
    private void AddSetText(AddModifyProduct addprod, String[] data){
        addprod.ProdNameField.setText(data[0]);
        addprod.StockField.setText(data[1]);
        addprod.WarningField.setText(data[2]);
        addprod.priceField.setText(data[3]);
        addprod.brandField.setText(data[4]);
        addprod.categoryField.setSelectedIndex(Integer.parseInt(data[5]));
        addprod.retailerField.setSelectedIndex(Integer.parseInt(data[6]));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        ScrollPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textSearchField = new javax.swing.JTextField();
        imageTemplate1 = new ImageTemplate();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1039, 512));

        ScrollPanel.setLayout(new javax.swing.BoxLayout(ScrollPanel, javax.swing.BoxLayout.Y_AXIS));
        ScrollPane.setViewportView(ScrollPanel);

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Products");

        jButton1.setText("Add Product");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Stock", "Price", "Name", "ID" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Sort By:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Search:");

        textSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchFieldKeyReleased(evt);
            }
        });

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siomai_only.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollPane))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

        
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        ListProducts();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        ListProducts();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void textSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchFieldKeyReleased
        ListProducts();
    }//GEN-LAST:event_textSearchFieldKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddProduct(null);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    public javax.swing.JPanel ScrollPanel;
    private ImageTemplate imageTemplate1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textSearchField;
    // End of variables declaration//GEN-END:variables
}
