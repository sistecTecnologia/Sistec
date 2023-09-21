/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.visao.Produto;

import brSoft.uteis.CaseLimited.UpperCaseValores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import sistec.CellEditor.gradeProdutoCellEditor;
import sistec.CellRenderer.GradeProdutoCellRenderer;
import sistec.ColumModel.Produto.GradeProdutoColumnModel;
import sistec.bean.produto.Aliquota;
import sistec.bean.produto.GradeProduto;
import sistec.bean.produto.Marca;
import sistec.bean.produto.Produto;
import sistec.tableModel.Produto.GradeProdutoTableModel;
import uteis.FieldListener;
import uteis.UpperCaseLimitado;
import uteis.UpperCaseParaNumerico;

/**
 *
 * @author SERVIDOR
 */
public class ProdutosCadastro extends javax.swing.JDialog {

    private Produto produto = new Produto();
    private List<GradeProduto> lstGp;

    /**
     * Creates new form ProdurosCadastro
     */
    public ProdutosCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        jTxfAliquota.setDocument(new UpperCaseLimitado(20));
        jTxfCest.setDocument(new UpperCaseLimitado(8));
        jTxfCusto.setDocument(new UpperCaseValores(11));
        jTxfDescricao.setDocument(new UpperCaseLimitado(150));
        jTxfEstoque.setDocument(new UpperCaseValores(11));
        jTxfIdAliquota.setDocument(new UpperCaseParaNumerico(4));
        jTxfIdMarca.setDocument(new UpperCaseParaNumerico(4));
        jTxfNcm.setDocument(new UpperCaseParaNumerico(8));
        jTxfDescricao.addFocusListener(new FieldListener());
        this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getRootPane().getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
// TABELA GRTADE PRODUTO
        jTblGradeProduto.setAutoCreateColumnsFromModel(false);
        jTblGradeProduto.setColumnModel(new GradeProdutoColumnModel());
        jTblGradeProduto.getSelectionModel().addListSelectionListener(jTblGradeProduto);
        jTblGradeProduto.setDefaultEditor(GradeProduto.class, new gradeProdutoCellEditor(produto.getLstGradeProduto()));
        jTblGradeProduto.setAutoResizeMode(jTblGradeProduto.AUTO_RESIZE_OFF);
    }

    public void addActionListene(ActionListener listener) {
        jBtnAliquota.addActionListener(listener);
        jBtnAlterar.addActionListener(listener);
        jBtnCest.addActionListener(listener);
        jBtnExcluir.addActionListener(listener);
        jBtnMarca.addActionListener(listener);
        jBtnNcm.addActionListener(listener);
        jBtnNovo.addActionListener(listener);
        jBtnAddGrade.addActionListener(listener);
        jBtnRemoveGrade.addActionListener(listener);

    }

    public void setMarca(Marca marca) {
        jTxfIdMarca.setText(marca.getIdMarca() + "");
        jTxfMarca.setText(marca.getNomeMarca());
    }

    public void setAliquota(Aliquota aliq) {
        if (aliq.getAliquota().length() > 12) {
            aliq.setAliquota(aliq.getAliquota().substring(0, 12));
        }
        jTxfIdAliquota.setText(aliq.getIdAliquota() + "");
        jTxfAliquota.setText(aliq.getAliquota());
    }

    public void setlistGrade(List<GradeProduto> lstProduto) {
        this.lstGp = lstProduto;
        jTblGradeProduto.setModel(new GradeProdutoTableModel(lstProduto));
        jTblGradeProduto.setColumnModel(new GradeProdutoColumnModel());
        jTblGradeProduto.setDefaultRenderer(GradeProduto.class, new GradeProdutoCellRenderer());
    }
    private GradeProdutoTableModel gradeProdutoTableModel;

    public GradeProduto getGradeProdutoSelecionado() throws Exception {
        if (jTblGradeProduto.getSelectedRow() == -1) {
            throw new Exception("Nao foi selecionado nenhum Registo!");
        }
        return ((GradeProdutoTableModel) jTblGradeProduto.getModel()).getValorCidade(jTblGradeProduto.getSelectedRow());

    }

    public void getProduto(Produto p) {
        p.setDescricaoProduto(jTxfDescricao.getText());
        p.getAliquota().setIdAliquota(Integer.parseInt(jTxfIdAliquota.getText()));
        p.getAliquota().setAliquota(jTxfAliquota.getText());
        p.setCest(jTxfCest.getText());
        p.setNcm(jTxfNcm.getText());
        p.getMarca().setIdMarca(Integer.parseInt(jTxfIdMarca.getText()));
        p.getMarca().setNomeMarca(jTxfMarca.getText());
        p.setEstoque(Double.parseDouble(jTxfEstoque.getText()));
        p.setPrecoCusto(Double.parseDouble(jTxfCusto.getText()));
        p.setLstGradeProduto(lstGp);

    }

    public void setProduto(Produto p) {

    }

    public void setCellEditor() {
        jTblGradeProduto.setDefaultEditor(GradeProduto.class, new gradeProdutoCellEditor(produto.getLstGradeProduto()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxfDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxfCusto = new javax.swing.JTextField();
        jTxfIdMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxfMarca = new javax.swing.JTextField();
        jBtnMarca = new javax.swing.JButton();
        jTxfAliquota = new javax.swing.JTextField();
        jBtnAliquota = new javax.swing.JButton();
        jTxfIdAliquota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxfNcm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBtnNcm = new javax.swing.JButton();
        jTxfCest = new javax.swing.JTextField();
        jBtnCest = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTxfEstoque = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblGradeProduto = new javax.swing.JTable();
        jBtnAddGrade = new javax.swing.JButton();
        jBtnRemoveGrade = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBtnExcluir = new javax.swing.JButton();
        jBtnNovo = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Cadastrar Produto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/FUNDO/BARRA DE FUNDO.jpeg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 70));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("DESCRIÇÃO");

        jTxfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfDescricaoKeyPressed(evt);
            }
        });

        jLabel3.setText("MARCA");

        jTxfCusto.setText("0");

        jTxfIdMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfIdMarcaKeyPressed(evt);
            }
        });

        jLabel4.setText("PREÇO CUSTO");

        jBtnMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Find.png"))); // NOI18N
        jBtnMarca.setActionCommand("marca");

        jBtnAliquota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Find.png"))); // NOI18N
        jBtnAliquota.setActionCommand("ConsultaAliquota");

        jLabel5.setText("ALIQUOTA");

        jLabel6.setText("NCM");

        jBtnNcm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Find.png"))); // NOI18N

        jTxfCest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxfCestActionPerformed(evt);
            }
        });

        jBtnCest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Find.png"))); // NOI18N

        jLabel8.setText("CEST");

        jTxfEstoque.setText("0");

        jLabel9.setText("ESTOQUE");

        jTblGradeProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4", "Título 5", "Título 6", "Título 7", "Título 8"
            }
        ));
        jTblGradeProduto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTblGradeProduto);

        jBtnAddGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Add.png"))); // NOI18N
        jBtnAddGrade.setToolTipText("");
        jBtnAddGrade.setActionCommand("addGrade");

        jBtnRemoveGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Close.png"))); // NOI18N
        jBtnRemoveGrade.setActionCommand("removeGrade");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTxfCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBtnNcm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxfNcm, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTxfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(jBtnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(jTxfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBtnCest, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxfCest, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxfIdAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jBtnAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTxfAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAddGrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRemoveGrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAddGrade))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTxfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTxfCest, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnCest, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jTxfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnRemoveGrade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTxfIdAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTxfNcm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnNcm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTxfAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxfCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTxfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Delete.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");

        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Create.png"))); // NOI18N
        jBtnNovo.setText("Novo");
        jBtnNovo.setActionCommand("NovoProduto");

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Save.png"))); // NOI18N
        jBtnAlterar.setText("Salvar");
        jBtnAlterar.setActionCommand("salvarProduto");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jBtnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnNovo)
                .addGap(10, 10, 10)
                .addComponent(jBtnExcluir)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jTxfCestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxfCestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfCestActionPerformed

    private void jTxfDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfDescricaoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfIdMarca.requestFocus();
        }

    }//GEN-LAST:event_jTxfDescricaoKeyPressed

    private void jTxfIdMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfIdMarcaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jBtnMarca.doClick();

        }
    }//GEN-LAST:event_jTxfIdMarcaKeyPressed

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
            java.util.logging.Logger.getLogger(ProdutosCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutosCadastro dialog = new ProdutosCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAddGrade;
    private javax.swing.JButton jBtnAliquota;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCest;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnMarca;
    private javax.swing.JButton jBtnNcm;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnRemoveGrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTblGradeProduto;
    private javax.swing.JTextField jTxfAliquota;
    private javax.swing.JTextField jTxfCest;
    private javax.swing.JTextField jTxfCusto;
    private javax.swing.JTextField jTxfDescricao;
    private javax.swing.JTextField jTxfEstoque;
    private javax.swing.JTextField jTxfIdAliquota;
    private javax.swing.JTextField jTxfIdMarca;
    private javax.swing.JTextField jTxfMarca;
    private javax.swing.JTextField jTxfNcm;
    // End of variables declaration//GEN-END:variables
}
