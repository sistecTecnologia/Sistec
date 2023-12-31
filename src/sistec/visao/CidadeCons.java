/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import jdk.nashorn.internal.ir.BreakNode;
import sistec.ColumModel.CidadeColumnModel;
import sistec.bean.Cidade;
import sistec.bean.Usuario;
import sistec.tableModel.CidadeTableModel;
import uteis.UpperCaseLimitado;
import uteis.UpperCaseParaNumerico;

/**
 *
 * @author CASSIO JUNIOR
 */
public class CidadeCons extends javax.swing.JDialog {

    /**
     * Creates new form UsuarioCadastro
     */
    public CidadeCons(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        jTblCidade.setColumnModel(new CidadeColumnModel(0));
        jTxfNome.setDocument(new UpperCaseLimitado(60));
        jTxfIbge.setDocument(new UpperCaseParaNumerico(10));
         this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getRootPane().getActionMap().put("escape", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public void addActionListener(ActionListener listener) {
        jBtnSalvarCidade.addActionListener(listener);
        jBtnExcluir.addActionListener(listener);
        jBtnAlterar.addActionListener(listener);
        jBtnNovo.addActionListener(listener);
        jBtnSelecionar.addActionListener(listener);
    }

    public void setCidade(Cidade cidade) {
        jTxfIbge.setText(cidade.getIbge() + "");
        jTxfIdCidade.setText(cidade.getIdCidade() + "");
        jTxfNome.setText(cidade.getNome());
    }

    public void desabilitarCampos(boolean nome, boolean ibge) {
        jTxfNome.setEditable(nome);
        jTxfIbge.setEditable(ibge);
    }

    public void getCidade(Cidade cidade) {
        cidade.setIbge(Integer.parseInt(jTxfIbge.getText()));
        cidade.setNome(jTxfNome.getText());
        cidade.setIdCidade(Integer.parseInt(jTxfIdCidade.getText()));

    }

    public void limparCampos() {
        jTxfIbge.setText("");
        jTxfNome.setText("");
        jTxfIdCidade.setText("0");
    }

    public void setList(List<Cidade> lst) {
        jTblCidade.setModel(new CidadeTableModel(lst));
        jTblCidade.setColumnModel(new CidadeColumnModel(0));
    }

    public void desabilitarBotes(boolean alterar, boolean excluir, boolean novo, boolean salvar) {
        jBtnAlterar.setEnabled(alterar);
        jBtnExcluir.setEnabled(excluir);
        jBtnNovo.setEnabled(novo);
        jBtnSalvarCidade.setEnabled(salvar);
    }
    private CidadeTableModel cidadeTableModel;

    public Cidade getCidadeSelecionado() throws Exception {
        if (jTblCidade.getSelectedRow() == -1) {
            throw new Exception("Nao foi selecionado nenhuma Cidade");
        }
        return ((CidadeTableModel) jTblCidade.getModel()).getValorCidade(jTblCidade.getSelectedRow());

    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblCidade = new javax.swing.JTable();
        jTxfIbge = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxfNome = new javax.swing.JTextField();
        jTxfIdCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jBtnNovo = new javax.swing.JButton();
        jBtnSalvarCidade = new javax.swing.JButton();
        jBtnSelecionar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cidades");
        setPreferredSize(new java.awt.Dimension(550, 428));
        setResizable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Find.png"))); // NOI18N

        jTblCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTblCidade);

        jTxfIbge.setEditable(false);
        jTxfIbge.setBackground(new java.awt.Color(255, 255, 255));
        jTxfIbge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfIbgeKeyPressed(evt);
            }
        });

        jLabel8.setText("IBGE");

        jTxfNome.setEditable(false);
        jTxfNome.setBackground(new java.awt.Color(255, 255, 255));
        jTxfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxfNomeActionPerformed(evt);
            }
        });
        jTxfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfNomeKeyPressed(evt);
            }
        });

        jTxfIdCidade.setEditable(false);
        jTxfIdCidade.setBackground(new java.awt.Color(255, 255, 255));
        jTxfIdCidade.setText("0");
        jTxfIdCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxfIdCidadeActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome");

        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Add.png"))); // NOI18N
        jBtnNovo.setText("Novo");
        jBtnNovo.setActionCommand("novaCidade");
        jBtnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnNovoKeyPressed(evt);
            }
        });

        jBtnSalvarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Save.png"))); // NOI18N
        jBtnSalvarCidade.setText("Salvar");
        jBtnSalvarCidade.setActionCommand("salvarCidade");
        jBtnSalvarCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnSalvarCidadeKeyPressed(evt);
            }
        });

        jBtnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Apply.png"))); // NOI18N
        jBtnSelecionar.setText("Selecionar");
        jBtnSelecionar.setActionCommand("selecionarCidade");
        jBtnSelecionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnSelecionarKeyPressed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Notes.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.setActionCommand("alterarCidade");
        jBtnAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnAlterarKeyPressed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Close.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSalvarCidade)
                        .addGap(10, 10, 10)
                        .addComponent(jBtnSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTxfIdCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnSalvarCidade)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnNovo)
                    .addComponent(jBtnSelecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Cidades");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 330, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/FUNDO/BARRA DE FUNDO.jpeg"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfNomeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
        }
    }//GEN-LAST:event_jTxfNomeKeyPressed

    private void jBtnSalvarCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnSalvarCidadeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jBtnSalvarCidade.doClick();
        }
    }//GEN-LAST:event_jBtnSalvarCidadeKeyPressed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed

    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jTxfIbgeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfIbgeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfIbgeKeyPressed

    private void jBtnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnAlterarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAlterarKeyPressed

    private void jBtnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnNovoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnNovoKeyPressed

    private void jTxfIdCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxfIdCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfIdCidadeActionPerformed

    private void jTxfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfNomeActionPerformed

    private void jBtnSelecionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnSelecionarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSelecionarKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnSalvarCidade;
    private javax.swing.JButton jBtnSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblCidade;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTxfIbge;
    private javax.swing.JTextField jTxfIdCidade;
    private javax.swing.JTextField jTxfNome;
    // End of variables declaration//GEN-END:variables
}
