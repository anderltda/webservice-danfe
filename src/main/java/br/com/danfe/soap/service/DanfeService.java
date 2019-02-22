
package br.com.danfe.soap.service;

import java.util.List;

import br.com.danfe.fundacao.service.CommonPersistenceService;
import br.com.danfe.fundacao.service.ServiceException;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.soap.reader.Detail;
import br.com.danfe.soap.reader.Product;

public interface DanfeService extends CommonPersistenceService {

	void persistenciaDanfeXml(SrvDanfe danfe, List<Detail> detalhes, List<Product> produtos) throws ServiceException;
	
	List<SrvDanfe> findByDanfes() throws ServiceException;

	void testeDemoraBanco(int tempoEmSegundos) throws ServiceException;

}