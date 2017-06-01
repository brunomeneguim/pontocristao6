package pontocristao.visao;

import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import pontocristao.controle.*;
import pontocristao.modelo.*;
import pontocristao.util.Utilidades;

/**
 *
 * @author Marcondes
 */
public class FrmLocacao extends javax.swing.JDialog {

    private DefaultTableModel modeloTabela;
    private ControleLocacao controle = new ControleLocacao();
    private static Frame frame;
    private java.util.List<Locacao> lista;

    public static FrmLocacao Mostrar(java.awt.Frame parent) {
        frame = parent;
        FrmLocacao frm = new FrmLocacao(parent, true);
        frm.setVisible(true);
        return frm;
    }

    public FrmLocacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AjustarTabela();

        Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        this.setBounds(bounds);

        txtPesquisar.requestFocus();

        BtnEditar.setEnabled(false);
        BtnExcluir.setEnabled(false);
        BtnPagamento.setEnabled(false);
        BtnDevolver.setEnabled(false);

        Listar();
    }

    private void AjustarTabela() {
        String[] colunas = new String[]{"Data", "Cliente", "Valor", "Pago"};
        modeloTabela = new DefaultTableModel(null, colunas) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        jTableLista.setModel(modeloTabela);
        jTableLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jTableLista.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    if (jTableLista.getSelectedRow() >= 0) {
                        BtnEditar.setEnabled(true);
                        BtnExcluir.setEnabled(true);

                        int linhaSelecionada = jTableLista.getSelectedRow();
                        Locacao locacao = lista.get(linhaSelecionada);

                        if (!locacao.getPago()) {
                            BtnPagamento.setEnabled(true);
                        }

                    } else {
                        BtnEditar.setEnabled(false);
                        BtnExcluir.setEnabled(false);
                        BtnPagamento.setEnabled(false);
                    }
                }
            }
        });
    }

    private void AtualizarTabela(java.util.List<Locacao> locacoes) {
        while (modeloTabela.getRowCount() > 0) {
            modeloTabela.removeRow(0);
        }

        lista = locacoes;

        for (Locacao locacao : locacoes) {
            AdicionarLinha(locacao);
        }
    }

    private void AdicionarLinha(Locacao locacao) {
        modeloTabela.addRow(RetornarNovaLinha(locacao));
    }

    private Object[] RetornarNovaLinha(Locacao locacao) {
        return new Object[]{
            locacao.getData(),
            locacao.getCliente().getNome(),
            locacao.getValorTotal(),
            locacao.getPago()
        };
    }

    public void Listar() {
        try {
            AtualizarTabela(controle.RetornarLocacoes());
        } catch (Exception e) {
            Utilidades.MostrarMensagemErro(e);
        }
    }

    public void Listar(String pesquisa) {
        if (pesquisa != null && pesquisa.length() > 0) {
            String[] camposPesquisa = new String[]{"data", "Cliente.nome", "valor", "pago"};
            AtualizarTabela(controle.RetornarLocacoes(camposPesquisa, pesquisa));
        } else {
            Listar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnNovo = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        BtnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        BtnSair1 = new javax.swing.JButton();
        BtnPagamento = new javax.swing.JButton();
        BtnDevolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locação");
        setResizable(false);

        BtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnNovo.png"))); // NOI18N
        BtnNovo.setText("Novo");
        BtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNovoActionPerformed(evt);
            }
        });

        BtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnEditar.png"))); // NOI18N
        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnExcluir.png"))); // NOI18N
        BtnExcluir.setText("Excluir");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        BtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnPesquisar.png"))); // NOI18N
        BtnPesquisar.setText("Pesquisar");
        BtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisarActionPerformed(evt);
            }
        });

        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableLista);

        BtnSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnSair.png"))); // NOI18N
        BtnSair1.setText("Sair");
        BtnSair1.setPreferredSize(new java.awt.Dimension(139, 65));
        BtnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSair1ActionPerformed(evt);
            }
        });

        BtnPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnPagar.png"))); // NOI18N
        BtnPagamento.setText("Pagar");
        BtnPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPagamentoActionPerformed(evt);
            }
        });

        BtnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnDevolver.png"))); // NOI18N
        BtnDevolver.setText("Devolver");
        BtnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(BtnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNovoActionPerformed
        FrmCadastrarLocacao frm = FrmCadastrarLocacao.Mostrar(frame, 0);

        if (frm.getModeloAtualizado()) {
            Locacao locacao = frm.getLocacao();
            AdicionarLinha(locacao);
            lista.add(locacao);
        }

        controle = new ControleLocacao();
    }//GEN-LAST:event_BtnNovoActionPerformed

    private void BtnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSair1ActionPerformed
        Object[] botoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(null,
                "Deseja sair da lista de locações? ",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                botoes, botoes[0]);
        if (resposta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_BtnSair1ActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        if (lista != null) {
            int linhaSelecionada = jTableLista.getSelectedRow();
            Locacao locacao = lista.get(linhaSelecionada);
            FrmCadastrarLocacao frm = FrmCadastrarLocacao.Mostrar(frame, locacao.getId());

            locacao = frm.getLocacao();

            if (frm.getModeloAtualizado()) {
                modeloTabela.removeRow(linhaSelecionada);
                modeloTabela.insertRow(linhaSelecionada, RetornarNovaLinha(locacao));

                controle = new ControleLocacao();
            }
        }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
        if (lista != null) {

            Boolean podeExcluir = Utilidades.MostrarMensagemPergunta("Confirmação", "Tem certeza que deseja excluir a locação?", false);

            if (podeExcluir) {
                int linhaSelecionada = jTableLista.getSelectedRow();
                Locacao locacao = lista.get(linhaSelecionada);

                try {
                    controle.Excluir(locacao.getId());
                    modeloTabela.removeRow(linhaSelecionada);
                    lista.remove(locacao);

                    controle = new ControleLocacao();
                } catch (Exception e) {
                    Utilidades.MostrarMensagemErro(e);
                }
            }
        }
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        Listar(txtPesquisar.getText());
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPagamentoActionPerformed
        if (lista != null) {
            int linhaSelecionada = jTableLista.getSelectedRow();
            Locacao locacao = lista.get(linhaSelecionada);
            FrmPagamentoLocacao frm = FrmPagamentoLocacao.Mostrar(frame, locacao.getId());

            locacao = frm.getLocacao();

            if (frm.getModeloAtualizado()) {
                modeloTabela.removeRow(linhaSelecionada);
                modeloTabela.insertRow(linhaSelecionada, RetornarNovaLinha(locacao));

                controle = new ControleLocacao();
            }
        }
    }//GEN-LAST:event_BtnPagamentoActionPerformed

    private void BtnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDevolverActionPerformed
        if (lista != null) {
            int linhaSelecionada = jTableLista.getSelectedRow();
            Locacao locacao = lista.get(linhaSelecionada);

            Boolean devolver = Utilidades.MostrarMensagemPergunta("Confirmar devolução da locação", "Tem certeza que deseja confirmar a devolução da locação?", false);

            if (devolver) {
                try {
                    locacao.setDevolvido(true);

                    //controle.DevolverLocacao(locacao.getId());
                    modeloTabela.removeRow(linhaSelecionada);
                    modeloTabela.insertRow(linhaSelecionada, RetornarNovaLinha(locacao));

                } catch (Exception e) {
                    Utilidades.MostrarMensagemErro(e);
                }

            }
        }
    }//GEN-LAST:event_BtnDevolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmLocacao dialog = new FrmLocacao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnDevolver;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnNovo;
    private javax.swing.JButton BtnPagamento;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnSair1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
