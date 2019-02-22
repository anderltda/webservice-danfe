package br.com.danfe.soap.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.danfe.commons.ExceptionFactory;
import br.com.danfe.commons.util.NumberUtil;
import br.com.danfe.commons.util.SetUtil;
import br.com.danfe.commons.util.StringUtil;
import br.com.danfe.fundacao.query.Condition;
import br.com.danfe.fundacao.service.ServiceException;
import br.com.danfe.fundacao.service.impl.CommonPersistenceServiceImpl;
import br.com.danfe.servicos.persistencia.SrvDanfe;
import br.com.danfe.servicos.persistencia.SrvDanfeXmlCliente;
import br.com.danfe.servicos.persistencia.SrvDanfeXmlDetalhe;
import br.com.danfe.servicos.persistencia.SrvDanfeXmlProduto;
import br.com.danfe.soap.reader.Detail;
import br.com.danfe.soap.reader.Product;
import br.com.danfe.soap.service.DanfeService;

@Service(value = "serviceDanfeService")
@Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
public class DanfeServiceImpl extends CommonPersistenceServiceImpl implements DanfeService {

	private static final long serialVersionUID = 1L;

	@Override
	public void persistenciaDanfeXml(SrvDanfe danfe, List<Detail> detalhes, List<Product> produtos) throws ServiceException {

		SrvDanfeXmlDetalhe detalhe = getByID(SrvDanfeXmlDetalhe.class, danfe.getDanfe());
		SrvDanfeXmlCliente destinatario = new SrvDanfeXmlCliente();
		SrvDanfeXmlCliente emitente = new SrvDanfeXmlCliente();
		SrvDanfeXmlProduto produto = null;

		if (detalhe != null) return;

		if (SetUtil.isEmpty(detalhes)) {
			// throw new
			// ServiceException("Nenhum informação encontrada no XML.");
			danfe.setCodigoErro("404");
			danfe.setMensagemErro("Nenhum informação encontrada no XML.");
			return;
		}

		detalhe = new SrvDanfeXmlDetalhe();

		for (Detail detailReader : detalhes) {

			if (StringUtil.isNotEmpty(detailReader.getCoderro())) {
				// throw new ServiceException(detailReader.getCoderro() + " - "
				// + detailReader.getErro());
				danfe.setCodigoErro(detailReader.getCoderro());
				danfe.setMensagemErro(detailReader.getErro());
				return;
			}

			if (StringUtil.isNotEmpty(detailReader.getStatusConsulta()) || StringUtil.isNotEmpty(detailReader.getStatusDescricao())) {
				// throw new ServiceException(detailReader.getStatusConsulta() +
				// " - " + detailReader.getStatusDescricao());
				danfe.setCodigoErro(detailReader.getStatusConsulta());
				danfe.setMensagemErro(detailReader.getStatusDescricao());
				return;
			}

			danfe.setCodigoErro(null);
			danfe.setMensagemErro(null);

			if (detalhe.getBaseCalculo() == null) detalhe.setBaseCalculo(detailReader.getBaseCalculo());

			if (detalhe.getDataEmissao() == null) detalhe.setDataEmissao(detailReader.getDataEmissao());

			if (detalhe.getNumeroNf() == null) detalhe.setNumeroNf(detailReader.getNumeroNf());

			if (detalhe.getOutrosValores() == null) detalhe.setOutrosValores(detailReader.getOutrosValores());

			if (detalhe.getSerie() == null) detalhe.setSerie(detailReader.getSerie());

			if (detalhe.getValorFrete() == null) detalhe.setValorFrete(detailReader.getValorFrete());

			if (detalhe.getValorIcms() == null) detalhe.setValorIcms(detailReader.getValorIcms());

			if (detalhe.getValorNf() == null) detalhe.setValorNf(detailReader.getValorNf());

			if (detalhe.getValorSeguro() == null) detalhe.setValorSeguro(detailReader.getValorSeguro());

			if (StringUtil.isEmpty(detailReader.getTag())) {
				detailReader.createEmitente(emitente);
				detailReader.createDestinatario(destinatario);
			} else if (StringUtil.isEqual(detailReader.getTag(), "emit")) {
				detailReader.createEmitente(emitente);
			} else if (StringUtil.isEqual(detailReader.getTag(), "dest")) {
				detailReader.createDestinatario(destinatario);
			}
		}

		if (StringUtil.isEmpty(emitente.getNumero())) emitente.setNumero("-");

		if (StringUtil.isEmpty(destinatario.getNumero())) destinatario.setNumero("-");

		if (StringUtil.isNotEmpty(emitente.getRazaoSocial()) && emitente.getRazaoSocial().length() > 80) {
			emitente.setRazaoSocial(StringUtil.subString(emitente.getRazaoSocial(), 80));
		}

		if (StringUtil.isNotEmpty(destinatario.getRazaoSocial()) && destinatario.getRazaoSocial().length() > 80) {
			destinatario.setRazaoSocial(StringUtil.subString(destinatario.getRazaoSocial(), 80));
		}

		if (StringUtil.isNotEmpty(emitente.getIeRg()) && emitente.getIeRg().length() > 20) {
			emitente.setIeRg(StringUtil.subString(emitente.getIeRg(), 20));
		}

		if (StringUtil.isNotEmpty(destinatario.getIeRg()) && destinatario.getIeRg().length() > 20) {
			destinatario.setIeRg(StringUtil.subString(destinatario.getIeRg(), 20));
		}

		if (StringUtil.isNotEmpty(emitente.getCidade()) && emitente.getCidade().length() > 80) {
			emitente.setCidade(StringUtil.subString(emitente.getCidade(), 80));
		}

		if (StringUtil.isNotEmpty(destinatario.getCidade()) && destinatario.getCidade().length() > 80) {
			destinatario.setCidade(StringUtil.subString(destinatario.getCidade(), 80));
		}

		if (StringUtil.isNotEmpty(emitente.getCodCidadeIbge()) && emitente.getCodCidadeIbge().length() > 10) {
			emitente.setCodCidadeIbge(StringUtil.subString(emitente.getCodCidadeIbge(), 10));
		}

		if (StringUtil.isNotEmpty(destinatario.getCodCidadeIbge()) && destinatario.getCodCidadeIbge().length() > 10) {
			destinatario.setCodCidadeIbge(StringUtil.subString(destinatario.getCodCidadeIbge(), 10));
		}

		super.create(emitente);
		super.create(destinatario);

		detalhe.setId(danfe.getDanfe());
		detalhe.setDestinatario(destinatario);
		detalhe.setEmitente(emitente);

		super.create(detalhe);

		if (SetUtil.nonEmpty(produtos)) {
			for (Product productReader : produtos) {

				produto = new SrvDanfeXmlProduto();
				produto.setCfop(NumberUtil.getInteger(productReader.getCfop()));
				produto.setCodEan(productReader.getCean());
				produto.setCodEanTrib(productReader.getCeantrib());
				produto.setCodProduto(productReader.getCprod());
				produto.setDescricao(productReader.getXprod());
				produto.setDetalhe(detalhe);
				produto.setUnidade(productReader.getUcom());
				produto.setUnidTrib(productReader.getUtrib());
				produto.setValorIcms(NumberUtil.getDouble(productReader.getVicms()));
				produto.setValorTotal(NumberUtil.getDouble(productReader.getVprod()));
				produto.setValorUnidTrib(NumberUtil.getDouble(productReader.getVuntrib()));
				produto.setValorUnit(NumberUtil.getDouble(productReader.getVuncom()));
				produto.setNcm(productReader.getNcm());
				produto.setQtdeTrib(NumberUtil.getDouble(productReader.getQtrib()));
				produto.setQuantidade(NumberUtil.getDouble(productReader.getQcom()));

				super.create(produto);
			}
		}
	}

	@Override
	public List<SrvDanfe> findByDanfes() throws ServiceException {
		return findByProperties(SrvDanfe.class, new Condition("danfeConsultada", false));
	}

	@Override
	public void testeDemoraBanco(int tempoEmSegundos) throws ServiceException {
		Connection conn = null;
		CallableStatement ctsmt = null;
		try {
			conn = getJTAConnection();
			long inicio = System.currentTimeMillis();
			ctsmt = conn.prepareCall("begin dbms_lock.sleep(" + tempoEmSegundos + "); end;");
			ctsmt.execute();
			System.out.println("Demora com sucesso. tempo Gasto " + (System.currentTimeMillis() - inicio));
		} catch (Exception e) {
			throw ExceptionFactory.createException(ServiceException.class, e);
		} finally {
			if (ctsmt != null) {
				try {
					ctsmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}

}