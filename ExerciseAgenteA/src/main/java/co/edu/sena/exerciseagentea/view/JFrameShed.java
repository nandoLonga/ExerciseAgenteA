package co.edu.sena.exerciseagentea.view;

import co.edu.sena.exerciseagentea.controller.IShedController;
import co.edu.sena.exerciseagentea.controller.ShedController;
import co.edu.sena.exerciseagentea.model.Shed;
import co.edu.sena.exerciseagentea.utils.MessageUtils;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Fecha: 22/10/2026
 * @author luilonmu
 * Objetivo: vista galpon
 */
public class JFrameShed extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFrameShed.class.getName());
    private IShedController shedController = new ShedController();
    private DefaultTableModel tableModel;

    /**
     * Creates new form JFrameShed
     */
    public JFrameShed() {
        initComponents();
        fillTable();
    }
    
    public void fillTable()
    {
        try
        {
            DefaultTableModel model = new DefaultTableModel();
        jTableSheds.setModel(model);
        //columnas
        model.addColumn("Número");
        model.addColumn("Estado");
        
        //filas
        String[] row = new String[2];
        for (Shed shed : shedController.findAll()) 
        {
            row[0] = String.valueOf(shed.getNumber());
            row[1] = shed.getStatus();
            model.addRow(row);
        }
        }catch (Exception ex) 
        {
            System.getLogger(JFrameShed.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jTextFieldNumber = new javax.swing.JTextField();
        jButtonInsert = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSheds = new javax.swing.JTable();
        jComboBoxStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Galpones");

        jLabelTitle.setText("Gestión de inforamión galpones");

        jLabelNumber.setText("Número galpón");

        jLabelStatus.setText("Estado galpón");

        jButtonInsert.setText("Crear");
        jButtonInsert.addActionListener(this::jButtonInsertActionPerformed);

        jButtonUpdate.setText("Actualizar");
        jButtonUpdate.setEnabled(false);
        jButtonUpdate.addActionListener(this::jButtonUpdateActionPerformed);

        jButtonDelete.setText("Eliminar");
        jButtonDelete.setEnabled(false);
        jButtonDelete.addActionListener(this::jButtonDeleteActionPerformed);

        jButtonClean.setText("Limpiar");
        jButtonClean.addActionListener(this::jButtonCleanActionPerformed);

        jTableSheds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableSheds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableShedsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSheds);

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "OCUPADO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonInsert)
                    .addComponent(jLabelNumber))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButtonUpdate)))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClean)
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelStatus)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabelTitle)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTitle)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumber)
                    .addComponent(jLabelStatus)
                    .addComponent(jTextFieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsert)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonClean))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        clear();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        try
        {
            Shed shed = new Shed();
            shed.setNumber(Integer.parseInt(jTextFieldNumber.getText()));
            shed.setStatus (jComboBoxStatus.getSelectedItem().toString());
            
            shedController.insert(shed);
            MessageUtils.getInstance().showInfo("El registro fue creado");
            clear();
            fillTable();
            
        } catch (NumberFormatException ex) 
        {
            MessageUtils.getInstance().showError("El número del galpón debe contener solo números");
        }
        catch (Exception ex) 
        {
            MessageUtils.getInstance().showError(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try
        {
            Shed shed = new Shed();
            shed.setNumber(Integer.parseInt(jTextFieldNumber.getText()));
            shed.setStatus (jComboBoxStatus.getSelectedItem().toString());
            
            shedController.update(shed);
            MessageUtils.getInstance().showInfo("El registro fue modificado con exito");
            clear();
            fillTable();
            
        } catch (NumberFormatException ex) 
        {
            MessageUtils.getInstance().showError("El número del galpón debe contener solo números");
        }
        catch (Exception ex) 
        {
            MessageUtils.getInstance().showError(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int option = MessageUtils.getInstance().showConfirm("Está seguro de eliminar el seguro?=");
        if(option == JOptionPane.YES_OPTION)
        {
            try {
                shedController.delete(Integer.parseInt(jTextFieldNumber.getText()));
                MessageUtils.getInstance().showInfo("Registro eliminado con exito");
                clear();
                fillTable();
            } catch (Exception ex) {
                MessageUtils.getInstance().showError(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableShedsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableShedsMouseClicked
        int rowSelected = jTableSheds.getSelectedRow();
        if(rowSelected != -1)
        {
            jButtonUpdate.setEnabled(true);
            jButtonDelete.setEnabled(true);
            jButtonInsert.setEnabled(false);
            
            int numberSelected = Integer.parseInt(jTableSheds.getValueAt(rowSelected, 0).toString());
            try 
            {
                Shed shed = shedController.find(numberSelected);
                jTextFieldNumber.setText(String.valueOf(shed.getNumber()));
                jComboBoxStatus.setSelectedItem(shed.getStatus());
            } catch(Exception ex) 
            {
                MessageUtils.getInstance().showError(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jTableShedsMouseClicked
    
    public void clear()
    {
        jTextFieldNumber.setText("");
        jComboBoxStatus.setSelectedIndex(0);
        jTableSheds.clearSelection();
        jButtonInsert.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
    }
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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JFrameShed().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSheds;
    private javax.swing.JTextField jTextFieldNumber;
    // End of variables declaration//GEN-END:variables
}
