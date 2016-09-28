package model;

import java.io.Serializable;
import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Local extends BasicDBObject implements Serializable {
	
	private long idLocal;
	private long ativo;
	private String celular;
	private String cnpj;
	private long codigo;
	private long codigoAgenteReguladoInformante;
	private long codigoAtividadeEconomicaANP;
	private long codigoInstalacaoANP;
	private String contato;
	private Date dataCadastro;
	private Date dataDeRegistroNaJuntaComercial;
	private Date dataDeRegistroNaSefaz;
	private Date dataUltimaAtualizacao;
	private String descricao;
	private String email;
	private String emailEnvioNFE;
	private long escritaContabilRegular;
	private String fax;
	private long idFilial;
	private long idFilialAcerto;
	private long idLocalCobranca;
	private Parceiro idParceiro;
	private long idPontoGeografico;
	private String inscricaoEstadual;
	private String inscricaoEstadualSt;
	private String inscricaoMunicipal;
	private String inscricaoProdutorRural;
	private String inscricaoRSP;
	private String inscricaoSuframa;
	private long localProdutorRural;
	private String numeroDAP;
	private long numeroEmpregado;
	private long numeroRegistroJuntaComercial;
	private String numeroRenasem;
	private String pessoaContato;
	private String ramalContato;
	private String razaoSocial;
	private long somenteCobranca;
	private String telefone;
	private Date validadeInscricaoEstadual;

	public Local(long idLocal, long ativo, String celular, String cnpj, long codigo,
			long codigoAgenteReguladoInformante, long codigoAtividadeEconomicaANP, long codigoInstalacaoANP,
			String contato, Date dataCadastro, Date dataDeRegistroNaJuntaComercial, Date dataDeRegistroNaSefaz,
			Date dataUltimaAtualizacao, String descricao, String email, String emailEnvioNFE,
			long escritaContabilRegular, String fax, long idFilial, long idFilialAcerto, long idLocalCobranca,
			Parceiro idParceiro, long idPontoGeografico, String inscricaoEstadual, String inscricaoEstadualSt,
			String inscricaoMunicipal, String inscricaoProdutorRural, String inscricaoRSP, String inscricaoSuframa,
			long localProdutorRural, String numeroDAP, long numeroEmpregado, long numeroRegistroJuntaComercial,
			String numeroRenasem, String pessoaContato, String ramalContato, String razaoSocial, long somenteCobranca,
			String telefone, Date validadeInscricaoEstadual) {
		this.idLocal = idLocal;
		this.ativo = ativo;
		this.celular = celular;
		this.cnpj = cnpj;
		this.codigo = codigo;
		this.codigoAgenteReguladoInformante = codigoAgenteReguladoInformante;
		this.codigoAtividadeEconomicaANP = codigoAtividadeEconomicaANP;
		this.codigoInstalacaoANP = codigoInstalacaoANP;
		this.contato = contato;
		this.dataCadastro = dataCadastro;
		this.dataDeRegistroNaJuntaComercial = dataDeRegistroNaJuntaComercial;
		this.dataDeRegistroNaSefaz = dataDeRegistroNaSefaz;
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
		this.descricao = descricao;
		this.email = email;
		this.emailEnvioNFE = emailEnvioNFE;
		this.escritaContabilRegular = escritaContabilRegular;
		this.fax = fax;
		this.idFilial = idFilial;
		this.idFilialAcerto = idFilialAcerto;
		this.idLocalCobranca = idLocalCobranca;
		this.idParceiro = idParceiro;
		this.idPontoGeografico = idPontoGeografico;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoEstadualSt = inscricaoEstadualSt;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.inscricaoProdutorRural = inscricaoProdutorRural;
		this.inscricaoRSP = inscricaoRSP;
		this.inscricaoSuframa = inscricaoSuframa;
		this.localProdutorRural = localProdutorRural;
		this.numeroDAP = numeroDAP;
		this.numeroEmpregado = numeroEmpregado;
		this.numeroRegistroJuntaComercial = numeroRegistroJuntaComercial;
		this.numeroRenasem = numeroRenasem;
		this.pessoaContato = pessoaContato;
		this.ramalContato = ramalContato;
		this.razaoSocial = razaoSocial;
		this.somenteCobranca = somenteCobranca;
		this.telefone = telefone;
		this.validadeInscricaoEstadual = validadeInscricaoEstadual;
	}

	public long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}

	public long getAtivo() {
		return ativo;
	}

	public void setAtivo(long ativo) {
		this.ativo = ativo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public long getCodigoAgenteReguladoInformante() {
		return codigoAgenteReguladoInformante;
	}

	public void setCodigoAgenteReguladoInformante(long codigoAgenteReguladoInformante) {
		this.codigoAgenteReguladoInformante = codigoAgenteReguladoInformante;
	}

	public long getCodigoAtividadeEconomicaANP() {
		return codigoAtividadeEconomicaANP;
	}

	public void setCodigoAtividadeEconomicaANP(long codigoAtividadeEconomicaANP) {
		this.codigoAtividadeEconomicaANP = codigoAtividadeEconomicaANP;
	}

	public long getCodigoInstalacaoANP() {
		return codigoInstalacaoANP;
	}

	public void setCodigoInstalacaoANP(long codigoInstalacaoANP) {
		this.codigoInstalacaoANP = codigoInstalacaoANP;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataDeRegistroNaJuntaComercial() {
		return dataDeRegistroNaJuntaComercial;
	}

	public void setDataDeRegistroNaJuntaComercial(Date dataDeRegistroNaJuntaComercial) {
		this.dataDeRegistroNaJuntaComercial = dataDeRegistroNaJuntaComercial;
	}

	public Date getDataDeRegistroNaSefaz() {
		return dataDeRegistroNaSefaz;
	}

	public void setDataDeRegistroNaSefaz(Date dataDeRegistroNaSefaz) {
		this.dataDeRegistroNaSefaz = dataDeRegistroNaSefaz;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailEnvioNFE() {
		return emailEnvioNFE;
	}

	public void setEmailEnvioNFE(String emailEnvioNFE) {
		this.emailEnvioNFE = emailEnvioNFE;
	}

	public long getEscritaContabilRegular() {
		return escritaContabilRegular;
	}

	public void setEscritaContabilRegular(long escritaContabilRegular) {
		this.escritaContabilRegular = escritaContabilRegular;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public long getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(long idFilial) {
		this.idFilial = idFilial;
	}

	public long getIdFilialAcerto() {
		return idFilialAcerto;
	}

	public void setIdFilialAcerto(long idFilialAcerto) {
		this.idFilialAcerto = idFilialAcerto;
	}

	public long getIdLocalCobranca() {
		return idLocalCobranca;
	}

	public void setIdLocalCobranca(long idLocalCobranca) {
		this.idLocalCobranca = idLocalCobranca;
	}

	public Parceiro getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Parceiro idParceiro) {
		this.idParceiro = idParceiro;
	}

	public long getIdPontoGeografico() {
		return idPontoGeografico;
	}

	public void setIdPontoGeografico(long idPontoGeografico) {
		this.idPontoGeografico = idPontoGeografico;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoEstadualSt() {
		return inscricaoEstadualSt;
	}

	public void setInscricaoEstadualSt(String inscricaoEstadualSt) {
		this.inscricaoEstadualSt = inscricaoEstadualSt;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getInscricaoProdutorRural() {
		return inscricaoProdutorRural;
	}

	public void setInscricaoProdutorRural(String inscricaoProdutorRural) {
		this.inscricaoProdutorRural = inscricaoProdutorRural;
	}

	public String getInscricaoRSP() {
		return inscricaoRSP;
	}

	public void setInscricaoRSP(String inscricaoRSP) {
		this.inscricaoRSP = inscricaoRSP;
	}

	public String getInscricaoSuframa() {
		return inscricaoSuframa;
	}

	public void setInscricaoSuframa(String inscricaoSuframa) {
		this.inscricaoSuframa = inscricaoSuframa;
	}

	public long getLocalProdutorRural() {
		return localProdutorRural;
	}

	public void setLocalProdutorRural(long localProdutorRural) {
		this.localProdutorRural = localProdutorRural;
	}

	public String getNumeroDAP() {
		return numeroDAP;
	}

	public void setNumeroDAP(String numeroDAP) {
		this.numeroDAP = numeroDAP;
	}

	public long getNumeroEmpregado() {
		return numeroEmpregado;
	}

	public void setNumeroEmpregado(long numeroEmpregado) {
		this.numeroEmpregado = numeroEmpregado;
	}

	public long getNumeroRegistroJuntaComercial() {
		return numeroRegistroJuntaComercial;
	}

	public void setNumeroRegistroJuntaComercial(long numeroRegistroJuntaComercial) {
		this.numeroRegistroJuntaComercial = numeroRegistroJuntaComercial;
	}

	public String getNumeroRenasem() {
		return numeroRenasem;
	}

	public void setNumeroRenasem(String numeroRenasem) {
		this.numeroRenasem = numeroRenasem;
	}

	public String getPessoaContato() {
		return pessoaContato;
	}

	public void setPessoaContato(String pessoaContato) {
		this.pessoaContato = pessoaContato;
	}

	public String getRamalContato() {
		return ramalContato;
	}

	public void setRamalContato(String ramalContato) {
		this.ramalContato = ramalContato;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public long getSomenteCobranca() {
		return somenteCobranca;
	}

	public void setSomenteCobranca(long somenteCobranca) {
		this.somenteCobranca = somenteCobranca;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getValidadeInscricaoEstadual() {
		return validadeInscricaoEstadual;
	}

	public void setValidadeInscricaoEstadual(Date validadeInscricaoEstadual) {
		this.validadeInscricaoEstadual = validadeInscricaoEstadual;
	}

	@Override
	public String toString() {
		return "Local [idLocal=" + idLocal + ", ativo=" + ativo + ", celular=" + celular + ", cnpj=" + cnpj
				+ ", codigo=" + codigo + ", codigoAgenteReguladoInformante=" + codigoAgenteReguladoInformante
				+ ", codigoAtividadeEconomicaANP=" + codigoAtividadeEconomicaANP + ", codigoInstalacaoANP="
				+ codigoInstalacaoANP + ", contato=" + contato + ", dataCadastro=" + dataCadastro
				+ ", dataDeRegistroNaJuntaComercial=" + dataDeRegistroNaJuntaComercial + ", dataDeRegistroNaSefaz="
				+ dataDeRegistroNaSefaz + ", dataUltimaAtualizacao=" + dataUltimaAtualizacao + ", descricao="
				+ descricao + ", email=" + email + ", emailEnvioNFE=" + emailEnvioNFE + ", escritaContabilRegular="
				+ escritaContabilRegular + ", fax=" + fax + ", idFilial=" + idFilial + ", idFilialAcerto="
				+ idFilialAcerto + ", idLocalCobranca=" + idLocalCobranca + ", idParceiro=" + idParceiro
				+ ", idPontoGeografico=" + idPontoGeografico + ", inscricaoEstadual=" + inscricaoEstadual
				+ ", inscricaoEstadualSt=" + inscricaoEstadualSt + ", inscricaoMunicipal=" + inscricaoMunicipal
				+ ", inscricaoProdutorRural=" + inscricaoProdutorRural + ", inscricaoRSP=" + inscricaoRSP
				+ ", inscricaoSuframa=" + inscricaoSuframa + ", localProdutorRural=" + localProdutorRural
				+ ", numeroDAP=" + numeroDAP + ", numeroEmpregado=" + numeroEmpregado
				+ ", numeroRegistroJuntaComercial=" + numeroRegistroJuntaComercial + ", numeroRenasem=" + numeroRenasem
				+ ", pessoaContato=" + pessoaContato + ", ramalContato=" + ramalContato + ", razaoSocial=" + razaoSocial
				+ ", somenteCobranca=" + somenteCobranca + ", telefone=" + telefone + ", validadeInscricaoEstadual="
				+ validadeInscricaoEstadual + "]";
	}

	@Override
	public String toJson() {

		BasicDBObject doc = new BasicDBObject();
		doc.put("IDLOCAL" , (int)this.getIdLocal());
				doc.put("ATIVO" ,(int) this.getAtivo());
				doc.put("CELULAR" , this.getCelular());
				doc.put("CNPJ", this.getCelular());
				doc.put("CODIGO", (int)this.getCodigo());
				doc.put("CODIGOAGENTEREGULADOINFORMANTE", (int) this.getCodigoAgenteReguladoInformante());
				doc.put("CODIGOATIVIDADEECONOMICAANP" , (int) this.getCodigoAtividadeEconomicaANP());
				doc.put("CODIGOINSTALACAOANP" , (int) this.getCodigoInstalacaoANP());
				doc.put("CONTATO" , this.getContato());
				doc.put("DATACADASTRO" , this.getDataCadastro());
				doc.put("DATADEREGISTRONAJUNTACOMERCIAL" , this.getDataDeRegistroNaJuntaComercial());
				doc.put("DATADEREGISTRONASEFAZ" , this.getDataDeRegistroNaSefaz());
				doc.put("DATAULTIMAATUALIZACAO" , this.getDataUltimaAtualizacao());
				doc.put("DESCRICAO" , this.getDescricao());
				doc.put("EMAIL" , this.getEmail());
				doc.put("EMAILENVIONFE" , this.getEmailEnvioNFE());
				doc.put("ESCRITACONTABILREGULAR" , this.getEscritaContabilRegular());
				doc.put("FAX" , this.getFax());
				doc.put("IDFILIAL" , this.getIdFilial());
				doc.put("IDFILIALACERTO" , this.getIdFilialAcerto());
				doc.put("IDLOCALCOBRANCA" , this.getIdLocalCobranca());
				doc.put("IDPARCEIRO" , this.getIdParceiro().toJson());
				doc.put("IDPONTOGEOGRAFICO" , this.getIdPontoGeografico());
				doc.put("INSCRICAOESTADUAL" , this.getInscricaoEstadual());
				doc.put("INSCRICAOESTADUALST" , this.getInscricaoEstadualSt());
				doc.put("INSCRICAOMUNICIPAL" , this.getInscricaoMunicipal());
				doc.put("INSCRICAOPRODUTORRURAL" , this.getInscricaoProdutorRural());
				doc.put("INSCRICAORSP" , this.getInscricaoRSP());
				doc.put("INSCRICAOSUFRAMA" , this.getInscricaoSuframa());
				doc.put("LOCALPRODUTORRURAL" , this.getLocalProdutorRural());
				doc.put("NUMERODAP" , this.getNumeroDAP());
				doc.put("NUMEROEMPREGADO" , this.getNumeroEmpregado());
				doc.put("NUMEROREGISTROJUNTACOMERCIAL" , this.getNumeroRegistroJuntaComercial());
				doc.put("NUMERORENASEM" , this.getNumeroRenasem());
				doc.put("PESSOACONTATO" , this.getPessoaContato());
				doc.put("RAMALCONTATO" , this.getRamalContato());
				doc.put("RAZAOSOCIAL" , this.getRazaoSocial());
				doc.put("SOMENTECOBRANCA" , this.getSomenteCobranca());
				doc.put("TELEFONE" , this.getTelefone());
				doc.put("VALIDADEINSCRICAOESTADUAL" , this.getValidadeInscricaoEstadual());

		return doc.toString();
	}
 
	public static Local toObject(Document doc) {

		long idLocal = doc.getInteger("IDLOCAL");
		long ativo = doc.getInteger("ATIVO");
		String celular = doc.getString("CELULAR");
		String cnpj = doc.getString("CNPJ");
		long codigo = doc.getInteger("CODIGO");
		long codigoAgenteReguladoInformante = doc.getInteger("CODIGOAGENTEREGULADOINFORMANTE");
		long codigoAtividadeEconomicaANP = doc.getInteger("CODIGOATIVIDADEECONOMICAANP");
		long codigoInstalacaoANP = doc.getInteger("CODIGOINSTALACAOANP");
		String contato = doc.getString("CONTATO");

		Date dataCadastro = doc.getDate("DATACADASTRO");
		Date dataDeRegistroNaJuntaComercial = doc.getDate("DATADEREGISTRONAJUNTACOMERCIAL");
		Date dataDeRegistroNaSefaz = doc.getDate("DATADEREGISTRONASEFAZ");
		Date dataUltimaAtualizacao = doc.getDate("DATAULTIMAATUALIZACAO");

		String descricao = doc.getString("DESCRICAO");
		String email = doc.getString("EMAIL");
		String emailEnvioNFE = doc.getString("EMAILENVIONFE");
		long escritaContabilRegular = doc.getInteger("ESCRITACONTABILREGULAR");
		String fax = doc.getString("FAX");
		long idFilial = doc.getInteger("IDFILIAL");
		long idFilialAcerto = doc.getInteger("IDFILIALACERTO");
		long idLocalCobranca = doc.getInteger("IDLOCALCOBRANCA");
		Document db =  (Document) doc.get("IDPARCEIRO");
		Parceiro idParceiro = Parceiro.toObject(db);
		long idPontoGeografico = doc.getInteger("IDPONTOGEOGRAFICO");
		String inscricaoEstadual = doc.getString("INSCRICAOESTADUAL");
		String inscricaoEstadualSt = doc.getString("INSCRICAOESTADUALST");
		String inscricaoMunicipal = doc.getString("INSCRICAOMUNICIPAL");
		String inscricaoProdutorRural = doc.getString("INSCRICAOPRODUTORRURAL");
		String inscricaoRSP = doc.getString("INSCRICAORSP");
		String inscricaoSuframa = doc.getString("INSCRICAOSUFRAMA");
		long localProdutorRural = doc.getInteger("LOCALPRODUTORRURAL");
		String numeroDAP = doc.getString("NUMERODAP");
		long numeroEmpregado = doc.getInteger("NUMEROEMPREGADO");
		long numeroRegistroJuntaComercial = doc.getInteger("NUMEROREGISTROJUNTACOMERCIAL");
		String numeroRenasem = doc.getString("NUMERORENASEM");
		String pessoaContato = doc.getString("PESSOACONTATO");
		String ramalContato = doc.getString("RAMALCONTATO");
		String razaoSocial = doc.getString("RAZAOSOCIAL");
		long somenteCobranca = doc.getInteger("SOMENTECOBRANCA");
		String telefone = doc.getString("TELEFONE");

		Date validadeInscricaoEstadual = doc.getDate("VALIDADEINSCRICAOESTADUAL");

		Local loc = new Local(idLocal, ativo, celular, cnpj, codigo, codigoAgenteReguladoInformante,
				codigoAtividadeEconomicaANP, codigoInstalacaoANP, contato, dataCadastro, dataDeRegistroNaJuntaComercial,
				dataDeRegistroNaSefaz, dataUltimaAtualizacao, descricao, email, emailEnvioNFE, escritaContabilRegular,
				fax, idFilial, idFilialAcerto, idLocalCobranca, idParceiro, idPontoGeografico, inscricaoEstadual,
				inscricaoEstadualSt, inscricaoMunicipal, inscricaoProdutorRural, inscricaoRSP, inscricaoSuframa,
				localProdutorRural, numeroDAP, numeroEmpregado, numeroRegistroJuntaComercial, numeroRenasem,
				pessoaContato, ramalContato, razaoSocial, somenteCobranca, telefone, validadeInscricaoEstadual);

		return loc;
	}
	
}
