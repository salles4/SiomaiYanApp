
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

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
        setCategCombBox();
    }

    private void setScrollSpeed() {
        ScrollPane.getVerticalScrollBar().setUnitIncrement(25);
        //ScrollPane.getVerticalScrollBar().setBlockIncrement(110);
    }

    @SuppressWarnings("CollectionsToArray")
    private void setCategCombBox() {
        ArrayList<String> categoriesList = new ArrayList<>();
        categoriesList.add("All");
        SQLiteJava.SQLiteSelect("select name from categories  where visible = 1 order by id", categoriesList);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(categoriesList.toArray(new String[0])));
    }
    final String[] SORTSTRINGS = {"stock_diff", "price", "name", "id"};
    final String[] ORDER = {"asc", "desc"};

    public final void ListProducts() {
        int SortedBy = jComboBox1.getSelectedIndex();
        int ascDesc = jComboBox2.getSelectedIndex();
        int categFilter = jComboBox3.getSelectedIndex() - 1;
        String searchText = textSearchField.getText().toLowerCase().strip();
        System.out.println(categFilter);
        if (categFilter != -1) {
            if (!searchText.isEmpty()) {
                SQLiteJava.SQLiteRS("SELECT p.*, d.category FROM products p JOIN products_details d ON p.id = d.product_id "
                        + "WHERE category = " + categFilter + " and (LOWER(name) LIKE '" + searchText + "%' OR "
                        + "LOWER(name) LIKE '%" + searchText + "%') ORDER BY CASE WHEN LOWER(name) LIKE '"
                        + searchText + "%' THEN 0 ELSE 1 END, " + SORTSTRINGS[SortedBy] + " " + ORDER[ascDesc], this);
            } else {
                SQLiteJava.SQLiteRS("select p.*, d.category FROM products p JOIN products_details d ON p.id = d.product_id "
                        + "WHERE category = " + categFilter + " order by " + SORTSTRINGS[SortedBy] + " " + ORDER[ascDesc], this);
            }
        } else {
            if (!searchText.isEmpty()) {
                SQLiteJava.SQLiteRS("SELECT * FROM products WHERE LOWER(name) LIKE '" + searchText + "%' OR "
                        + "LOWER(name) LIKE '%" + searchText + "%' ORDER BY CASE WHEN LOWER(name) LIKE '"
                        + searchText + "%' THEN 0 ELSE 1 END, " + SORTSTRINGS[SortedBy] + " " + ORDER[ascDesc], this);
            } else {
                SQLiteJava.SQLiteRS("select * from products order by " + SORTSTRINGS[SortedBy] + " " + ORDER[ascDesc], this);
            }
        }
        revalidate();
        repaint();
    }

    private void AddProduct(String[] data) {
        AddModifyProduct addProd = new AddModifyProduct();

        if (data != null) {
            AddSetText(addProd, data);
        }

        addProd.IDField.setText(Integer.parseInt(SQLiteJava.SQLiteSelect("select id from products order by id desc limit 1")) + 1 + "");

        int response = JOptionPane.showOptionDialog(this, addProd, "Add Product", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, -1);

        if (response == JOptionPane.OK_OPTION) {
            String[] dataIn = {
                addProd.ProdNameField.getText(),
                addProd.StockField.getText(),
                addProd.WarningField.getText(),
                addProd.priceField.getText(),
                addProd.brandField.getText(),
                String.valueOf(addProd.categoryField.getSelectedIndex()),
                String.valueOf(addProd.retailerField.getSelectedIndex())
            };
            System.out.println(Arrays.toString(dataIn));
            boolean blanked = false;
            for (int i = 0; i < dataIn.length; i++) {
                if (dataIn[i].isBlank()) {
                    if (i == 3 || i == 4) {
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

            String[] productsIn = {dataIn[0], dataIn[1], dataIn[2], dataIn[3]};
            dataIn[3] = dataIn[3].equals("0") || dataIn[3].isBlank() ? null : dataIn[3];
            String[] moredetailsIn = {dataIn[4], dataIn[5], dataIn[6]};
            
            
            
            SQLiteJava.SQLitePrepare("insert into products (name,amount,min_stock,price) "
                    + "values (?,?,?,?)", productsIn);
            SQLiteJava.SQLitePrepare("insert into products_details (product_id,brand,category,retailer)"
                    + "values ((select id from products order by id desc limit 1),?,?,?) ", moredetailsIn);
            SQLiteJava.SQLite("update products set price = null where price = 0 or price = ''");
            
            String productID = SQLiteJava.SQLiteSelect("select id from products order by id desc limit 1");
            
            SQLiteJava.SQLiteLog("Added "+dataIn[0]+" (ID: "+productID+") to database with these data:\n\t"+Arrays.toString(dataIn), "Add Product");
            SQLiteJava.LogProduct(productID+"", "Created Product with this details: \n"+Arrays.toString(dataIn));
            
            if (!addProd.selectedImagePath.equals("/img/defIMG.png")) {
                File READfile = new File(addProd.selectedImagePath);
                File destinationFile = new File("src/img/product_img/" + SQLiteJava.SQLiteSelect("select id from products order by id desc limit 1") + ".jpg");

                try {
                    if (destinationFile.exists()) {
                        destinationFile.delete();
                    }
                    BufferedImage readimage = ImageIO.read(READfile);
                    ImageIO.write(readimage, "jpg", destinationFile);
                } catch (IOException e) {
                    System.out.println("Error copying and converting image: " + e.getMessage());
                }
            }

            JOptionPane.showMessageDialog(this, dataIn[0] + " has been successfully added to database!",
                    "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void AddSetText(AddModifyProduct addprod, String[] data) {
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

        jButton3 = new javax.swing.JButton();
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
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jButton3.setText("Retailers");

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

        jButton2.setText("Categories");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Category:");

        jButton5.setText("CSV");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textSearchField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JDialog dialog = new JDialog();
        dialog.setTitle("Categories");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setLayout(new java.awt.BorderLayout());
        dialog.add(new categoriesListPanel(), java.awt.BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        setCategCombBox();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        ListProducts();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        printPv pv = new printPv();

        JOptionPane.showOptionDialog(this, pv, "Print",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, null, -1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Destination Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String selectedFolderPath = fileChooser.getSelectedFile().getAbsolutePath();
            String csvFilePath = selectedFolderPath + "\\table_data.csv";
            try {
                writeTableToCsv(new printPv().jTable1, csvFilePath, true);
                JOptionPane.showMessageDialog(this, "CSV saved successfully at\n"+csvFilePath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while saving CSV\n"+ex.getMessage(),"ERROR",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    private void writeTableToCsv(JTable table, String filePath, boolean includeHeaders) throws IOException {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        try (FileWriter writer = new FileWriter(filePath)) {
            if (includeHeaders) {
                for (int col = 0; col < columnCount; col++) {
                    writer.append(escapeSpecialCharacters(model.getColumnName(col)));
                    if (col < columnCount - 1) {
                        writer.append(',');
                    }
                }
                writer.append('\n');
            }

            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    Object value = model.getValueAt(row, col);
                    writer.append(escapeSpecialCharacters(value != null ? value.toString() : ""));
                    if (col < columnCount - 1) {
                        writer.append(',');
                    }
                }
                writer.append('\n');
            }
        }
    }

    // Helper method to escape special characters in CSV values
    private String escapeSpecialCharacters(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("'")) {
            value = value.replace("\"", "\"\"");
            value = "\"" + value + "\"";
        }
        return value;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    public javax.swing.JPanel ScrollPanel;
    private ImageTemplate imageTemplate1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textSearchField;
    // End of variables declaration//GEN-END:variables
}
