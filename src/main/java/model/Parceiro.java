package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Parceiro extends BasicDBObject implements Serializable {

    private long idParceiro;
    private long ativo;
    private long codigo;
    private Date dataAlteracaoSimplificado;
    private Date dataCadastro;
    private Date dataUltimaAtualizacao;
    private String descricao;
    private String email;
    private String homepage;
    private long idAtivididadeEconomica;
    private long idClassificacaoCredito;
    private long idFilialCadastro;
    private Flag idFlagTipoPessoa;
    private GrupoEmpresarial idGrupoEmpresarial;
    private long idPorte;
    private long idTipoParceiro;
    private byte[] imagem;
    private String nome;
    private String observacao;
    private String sigla;
    private long simplificado;
    private long usuarioAlteracaoSimplificado;

    public Parceiro(long idParceiro, long ativo, long codigo, Date dataAlteracaoSimplificado, Date dataCadastro, Date dataUltimaAtualizacao, String descricao, String email, String homepage, long idAtivididadeEconomica, long idClassificacaoCredito, long idFilialCadastro, Flag idFlagTipoPessoa, GrupoEmpresarial idGrupoEmpresarial, long idPorte, long idTipoParceiro, byte[] imagem, String nome, String observacao, String sigla, long simplificado, long usuarioAlteracaoSimplificado) {

	this.idParceiro = idParceiro;
	this.ativo = ativo;
	this.codigo = codigo;
	this.dataAlteracaoSimplificado = dataAlteracaoSimplificado;
	this.dataCadastro = dataCadastro;
	this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	this.descricao = descricao;
	this.email = email;
	this.homepage = homepage;
	this.idAtivididadeEconomica = idAtivididadeEconomica;
	this.idClassificacaoCredito = idClassificacaoCredito;
	this.idFilialCadastro = idFilialCadastro;
	this.idFlagTipoPessoa = idFlagTipoPessoa;
	this.idGrupoEmpresarial = idGrupoEmpresarial;
	this.idPorte = idPorte;
	this.idTipoParceiro = idTipoParceiro;
	this.imagem = imagem;
	this.nome = nome;
	this.observacao = observacao;
	this.sigla = sigla;
	this.simplificado = simplificado;
	this.usuarioAlteracaoSimplificado = usuarioAlteracaoSimplificado;
    }

    public long getIdParceiro() {
	return idParceiro;
    }

    public void setIdParceiro(long idParceiro) {
	this.idParceiro = idParceiro;
    }

    public long getAtivo() {
	return ativo;
    }

    public void setAtivo(long ativo) {
	this.ativo = ativo;
    }

    public long getCodigo() {
	return codigo;
    }

    public void setCodigo(long codigo) {
	this.codigo = codigo;
    }

    public Date getDataAlteracaoSimplificado() {
	return dataAlteracaoSimplificado;
    }

    public void setDataAlteracaoSimplificado(Date dataAlteracaoSimplificado) {
	this.dataAlteracaoSimplificado = dataAlteracaoSimplificado;
    }

    public Date getDataCadastro() {
	return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
	this.dataCadastro = dataCadastro;
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

    public String getHomepage() {
	return homepage;
    }

    public void setHomepage(String homepage) {
	this.homepage = homepage;
    }

    public long getIdAtivididadeEconomica() {
	return idAtivididadeEconomica;
    }

    public void setIdAtivididadeEconomica(long idAtivididadeEconomica) {
	this.idAtivididadeEconomica = idAtivididadeEconomica;
    }

    public long getIdClassificacaoCredito() {
	return idClassificacaoCredito;
    }

    public void setIdClassificacaoCredito(long idClassificacaoCredito) {
	this.idClassificacaoCredito = idClassificacaoCredito;
    }

    public long getIdFilialCadastro() {
	return idFilialCadastro;
    }

    public void setIdFilialCadastro(long idFilialCadastro) {
	this.idFilialCadastro = idFilialCadastro;
    }

    public Flag getIdFlagTipoPessoa() {
	return idFlagTipoPessoa;
    }

    public void setIdFlagTipoPessoa(Flag idFlagTipoPessoa) {
	this.idFlagTipoPessoa = idFlagTipoPessoa;
    }

    public GrupoEmpresarial getIdGrupoEmpresarial() {
	return idGrupoEmpresarial;
    }

    public void setIdGrupoEmpresarial(GrupoEmpresarial idGrupoEmpresarial) {
	this.idGrupoEmpresarial = idGrupoEmpresarial;
    }

    public long getIdPorte() {
	return idPorte;
    }

    public void setIdPorte(long idPorte) {
	this.idPorte = idPorte;
    }

    public long getIdTipoParceiro() {
	return idTipoParceiro;
    }

    public void setIdTipoParceiro(long idTipoParceiro) {
	this.idTipoParceiro = idTipoParceiro;
    }

    public byte[] getImagem() {
	return imagem;
    }

    public void setImagem(byte[] imagem) {
	this.imagem = imagem;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getObservacao() {
	return observacao;
    }

    public void setObservacao(String observacao) {
	this.observacao = observacao;
    }

    public String getSigla() {
	return sigla;
    }

    public void setSigla(String sigla) {
	this.sigla = sigla;
    }

    public long getSimplificado() {
	return simplificado;
    }

    public void setSimplificado(long simplificado) {
	this.simplificado = simplificado;
    }

    public long getUsuarioAlteracaoSimplificado() {
	return usuarioAlteracaoSimplificado;
    }

    public void setUsuarioAlteracaoSimplificado(long usuarioAlteracaoSimplificado) {
	this.usuarioAlteracaoSimplificado = usuarioAlteracaoSimplificado;
    }

    @Override
    public String toString() {
	return "Parceiro [idParceiro=" + idParceiro + ", ativo=" + ativo + ", codigo=" + codigo + ", dataAlteracaoSimplificado=" + dataAlteracaoSimplificado + ", dataCadastro=" + dataCadastro + ", dataUltimaAtualizacao=" + dataUltimaAtualizacao + ", descricao=" + descricao + ", email=" + email + ", homepage=" + homepage + ", idAtivididadeEconomica=" + idAtivididadeEconomica + ", idClassificacaoCredito=" + idClassificacaoCredito + ", idFilialCadastro=" + idFilialCadastro + ", idFlagTipoPessoa="
		+ idFlagTipoPessoa + ", idGrupoEmpresarial=" + idGrupoEmpresarial + ", idPorte=" + idPorte + ", idTipoParceiro=" + idTipoParceiro + ", imagem=" + Arrays.toString(imagem) + ", nome=" + nome + ", observacao=" + observacao + ", sigla=" + sigla + ", simplificado=" + simplificado + ", usuarioAlteracaoSimplificado=" + usuarioAlteracaoSimplificado + "]";
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();
	doc.put("IDPARCEIRO", (int) this.getIdParceiro());
	doc.put("ATIVO", (int) this.getAtivo());
	doc.put("CODIGO", (int) this.getCodigo());
	doc.put("DATAALTERACAOSIMPLIFICADO", this.getDataAlteracaoSimplificado());
	doc.put("DATACADASTRO", this.getDataCadastro());
	doc.put("DATAULTIMAATUALIZACAO", this.getDataUltimaAtualizacao());
	doc.put("DESCRICAO", this.getDescricao());
	doc.put("EMAIL", this.getEmail());
	doc.put("HOMEPAGE", this.getHomepage());
	doc.put("IDATIVIDIDADEECONOMICA", this.getIdAtivididadeEconomica());
	doc.put("IDCLASSIFICACAOCREDITO", this.getIdClassificacaoCredito());
	doc.put("IDFILIALCADASTRO", this.getIdFilialCadastro());
	doc.put("IDFLAGTIPOPESSOA", this.getIdFlagTipoPessoa().toJson());
	doc.put("IDGRUPOEMPRESARIAL", this.getIdGrupoEmpresarial());
	doc.put("IDPORTE", this.getIdPorte());
	doc.put("IDTIPOPARCEIRO", this.getIdTipoParceiro());
	doc.put("IMAGEM", this.getImagem());
	doc.put("NOME", this.getNome());
	doc.put("OBSERVACAO", this.getObservacao());
	doc.put("SIGLA", this.getSigla());
	doc.put("SIMPLIFICADO", this.getSimplificado());
	doc.put("USUARIOALTERACAOSIMPLIFICADO", this.getUsuarioAlteracaoSimplificado());

	return doc.toString();

    }

    public static Parceiro toObject(Document doc) {

	long idParceiro = doc.getInteger("IDPARCEIRO");
	long ativo = doc.getInteger("ATIVO");
	long codigo = doc.getInteger("CODIGO");

	Date dataAlteracaoSimplificado = doc.getDate("DATAALTERACAOSIMPLIFICADO");
	Date dataCadastro = doc.getDate("DATACADASTRO");
	Date dataUltimaAtualizacao = doc.getDate("DATAULTIMAATUALIZACAO");

	String descricao = doc.getString("DESCRICAO");
	String email = doc.getString("EMAIL");
	String homepage = doc.getString("HOMEPAGE");
	long idAtivididadeEconomica = doc.getInteger("IDATIVIDIDADEECONOMICA");
	long idClassificacaoCredito = doc.getInteger("IDCLASSIFICACAOCREDITO");
	long idFilialCadastro = doc.getInteger("IDFILIALCADASTRO");
	Document db = (Document) doc.get("IDFLAGTIPOPESSOA");
	Flag idFlagTipoPessoa = Flag.toObject(db);
	db = (Document) doc.get("IDGRUPOEMPRESARIAL");
	GrupoEmpresarial idGrupoEmpresarial = GrupoEmpresarial.toObject(db);
	long idPorte = doc.getInteger("IDPORTE");
	long idTipoParceiro = doc.getInteger("IDTIPOPARCEIRO");
	byte[] imagem = doc.getString("IMAGEM").getBytes();
	String nome = doc.getString("NOME");
	String observacao = doc.getString("OBSERVACAO");
	String sigla = doc.getString("SIGLA");
	long simplificado = doc.getInteger("SIMPLIFICADO");
	long usuarioAlteracaoSimplificado = doc.getInteger("USUARIOALTERACAOSIMPLIFICADO");

	Parceiro parceiro = new Parceiro(idParceiro, ativo, codigo, dataAlteracaoSimplificado, dataCadastro, dataUltimaAtualizacao, descricao, email, homepage, idAtivididadeEconomica, idClassificacaoCredito, idFilialCadastro, idFlagTipoPessoa, idGrupoEmpresarial, idPorte, idTipoParceiro, imagem, nome, observacao, sigla, simplificado, usuarioAlteracaoSimplificado);

	return parceiro;
    }

}