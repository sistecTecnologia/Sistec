/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistec.bean;

/**
 *
 * @author SERVIDOR
 */
public class ConfiguracaoConexao {

    private String servidor;
    private String porta;
    private int numTerminal;
    private String isServidor;

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public int getNumTerminal() {
        return numTerminal;
    }

    public void setNumTerminal(int numTerminal) {
        this.numTerminal = numTerminal;
    }

    public String getIsServidor() {
        return isServidor;
    }

    public void setIsServidor(String isServidor) {
        this.isServidor = isServidor;
    }

    public String getPortaConexaoCentral() {
        return portaConexaoCentral;
    }

    public void setPortaConexaoCentral(String portaConexaoCentral) {
        this.portaConexaoCentral = portaConexaoCentral;
    }

    public String getBaseDados() {
        return baseDados;
    }

    public void setBaseDados(String baseDados) {
        this.baseDados = baseDados;
    }

    public String getConexaoExterna() {
        return conexaoExterna;
    }

    public void setConexaoExterna(String conexaoExterna) {
        this.conexaoExterna = conexaoExterna;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    private String portaConexaoCentral;
    private String baseDados;
    private String conexaoExterna;
    private String usuario;

}
