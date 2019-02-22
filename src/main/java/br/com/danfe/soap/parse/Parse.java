package br.com.danfe.soap.parse;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.danfe.cadastro.persistencia.CadFilial;
import br.com.danfe.commons.util.FileUtil;
import br.com.danfe.commons.util.StringUtil;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.servicos.persistencia.SrvLoteDanfe;
import br.com.danfe.soap.SOAP;

/**
 * @author andersonsilva-tool
 *
 */
public class Parse extends SOAP {

	protected static final Log log = LogFactory.getLog(Parse.class);

	private static String PATH = "//btu-danfe02/Danfes/";
	private static String NFE = "NFe";
	private static String XML = ".xml";	

	@Override
	public void read() throws Exception {

		for (SrvDanfe danfe : danfes) {

			log.debug("Iniciando processo DANFE Nº " + danfe.getDanfe() + " current thread:" + Thread.currentThread().getId());

			try {
				
				if(processFile(danfe)) {					
					SrvLoteDanfe loteDanfe = service.getByID(SrvLoteDanfe.class, danfe.getLoteDanfe().getId());
					CadFilial cadFilial = service.getByID(CadFilial.class, loteDanfe.getCadFilial().getId());
					danfe.setFornecedor(reader.getName());
					reader.setService(service);
					reader.setDanfe(danfe);
					reader.setCompleto(cadFilial.getConsultaProdutos());
					reader.read();
					
					if(StringUtil.isEmpty(danfe.getCodigoErro())) {
						createFile(reader.getName(), danfe.getDanfe(), reader.getXml());					
					}
				} 				

			} catch (Exception e) {
				danfe.setCodigoErro("500");
				danfe.setMensagemErro(e.getMessage());
				log.error(e.getMessage());
				e.printStackTrace();
			} finally {
				danfe.setDanfeConsultada(true);
				danfe.setDhFimConsulta(new Date());
				service.update(danfe);						
			}

			log.debug("Finalizando processo DANFE Nº " + danfe.getDanfe() + " current thread:" + Thread.currentThread().getId());
		}

		try {
			getBarrier().await(2000, TimeUnit.SECONDS);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 * @throws Exception 
	 */
	private boolean processFile(SrvDanfe danfe) throws Exception {
		
		File file = null;		
		InputStream inputStream = null;
		List<String> paths = new ArrayList<String>();
		
		StringBuilder builder = new StringBuilder();
		paths.add(builder.append(PATH).append(danfe.getDanfe().substring(6, 20) + "/").append(20 + danfe.getDanfe().substring(2, 6) + "/").append(NFE + danfe.getDanfe() + XML).toString());
		
		builder = new StringBuilder();
		paths.add(builder.append(PATH).append(danfe.getDanfe().substring(6, 20) + "/").append(20 + danfe.getDanfe().substring(2, 6) + "/").append(Sim.NAME_INIT +"_"+ danfe.getDanfe() + XML).toString());
		
		builder = new StringBuilder();
		paths.add(builder.append(PATH).append(danfe.getDanfe().substring(6, 20) + "/").append(20 + danfe.getDanfe().substring(2, 6) + "/").append(Dbi.NAME_INIT +"_"+ danfe.getDanfe() + XML).toString());
		
		for (String path : paths) {
			file = new File(path);
			if(file.exists()) {
				break;			
			} else {
				file = null;	
			}
		}
		
		if(file != null) {
			inputStream = new ByteArrayInputStream(StringUtil.convertNode(FileUtil.getStringContent((file)).toString()).getBytes());			
			if(file.getName().contains(Dbi.NAME_INIT)) {
				danfe.setFornecedor(Dbi.NAME_INIT);
				new Dbi(danfe, service, inputStream);
			} else {
				danfe.setFornecedor(file.getName().contains(Sim.NAME_INIT) ? Sim.NAME_INIT : NFE);
				new Sim(danfe, service, inputStream);
			}			
			return false;
		} 
		
		return true;
	}
	
	/**
	 * @param name
	 * @param danfe
	 * @param xml
	 */
	private void createFile(String name, String danfe, String xml) {
		try {

			String pastaCnpj = danfe.substring(6, 20).concat("/");
			String pastaMesAno = 20 + danfe.substring(2, 6).concat("/");
			StringBuilder builder = new StringBuilder();
			builder.append(PATH);
			builder.append(pastaCnpj);
			builder.append(pastaMesAno);
			builder.append(name +"_"+ danfe + ".xml");

			File pasta = new File(PATH + pastaCnpj + pastaMesAno);
			pasta.mkdirs();

			File file = new File(builder.toString());		
			file.createNewFile();

			BufferedWriter out = new BufferedWriter(new FileWriter(builder.toString()));
			out.write(xml);
			out.flush();
			out.close();		
			
			log.debug("Criado o arquivo xml da DANFE Nº " + danfe + " com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Ocorreu erro ao criar o arquivo xml da DANFE Nº " + danfe + ", erro identificado " + e.getMessage());
		}		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getXml() {
		// TODO Auto-generated method stub
		return null;
	}
}
