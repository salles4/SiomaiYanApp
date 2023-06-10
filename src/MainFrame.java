

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author Salles
 */
public class MainFrame extends javax.swing.JFrame {
    
    private Connection conn;

    public MainFrame() {
        SQLiteJava.ConnectDatabase();
        conn = SQLiteJava.conn;
        //
        initComponents();
        //
        setAccDetails();
        increaseScrollSpeed();
    }
    
    private void setAccDetails(){
        nameLabel.setText("Name: "+ accDetails.username);
        IDLabel.setText("ID Number: "+ accDetails.accnumber);
        if(accDetails.admin){
            AccType.setText("Account Type: Admin");
        }else{
            AccType.setText("Account Type: Employee");
        }
    }
    

    void SQLiteRS(String command) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        ScrollPanel.removeAll();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM (" + command + ") where visible = 1");
            if (rs.next()) {
                do {
                    String[] row = {rs.getString("id"), rs.getString("name"),
                        rs.getString("amount"), rs.getString("price")};
                    ScrollPanel.add(new ItemPanel(row));
                    model.addRow(row);
                } while (rs.next());
            } else {
                System.out.println("Empty Data");
            }
            System.out.println("Data Listed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ScrollPanel.revalidate();
        ScrollPanel.repaint();
    }

    void SQLite(String command, String[] data) {
        try (PreparedStatement pStmt = conn.prepareStatement(command)) {
            for (int i = 0; i < data.length; i++) {
                pStmt.setString(i + 1, data[i]);
            }
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void SQLite(String command) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(command);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void UpdateTablewSearch() {
        String searchText = textSearchField.getText();
        if(!searchText.isEmpty()){
            SQLiteRS("SELECT * FROM products WHERE name LIKE '" + searchText + "%' "
                + "OR name LIKE '%" + searchText + "%' AND name NOT LIKE '"
                + searchText + "%' ORDER BY LENGTH(name) ASC");
        }else{
            SQLiteRS("select * from products");
        }
    }

    private void increaseScrollSpeed() {
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(55);
        jScrollPane2.getVerticalScrollBar().setBlockIncrement(110);
    }

    // <editor-fold defaultstate="collapsed" desc="unique ID generator">
    /* for future use (unique id generator)
    int GenerateID() {
        int tempID = new java.util.Random().nextInt(10000, 99999);
        for (String[] rowData : DataArrayList) {
            if (rowData[0].equals(String.valueOf(tempID))) {
                tempID = GenerateID();
            }
        }
        int uniqueID = tempID;
        return uniqueID;
    }*/
    // </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Remove = new javax.swing.JButton();
        jButton_Remove1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ScrollPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        textSearchField = new javax.swing.JTextField();
        jButton_NewData = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        jButton_Modify = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        AccType = new javax.swing.JLabel();
        manageButt = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        imageTemplate1 = new ImageTemplate();

        jButton_Remove.setText("Remove");
        jButton_Remove.setEnabled(false);
        jButton_Remove.setFocusable(false);
        jButton_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveActionPerformed(evt);
            }
        });

        jButton_Remove1.setText("-10");
        jButton_Remove1.setEnabled(false);
        jButton_Remove1.setFocusable(false);
        jButton_Remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Remove1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory System");
        setBackground(new java.awt.Color(0, 153, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        ScrollPanel.setLayout(new javax.swing.BoxLayout(ScrollPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(ScrollPanel);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(40);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Control Panel"));

        jLabel1.setLabelFor(textSearchField);
        jLabel1.setText("Search");

        textSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchFieldKeyReleased(evt);
            }
        });

        jButton_NewData.setText("New Data");
        jButton_NewData.setFocusable(false);
        jButton_NewData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NewDataActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jButton_Modify.setText("Modify");
        jButton_Modify.setEnabled(false);
        jButton_Modify.setFocusable(false);
        jButton_Modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSearchField, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Modify)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton_NewData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Modify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_NewData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Refresh)
                .addGap(24, 24, 24))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Account"));

        nameLabel.setText("Username: ey");

        IDLabel.setText("User ID: 1234567890");

        AccType.setText("Account Type: Admin");

        manageButt.setText("Manage Account");
        manageButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageButtActionPerformed(evt);
            }
        });

        LogOut.setBackground(new java.awt.Color(255, 102, 102));
        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDLabel)
                    .addComponent(AccType)
                    .addComponent(nameLabel)
                    .addComponent(manageButt)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(LogOut)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageButt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOut)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//initialize table
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SQLiteRS("select * from products");
    }//GEN-LAST:event_formWindowOpened

    private void textSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchFieldKeyReleased
        UpdateTablewSearch();
    }//GEN-LAST:event_textSearchFieldKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int SelectedRow = jTable1.getSelectedRow();
        if (SelectedRow < 0) {
            jButton_Modify.setEnabled(false);
            jButton_Remove.setEnabled(false);
            jButton_Remove1.setEnabled(false);
        } else {
            jButton_Remove1.setEnabled(true);
            jButton_Modify.setEnabled(true);
            jButton_Remove.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton_ModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ModifyActionPerformed
        int SelectedRow = jTable1.getSelectedRow();
        System.out.println(SelectedRow);
        String a = jTable1.getValueAt(SelectedRow, 0).toString();
        String b = jTable1.getValueAt(SelectedRow, 1).toString();
        String c = jTable1.getValueAt(SelectedRow, 2).toString();
        ModifyPanel ModifyPopUp = new ModifyPanel();
        DisplayModifyPane(a, b, c, ModifyPopUp);

        jTable1.getSelectionModel().clearSelection();
        jButton_Modify.setEnabled(false);
        jButton_Remove.setEnabled(false);
    }//GEN-LAST:event_jButton_ModifyActionPerformed
    void DisplayModifyPane(String IDtoReplace, String ChangedName, String ChangedAmt, ModifyPanel ModifyPopUp) {
        //option pane's options and placing selected item
        String[] responses = {"Confirm", "Cancel"};
        ModifyPopUp.ProductID.setText(IDtoReplace);
        ModifyPopUp.modifyField1.setText(ChangedName);
        ModifyPopUp.modifyField2.setText(ChangedAmt);

        int n = JOptionPane.showOptionDialog(this, ModifyPopUp, "Modify",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, responses, 0);

        if (n == JOptionPane.YES_OPTION) {
            if (ModifyPopUp.modifyField1.getText().trim().equals("")
                    || ModifyPopUp.modifyField2.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this,
                        "Please fill all fields", "ERROR", JOptionPane.ERROR_MESSAGE);
                DisplayModifyPane(IDtoReplace, ChangedName, ChangedAmt, ModifyPopUp);
            } else if (ModifyPopUp.modifyField1.getText().trim().length() > 15) {
                JOptionPane.showMessageDialog(this,
                        "Product name should be up to 15 characters only", "ERROR", JOptionPane.ERROR_MESSAGE);
                DisplayModifyPane(IDtoReplace, ChangedName, ChangedAmt, ModifyPopUp);
            } else {
                String NameReplacer = ModifyPopUp.modifyField1.getText();
                String AmountReplacer = ModifyPopUp.modifyField2.getText();
                System.out.println(NameReplacer + AmountReplacer);
                //changeRowData(IDtoReplace, NameReplacer, AmountReplacer);
                String[] replaceData = {NameReplacer, AmountReplacer, IDtoReplace};
                SQLite("UPDATE products SET name = ?, amount = ? WHERE id = ?", replaceData);
                UpdateTablewSearch();
            }
        }
    }

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        jTable1.getSelectionModel().clearSelection();
        jButton_Modify.setEnabled(false);
        jButton_Remove.setEnabled(false);
        jButton_Remove1.setEnabled(false);
    }//GEN-LAST:event_jTable1FocusLost

    private void jButton_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveActionPerformed
        int SelectedRow = jTable1.getSelectedRow();
        System.out.println(SelectedRow);
        String SelectedName = jTable1.getValueAt(SelectedRow, 1).toString();
        String SelectedID = jTable1.getValueAt(SelectedRow, 0).toString();

        int n = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to remove " + SelectedName + " (ID: " + SelectedID + ")?", "Remove?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (n == JOptionPane.YES_OPTION) {
            System.out.println("Agreed to Remove");
            //removeRowData(SelectedID);
            SQLite("UPDATE products SET visible = 0 WHERE id = " + SelectedID);
            SQLiteRS("SELECT * FROM products");
        }
    }//GEN-LAST:event_jButton_RemoveActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        textSearchField.setText("");
        SQLiteRS("SELECT * FROM products");
    }//GEN-LAST:event_RefreshActionPerformed

    private void jButton_NewDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NewDataActionPerformed

    }//GEN-LAST:event_jButton_NewDataActionPerformed

    private void jButton_Remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Remove1ActionPerformed
        int SelectedRow = jTable1.getSelectedRow();
        String SelectedID = jTable1.getValueAt(SelectedRow, 0).toString();
        SQLite("UPDATE products SET amount = amount - 10 WHERE id = " + SelectedID);
        UpdateTablewSearch();
        jTable1.setRowSelectionInterval(SelectedRow, SelectedRow);
    }//GEN-LAST:event_jButton_Remove1ActionPerformed

    private void manageButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtActionPerformed
        if(accDetails.admin){
            dispose();
            new ManageAcc().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "TODO: NotAadminManageAccount");
        }
    }//GEN-LAST:event_manageButtActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        dispose();
        new LogIn().setVisible(true);
    }//GEN-LAST:event_LogOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    break;
                }
            }/*
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        */} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccType;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JButton LogOut;
    private javax.swing.JButton Refresh;
    private javax.swing.JPanel ScrollPanel;
    private ImageTemplate imageTemplate1;
    private javax.swing.JButton jButton_Modify;
    private javax.swing.JButton jButton_NewData;
    private javax.swing.JButton jButton_Remove;
    private javax.swing.JButton jButton_Remove1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton manageButt;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField textSearchField;
    // End of variables declaration//GEN-END:variables
}
