/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.Produto.Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistec.bean.produto.Aliquota;
import sistec.visao.Produto.AliquotaCons;

/**
 *
 * @author SERVIDOR
 */
public class aliquotaControler implements ActionListener {

    AliquotaCons aliqCons = new AliquotaCons(new javax.swing.JFrame(), true);
    private final Aliquota aliquota;
    private List<Aliquota> lstAliquota;

    public aliquotaControler(Aliquota aliquota) {
        this.aliquota = aliquota;
        adicionarAliquota();
        aliqCons.setList(lstAliquota);
        aliqCons.addActionListener(this);
        aliqCons.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "SelecionarAliquota": {
                try {
                    selecionarAliquota();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            break;
        }
    }

    private void selecionarAliquota() throws Exception {
        Aliquota aliq = aliqCons.getAliquotaSelecionada();
        new UteisControler(aliquota, aliq);
        aliqCons.dispose();
    }

    private void adicionarAliquota() {
        lstAliquota = new ArrayList<>();
        Aliquota aliq = new Aliquota();

        aliq.setIdAliquota(1);
        aliq.setAliquota("17-Tributado");
        lstAliquota.add(aliq);
        aliq = new Aliquota();
        aliq.setIdAliquota(2);
        aliq.setAliquota("F-Substituição Tributaria");
        lstAliquota.add(aliq);
        aliq = new Aliquota();
        aliq.setIdAliquota(3);
        aliq.setAliquota("Isento");
        lstAliquota.add(aliq);

    }

}
