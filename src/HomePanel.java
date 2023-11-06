
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Salles
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePanel
     */
    public HomePanel() {
        initComponents();
        Random rm = new Random();
        toDisplayedIndex = rm.nextInt(3);
        imageTemplateforHome2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePaths[toDisplayedIndex])));
        nextTimer.start();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        imageTemplateforHome2 = new ImageTemplateforHome();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1039, 512));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jButton1.setText("<");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        imageTemplateforHome2.setAlphaValue(1.0F);
        imageTemplateforHome2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/webAdEdited.png"))); // NOI18N
        imageTemplateforHome2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imageTemplateforHome2MousePressed(evt);
            }
        });
        jPanel1.add(imageTemplateforHome2);

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jButton2.setText(">");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 234, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(213, 213, 213))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(218, 218, 218))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setButtons(boolean enable){
        jButton1.setEnabled(enable);
        jButton2.setEnabled(enable);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        alphaTimer.stop();
        nextTimer.stop();
        toDisplayedIndex = (toDisplayedIndex + 1) % imagePaths.length;
        alphaTimer.start();
        nextTimer.start();
        setButtons(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        alphaTimer.stop();
        nextTimer.stop();
        toDisplayedIndex = (toDisplayedIndex - 1 + imagePaths.length) % imagePaths.length;
        alphaTimer.start();
        nextTimer.start();
        setButtons(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void imageTemplateforHome2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageTemplateforHome2MousePressed
        if(toDisplayedIndex == 0){
            String url = "https://salles4.github.io/SiomaiYan/";
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.browse(new java.net.URI(url));
        } catch (IOException | URISyntaxException e) {
        }
        }
    }//GEN-LAST:event_imageTemplateforHome2MousePressed
    
    int toDisplayedIndex = 0;
    String[] imagePaths = {"/img/webAdEdited.png", "/img/mainAd.png", "/img/SystemAdEdited.png"};
    @SuppressWarnings("Convert2Lambda")
    Timer nextTimer = new Timer(7000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            toDisplayedIndex = (toDisplayedIndex + 1) % imagePaths.length;
            alphaTimer.start();
            setButtons(false);
        }
    });
    
    float alphaValue = 1;
    float incrementAlpha = -0.07f;
    
    
    Timer alphaTimer = new Timer(15, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alphaValue += incrementAlpha;
            
            if (alphaValue <= 0) {
                alphaValue = 0;
                incrementAlpha = 0.07f;
                //change pic
                imageTemplateforHome2.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePaths[toDisplayedIndex])));
            }
            else if (alphaValue > 1){
                alphaValue = 1;
                incrementAlpha = -0.07f;
                alphaTimer.stop();
                setButtons(true);
            }
                
            
            imageTemplateforHome2.setAlphaValue(alphaValue);
        }
    });
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ImageTemplateforHome imageTemplateforHome2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
