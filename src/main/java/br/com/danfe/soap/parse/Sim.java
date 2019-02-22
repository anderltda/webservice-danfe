package br.com.danfe.soap.parse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

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
public class Sim extends SOAP {

	protected static final Log log = LogFactory.getLog(Sim.class);

	private final static String CHAVE_ACESSO = "FE94F5B6-019C-4966-B3E3-71E02CAABC9A";
	private final static String SOAP_ACTION = "http://ws.simconsultas.com.br/service.asmx/GetNfeTipo?";	
	public static String NAME_INIT = "SIM";

	private static Integer TIPO_SIMPLES = 3; 
	private static Integer TIPO_COMPLETO = 1;
	protected String xml = null;
	
	public Sim() {
		super();
	}

	public Sim(SrvDanfe danfe, DanfeService service, InputStream inputStream) throws Exception {		
		log.debug("Inicio File SIM current thread:" + Thread.currentThread().getId());
		
		if(inputStream != null) {
			this.danfe = danfe;
			this.danfe.setMailbox(true);
			this.inputStream = inputStream;
			this.service = service;
			init();
		}
		
		log.debug("Final File SIM current thread:" + Thread.currentThread().getId());
	}

	@Override
	public void read() throws Exception {

		log.debug("Consultando SIM current thread:" + Thread.currentThread().getId());

		StringBuilder builder = new StringBuilder();
		builder.append("chaveAcesso=");
		builder.append(CHAVE_ACESSO + "&");
		builder.append("chaveNFe=");
		builder.append(danfe.getDanfe() + "&");
		builder.append("Tipo=");
		builder.append(completo ? TIPO_COMPLETO : TIPO_SIMPLES);		

		URL url = new URL(StringUtil.getString(SOAP_ACTION + builder.toString()));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		xml = StringUtil.convertInputStreamToString(connection.getInputStream());
		inputStream = new ByteArrayInputStream(StringUtil.convertNode(xml).getBytes("UTF-8"));
		
		connection.disconnect();	

		init();			

		log.debug("Final da Consulta SIM current thread:" + Thread.currentThread().getId());
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		tag = qName;

		if(StringUtil.isEqual("ide", qName)) {
			detalhe = new Detail(qName);	
			detalhes.add(detalhe);
		} else if(StringUtil.isEqual("emit", qName)) {
			detalhe = new Detail(qName);	
			detalhes.add(detalhe);
		} else if(StringUtil.isEqual("dest", qName)) {
			detalhe = new Detail(qName);		
			detalhes.add(detalhe);
		} else if(StringUtil.isEqual("total", qName)) {
			detalhe = new Detail(qName);		
			detalhes.add(detalhe);
			prod = false;
		} else if(StringUtil.isEqual("transp", qName)) {
			detalhe = new Detail(qName);		
			detalhes.add(detalhe);
		} else if(StringUtil.isEqual("det", qName)) {
			produto = new Product();		
			produtos.add(produto);
			prod = true;
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
