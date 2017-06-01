package pontocristao.visao;

import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import pontocristao.controle.ControleFornecedor;
import pontocristao.modelo.Fornecedor;
import pontocristao.util.Utilidades;

/**
 *
 * @author Marcondes
 */
public class FrmCadastrarFornecedor extends javax.swing.JDialog {

    private static Frame frame;
    private ControleFornecedor controle;
    private Boolean modeloAtualizado = false;

    public Boolean getModeloAtualizado() {
        return modeloAtualizado;
    }

    public Fornecedor getFornecedor() {
        return controle.getFornecedor();
    }

    public FrmCadastrarFornecedor(java.awt.Frame parent, boolean modal, long id) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);

        txtNomeFantasia.requestFocus();

        Utilidades.setMascara("##.###.###/####-##", txtCnpj);
        Utilidades.setMascara("(##)####-####", txtTelefone);
        Utilidades.setMascara("(##)####-####", txtCelular);

        InicializarControle(id);
    }

    public static FrmCadastrarFornecedor Mostrar(java.awt.Frame parent, long id) {
        frame = parent;
        FrmCadastrarFornecedor frmCadastrarFornecedor = new FrmCadastrarFornecedor(parent, true, id);
        frmCadastrarFornecedor.setVisible(true);
        return frmCadastrarFornecedor;
    }

    private void InicializarControle(long id) {
        this.controle = new ControleFornecedor();

        if (id > 0) {
            Exception erro = this.controle.RecuperarFornecedor(id);

            if (erro != null) {
                Utilidades.MostrarMensagemErro(erro);
            } else {
                AtualizarCampos();
            }
        }
    }

    private void AtualizarCampos() {
        txtCelular.setText(controle.getFornecedor().getCelular());
        txtCnpj.setText(controle.getFornecedor().getCnpj());
        txtDescricao.setText(controle.getFornecedor().getDescricao());
        txtInscricaoEstadual.setText(controle.getFornecedor().getInscricaoEstadual());
        txtNomeFantasia.setText(controle.getFornecedor().getNomeFantasia());
        txtRazaoSocial.setText(controle.getFornecedor().getRazaoSocial());
        txtTelefone.setText(controle.getFornecedor().getTelefone());
    }

    private void AtualizarModelo() {
        controle.getFornecedor().setCelular(txtCelular.getText());
        controle.getFornecedor().setCnpj(txtCnpj.getText());
        controle.getFornecedor().setDescricao(txtDescricao.getText());
        controle.getFornecedor().setInscricaoEstadual(txtInscricaoEstadual.getText());
        controle.getFornecedor().setNomeFantasia(txtNomeFantasia.getText());
        controle.getFornecedor().setRazaoSocial(txtRazaoSocial.getText());
        controle.getFornecedor().setTelefone(txtTelefone.getText());
    }

    public Boolean ValidaCampos() {
        Boolean retorno = true;

        if (txtNomeFantasia.getText().equals("")
                || Utilidades.getValorSemMascara(txtCnpj).equals("")
                || Utilidades.getValorSemMascara(txtTelefone).equals("")
                || txtRazaoSocial.getText().equals("")
                || txtInscricaoEstadual.getText().equals("")) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos.");
        }

        return retorno;
    }

    @Override
    public void dispose() {
        if (controle != null) {
            controle.Dispose();
        }

        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lNomeFantasia = new javax.swing.JLabel();
        lTelefone = new javax.swing.JLabel();
        lCelular = new javax.swing.JLabel();
        ldescricao = new javax.swing.JLabel();
        lCnpj = new javax.swing.JLabel();
        lRazaoSocial = new javax.swing.JLabel();
        lInscricaoEstadual = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        BtnConfirmar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtCnpj = new javax.swing.JFormattedTextField();
        txtRazaoSocial = new javax.swing.JFormattedTextField();
        txtInscricaoEstadual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedores");

        lNomeFantasia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lNomeFantasia.setText("Nome Fantasia*");

        lTelefone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lTelefone.setText("Telefone*");

        lCelular.setText("Celular");

        ldescricao.setText("Descrição");

        lCnpj.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lCnpj.setText("CNPJ*");

        lRazaoSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lRazaoSocial.setText("Razão Social*");

        lInscricaoEstadual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lInscricaoEstadual.setText("Inscrição Estadual*");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnConfirmar)
                .addGap(18, 18, 18)
                .addComponent(BtnCancelar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNomeFantasia)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lTelefone))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lCelular)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 257, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeFantasia)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRazaoSocial)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ldescricao)
                                    .addComponent(lRazaoSocial)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lCnpj))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lInscricaoEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lNomeFantasia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTelefone)
                    .addComponent(lCelular))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lRazaoSocial)
                .addGap(2, 2, 2)
                .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lInscricaoEstadual)
                    .addComponent(lCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ldescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnConfirmar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        if (ValidaCampos()) {
            AtualizarModelo();

            Exception erro = controle.Salvar();

            if (erro != null) {
                Utilidades.MostrarMensagemErro(erro);
            } else {
                modeloAtualizado = true;
                this.dispose();
            }
        }
    }//GEN-LAST:event_BtnConfirmarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
       Object[] botoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(null,
                "Deseja cancelar o cadastro de Fornecedor? ",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                botoes, botoes[0]);
        if (resposta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_BtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastrarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCadastrarFornecedor dialog = new FrmCadastrarFornecedor(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JLabel lCelular;
    private javax.swing.JLabel lCnpj;
    private javax.swing.JLabel lInscricaoEstadual;
    private javax.swing.JLabel lNomeFantasia;
    private javax.swing.JLabel lRazaoSocial;
    private javax.swing.JLabel lTelefone;
    private javax.swing.JLabel ldescricao;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtInscricaoEstadual;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JFormattedTextField txtRazaoSocial;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
