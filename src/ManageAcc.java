

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageAcc extends javax.swing.JFrame {

    public ManageAcc() {
        ConnectDatabase();
        initComponents();
        ListToTable();
    }

    //connects sqlitejava.java to database if not connected
    private void ConnectDatabase() {
        if (SQLiteJava.conn == null) {
            SQLiteJava.ConnectDatabase();
        }
    }

    //sync arrayList and table to database
    ArrayList<String[]> accounts = new ArrayList<>();

    private void ListToTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        SQLiteJava.SQLiteRS("select * from accounts", accounts);
        for (String[] rowData : accounts) {
            model.addRow(rowData);
        }
    }

    //unique id generator
    String GenerateID() {
        int randomNums = new java.util.Random().nextInt(10000, 99999);
        String tempID = "2023 - " + randomNums;
        for (String[] rowData : accounts) {
            if (rowData[0].equals(tempID)) {
                tempID = GenerateID();
            }
        }
        String uniqueID = tempID;
        return uniqueID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        button_add = new javax.swing.JButton();
        button_edit = new javax.swing.JButton();
        button_save = new javax.swing.JButton();
        button_del = new javax.swing.JButton();
        button_back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        repassField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        IDField = new javax.swing.JLabel();
        imageTemplate1 = new ImageTemplate();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Account Manager");
        setType(java.awt.Window.Type.POPUP);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password"
            }
        ));
        jTable1.setRowHeight(30);
        jTable1.setShowHorizontalLines(true);
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

        button_add.setText("ADD");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_edit.setText("EDIT");
        button_edit.setEnabled(false);
        button_edit.setFocusable(false);
        button_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editActionPerformed(evt);
            }
        });

        button_save.setText("SAVE");
        button_save.setEnabled(false);
        button_save.setFocusable(false);
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_del.setText("DELETE");
        button_del.setEnabled(false);
        button_del.setFocusable(false);
        button_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_delActionPerformed(evt);
            }
        });

        button_back.setText("Back");
        button_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_backActionPerformed(evt);
            }
        });

        jLabel3.setText("Re-Type Password:");

        jLabel2.setText("Password:");

        jLabel1.setText("Username:");

        userField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userFieldKeyReleased(evt);
            }
        });

        jLabel4.setText("ID:");

        IDField.setText("2023 -");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(button_del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(button_back)))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(repassField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(IDField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button_add, button_back, button_del, button_edit, button_save});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add)
                    .addComponent(button_edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_save)
                    .addComponent(button_del))
                .addGap(18, 18, 18)
                .addComponent(button_back)
                .addGap(26, 26, 26))
        );

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int SelectedRow = jTable1.getSelectedRow();

        System.out.println(SelectedRow);
        if (SelectedRow < 0) {
            button_del.setEnabled(false);
            button_edit.setEnabled(false);
        } else {
            button_del.setEnabled(true);
            button_edit.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        jTable1.clearSelection();
        button_del.setEnabled(false);
        button_edit.setEnabled(false);
    }//GEN-LAST:event_jTable1FocusLost

    private void button_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_backActionPerformed
        dispose();
        new MainFrame().setVisible(true);
    }//GEN-LAST:event_button_backActionPerformed

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        String id = IDField.getText();
        String user = userField.getText();
        String pass = String.valueOf(passField.getPassword());
        String repass = String.valueOf(repassField.getPassword());
        if (SQLiteJava.SQLiteCheckIfInDatabase("select * from accounts where name=? and visible=1", user)) {
            JOptionPane.showMessageDialog(this, "Username already exists,\nPlease choose another.", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!user.isBlank() && !pass.isBlank() && !repass.isBlank()) {
            if (pass.equals(repass)) {
                String setData[] = {id, user, pass};
                SQLiteJava.SQLitePrepare("insert into accounts (id, name, password) values (?,?,?)", setData);
                passField.setText("");
                repassField.setText("");
                userField.setText("");
                IDField.setText("2023 -");
                JOptionPane.showMessageDialog(this, "Successfully Added!");
            } else {
                JOptionPane.showMessageDialog(this, "Password Does not match", "", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fill all fields", "", JOptionPane.WARNING_MESSAGE);
        }
        ListToTable();
    }//GEN-LAST:event_button_addActionPerformed

    private void button_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_delActionPerformed
        int SelectedRow = jTable1.getSelectedRow();
        String SelectedName = jTable1.getValueAt(SelectedRow, 1).toString();
        String SelectedID = jTable1.getValueAt(SelectedRow, 0).toString();
        int n = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to remove user: " + SelectedName + " (ID: " + SelectedID + ")?", "Remove?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (n == JOptionPane.YES_OPTION) {
            SQLiteJava.SQLite("update accounts set visible = 0 where id = '" + SelectedID + "'");
            ListToTable();
        }
    }//GEN-LAST:event_button_delActionPerformed

    private void button_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editActionPerformed
        button_add.setEnabled(false);
        button_save.setEnabled(true);
        int SelectedRow = jTable1.getSelectedRow();
        String SelectedName = jTable1.getValueAt(SelectedRow, 1).toString();
        String SelectedID = jTable1.getValueAt(SelectedRow, 0).toString();
        String SelectedPass = jTable1.getValueAt(SelectedRow, 2).toString();
        IDField.setText(SelectedID);
        userField.setText(SelectedName);
        passField.setText(SelectedPass);

    }//GEN-LAST:event_button_editActionPerformed

    private void userFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userFieldKeyReleased
        if (IDField.getText().equals("2023 -")) {
            if (!userField.getText().isBlank()) {
                IDField.setText(GenerateID());
            }
        } else {
            if (userField.getText().isBlank()) {
                if (button_save.isEnabled()) {
                    button_save.setEnabled(false);
                    button_add.setEnabled(true);
                    passField.setText("");
                    repassField.setText("");
                }
                IDField.setText("2023 -");
            }
        }
    }//GEN-LAST:event_userFieldKeyReleased

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        String id = IDField.getText();
        String user = userField.getText();
        String pass = String.valueOf(passField.getPassword());
        String repass = String.valueOf(repassField.getPassword());
        if (!user.isBlank() && !pass.isBlank() && !repass.isBlank()) {
            if (pass.equals(repass)) {
                String setData[] = {user, pass};
                SQLiteJava.SQLitePrepare("update accounts set name = ?, password = ? where id = '" + id + "'", setData);
                button_add.setEnabled(true);
                button_save.setEnabled(false);
                passField.setText("");
                repassField.setText("");
                userField.setText("");
                JOptionPane.showMessageDialog(this, "Successfully Updated!");
            } else {
                JOptionPane.showMessageDialog(this, "Password Does not match", "", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fill all fields", "", JOptionPane.WARNING_MESSAGE);
        }
        ListToTable();
    }//GEN-LAST:event_button_saveActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    break;
                }
            }/*
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             */
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ManageAcc().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDField;
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_back;
    private javax.swing.JButton button_del;
    private javax.swing.JButton button_edit;
    private javax.swing.JButton button_save;
    private ImageTemplate imageTemplate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPasswordField passField;
    private javax.swing.JPasswordField repassField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
