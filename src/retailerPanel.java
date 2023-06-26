
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Salles
 */
public class retailerPanel extends javax.swing.JPanel {

    /**
     * Creates new form retailerPanel
     */
    public retailerPanel() {
        initComponents();
    }

    ArrayList<String[]> retailList = new ArrayList<>();
    String[] get = {"id", "name", "count(retailer)"};
    private void initData(){
        retailList.clear();
        SQLiteJava.SQLiteRS("select r.*, count(retailer) from retails r left join products_details d on r.id = d.retailer group by r.id", retailList, get);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (String[] category : retailList){
            model.addRow(category);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        del_button = new javax.swing.JButton();
        rename_button = new javax.swing.JButton();
        add_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton4.setText("Close");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        del_button.setText("Delete");
        del_button.setEnabled(false);
        del_button.setFocusable(false);
        del_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_buttonActionPerformed(evt);
            }
        });

        rename_button.setText("Rename");
        rename_button.setEnabled(false);
        rename_button.setFocusable(false);
        rename_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rename_buttonActionPerformed(evt);
            }
        });

        add_button.setText("Add");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rename_button, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
            .addComponent(del_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(add_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rename_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(del_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Retailer", "Location", "Contact", "Website"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        categoryName addPop = new categoryName();
        int response = JOptionPane.showConfirmDialog(this, addPop, "Add Retailer", JOptionPane.OK_CANCEL_OPTION);
        if(response == JOptionPane.OK_OPTION){
            SQLiteJava.SQLite("insert into retails (name,location,phone,website) values ('"+addPop.nameField.getText()+"')");
            initData();
        }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void rename_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rename_buttonActionPerformed
        int SelectedRow = jTable1.getSelectedRow();
        if(SelectedRow == 0){
            JOptionPane.showMessageDialog(this, "Uncategorized can't be modified","",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = jTable1.getValueAt(SelectedRow, 0)+"";
        String name = jTable1.getValueAt(SelectedRow, 1)+"";
        String count = jTable1.getValueAt(SelectedRow, 2)+"";

        categoryName renamePop = new categoryName();
        renamePop.IDField.setText(id);
        renamePop.NumberField.setText(count);
        renamePop.nameField.setText(name);

        int response = JOptionPane.showConfirmDialog(this, renamePop, "Rename Category", JOptionPane.OK_CANCEL_OPTION);
        if(response == JOptionPane.OK_OPTION){
            SQLiteJava.SQLite("update categories set name = '"+renamePop.nameField.getText()+"' where id = "+id);
            initData();
        }
    }//GEN-LAST:event_rename_buttonActionPerformed

    private void del_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_buttonActionPerformed
        int SelectedRow = jTable1.getSelectedRow();
        if(SelectedRow == 0){
            JOptionPane.showMessageDialog(this, "Uncategorized can't be modified","",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = jTable1.getValueAt(SelectedRow, 0)+"";
        String name = jTable1.getValueAt(SelectedRow, 1)+"";
        String count = jTable1.getValueAt(SelectedRow, 2)+"";
        int response = JOptionPane.showConfirmDialog(this, "Delete "+name+" (ID:"+id+")?\n"+count+" product(s) will be moved to Uncategorized category", "Delete Category?", JOptionPane.OK_CANCEL_OPTION);
        if(response == JOptionPane.OK_OPTION){
            SQLiteJava.SQLite("update products_details set category = 0 where category = "+id);
            SQLiteJava.SQLite("update categories set visible = 0 where id = "+id);

            initData();
        }
    }//GEN-LAST:event_del_buttonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(jButton4);
        dialog.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JButton del_button;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton rename_button;
    // End of variables declaration//GEN-END:variables
}
