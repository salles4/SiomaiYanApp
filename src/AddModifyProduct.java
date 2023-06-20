
import java.io.File;
import javax.swing.JFileChooser;


/**
 *
 * @author Salles
 */
public class AddModifyProduct extends javax.swing.JPanel {

    String selectedImagePath = "/img/defIMG.png";
    public AddModifyProduct() {
        initComponents();
        removeImage.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ProdNameField = new javax.swing.JTextField();
        StockField = new javax.swing.JTextField();
        WarningField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        imageTemplateNoSclr1 = new ImageTemplateNoSclr();
        retailerField = new javax.swing.JComboBox<>();
        categoryField = new javax.swing.JComboBox<>();
        brandField = new javax.swing.JTextField();
        IDField = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        removeImage = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Product Name:");

        jLabel2.setText("ID:");

        jLabel3.setText("Buying Price:");

        jLabel4.setText("Notify if stock is below:");

        jLabel5.setText("Inventory Stock:");

        jLabel7.setText("Brand:");

        jLabel6.setText("Category:");

        jLabel10.setText("Retailer:");

        imageTemplateNoSclr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/defIMG.png"))); // NOI18N
        imageTemplateNoSclr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imageTemplateNoSclr1MousePressed(evt);
            }
        });

        retailerField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        categoryField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        IDField.setText("Generated After");

        jLabel12.setText("Product Picture:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel13.setText("(click image to change picture)");

        removeImage.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        removeImage.setText("Remove Image");
        removeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(removeImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProdNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDField)
                    .addComponent(retailerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WarningField)
                    .addComponent(priceField)
                    .addComponent(imageTemplateNoSclr1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {IDField, ProdNameField, StockField, WarningField, brandField, categoryField, priceField, retailerField});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel12, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ProdNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(StockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(WarningField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(brandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(retailerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageTemplateNoSclr1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel13)
                        .addGap(6, 6, 6)
                        .addComponent(removeImage)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageTemplateNoSclr1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageTemplateNoSclr1MousePressed
        JFileChooser fileChoose = new JFileChooser();
        
        int response = fileChoose.showOpenDialog(this);
        
        if (response == JFileChooser.APPROVE_OPTION){
            selectedImagePath = fileChoose.getSelectedFile().getAbsolutePath();
            imageTemplateNoSclr1.setIcon(new javax.swing.ImageIcon(selectedImagePath));
            removeImage.setVisible(true);
            /*
            File READfile = new File(fileChoose.getSelectedFile().getAbsolutePath());
            File destinationFile = new File("src/img/product_img/"+productID+".jpg");
            
            System.out.println(READfile);
            System.out.println(destinationFile);
            try {
                System.out.println("tried to write");
                if(destinationFile.exists()) destinationFile.delete();
                BufferedImage readimage = ImageIO.read(READfile);
                ImageIO.write(readimage, "jpg", destinationFile);
                System.out.println("written");
                System.out.println(destinationFile.exists());
                newimageWarningLabel.setVisible(true);
                time.start();
            } catch (IOException e) {
                System.out.println("Error copying and converting image: " + e.getMessage());
            }*/
            
        }
    }//GEN-LAST:event_imageTemplateNoSclr1MousePressed

    private void removeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeImageActionPerformed
        imageTemplateNoSclr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/defIMG.png")));
        selectedImagePath = "/img/defIMG.png";
        removeImage.setVisible(false);
    }//GEN-LAST:event_removeImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel IDField;
    javax.swing.JTextField ProdNameField;
    javax.swing.JTextField StockField;
    javax.swing.JTextField WarningField;
    javax.swing.JTextField brandField;
    javax.swing.JComboBox<String> categoryField;
    ImageTemplateNoSclr imageTemplateNoSclr1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    javax.swing.JTextField priceField;
    private javax.swing.JButton removeImage;
    javax.swing.JComboBox<String> retailerField;
    // End of variables declaration//GEN-END:variables
}
