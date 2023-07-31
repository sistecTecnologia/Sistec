/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author CASSIO JUNIOR
 */
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import java.net.HttpURLConnection;

public class EnvioNFe {

    private String cnpjEmitente;
    private String ufEmitente;
    private String tipoAmbiente;
    private String urlSefaz;

    public EnvioNFe(String cnpjEmitente, String ufEmitente, String tipoAmbiente, String urlSefaz) {
        this.cnpjEmitente = cnpjEmitente;
        this.ufEmitente = ufEmitente;
        this.tipoAmbiente = tipoAmbiente;
        this.urlSefaz = urlSefaz;
    }

    public String enviar(Element nfeElement) throws Exception {
        String xml = documentToString(nfeElement);
        String soapRequest = criarSoapRequest(xml);
        String soapResponse = enviarSoapRequest(soapRequest);
        return soapResponse;
    }

    private String documentToString(Element element) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        org.apache.xml.serialize.OutputFormat format = new org.apache.xml.serialize.OutputFormat();
        format.setIndenting(true);
        org.apache.xml.serialize.XMLSerializer serializer = new org.apache.xml.serialize.XMLSerializer(output, format);
        serializer.serialize(element);
        return output.toString();
    }

    private String criarSoapRequest(String xml) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String dataHora = sdf.format(new Date());

        String cabecalho = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:ns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4\">"
                + "<soapenv:Header>"
                + "<ns:cabecMsg xmlns:ns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4\" versao=\"4.00\">"
                + "<ns:versaoDados>4.00</ns:versaoDados>"
                + "<ns:tpAmb>" + tipoAmbiente + "</ns:tpAmb>"
                + "<ns:cnpj>" + cnpjEmitente + "</ns:cnpj>"
                + "<ns:cpf></ns:cpf>"
                + "<ns:dhEmi>" + dataHora + "</ns:dhEmi>"
                + "<ns:hashAlg>" + "SHA-1" + "</ns:hashAlg>"
                + "<ns:signature></ns:signature>"
                + "</ns:cabecMsg>"
                + "</soapenv:Header>"
                + "<soapenv:Body>"
                + "<ns:nfeDadosMsg xmlns:ns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4\">"
                + xml
                + "</ns:nfeDadosMsg>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";

        return cabecalho;
    }

    private String enviarSoapRequest(String soapRequest) throws Exception {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlSefaz);
//            connection = (connection.getOutputStream().write(soapRequest.getBytes());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            connection.getOutputStream().write(soapRequest.getBytes());

            InputStream responseStream = connection.getInputStream();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document responseDoc = db.parse(new InputSource(responseStream));

            return documentToString(responseDoc.getDocumentElement());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String calcularHash(String conteudo) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(conteudo.getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toHexString(0xFF & digest[i]));
        }
        return sb.toString();
    }
}
