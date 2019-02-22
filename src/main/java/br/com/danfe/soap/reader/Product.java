package br.com.danfe.soap.reader;

import java.io.Serializable;

import br.com.danfe.commons.util.StringUtil;

/**
 * @author andersonsilva-tool
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itemno;
	private String descricao;
	private String quantidade;
	private String valor;
	private String codigoproduto;
	private String codigoncm;
	private String cfop;
	private String genero;
	private String codigoeancomercial;
	private String unidadecomercial;
	private String quantidadecomercial;
	private String codigoeantributavel;
	private String unidadetributavel;
	private String quantidadetributavel;
	private String valorunitariocomercial;
	private String valorunitariotributacao;
	private String origemmercadoria;
	private String tributacaoicms;
	private String modalidadedefinicaobcicmsnormal;
	private String basecalculoicmsnormal;
	private String aliquotaicmsnormal;
	private String valoricmsnormal;
	private String basecalculoicmsst;
	private String aliquotaicmsst;
	private String valoricmsst;
	private String percentualmvaicmsst;
	private String modalidadedefinicaobcicmsst;
	private String codigoenquadramentoimposto;
	private String basecalculoimposto;
	private String aliquotaimposto;
	private String valoripi;
	private String cst;
	private String cprod;
	private String cean;
	private String xprod;
	private String ncm;
	private String ucom;
	private String qcom;
	private String vuncom;
	private String vprod;
	private String ceantrib;
	private String utrib;
	private String qtrib;
	private String vuntrib;
	private String orig;
	private String modbc;
	private String picms;
	private String vicms;
	private String cenq;
	private String vbc;
	private String pipi;
	private String vipi;

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getDescricao() {		
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getXprod() {

		if(StringUtil.isNotEmpty(descricao)) {
			return descricao;
		}	

		return xprod;
	}

	public void setXprod(String xprod) {
		this.xprod = xprod;
	}

	public String getQuantidade() {
		return quantidade;			
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getQcom() {
		
		if(StringUtil.isNotEmpty(quantidade)) {
			return hashValue(quantidade);	
		}

		return qcom;
	}

	public void setQcom(String qcom) {
		this.qcom = qcom;
	}

	public String getValor() {
		return valor;			
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getVprod() {
		
		if(StringUtil.isNotEmpty(valor)) {
			return hashValue(valor);	
		}

		return vprod;
	}

	public void setVprod(String vprod) {
		this.vprod = vprod;
	}

	public String getCodigoproduto() {
		return codigoproduto;
	}

	public void setCodigoproduto(String codigoproduto) {
		this.codigoproduto = codigoproduto;
	}
	
	public String getCprod() {
		
		if(StringUtil.isNotEmpty(codigoproduto)) {
			return codigoproduto;
		}

		return cprod;
	}

	public void setCprod(String cprod) {
		this.cprod = cprod;
	}

	public String getCodigoncm() {
		return codigoncm;
	}

	public void setCodigoncm(String codigoncm) {
		this.codigoncm = codigoncm;
	}

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCodigoeancomercial() {		
		return codigoeancomercial;
	}

	public void setCodigoeancomercial(String codigoeancomercial) {
		this.codigoeancomercial = codigoeancomercial;
	}
	
	public String getCean() {

		if(StringUtil.isNotEmpty(codigoeancomercial)) {
			return codigoeancomercial;
		}		
		
		return cean;
	}

	public void setCean(String cean) {
		this.cean = cean;
	}

	public String getUnidadecomercial() {
		return unidadecomercial;			
	}

	public void setUnidadecomercial(String unidadecomercial) {
		this.unidadecomercial = unidadecomercial;
	}
	
	public String getUcom() {

		if(StringUtil.isNotEmpty(unidadecomercial)) {
			return unidadecomercial;
		}

		return ucom;			
	}

	public void setUcom(String ucom) {
		this.ucom = ucom;
	}

	public String getQuantidadecomercial() {
		return quantidadecomercial;
	}

	public void setQuantidadecomercial(String quantidadecomercial) {
		this.quantidadecomercial = quantidadecomercial;
	}

	public String getCodigoeantributavel() {
		return codigoeantributavel;			
	}

	public void setCodigoeantributavel(String codigoeantributavel) {
		this.codigoeantributavel = codigoeantributavel;
	}
	
	public String getCeantrib() {

		if(StringUtil.isNotEmpty(codigoeantributavel) ) {
			return codigoeantributavel;
		}
		
		return ceantrib;
	}

	public void setCeantrib(String ceantrib) {
		this.ceantrib = ceantrib;
	}

	public String getUnidadetributavel() {
		return unidadetributavel;			
	}

	public void setUnidadetributavel(String unidadetributavel) {
		this.unidadetributavel = unidadetributavel;
	}
	
	public String getUtrib() {
		
		if(StringUtil.isNotEmpty(unidadetributavel)) {
			return unidadetributavel;
		}		

		return utrib;
	}

	public void setUtrib(String utrib) {
		this.utrib = utrib;
	}

	public String getQuantidadetributavel() {
		return quantidadetributavel;
	}

	public void setQuantidadetributavel(String quantidadetributavel) {
		this.quantidadetributavel = quantidadetributavel;
	}

	public String getValorunitariocomercial() {
		return valorunitariocomercial;
	}

	public void setValorunitariocomercial(String valorunitariocomercial) {
		this.valorunitariocomercial = valorunitariocomercial;
	}
	
	public String getVuncom() {

		if(StringUtil.isNotEmpty(valorunitariocomercial)) {
			return hashValue(valorunitariocomercial);
		}

		return vuncom;			
	}

	public void setVuncom(String vuncom) {
		this.vuncom = vuncom;
	}

	public String getValorunitariotributacao() {
		return valorunitariotributacao;
	}

	public void setValorunitariotributacao(String valorunitariotributacao) {
		this.valorunitariotributacao = valorunitariotributacao;
	}
	
	public String getVuntrib() {

		if(StringUtil.isNotEmpty(valorunitariotributacao))	{
			return hashValue(valorunitariotributacao);
		}

		return vuntrib;
	}

	public void setVuntrib(String vuntrib) {
		this.vuntrib = vuntrib;
	}

	public String getOrigemmercadoria() {
		return origemmercadoria;
	}

	public void setOrigemmercadoria(String origemmercadoria) {
		this.origemmercadoria = origemmercadoria;
	}

	public String getTributacaoicms() {
		return tributacaoicms;
	}

	public void setTributacaoicms(String tributacaoicms) {
		this.tributacaoicms = tributacaoicms;
	}

	public String getModalidadedefinicaobcicmsnormal() {
		return modalidadedefinicaobcicmsnormal;
	}

	public void setModalidadedefinicaobcicmsnormal(String modalidadedefinicaobcicmsnormal) {
		this.modalidadedefinicaobcicmsnormal = modalidadedefinicaobcicmsnormal;
	}

	public String getBasecalculoicmsnormal() {
		return basecalculoicmsnormal;
	}

	public void setBasecalculoicmsnormal(String basecalculoicmsnormal) {
		this.basecalculoicmsnormal = basecalculoicmsnormal;
	}

	public String getAliquotaicmsnormal() {
		return aliquotaicmsnormal;
	}

	public void setAliquotaicmsnormal(String aliquotaicmsnormal) {
		this.aliquotaicmsnormal = aliquotaicmsnormal;
	}

	public String getValoricmsnormal() {
		return valoricmsnormal;			
	}

	public void setValoricmsnormal(String valoricmsnormal) {
		this.valoricmsnormal = valoricmsnormal;
	}
	
	public String getVicms() {

		if(StringUtil.isNotEmpty(valoricmsnormal)) {
			return hashValue(valoricmsnormal);
		}		

		return vicms;
	}

	public void setVicms(String vicms) {
		this.vicms = vicms;
	}

	public String getBasecalculoicmsst() {
		return basecalculoicmsst;
	}

	public void setBasecalculoicmsst(String basecalculoicmsst) {
		this.basecalculoicmsst = basecalculoicmsst;
	}

	public String getAliquotaicmsst() {
		return aliquotaicmsst;
	}

	public void setAliquotaicmsst(String aliquotaicmsst) {
		this.aliquotaicmsst = aliquotaicmsst;
	}

	public String getValoricmsst() {
		return valoricmsst;
	}

	public void setValoricmsst(String valoricmsst) {
		this.valoricmsst = valoricmsst;
	}

	public String getPercentualmvaicmsst() {
		return percentualmvaicmsst;
	}

	public void setPercentualmvaicmsst(String percentualmvaicmsst) {
		this.percentualmvaicmsst = percentualmvaicmsst;
	}

	public String getModalidadedefinicaobcicmsst() {
		return modalidadedefinicaobcicmsst;
	}

	public void setModalidadedefinicaobcicmsst(String modalidadedefinicaobcicmsst) {
		this.modalidadedefinicaobcicmsst = modalidadedefinicaobcicmsst;
	}

	public String getCodigoenquadramentoimposto() {
		return codigoenquadramentoimposto;
	}

	public void setCodigoenquadramentoimposto(String codigoenquadramentoimposto) {
		this.codigoenquadramentoimposto = codigoenquadramentoimposto;
	}

	public String getBasecalculoimposto() {
		return basecalculoimposto;
	}

	public void setBasecalculoimposto(String basecalculoimposto) {
		this.basecalculoimposto = basecalculoimposto;
	}

	public String getAliquotaimposto() {
		return aliquotaimposto;
	}

	public void setAliquotaimposto(String aliquotaimposto) {
		this.aliquotaimposto = aliquotaimposto;
	}

	public String getValoripi() {
		return valoripi;
	}

	public void setValoripi(String valoripi) {
		this.valoripi = valoripi;
	}

	public String getCst() {
		return cst;
	}

	public void setCst(String cst) {
		this.cst = cst;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getQtrib() {

		if(StringUtil.isNotEmpty(quantidadetributavel) ) {
			return hashValue(quantidadetributavel);
		} 

		return qtrib;			
	}

	public void setQtrib(String qtrib) {
		this.qtrib = qtrib;
	}

	public String getOrig() {
		return orig;
	}

	public void setOrig(String orig) {
		this.orig = orig;
	}

	public String getModbc() {
		return modbc;
	}

	public void setModbc(String modbc) {
		this.modbc = modbc;
	}

	public String getPicms() {
		return picms;
	}

	public void setPicms(String picms) {
		this.picms = picms;
	}

	public String getCenq() {
		return cenq;
	}

	public void setCenq(String cenq) {
		this.cenq = cenq;
	}

	public String getVbc() {
		return vbc;
	}

	public void setVbc(String vbc) {
		this.vbc = vbc;
	}

	public String getPipi() {
		return pipi;
	}

	public void setPipi(String pipi) {
		this.pipi = pipi;
	}

	public String getVipi() {
		return vipi;
	}

	public void setVipi(String vipi) {
		this.vipi = vipi;
	}
	
	private String hashValue(String value) {
		return value.replace(".", "").replaceAll(",",".");
	}
}