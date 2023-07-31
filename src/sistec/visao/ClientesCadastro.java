/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.visao;

import Jm.JMascara;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import sistec.bean.Cidade;
import sistec.bean.Pessoa;
import uteis.UpperCaseLimitado;
import uteis.UpperCaseParaNumerico;

/**
 *
 * @author CASSIO JUNIOR
 */
public class ClientesCadastro extends javax.swing.JDialog {

    /**
     * Creates new form ClientesCadastro
     */
    public ClientesCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jTxfBairro.setDocument(new UpperCaseLimitado(50));
        jTxfCep.setDocument(new UpperCaseParaNumerico(20));
        jTxfCidade.setDocument(new UpperCaseLimitado(100));
        jTxfCnpj.setDocument(new UpperCaseParaNumerico(20));
        jTxfEndereco.setDocument(new UpperCaseLimitado(200));
        jTxfInscricaoEstadual.setDocument(new UpperCaseParaNumerico(20));
        jTxfLote.setDocument(new UpperCaseLimitado(20));
        jTxfNomeFantasia.setDocument(new UpperCaseLimitado(200));
        jTxfQuadra.setDocument(new UpperCaseLimitado(20));
        jTxfRazaoSocial.setDocument(new UpperCaseLimitado(200));
        jTxfTelefone.setDocument(new UpperCaseLimitado(30));
        jTxfIdCidade.setDocument(new UpperCaseParaNumerico(2));
         this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getRootPane().getActionMap().put("escape", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBtnSalvar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxfRazaoSocial = new javax.swing.JTextField();
        jTxfCnpj = new javax.swing.JTextField();
        jTxfInscricaoEstadual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxfTelefone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxfNomeFantasia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxfBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxfQuadra = new javax.swing.JTextField();
        jTxfEndereco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxfLote = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxfCidade = new javax.swing.JTextField();
        jBtnBuscaCidade = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTxfIdPessoa = new javax.swing.JTextField();
        jTxfIdCidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTxfCep = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Clientes");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Cadastrar Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/FUNDO/BARRA DE FUNDO.jpeg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 60));

        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Save.png"))); // NOI18N
        jBtnSalvar.setText("Salvar");
        jBtnSalvar.setActionCommand("SalvarCliente");

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Erase.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnSalvar)
                .addGap(62, 62, 62)
                .addComponent(jBtnCancelar)
                .addGap(190, 190, 190))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSalvar)
                    .addComponent(jBtnCancelar))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel2.setText("Nome / Razão Social");

        jLabel3.setText(" CPF / CNPJ");

        jTxfRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfRazaoSocialKeyPressed(evt);
            }
        });

        jTxfCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxfCnpjFocusLost(evt);
            }
        });
        jTxfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfCnpjKeyPressed(evt);
            }
        });

        jTxfInscricaoEstadual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfInscricaoEstadualKeyPressed(evt);
            }
        });

        jLabel6.setText("Inscricao Estadual");

        jTxfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfTelefoneKeyPressed(evt);
            }
        });

        jLabel8.setText("Telefone");

        jTxfNomeFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfNomeFantasiaKeyPressed(evt);
            }
        });

        jLabel9.setText("Nome Fantasia");

        jLabel10.setText("Bairro");

        jTxfBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxfBairroActionPerformed(evt);
            }
        });
        jTxfBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfBairroKeyPressed(evt);
            }
        });

        jLabel11.setText("Qd");

        jTxfQuadra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfQuadraKeyPressed(evt);
            }
        });

        jTxfEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfEnderecoKeyPressed(evt);
            }
        });

        jLabel12.setText("Endereço");

        jTxfLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfLoteKeyPressed(evt);
            }
        });

        jLabel13.setText("LT");

        jTxfCidade.setEditable(false);
        jTxfCidade.setBackground(new java.awt.Color(255, 255, 255));
        jTxfCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfCidadeKeyPressed(evt);
            }
        });

        jBtnBuscaCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistec/imagens/18x18/Find.png"))); // NOI18N
        jBtnBuscaCidade.setActionCommand("consultaCidade");
        jBtnBuscaCidade.setPreferredSize(new java.awt.Dimension(51, 25));

        jLabel14.setText("Cidade");

        jTxfIdPessoa.setEditable(false);
        jTxfIdPessoa.setBackground(new java.awt.Color(255, 255, 255));
        jTxfIdPessoa.setText("0");

        jLabel15.setText("Codigo");

        jTxfCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxfCepKeyPressed(evt);
            }
        });

        jLabel16.setText("Cep");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(132, 132, 132)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTxfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnBuscaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(140, 140, 140)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jTxfLote)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxfIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTxfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jTxfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTxfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxfNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTxfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxfQuadra, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTxfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jTxfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxfNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxfLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxfQuadra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnBuscaCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtnBuscaCidade, jTxfCep, jTxfCidade, jTxfEndereco, jTxfIdCidade});

        jTabbedPane1.addTab("Clientes", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void getCliente(Pessoa pessoa) {
        pessoa.setBairro(jTxfBairro.getText());
        pessoa.setCidade(jTxfCidade.getText());
        pessoa.setCpfCnpj(jTxfCnpj.getText());
        pessoa.setEndereco(jTxfEndereco.getText());
        pessoa.setIdCidade(Integer.parseInt(jTxfIdCidade.getText()));
        pessoa.setIdPessoa(Integer.parseInt(jTxfIdPessoa.getText()));
        pessoa.setInscricaoEstadual(jTxfInscricaoEstadual.getText());
        pessoa.setLote(jTxfLote.getText());
        pessoa.setNomeFantasia(jTxfNomeFantasia.getText());
        pessoa.setQuadra(jTxfQuadra.getText());
        pessoa.setNomeRazaoSocial(jTxfRazaoSocial.getText());
        pessoa.setTelefone(jTxfTelefone.getText());
        pessoa.setCep(jTxfCep.getText());
    }

    public void setCliente(Pessoa p) {
        jTxfBairro.setText(p.getBairro());
        jTxfCep.setText(p.getCep());
        jTxfCidade.setText(p.getCidade());
        jTxfCnpj.setText(p.getCpfCnpj());
        jTxfEndereco.setText(p.getEndereco());
        jTxfIdCidade.setText(p.getIdCidade() + "");
        jTxfIdPessoa.setText(p.getIdPessoa() + "");
        jTxfInscricaoEstadual.setText(p.getInscricaoEstadual());
        jTxfLote.setText(p.getLote());
        jTxfNomeFantasia.setText(p.getNomeFantasia());
        jTxfQuadra.setText(p.getQuadra());
        jTxfRazaoSocial.setText(p.getNomeRazaoSocial());
        jTxfTelefone.setText(p.getTelefone());
    }
    private void jTxfLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfLoteKeyPressed
        jBtnBuscaCidade.requestFocus();

    }//GEN-LAST:event_jTxfLoteKeyPressed

    private void jTxfEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfEnderecoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfBairro.requestFocus();

        }
    }//GEN-LAST:event_jTxfEnderecoKeyPressed

    private void jTxfQuadraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfQuadraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfLote.requestFocus();

        }
    }//GEN-LAST:event_jTxfQuadraKeyPressed

    private void jTxfBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfBairroKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfQuadra.requestFocus();

        }
    }//GEN-LAST:event_jTxfBairroKeyPressed

    private void jTxfBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxfBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfBairroActionPerformed

    private void jTxfNomeFantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfNomeFantasiaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfTelefone.requestFocus();

        }
    }//GEN-LAST:event_jTxfNomeFantasiaKeyPressed

    private void jTxfTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfTelefoneKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfEndereco.requestFocus();

        }
    }//GEN-LAST:event_jTxfTelefoneKeyPressed

    private void jTxfInscricaoEstadualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfInscricaoEstadualKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfNomeFantasia.requestFocus();

        }
    }//GEN-LAST:event_jTxfInscricaoEstadualKeyPressed

    private void jTxfCnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfCnpjKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfInscricaoEstadual.requestFocus();

        }
    }//GEN-LAST:event_jTxfCnpjKeyPressed

    private void jTxfRazaoSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfRazaoSocialKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTxfCnpj.requestFocus();

        }
    }//GEN-LAST:event_jTxfRazaoSocialKeyPressed

    private void jTxfCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfCidadeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfCidadeKeyPressed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxfCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxfCepKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxfCepKeyPressed

    private void jTxfCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxfCnpjFocusLost

        jTxfCnpj.setText(JMascara.GetJmascaraCpfCnpj(jTxfCnpj.getText()));
    }//GEN-LAST:event_jTxfCnpjFocusLost
    public void addActionListener(ActionListener listener) {
        jBtnBuscaCidade.addActionListener(listener);
        jBtnCancelar.addActionListener(listener);
        jBtnSalvar.addActionListener(listener);
    }

    public void setCidade(Cidade cidade) {
        jTxfIdCidade.setText(cidade.getIdCidade() + "");
        jTxfCidade.setText(cidade.getNome());
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscaCidade;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTxfBairro;
    private javax.swing.JTextField jTxfCep;
    private javax.swing.JTextField jTxfCidade;
    private javax.swing.JTextField jTxfCnpj;
    private javax.swing.JTextField jTxfEndereco;
    private javax.swing.JTextField jTxfIdCidade;
    private javax.swing.JTextField jTxfIdPessoa;
    private javax.swing.JTextField jTxfInscricaoEstadual;
    private javax.swing.JTextField jTxfLote;
    private javax.swing.JTextField jTxfNomeFantasia;
    private javax.swing.JTextField jTxfQuadra;
    private javax.swing.JTextField jTxfRazaoSocial;
    private javax.swing.JTextField jTxfTelefone;
    // End of variables declaration//GEN-END:variables
}
