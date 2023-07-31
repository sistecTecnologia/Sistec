/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.visao.Produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import jdk.nashorn.internal.ir.BreakNode;
import sistec.ColumModel.CidadeColumnModel;
import sistec.ColumModel.Produto.MarcaColumnModel;
import sistec.bean.produto.Marca;
import sistec.bean.Usuario;
import sistec.tableModel.CidadeTableModel;
import sistec.tableModel.Produto.MarcaTableModel;
import uteis.UpperCaseLimitado;
import uteis.UpperCaseParaNumerico;

/**
 *
 * @author CASSIO JUNIOR
 */
public class MarcaCons extends javax.swing.JDialog {

    /**
     * Creates new form UsuarioCadastro
     */
    public MarcaCons(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTblMarca.requestFocus();
        setResizable(false);
        setLocationRelativeTo(null);
        jTblMarca.setColumnModel(new MarcaColumnModel(0));
        jTxfNome.setDocument(new UpperCaseLimitado(60));
        jTxfParametroConsulta.setDocument(new UpperCaseLimitado(60));
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getRootPane().getActionMap().put("escape", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public void getMarca(Marca marca) {
        marca.setNomeMarca(jTxfNome.getText());
        marca.setIdMarca(Integer.parseInt(jTxfIdMarca.getText()));
    }

    public void addActionListener(ActionListener listener) {
        jBtnSalvarCidade.addActionListener(listener);
        jBtnExcluir.addActionListener(listener);
        jBtnAlterar.addActionListener(listener);
        jBtnNovo.addActionListener(listener);
        jBtnSelecionar.addActionListener(listener);
    }

    public void desabilitarCampos(boolean nome) {
        jTxfNome.setEditable(nome);
    }

    public void limparCampos() {
        jTxfNome.setText("");
        jTxfIdMarca.setText("0");
    }

    public void setList(List<Marca> lst) {
        jTblMarca.setModel(new MarcaTableModel(lst));
        jTblMarca.setColumnModel(new MarcaColumnModel(0));
    }

    public void desabilitarBotes(boolean alterar, boolean excluir, boolean novo, boolean salvar) {
        jBtnAlterar.setEnabled(alterar);
        jBtnExcluir.setEnabled(excluir);
        jBtnNovo.setEnabled(novo);
        jBtnSalvarCidade.setEnabled(salvar);
    }
    private CidadeTableModel cidadeTableModel;

    public Marca getMarcaSelecionado() throws Exception {
        if (jTblMarca.getSelectedRow() == -1) {
            throw new Exception("Nao foi selecionado nenhuma Cidade");
        }
        return ((MarcaTableModel) jTblMarca.getModel()).getValorCidade(jTblMarca.getSelectedRow());

    }

    public void setMarca(Marca marca) {
        jTxfIdMarca.setText(marca.getIdMarca() + "");
        jTxfNome.setText(marca.getNomeMarca());
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
        jTxfParametroConsulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblMarca = new javax.swing.JTable();
        jTxfNome = new javax.swing.JTextField();
        jTxfIdMarca = new javax.swing.JTextField();
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
        setResizable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Find.png"))); // NOI18N

        jTblMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTblMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblMarcaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblMarca);

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

        jTxfIdMarca.setEditable(false);
        jTxfIdMarca.setBackground(new java.awt.Color(255, 255, 255));
        jTxfIdMarca.setText("0");
        jTxfIdMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxfIdMarcaActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome");

        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Add.png"))); // NOI18N
        jBtnNovo.setText("Novo");
        jBtnNovo.setActionCommand("novaMarca");
        jBtnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnNovoKeyPressed(evt);
            }
        });

        jBtnSalvarCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Save.png"))); // NOI18N
        jBtnSalvarCidade.setText("Salvar");
        jBtnSalvarCidade.setActionCommand("salvarMarca");
        jBtnSalvarCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnSalvarCidadeKeyPressed(evt);
            }
        });

        jBtnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Apply.png"))); // NOI18N
        jBtnSelecionar.setText("Selecionar");
        jBtnSelecionar.setActionCommand("selecionarMarca");
        jBtnSelecionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnSelecionarKeyPressed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Notes.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.setActionCommand("alterarMarca");
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTxfIdMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(168, 168, 168))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTxfParametroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnSalvarCidade)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnNovo)
                    .addComponent(jBtnSelecionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxfParametroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Marca");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 330, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/FUNDO/BARRA DE FUNDO.jpeg"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
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

        setBounds(0, 0, 566, 427);
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

    private void jBtnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnAlterarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAlterarKeyPressed

    private void jBtnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnNovoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnNovoKeyPressed

    private void jTxfIdMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxfIdMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfIdMarcaActionPerformed

    private void jTxfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfNomeActionPerformed

    private void jBtnSelecionarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnSelecionarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSelecionarKeyPressed

    private void jTblMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblMarcaMouseClicked
        if (evt.getClickCount() == 2) {

            jBtnSelecionar.doClick();
        }
    }//GEN-LAST:event_jTblMarcaMouseClicked

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblMarca;
    private javax.swing.JTextField jTxfIdMarca;
    private javax.swing.JTextField jTxfNome;
    private javax.swing.JTextField jTxfParametroConsulta;
    // End of variables declaration//GEN-END:variables
}
