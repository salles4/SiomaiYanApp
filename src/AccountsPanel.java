
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccountsPanel extends javax.swing.JPanel {

    final String IDPREFIX = "2023 -";

    public AccountsPanel() {
        initComponents();
        ListToTable();
    }
    //sync arrayList and table to database
    ArrayList<String[]> accounts = new ArrayList<>();

    final String[] dataToGet = {"id", "name", "contact", "user", "password"};

    private void ListToTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        SQLiteJava.SQLiteRS("select * from accounts", accounts, dataToGet);
        for (String[] rowData : accounts) {
            model.addRow(rowData);
        }
    }

    private void warning(String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.WARNING_MESSAGE);
    }

    // 0user, 1pass, 2repass, 3num, 4name
    private boolean verifyFields(String[] fields) {
        if (fields[0].isBlank() || fields[1].isBlank() || fields[2].isBlank() || fields[3].isBlank() || fields[4].isBlank()) {
            warning("Fill all fields.");
            return false;
        }
        if (!fields[1].equals(fields[2])) {
            warning("Password do not match!");
            return false;
        }
        if (SQLiteJava.SQLiteCheckIfInDatabase("select * from accounts where user=? and visible=1", fields[0])) {
            warning("Username already exist\nPlease choose another.");
            return false;
        }
        if (fields[3].length() < 11 || !fields[3].startsWith("09")) {
            warning("Phone number is invalid");
            return false;
        }
        return true;
    }

    //unique id generator
    String GenerateID() {
        int randomNums = new java.util.Random().nextInt(10000, 99999);
        String tempID = IDPREFIX + " " + randomNums; // 2023 - #####
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
        jPanel2 = new javax.swing.JPanel();
        button_del = new javax.swing.JButton();
        button_save = new javax.swing.JButton();
        button_add = new javax.swing.JButton();
        button_edit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        IDField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        numField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        repassField = new javax.swing.JPasswordField();
        imageTemplate1 = new ImageTemplate();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1039, 512));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Phone Number", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
        }

        button_del.setText("Delete");
        button_del.setEnabled(false);
        button_del.setFocusable(false);
        button_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_delActionPerformed(evt);
            }
        });

        button_save.setText("Save");
        button_save.setEnabled(false);
        button_save.setFocusable(false);
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_add.setText("Add");
        button_add.setFocusable(false);
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_edit.setText("Edit");
        button_edit.setEnabled(false);
        button_edit.setFocusable(false);
        button_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editActionPerformed(evt);
            }
        });

        jLabel1.setText("ID: ");

        IDField.setText(IDPREFIX);

        jLabel6.setText("Full Name:");

        jLabel7.setText("Phone Number:");

        numField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numFieldKeyTyped(evt);
            }
        });

        jLabel2.setText("Username:");

        userField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userFieldKeyReleased(evt);
            }
        });

        jLabel3.setText("Password:");

        jLabel4.setText("Re-Type Password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(112, 112, 112)
                        .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_del, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repassField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {nameField, numField, passField, repassField, userField});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IDField))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(repassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(numField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add)
                    .addComponent(button_edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_del)
                    .addComponent(button_save))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        imageTemplate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stick_only.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Account Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageTemplate1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
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

    private void button_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editActionPerformed
        button_add.setEnabled(false);
        button_save.setEnabled(true);
        int SelectedRow = jTable1.getSelectedRow();
        String SelectedUser = jTable1.getValueAt(SelectedRow, 3).toString();
        String SelectedID = jTable1.getValueAt(SelectedRow, 0).toString();
        String SelectedPass = jTable1.getValueAt(SelectedRow, 4).toString();
        String SelectedName = jTable1.getValueAt(SelectedRow, 1).toString();
        String SelectedNumber = jTable1.getValueAt(SelectedRow, 2).toString();

        IDField.setText(SelectedID);
        userField.setText(SelectedUser);
        passField.setText(SelectedPass);
        nameField.setText(SelectedName);
        numField.setText(SelectedNumber);
    }//GEN-LAST:event_button_editActionPerformed

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        String id = IDField.getText();
        String user = userField.getText();
        String pass = String.valueOf(passField.getPassword());
        String repass = String.valueOf(repassField.getPassword());
        String num = numField.getText();
        String name = nameField.getText();
        // 0user, 1pass, 2repass, 3num, 4name
        String verify[] = {user, pass, repass, num, name};
        if (verifyFields(verify)) {
            String setData[] = {id, user, pass, num, name};
            SQLiteJava.SQLitePrepare("insert into accounts (id, user, password, contact, name) values (?,?,?,?,?)", setData);
            passField.setText("");
            repassField.setText("");
            userField.setText("");
            IDField.setText(IDPREFIX);
            JOptionPane.showMessageDialog(this, "Successfully Added!");
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

    private void userFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userFieldKeyReleased
        if (IDField.getText().equals(IDPREFIX)) {
            if (!userField.getText().isBlank()) {
                IDField.setText(GenerateID());
            }
        } else {
            if (userField.getText().isBlank()) {
                IDField.setText(IDPREFIX);
                if (button_save.isEnabled()) {
                    button_save.setEnabled(false);
                    button_add.setEnabled(true);
                    passField.setText("");
                    repassField.setText("");
                    numField.setText("");
                    nameField.setText("");
                }
            }
        }
    }//GEN-LAST:event_userFieldKeyReleased

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        String id = IDField.getText();
        String user = userField.getText();
        String pass = String.valueOf(passField.getPassword());
        String repass = String.valueOf(repassField.getPassword());
        String num = numField.getText();
        String name = nameField.getText();
        if (user.isBlank() || pass.isBlank() || repass.isBlank() || num.isBlank() || name.isBlank()) {
            warning("Fill all fields");
            return;
        }
        if (num.length() < 11 || !num.startsWith("09")) {
            warning("Phone number is invalid");
            return;
        }
        if (pass.equals(repass)) {
            String setData[] = {user, pass, num, name};
            SQLiteJava.SQLitePrepare("update accounts set user = ?, password = ?, contact = ?, name = ? where id = '" + id + "'", setData);
            button_add.setEnabled(true);
            button_save.setEnabled(false);
            passField.setText("");
            repassField.setText("");
            userField.setText("");
            numField.setText("");
            nameField.setText("");
            IDField.setText(IDPREFIX);
            JOptionPane.showMessageDialog(this, "Successfully Updated!");
        } else {
            warning("Password does not match!");
        }
        ListToTable();
    }//GEN-LAST:event_button_saveActionPerformed

    private void numFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numFieldKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9')
                || (c == java.awt.event.KeyEvent.VK_BACK_SPACE)
                || (c == java.awt.event.KeyEvent.VK_DELETE))
                || numField.getText().length() >= 11) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_numFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDField;
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_del;
    private javax.swing.JButton button_edit;
    private javax.swing.JButton button_save;
    private ImageTemplate imageTemplate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField numField;
    private javax.swing.JPasswordField passField;
    private javax.swing.JPasswordField repassField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
