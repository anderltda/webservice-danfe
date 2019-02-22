package br.com.danfe.soap.parse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import br.com.danfe.commons.util.NumberUtil;
import br.com.danfe.commons.util.StringUtil;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.soap.SOAP;
import br.com.danfe.soap.reader.Detail;
import br.com.danfe.soap.reader.Product;
import br.com.danfe.soap.service.DanfeService;

/**
 * @author andersonsilva-tool
 *
 */
public class Dbi extends SOAP {

	protected static final Log log = LogFactory.getLog(Dbi.class);

	private final static String USUARIO = "danfe";
	private final static String SENHA = "d2002b11i476";
	private final static String SOAP_ACTION = "https://ws1.smartscore.com.br/dbiws.dll/soap/IDBIws";	
	public static String NAME_INIT = "DBI";

	private static Integer TIPO_SIMPLES = 20; 
	private static Integer TIPO_COMPLETO = 21;
	protected String xml = null;
	
	public Dbi() {
		super();
	}

	public Dbi(SrvDanfe danfe, DanfeService service, InputStream inputStream) throws Exception {		
		log.debug("Inicio File DBI current thread:" + Thread.currentThread().getId());
		
		if(inputStream != null) {
			this.danfe = danfe;
			this.danfe.setMailbox(true);
			this.inputStream = inputStream;
			this.service = service;
			init();
		}
		
		log.debug("Final File DBI current thread:" + Thread.currentThread().getId());
	}

	@Override
	public void read() throws Exception {

		log.debug("Consultando DBI current thread:" + Thread.currentThread().getId());

		StringBuilder builder = new StringBuilder();
		builder.append("<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ");
		builder.append("xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:DBIwsIntf-IDBIws\">");
		builder.append("<soapenv:Header/>");
		builder.append("<soapenv:Body>");
		builder.append("<urn:ConsultaOnLine soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">");
		builder.append("<usuario xsi:type=\"xsd:string\">");
		builder.append(USUARIO);
		builder.append("</usuario>");
		builder.append("<senha xsi:type=\"xsd:string\">");
		builder.append(SENHA);
		builder.append("</senha>");
		builder.append("<CodigoConsulta xsi:type=\"xsd:int\">");
		builder.append(completo ? TIPO_COMPLETO : TIPO_SIMPLES);
		builder.append("</CodigoConsulta>");
		builder.append("<Valor1 xsi:type=\"xsd:string\">");
		builder.append(danfe.getDanfe());
		builder.append("</Valor1>");
		builder.append("<Valor2 xsi:type=\"xsd:string\"/>");
		builder.append("<Valor3 xsi:type=\"xsd:string\"/>");
		builder.append("<Valor4 xsi:type=\"xsd:string\"/>");
		builder.append("<Valor5 xsi:type=\"xsd:string\"/>");
		builder.append("</urn:ConsultaOnLine>");
		builder.append("</soapenv:Body>");
		builder.append("</soapenv:Envelope>");	

		acceptSSL();

		URL url = new URL(StringUtil.getString(SOAP_ACTION));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true); 
		connection.setRequestMethod("POST");
		OutputStream out = connection.getOutputStream();
		OutputStreamWriter wout = new OutputStreamWriter(out, "UTF-8");
		wout.write(StringUtil.getString(builder.toString()));  			
		wout.flush();
		out.close();
		xml = StringUtil.convertInputStreamToString(connection.getInputStream());
		inputStream = new ByteArrayInputStream(StringUtil.convertNode(xml).getBytes("UTF-8"));
		connection.disconnect();	

		init();

		log.debug("Final da Consulta DBI current thread:" + Thread.currentThread().getId());
	}

	private static void acceptSSL() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		tag = qName;

		if(StringUtil.isEqual("Registro", qName) && NumberUtil.getInteger(attributes.getValue(0)).intValue() == 0) {
			detalhe = new Detail();
			detalhes.add(detalhe);
		} else if(StringUtil.isEqual("Registro", qName) && NumberUtil.getInteger(attributes.getValue(0)) > 0) {
			produto = new Product();	
			produtos.add(produto);
			prod = true;
		} else if(StringUtil.isEqual("CodErro", qName)) {
			detalhe = new Detail();
			detalhes.add(detalhe);
		}
	}

	@Override
	public String getName() {	
		return NAME_INIT;
	}
	
	@Override
	public String getXml() {
		return xml;
	}	
}
