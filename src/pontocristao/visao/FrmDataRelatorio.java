package pontocristao.visao;

import java.awt.*;
import java.util.Date;
import javax.swing.JOptionPane;
import pontocristao.util.Utilidades;

/**
 *
 * @author Marcondes
 */
public class FrmDataRelatorio extends javax.swing.JDialog {

    private static Frame frame;
    public Date DataInicio;
    public Date DataLimite;
    public boolean Confirmou;

    public FrmDataRelatorio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);

        jRadioPeriodo.setSelected(true);
        jcDataInicio.requestFocus();
    }

    public static FrmDataRelatorio Mostrar(java.awt.Frame parent, String titulo) {
        frame = parent;
        FrmDataRelatorio frm = new FrmDataRelatorio(parent, true);
        frm.setTitle(titulo);
        frm.setVisible(true);
        return frm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnConfirmar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jRadioTudo = new javax.swing.JRadioButton();
        jRadioPeriodo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jcDataInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jcDataLimite = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de tipo de produto");

        BtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnConfirmar.png"))); // NOI18N
        BtnConfirmar.setText("Confirmar");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnCancelar.png"))); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        jRadioTudo.setText("Tudo");
        jRadioTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTudoActionPerformed(evt);
            }
        });

        jRadioPeriodo.setText("Selecionar período");
        jRadioPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioPeriodoActionPerformed(evt);
            }
        });

        jLabel1.setText("Data de início");

        jLabel2.setText("Data limite");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioTudo)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioPeriodo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jcDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jcDataLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioTudo)
                    .addComponent(jRadioPeriodo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcDataLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnConfirmar)
                    .addComponent(BtnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        Object[] botoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(null,
                "Deseja cancelar a geração do relatório? ",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                botoes, botoes[0]);
        if (resposta == 0) {
            Confirmou = false;
            DataInicio = null;
            DataLimite = null;
            this.dispose();
        }
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        DataInicio = jcDataInicio.getDate();
        DataLimite = jcDataLimite.getDate();

        if (jRadioPeriodo.isSelected() && (DataInicio == null || DataLimite == null)) {
            JOptionPane.showMessageDialog(null, "A data de início e a data limite devem ser preenchidas.");
        } else {
            Confirmou = true;
            this.dispose();
        }

    }//GEN-LAST:event_BtnConfirmarActionPerformed

    private void jRadioTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTudoActionPerformed
        jRadioPeriodo.setSelected(false);
        
        jcDataInicio.setEnabled(false);
        jcDataLimite.setEnabled(false);
    }//GEN-LAST:event_jRadioTudoActionPerformed

    private void jRadioPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioPeriodoActionPerformed
        jRadioTudo.setSelected(false);
        
        jcDataInicio.setEnabled(true);
        jcDataLimite.setEnabled(true);

        jcDataInicio.requestFocus();
    }//GEN-LAST:event_jRadioPeriodoActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDataRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDataRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDataRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDataRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDataRelatorio dialog = new FrmDataRelatorio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioPeriodo;
    private javax.swing.JRadioButton jRadioTudo;
    private com.toedter.calendar.JDateChooser jcDataInicio;
    private com.toedter.calendar.JDateChooser jcDataLimite;
    // End of variables declaration//GEN-END:variables
}
