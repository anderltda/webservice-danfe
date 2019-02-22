package br.com.danfe.soap.reader;

import java.util.List;
import java.util.concurrent.CyclicBarrier;

import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.soap.service.DanfeService;

public interface Reader {

	void read()throws Exception;
	
	void setService(DanfeService service);

	void setDanfe(SrvDanfe danfe);
	
	void setCompleto(Boolean completo);
	
	void setList(List<SrvDanfe> danfes);
	
	void setReader(Reader reader);
	
	void setBarrier(CyclicBarrier barrier);
	
	String getName();
	
	String getXml();
}
