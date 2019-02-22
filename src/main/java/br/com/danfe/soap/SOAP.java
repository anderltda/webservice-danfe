package br.com.danfe.soap;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.danfe.commons.util.ReflectionUtil;
import br.com.danfe.commons.util.StringUtil;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.soap.reader.Detail;
import br.com.danfe.soap.reader.Product;
import br.com.danfe.soap.reader.Reader;
import br.com.danfe.soap.service.DanfeService;

/**
 * @author andersonsilva-tool
 * 
 */
public abstract class SOAP extends DefaultHandler implements Reader {

	CyclicBarrier barrier;

	protected List<Product> produtos = null;
	protected List<Detail> detalhes = null;

	protected Detail detalhe = null;
	protected Product produto = null;
	protected Boolean prod = false;
	protected String tag = null;
	protected SrvDanfe danfe = null;
	protected Boolean completo = null;
	protected DanfeService service = null;
	protected List<Reader> notFounds = null;
	protected List<SrvDanfe> danfes = null;
	protected InputStream inputStream = null;
	protected Reader reader = null;

	public void init() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		SAXParser saxParser = factory.newSAXParser();
		InputSource inputSource = new InputSource(inputStream);
		inputSource.setEncoding("UTF-8");
		saxParser.parse(inputSource, this);
		service.persistenciaDanfeXml(danfe, getDetalhes(), getProdutos());
	}

	@Override
	public void startDocument() throws SAXException {
		detalhes = new ArrayList<Detail>();
		produtos = new ArrayList<Product>();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = String.copyValueOf(ch, start, length).trim();

		if (value.length() > 0) {
			if (prod) {
				ReflectionUtil.executeSetterMethod(produto, hashTag(tag), value);
			} else {
				ReflectionUtil.executeSetterMethod(detalhe, hashTag(tag), value);
			}
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	public List<Product> getProdutos() {
		return produtos;
	}

	public List<Detail> getDetalhes() {
		return detalhes;
	}

	@Override
	public void setService(DanfeService service) {
		this.service = service;
	}

	@Override
	public void setCompleto(Boolean completo) {
		this.completo = completo;
	}

	@Override
	public void setDanfe(SrvDanfe danfe) {
		this.danfe = danfe;
	}

	@Override
	public void setList(List<SrvDanfe> danfes) {
		this.danfes = danfes;
	}

	@Override
	public void setReader(Reader reader) {
		this.reader = reader;
	}

	private String hashTag(String tag) {
		return StringUtil.toLowerCase(tag.replaceAll("_", ""));
	}

	public CyclicBarrier getBarrier() {
		return barrier;
	}

	public void setBarrier(CyclicBarrier barrier) {
		this.barrier = barrier;
	}	
}
