/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author CASSIO JUNIOR
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class EmitirNFe {

    public static void main(String[] args) throws Exception {
        // carrega o certificado digital A1
        KeyStore ks = KeyStore.getInstance("PKCS12");
        String senha = "senha_do_certificado";
        File certificado = new File("caminho_do_certificado.pfx");
        ks.load(new FileInputStream(certificado), senha.toCharArray());
        String alias = (String) ks.aliases().nextElement();
        PrivateKey chavePrivada = (PrivateKey) ks.getKey(alias, senha.toCharArray());
        X509Certificate certificadoDigital = (X509Certificate) ks.getCertificate(alias);

        // carrega o XML da NFe
        File xmlNFe = new File("caminho_do_xml_da_nfe.xml");
        InputStream is = new FileInputStream(xmlNFe);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(is);
        Element nfeElement = doc.getDocumentElement();

        // assina a NFe
        AssinaturaDigital assinaturaDigital = new AssinaturaDigital();
        assinaturaDigital.assinar(nfeElement, chavePrivada, certificadoDigital);

        // envia a NFe para a Sefaz
        String cnpjEmitente = "12345678901234";
        String ufEmitente = "SP";
        String tipoAmbiente = "1"; // ambiente de homologação
        String urlSefaz = "https://homologacao.nfe.fazenda.gov.br/NFeAutorizacao4/NFeAutorizacao4.asmx";
        EnvioNFe envioNFe = new EnvioNFe(cnpjEmitente, ufEmitente, tipoAmbiente, urlSefaz);
        String respostaSefaz = envioNFe.enviar(nfeElement);

        // trata a resposta da Sefaz
        DocumentBuilderFactory dbfResposta = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbResposta = dbfResposta.newDocumentBuilder();
        Document docResposta = dbResposta.parse(new InputSource(new StringReader(respostaSefaz)));
        NodeList nodeList = docResposta.getDocumentElement().getElementsByTagName("infProt");
        if (nodeList.getLength() > 0) {
            String codigoStatus = nodeList.item(0).getAttributes().getNamedItem("cStat").getTextContent();
            String descricaoStatus = nodeList.item(0).getAttributes().getNamedItem("xMotivo").getTextContent();
            if (codigoStatus.equals("100")) {
                System.out.println("NFe emitida com sucesso!");
            } else {
                System.out.println("Erro ao emitir NFe: " + codigoStatus + " - " + descricaoStatus);
            }
        }
    }
}
