package br.com.danfe.soap.reader;

import java.io.Serializable;
import java.util.Date;

import br.com.danfe.commons.util.DateTimeUtil;
import br.com.danfe.commons.util.NumberUtil;
import br.com.danfe.commons.util.StringUtil;
import br.com.danfe.servicos.persistencia.SrvDanfeXmlCliente;

/**
 * @author andersonsilva-tool
 *
 */
public class Detail implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tag;	
	private String chaveacesso;
	private String numeronfe;
	private String serienfe;
	private String dataemissao;
	private String valortotal;
	private String emissaoprocesso;
	private String emissaoversaoprocesso;
	private String emissaotipo;
	private String emissaofinalidade;
	private String emissaonaturezaoperacao;
	private String emissaotipooperacao;
	private String emissaoformapagamento;
	private String emissaodigestvalue;
	private String situacao;
	private String situacaoocorrencia;
	private String situacaoprotocolo;
	private String situacaodatahora;
	private String emitenterazaosocial;
	private String emitentenomefantasia;
	private String emitentecnpj;	
	private String emitenteendereco;
	private String emitentebairro;
	private String emitentecep;
	private String emitentemunicipio;
	private String emitentetelefone;
	private String emitenteestado;
	private String emitentepais;
	private String emitenteinscricaoestadual;
	private String emitenteinscricaoestadualsubstitutotributario;
	private String emitentemunicipioicms;
	private String destinatariorazaosocial;
	private String destinatariocnpj;
	private String destinatariocpf;
	private String destinatarioendereco;
	private String destinatariobairro;
	private String destinatariocep;
	private String destinatariomunicipio;
	private String destinatariotelefone;
	private String destinatarioestado;
	private String destinatariopais;
	private String destinatarioinscricaoestadual;
	private String basecalculoicms;
	private String valoricms;
	private String basecalculoicmsst;
	private String valoricmsst;
	private String valorprodutos;
	private String valorfrete;
	private String valorseguro;
	private String outrasdespesas;
	private String valoripi;
	private String valortotalnfe;
	private String valordescontos;
	private String valorii;
	private String valorpis;
	private String valorcofins;
	private String modalidadefrete;
	private String transportadorcnpj;
	private String transportadorrazaosocial;
	private String transportadorinscricaoestadual;
	private String transportadorendereco;
	private String transportadormunicipio;
	private String transportadorestado;
	private String transportadorplacaveiculo;
	private String transportadorestadoveiculo;
	private String transportadorvolumequantidade;
	private String transportadorvolumeespecie;
	private String transportadorvolumepesoliquido;
	private String transportadorvolumepesobruto;
	private String faturanumero;
	private String faturavalororiginal;
	private String faturavalorliquido;
	private String duplicatanumero;
	private String duplicatavencimento;
	private String duplicatavalor;
	private String informacoesadicionais;
	private String coderro;
	private String erro;
	private String cpf;

	// <ide>
	private String cuf;
	private String cnf;
	private String natop;
	private String indpag;
	private String mod;
	private String serie;
	private String nnf;
	private String demi;
	private String tpnf;
	private String cmunfg;
	private String tpimp;
	private String tpemis;
	private String cdv;
	private String tpamb;
	private String finnfe;
	private String procemi;
	private String verproc;

	// <emit>
	private String cnpj;
	private String xnome;
	private String xfant;
	private String enderemit;
	private String xlgr;
	private String nro;
	private String xbairro;
	private String cmun;
	private String xmun;
	private String uf;
	private String cep;
	private String cpais;
	private String xpais;
	private String fone;
	private String ie;

	// <dest>
	private String enderdest;
	private String xcpl;

	// <ICMSTot>
	private String vbc;
	private String vicms;
	private String vbcst;
	private String vst;
	private String vprod;
	private String vfrete;
	private String vseg;
	private String vdesc;
	private String vii;
	private String vipi;
	private String vpis;
	private String vcofins;
	private String voutro;
	private String vnf;

	// <transp>
	private String modfrete;
	private String cfoptransp;
	private String ncmtransp;
	private String transporta;
	private String qvol;
	private String esp;	

	//erro
	private String statusConsulta;
	private String statusDescricao;
	
	public Detail() {
		super();
	}

	public Detail(String tag) {
		super();
		this.tag = tag;
	}

	public String getChaveacesso() {
		return chaveacesso;
	}

	public void setChaveacesso(String chaveacesso) {
		this.chaveacesso = chaveacesso;
	}

	public String getNumeronfe() {
		return numeronfe;
	}

	public void setNumeronfe(String numeronfe) {
		this.numeronfe = numeronfe;
	}

	public String getSerienfe() {
		return serienfe;
	}

	public void setSerienfe(String serienfe) {
		this.serienfe = serienfe;
	}

	public String getDataemissao() {
		return dataemissao;
	}

	public void setDataemissao(String dataemissao) {
		this.dataemissao = dataemissao;
	}

	public String getValortotal() {
		return valortotal;
	}

	public void setValortotal(String valortotal) {
		this.valortotal = valortotal;
	}

	public String getEmissaoprocesso() {
		return emissaoprocesso;
	}

	public void setEmissaoprocesso(String emissaoprocesso) {
		this.emissaoprocesso = emissaoprocesso;
	}

	public String getEmissaoversaoprocesso() {
		return emissaoversaoprocesso;
	}

	public void setEmissaoversaoprocesso(String emissaoversaoprocesso) {
		this.emissaoversaoprocesso = emissaoversaoprocesso;
	}

	public String getEmissaotipo() {
		return emissaotipo;
	}

	public void setEmissaotipo(String emissaotipo) {
		this.emissaotipo = emissaotipo;
	}

	public String getEmissaofinalidade() {
		return emissaofinalidade;
	}

	public void setEmissaofinalidade(String emissaofinalidade) {
		this.emissaofinalidade = emissaofinalidade;
	}

	public String getEmissaonaturezaoperacao() {
		return emissaonaturezaoperacao;
	}

	public void setEmissaonaturezaoperacao(String emissaonaturezaoperacao) {
		this.emissaonaturezaoperacao = emissaonaturezaoperacao;
	}

	public String getEmissaotipooperacao() {
		return emissaotipooperacao;
	}

	public void setEmissaotipooperacao(String emissaotipooperacao) {
		this.emissaotipooperacao = emissaotipooperacao;
	}

	public String getEmissaoformapagamento() {
		return emissaoformapagamento;
	}

	public void setEmissaoformapagamento(String emissaoformapagamento) {
		this.emissaoformapagamento = emissaoformapagamento;
	}

	public String getEmissaodigestvalue() {
		return emissaodigestvalue;
	}

	public void setEmissaodigestvalue(String emissaodigestvalue) {
		this.emissaodigestvalue = emissaodigestvalue;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacaoocorrencia() {
		return situacaoocorrencia;
	}

	public void setSituacaoocorrencia(String situacaoocorrencia) {
		this.situacaoocorrencia = situacaoocorrencia;
	}

	public String getSituacaoprotocolo() {
		return situacaoprotocolo;
	}

	public void setSituacaoprotocolo(String situacaoprotocolo) {
		this.situacaoprotocolo = situacaoprotocolo;
	}

	public String getSituacaodatahora() {
		return situacaodatahora;
	}

	public void setSituacaodatahora(String situacaodatahora) {
		this.situacaodatahora = situacaodatahora;
	}

	public String getEmitenterazaosocial() {
		return emitenterazaosocial;
	}

	public void setEmitenterazaosocial(String emitenterazaosocial) {
		this.emitenterazaosocial = emitenterazaosocial;
	}

	public String getEmitentenomefantasia() {
		return emitentenomefantasia;
	}

	public void setEmitentenomefantasia(String emitentenomefantasia) {
		this.emitentenomefantasia = emitentenomefantasia;
	}

	public String getEmitentecnpj() {
		return emitentecnpj;
	}

	public void setEmitentecnpj(String emitentecnpj) {
		this.emitentecnpj = emitentecnpj;
	}

	public String getEmitenteendereco() {
		return emitenteendereco;
	}

	public void setEmitenteendereco(String emitenteendereco) {
		this.emitenteendereco = emitenteendereco;
	}

	public String getEmitentebairro() {
		return emitentebairro;
	}

	public void setEmitentebairro(String emitentebairro) {
		this.emitentebairro = emitentebairro;
	}

	public String getEmitentecep() {
		return emitentecep;
	}

	public void setEmitentecep(String emitentecep) {
		this.emitentecep = emitentecep;
	}

	public String getEmitentemunicipio() {
		return emitentemunicipio;
	}

	public void setEmitentemunicipio(String emitentemunicipio) {
		this.emitentemunicipio = emitentemunicipio;
	}

	public String getEmitentetelefone() {
		return emitentetelefone;
	}

	public void setEmitentetelefone(String emitentetelefone) {
		this.emitentetelefone = emitentetelefone;
	}

	public String getEmitenteestado() {
		return emitenteestado;
	}

	public void setEmitenteestado(String emitenteestado) {
		this.emitenteestado = emitenteestado;
	}

	public String getEmitentepais() {
		return emitentepais;
	}

	public void setEmitentepais(String emitentepais) {
		this.emitentepais = emitentepais;
	}

	public String getEmitenteinscricaoestadual() {
		return emitenteinscricaoestadual;
	}

	public void setEmitenteinscricaoestadual(String emitenteinscricaoestadual) {
		this.emitenteinscricaoestadual = emitenteinscricaoestadual;
	}

	public String getEmitenteinscricaoestadualsubstitutotributario() {
		return emitenteinscricaoestadualsubstitutotributario;
	}

	public void setEmitenteinscricaoestadualsubstitutotributario(
			String emitenteinscricaoestadualsubstitutotributario) {
		this.emitenteinscricaoestadualsubstitutotributario = emitenteinscricaoestadualsubstitutotributario;
	}

	public String getEmitentemunicipioicms() {
		return emitentemunicipioicms;
	}

	public void setEmitentemunicipioicms(String emitentemunicipioicms) {
		this.emitentemunicipioicms = emitentemunicipioicms;
	}

	public String getDestinatariorazaosocial() {
		return destinatariorazaosocial;
	}

	public void setDestinatariorazaosocial(String destinatariorazaosocial) {
		this.destinatariorazaosocial = destinatariorazaosocial;
	}

	public String getDestinatariocnpj() {
		return destinatariocnpj;
	}

	public void setDestinatariocnpj(String destinatariocnpj) {
		this.destinatariocnpj = destinatariocnpj;
	}

	public String getDestinatarioendereco() {
		return destinatarioendereco;
	}

	public void setDestinatarioendereco(String destinatarioendereco) {
		this.destinatarioendereco = destinatarioendereco;
	}

	public String getDestinatariobairro() {
		return destinatariobairro;
	}

	public void setDestinatariobairro(String destinatariobairro) {
		this.destinatariobairro = destinatariobairro;
	}

	public String getDestinatariocep() {
		return destinatariocep;
	}

	public void setDestinatariocep(String destinatariocep) {
		this.destinatariocep = destinatariocep;
	}

	public String getDestinatariomunicipio() {
		return destinatariomunicipio;
	}

	public void setDestinatariomunicipio(String destinatariomunicipio) {
		this.destinatariomunicipio = destinatariomunicipio;
	}

	public String getDestinatariotelefone() {
		return destinatariotelefone;
	}

	public void setDestinatariotelefone(String destinatariotelefone) {
		this.destinatariotelefone = destinatariotelefone;
	}

	public String getDestinatarioestado() {
		return destinatarioestado;
	}

	public void setDestinatarioestado(String destinatarioestado) {
		this.destinatarioestado = destinatarioestado;
	}

	public String getDestinatariopais() {
		return destinatariopais;
	}

	public void setDestinatariopais(String destinatariopais) {
		this.destinatariopais = destinatariopais;
	}

	public String getDestinatarioinscricaoestadual() {
		return destinatarioinscricaoestadual;
	}

	public void setDestinatarioinscricaoestadual(String destinatarioinscricaoestadual) {
		this.destinatarioinscricaoestadual = destinatarioinscricaoestadual;
	}

	public String getBasecalculoicms() {
		return basecalculoicms;
	}

	public void setBasecalculoicms(String basecalculoicms) {
		this.basecalculoicms = basecalculoicms;
	}

	public String getValoricms() {
		return valoricms;
	}

	public void setValoricms(String valoricms) {
		this.valoricms = valoricms;
	}

	public String getBasecalculoicmsst() {
		return basecalculoicmsst;
	}

	public void setBasecalculoicmsst(String basecalculoicmsst) {
		this.basecalculoicmsst = basecalculoicmsst;
	}

	public String getValoricmsst() {
		return valoricmsst;
	}

	public void setValoricmsst(String valoricmsst) {
		this.valoricmsst = valoricmsst;
	}

	public String getValorprodutos() {
		return valorprodutos;
	}

	public void setValorprodutos(String valorprodutos) {
		this.valorprodutos = valorprodutos;
	}

	public String getValorfrete() {
		return valorfrete;
	}

	public void setValorfrete(String valorfrete) {
		this.valorfrete = valorfrete;
	}

	public String getValorseguro() {
		return valorseguro;
	}

	public void setValorseguro(String valorseguro) {
		this.valorseguro = valorseguro;
	}

	public String getOutrasdespesas() {
		return outrasdespesas;
	}

	public void setOutrasdespesas(String outrasdespesas) {
		this.outrasdespesas = outrasdespesas;
	}

	public String getValoripi() {
		return valoripi;
	}

	public void setValoripi(String valoripi) {
		this.valoripi = valoripi;
	}

	public String getValortotalnfe() {
		return valortotalnfe;
	}

	public void setValortotalnfe(String valortotalnfe) {
		this.valortotalnfe = valortotalnfe;
	}

	public String getValordescontos() {
		return valordescontos;
	}

	public void setValordescontos(String valordescontos) {
		this.valordescontos = valordescontos;
	}

	public String getValorii() {
		return valorii;
	}

	public void setValorii(String valorii) {
		this.valorii = valorii;
	}

	public String getValorpis() {
		return valorpis;
	}

	public void setValorpis(String valorpis) {
		this.valorpis = valorpis;
	}

	public String getValorcofins() {
		return valorcofins;
	}

	public void setValorcofins(String valorcofins) {
		this.valorcofins = valorcofins;
	}

	public String getModalidadefrete() {
		return modalidadefrete;
	}

	public void setModalidadefrete(String modalidadefrete) {
		this.modalidadefrete = modalidadefrete;
	}

	public String getTransportadorcnpj() {
		return transportadorcnpj;
	}

	public void setTransportadorcnpj(String transportadorcnpj) {
		this.transportadorcnpj = transportadorcnpj;
	}

	public String getTransportadorrazaosocial() {
		return transportadorrazaosocial;
	}

	public void setTransportadorrazaosocial(String transportadorrazaosocial) {
		this.transportadorrazaosocial = transportadorrazaosocial;
	}

	public String getTransportadorinscricaoestadual() {
		return transportadorinscricaoestadual;
	}

	public void setTransportadorinscricaoestadual(
			String transportadorinscricaoestadual) {
		this.transportadorinscricaoestadual = transportadorinscricaoestadual;
	}

	public String getTransportadorendereco() {
		return transportadorendereco;
	}

	public void setTransportadorendereco(String transportadorendereco) {
		this.transportadorendereco = transportadorendereco;
	}

	public String getTransportadormunicipio() {
		return transportadormunicipio;
	}

	public void setTransportadormunicipio(String transportadormunicipio) {
		this.transportadormunicipio = transportadormunicipio;
	}

	public String getTransportadorestado() {
		return transportadorestado;
	}

	public void setTransportadorestado(String transportadorestado) {
		this.transportadorestado = transportadorestado;
	}

	public String getTransportadorplacaveiculo() {
		return transportadorplacaveiculo;
	}

	public void setTransportadorplacaveiculo(String transportadorplacaveiculo) {
		this.transportadorplacaveiculo = transportadorplacaveiculo;
	}

	public String getTransportadorestadoveiculo() {
		return transportadorestadoveiculo;
	}

	public void setTransportadorestadoveiculo(String transportadorestadoveiculo) {
		this.transportadorestadoveiculo = transportadorestadoveiculo;
	}

	public String getTransportadorvolumequantidade() {
		return transportadorvolumequantidade;
	}

	public void setTransportadorvolumequantidade(
			String transportadorvolumequantidade) {
		this.transportadorvolumequantidade = transportadorvolumequantidade;
	}

	public String getTransportadorvolumeespecie() {
		return transportadorvolumeespecie;
	}

	public void setTransportadorvolumeespecie(String transportadorvolumeespecie) {
		this.transportadorvolumeespecie = transportadorvolumeespecie;
	}

	public String getTransportadorvolumepesoliquido() {
		return transportadorvolumepesoliquido;
	}

	public void setTransportadorvolumepesoliquido(
			String transportadorvolumepesoliquido) {
		this.transportadorvolumepesoliquido = transportadorvolumepesoliquido;
	}

	public String getTransportadorvolumepesobruto() {
		return transportadorvolumepesobruto;
	}

	public void setTransportadorvolumepesobruto(String transportadorvolumepesobruto) {
		this.transportadorvolumepesobruto = transportadorvolumepesobruto;
	}

	public String getFaturanumero() {
		return faturanumero;
	}

	public void setFaturanumero(String faturanumero) {
		this.faturanumero = faturanumero;
	}

	public String getFaturavalororiginal() {
		return faturavalororiginal;
	}

	public void setFaturavalororiginal(String faturavalororiginal) {
		this.faturavalororiginal = faturavalororiginal;
	}

	public String getFaturavalorliquido() {
		return faturavalorliquido;
	}

	public void setFaturavalorliquido(String faturavalorliquido) {
		this.faturavalorliquido = faturavalorliquido;
	}

	public String getDuplicatanumero() {
		return duplicatanumero;
	}

	public void setDuplicatanumero(String duplicatanumero) {
		this.duplicatanumero = duplicatanumero;
	}

	public String getDuplicatavencimento() {
		return duplicatavencimento;
	}

	public void setDuplicatavencimento(String duplicatavencimento) {
		this.duplicatavencimento = duplicatavencimento;
	}

	public String getDuplicatavalor() {
		return duplicatavalor;
	}

	public void setDuplicatavalor(String duplicatavalor) {
		this.duplicatavalor = duplicatavalor;
	}

	public String getInformacoesadicionais() {
		return informacoesadicionais;
	}

	public void setInformacoesadicionais(String informacoesadicionais) {
		this.informacoesadicionais = informacoesadicionais;
	}

	public String getCoderro() {
		return coderro;
	}

	public void setCoderro(String coderro) {
		this.coderro = coderro;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCuf() {
		return cuf;
	}

	public void setCuf(String cuf) {
		this.cuf = cuf;
	}

	public String getCnf() {
		return cnf;
	}

	public void setCnf(String cnf) {
		this.cnf = cnf;
	}

	public String getNatop() {
		return natop;
	}

	public void setNatop(String natop) {
		this.natop = natop;
	}

	public String getIndpag() {
		return indpag;
	}

	public void setIndpag(String indpag) {
		this.indpag = indpag;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public String getSerie() {
		if(StringUtil.isNotEmpty(serie)) {
			return serie;
		} else {
			return serienfe;
		}
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNnf() {
		return nnf;
	}

	public void setNnf(String nnf) {
		this.nnf = nnf;
	}

	public String getDemi() {
		return demi;
	}

	public void setDemi(String demi) {
		this.demi = demi;
	}

	public String getTpnf() {
		return tpnf;
	}

	public void setTpnf(String tpnf) {
		this.tpnf = tpnf;
	}

	public String getCmunfg() {
		return cmunfg;
	}

	public void setCmunfg(String cmunfg) {
		this.cmunfg = cmunfg;
	}

	public String getTpimp() {
		return tpimp;
	}

	public void setTpimp(String tpimp) {
		this.tpimp = tpimp;
	}

	public String getTpemis() {
		return tpemis;
	}

	public void setTpemis(String tpemis) {
		this.tpemis = tpemis;
	}

	public String getCdv() {
		return cdv;
	}
	
	public void setCdv(String cdv) {
		this.cdv = cdv;
	}
	
	public String getTpamb() {
		return tpamb;
	}
	
	public void setTpamb(String tpamb) {
		this.tpamb = tpamb;
	}
	
	public String getFinnfe() {
		return finnfe;
	}
	
	public void setFinnfe(String finnfe) {
		this.finnfe = finnfe;
	}
	
	public String getProcemi() {
		return procemi;
	}
	
	public void setProcemi(String procemi) {
		this.procemi = procemi;
	}
	
	public String getVerproc() {
		return verproc;
	}
	
	public void setVerproc(String verproc) {
		this.verproc = verproc;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getXnome() {
		return xnome;
	}
	
	public void setXnome(String xnome) {
		this.xnome = xnome;
	}
	
	public String getXfant() {
		return xfant;
	}
	
	public void setXfant(String xfant) {
		this.xfant = xfant;
	}
	
	public String getEnderemit() {
		return enderemit;
	}
	
	public void setEnderemit(String enderemit) {
		this.enderemit = enderemit;
	}
	
	public String getXlgr() {
		return xlgr;
	}
	
	public void setXlgr(String xlgr) {
		this.xlgr = xlgr;
	}
	
	public String getNro() {
		return nro;
	}
	
	public void setNro(String nro) {
		this.nro = nro;
	}
	
	public String getXbairro() {
		return xbairro;
	}
	
	public void setXbairro(String xbairro) {
		this.xbairro = xbairro;
	}
	
	public String getCmun() {
		return cmun;
	}
	
	public void setCmun(String cmun) {
		this.cmun = cmun;
	}
	
	public String getXmun() {
		return xmun;
	}
	
	public void setXmun(String xmun) {
		this.xmun = xmun;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCpais() {
		return cpais;
	}
	
	public void setCpais(String cpais) {
		this.cpais = cpais;
	}
	
	public String getXpais() {
		return xpais;
	}
	
	public void setXpais(String xpais) {
		this.xpais = xpais;
	}
	
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getIe() {
		return ie;
	}
	
	public void setIe(String ie) {
		this.ie = ie;
	}
	
	public String getEnderdest() {
		return enderdest;
	}
	
	public void setEnderdest(String enderdest) {
		this.enderdest = enderdest;
	}
	
	public String getXcpl() {
		return xcpl;
	}
	
	public void setXcpl(String xcpl) {
		this.xcpl = xcpl;
	}
	
	public String getVbc() {
		return vbc;
	}
	
	public void setVbc(String vbc) {
		this.vbc = vbc;
	}
	
	public String getVicms() {
		return vicms;
	}
	
	public void setVicms(String vicms) {
		this.vicms = vicms;
	}
	
	public String getVbcst() {
		return vbcst;
	}
	
	public void setVbcst(String vbcst) {
		this.vbcst = vbcst;
	}
	
	public String getVst() {
		return vst;
	}
	
	public void setVst(String vst) {
		this.vst = vst;
	}
	
	public String getVprod() {
		return vprod;
	}
	
	public void setVprod(String vprod) {
		this.vprod = vprod;
	}
	
	public String getVfrete() {
		return vfrete;
	}
	
	public void setVfrete(String vfrete) {
		this.vfrete = vfrete;
	}
	
	public String getVseg() {
		return vseg;
	}
	
	public void setVseg(String vseg) {
		this.vseg = vseg;
	}
	
	public String getVdesc() {
		return vdesc;
	}
	
	public void setVdesc(String vdesc) {
		this.vdesc = vdesc;
	}
	
	public String getVii() {
		return vii;
	}
	
	public void setVii(String vii) {
		this.vii = vii;
	}
	
	public String getVipi() {
		return vipi;
	}
		
	public void setVipi(String vipi) {
		this.vipi = vipi;
	}
	
	public String getVpis() {
		return vpis;
	}
	
	public void setVpis(String vpis) {
		this.vpis = vpis;
	}

	public String getVcofins() {
		return vcofins;
	}

	public void setVcofins(String vcofins) {
		this.vcofins = vcofins;
	}

	public String getVoutro() {
		return voutro;
	}

	public void setVoutro(String voutro) {
		this.voutro = voutro;
	}

	public String getVnf() {
		return vnf;
	}

	public void setVnf(String vnf) {
		this.vnf = vnf;
	}

	public String getModfrete() {
		return modfrete;
	}

	public void setModfrete(String modfrete) {
		this.modfrete = modfrete;
	}

	public String getCfoptransp() {
		return cfoptransp;
	}

	public void setCfoptransp(String cfoptransp) {
		this.cfoptransp = cfoptransp;
	}

	public String getNcmtransp() {
		return ncmtransp;
	}

	public void setNcmtransp(String ncmtransp) {
		this.ncmtransp = ncmtransp;
	}

	public String getTransporta() {
		return transporta;
	}

	public void setTransporta(String transporta) {
		this.transporta = transporta;
	}

	public String getQvol() {
		return qvol;
	}

	public void setQvol(String qvol) {
		this.qvol = qvol;
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDestinatariocpf() {
		return destinatariocpf;
	}

	public void setDestinatariocpf(String destinatariocpf) {
		this.destinatariocpf = destinatariocpf;
	}
	
	public String getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public String getStatusDescricao() {
		return statusDescricao;
	}

	public void setStatusDescricao(String statusDescricao) {
		this.statusDescricao = statusDescricao;
	}	
	
	public Double getBaseCalculo() {

		if(StringUtil.isNotEmpty(vbc)) {
			return NumberUtil.getDouble(vbc);			
		} else if(StringUtil.isNotEmpty(basecalculoicms)) {
			return NumberUtil.getDouble(hashValue(basecalculoicms));
		}

		return null;
	} 	

	public Date getDataEmissao() {

		if(StringUtil.isNotEmpty(demi)) {
	    	String data [] = demi.split("-");
	    	String concate = new String();
	    	for (int i = data.length; i > 0; i--) concate += data[i-1] +"/";
			return DateTimeUtil.getDate(concate);			
		} else if(StringUtil.isNotEmpty(dataemissao)) {
			return DateTimeUtil.getDate(dataemissao);
		}
		return null;
	}

	public Integer getNumeroNf() {

		if(StringUtil.isNotEmpty(nnf)) {
			return NumberUtil.getInteger(nnf);			
		} else if(StringUtil.isNotEmpty(numeronfe)) {
			return NumberUtil.getInteger(numeronfe);
		}		
		return null;
	}
	
	public Double getOutrosValores() {

		if(StringUtil.isNotEmpty(voutro)) {
			return NumberUtil.getDouble(voutro);			
		} else if(StringUtil.isNotEmpty(outrasdespesas)) {
			return NumberUtil.getDouble(hashValue(outrasdespesas));
		}

		return null;
	}
	
	public Double getValorFrete() {

		if(StringUtil.isNotEmpty(vfrete)) {
			return NumberUtil.getDouble(vfrete);			
		} else if(StringUtil.isNotEmpty(valorfrete)) {
			return NumberUtil.getDouble(hashValue(valorfrete));
		}

		return null;
	}
	
	public Double getValorIcms() {

		if(StringUtil.isNotEmpty(vicms)) {
			return NumberUtil.getDouble(vicms);			
		} else if(StringUtil.isNotEmpty(valoricms)) {
			return NumberUtil.getDouble(hashValue(valoricms));
		}

		return null;
	}
	
	public Double getValorNf() {

		if(StringUtil.isNotEmpty(vnf)) {
			return NumberUtil.getDouble(vnf);			
		} else if(StringUtil.isNotEmpty(valortotal)) {
			return NumberUtil.getDouble(hashValue(valortotal));
		}

		return null;
	}
	
	public Double getValorSeguro() {

		if(StringUtil.isNotEmpty(vseg)) {
			return NumberUtil.getDouble(vseg);			
		} else if(StringUtil.isNotEmpty(valorseguro)) {
			return NumberUtil.getDouble(hashValue(valorseguro));
		}

		return null;
	}
	
	public void createDestinatario(SrvDanfeXmlCliente destinatario) {

		if(destinatario.getBairro() == null) 
			destinatario.setBairro(StringUtil.isNotEmpty(xbairro) ? xbairro : destinatariobairro);

		if(destinatario.getCep() == null)
			destinatario.setCep(StringUtil.isNotEmpty(cep) ? cep : destinatariocep);

		if(destinatario.getCidade() == null)
			destinatario.setCidade(StringUtil.isNotEmpty(xmun) ? xmun : StringUtil.isNotEmpty(destinatariomunicipio) ? StringUtil.removeSpecialChar(destinatariomunicipio.replaceAll("[0-9]","")) : null);

		if(destinatario.getCodCidadeIbge() == null)
			destinatario.setCodCidadeIbge(StringUtil.isNotEmpty(cmun) ? cmun : StringUtil.removeNonNumbers(destinatariomunicipio));				

		if(destinatario.getCpfCnpj() == null) {				
			if(StringUtil.isNotEmpty(cnpj) || StringUtil.isNotEmpty(destinatariocnpj)) { 
				destinatario.setCpfCnpj(StringUtil.isNotEmpty(cnpj) ? StringUtil.removeSpecialChar(cnpj) : StringUtil.removeSpecialChar(destinatariocnpj));
			} else {
				destinatario.setCpfCnpj(StringUtil.isNotEmpty(cpf) ? StringUtil.removeSpecialChar(cpf) : StringUtil.removeSpecialChar(destinatariocpf));
			}
		}

		if(destinatario.getEstado() == null)
			destinatario.setEstado(StringUtil.isNotEmpty(uf) ? uf : destinatarioestado);

		if(destinatario.getIeRg() == null)
			destinatario.setIeRg(StringUtil.isNotEmpty(ie) ? ie : destinatarioinscricaoestadual);

		if(destinatario.getLogradouro() == null)
			destinatario.setLogradouro(StringUtil.isNotEmpty(xlgr) ? xlgr : destinatarioendereco);

		if(destinatario.getNumero() == null) {
			if(StringUtil.isNotEmpty(nro) && nro.length() > 20) {
				destinatario.setNumero("-");
				destinatario.setComplemento(nro);
			} else if(StringUtil.isNotEmpty(nro)) {
				destinatario.setNumero(nro);				
			}

			if(StringUtil.isNotEmpty(destinatarioendereco) && destinatarioendereco.length() > 20) {
				destinatario.setNumero("-");
				destinatario.setComplemento(StringUtil.removeNonNumbers(destinatarioendereco));
			} else if(StringUtil.isNotEmpty(destinatarioendereco)) {
				destinatario.setNumero(StringUtil.removeNonNumbers(destinatarioendereco));				
			}
		}
				
		if(StringUtil.isNotEmpty(xcpl))
			destinatario.setComplemento(StringUtil.isNotEmpty(destinatario.getComplemento()) ? destinatario.getComplemento() +" "+ xcpl : xcpl);

		if(destinatario.getRazaoSocial() == null)
			destinatario.setRazaoSocial(StringUtil.isNotEmpty(xnome) ? StringUtil.getStringEmpty(xnome) : destinatariorazaosocial);		

		if(destinatario.getTelefone() == null) {
			destinatario.setDdd(StringUtil.isNotEmpty(fone) ? NumberUtil.getInteger(StringUtil.subString(fone, 2)) :  StringUtil.isNotEmpty(destinatariotelefone) ? NumberUtil.getInteger(StringUtil.subString(StringUtil.removeSpecialChar(destinatariotelefone), 2)) : null);
			destinatario.setTelefone(StringUtil.isNotEmpty(fone) ? StringUtil.removeSpecialChar(fone).substring(2) :  StringUtil.isNotEmpty(destinatariotelefone) ? StringUtil.removeSpecialChar(destinatariotelefone).substring(2) : null);
		}
	}

	public void createEmitente(SrvDanfeXmlCliente emitente) {

		if(emitente.getBairro() == null)
			emitente.setBairro(StringUtil.isNotEmpty(xbairro) ? xbairro : emitentebairro);

		if(emitente.getCep() == null)
			emitente.setCep(StringUtil.isNotEmpty(cep) ? cep : emitentecep);

		if(emitente.getCidade() == null)
			emitente.setCidade(StringUtil.isNotEmpty(xmun) ? xmun : StringUtil.isNotEmpty(emitentemunicipio) ? StringUtil.removeSpecialChar(emitentemunicipio.replaceAll("[0-9]","")) : null);

		if(emitente.getCodCidadeIbge() == null)
			emitente.setCodCidadeIbge(StringUtil.isNotEmpty(cmun) ? cmun : StringUtil.removeNonNumbers(emitentemunicipio));		

		if(emitente.getCpfCnpj() == null) 
			emitente.setCpfCnpj(StringUtil.isNotEmpty(cnpj) ? StringUtil.removeSpecialChar(cnpj) : StringUtil.removeSpecialChar(emitentecnpj));

		if(emitente.getEstado() == null)
			emitente.setEstado(StringUtil.isNotEmpty(uf) ? uf : emitenteestado);

		if(emitente.getFantasia() == null)
			emitente.setFantasia(StringUtil.isNotEmpty(xfant) ? xfant : emitentenomefantasia);

		if(emitente.getIeRg() == null)
			emitente.setIeRg(StringUtil.isNotEmpty(ie) ? ie : emitenteinscricaoestadual);

		if(emitente.getIeSubTributario() == null)
			emitente.setIeSubTributario(emitenteinscricaoestadualsubstitutotributario);

		if(emitente.getLogradouro() == null)
			emitente.setLogradouro(StringUtil.isNotEmpty(xlgr) ? xlgr : emitenteendereco);

		if(emitente.getNumero() == null) {
			if(StringUtil.isNotEmpty(nro) && nro.length() > 20) {
				emitente.setNumero("-");
				emitente.setComplemento(nro);
			} else if(StringUtil.isNotEmpty(nro)) {
				emitente.setNumero(nro);				
			}

			if(StringUtil.isNotEmpty(emitenteendereco) && emitenteendereco.length() > 20) {
				emitente.setNumero("-");
				emitente.setComplemento(StringUtil.removeNonNumbers(emitenteendereco));
			} else if(StringUtil.isNotEmpty(emitenteendereco)) {
				emitente.setNumero(StringUtil.removeNonNumbers(emitenteendereco));				
			}
		}			
		
		if(StringUtil.isNotEmpty(xcpl))
			emitente.setComplemento(StringUtil.isNotEmpty(emitente.getComplemento()) ? emitente.getComplemento() +" "+ xcpl : xcpl);

		if(emitente.getRazaoSocial() == null)
			emitente.setRazaoSocial(StringUtil.isNotEmpty(xnome) ? StringUtil.getStringEmpty(xnome) : emitenterazaosocial);		

		if(emitente.getTelefone() == null) {
			emitente.setDdd(StringUtil.isNotEmpty(fone) ? NumberUtil.getInteger(StringUtil.subString(fone, 2)) :  NumberUtil.getInteger(StringUtil.subString(StringUtil.removeSpecialChar(StringUtil.isNotEmpty(emitentetelefone) ? emitentetelefone : ""), 2)));
			emitente.setTelefone(StringUtil.isNotEmpty(fone) ? StringUtil.removeSpecialChar(fone).substring(2) :  StringUtil.isNotEmpty(emitentetelefone) ? StringUtil.removeSpecialChar(emitentetelefone).substring(2) : null);
		}	
	}	
	
	private String hashValue(String value) {
		return value.replace(".", "").replaceAll(",",".");
	}
}
