package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Cidade extends BasicDBObject implements Serializable {
    private long idCidade;
    private long codigo;
    private String codigoAnp;
    private String codigoDfc;
    private String codigoIAgro;
    private long codigoIBGE;
    private String ddd;
    private String descricao;
    private UnidadeFederativa idUnidadeFederativa;
    private String naturalidade;

    public Cidade(long idCidade, long codigo, String codigoAnp, String codigoDfc, String codigoIAgro, long codigoIBGE, String ddd, String descricao, UnidadeFederativa idUnidadeFederativa, String naturalidade) {
	super();
	this.idCidade = idCidade;
	this.codigo = codigo;
	this.codigoAnp = codigoAnp;
	this.codigoDfc = codigoDfc;
	this.codigoIAgro = codigoIAgro;
	this.codigoIBGE = codigoIBGE;
	this.ddd = ddd;
	this.descricao = descricao;
	this.idUnidadeFederativa = idUnidadeFederativa;
	this.naturalidade = naturalidade;
    }

    public Cidade() {

    }

    public long getIdCidade() {
	return idCidade;
    }

    public void setIdCidade(long idCidade) {
	this.idCidade = idCidade;
    }

    public long getCodigo() {
	return codigo;
    }

    public void setCodigo(long codigo) {
	this.codigo = codigo;
    }

    public String getCodigoAnp() {
	return codigoAnp;
    }

    public void setCodigoAnp(String codigoAnp) {
	this.codigoAnp = codigoAnp;
    }

    public String getCodigoDfc() {
	return codigoDfc;
    }

    public void setCodigoDfc(String codigoDfc) {
	this.codigoDfc = codigoDfc;
    }

    public String getCodigoIAgro() {
	return codigoIAgro;
    }

    public void setCodigoIAgro(String codigoIAgro) {
	this.codigoIAgro = codigoIAgro;
    }

    public long getCodigoIBGE() {
	return codigoIBGE;
    }

    public void setCodigoIBGE(long codigoIBGE) {
	this.codigoIBGE = codigoIBGE;
    }

    public String getDdd() {
	return ddd;
    }

    public void setDdd(String ddd) {
	this.ddd = ddd;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public UnidadeFederativa getIdUnidadeFederativa() {
	return idUnidadeFederativa;
    }

    public void setIdUnidadeFederativa(UnidadeFederativa idUnidadeFederativa) {
	this.idUnidadeFederativa = idUnidadeFederativa;
    }

    public String getNaturalidade() {
	return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
	this.naturalidade = naturalidade;
    }

    public String toJson() {
	BasicDBObject doc = new BasicDBObject();
	doc.put("IDCIDADE", (int) this.getIdCidade());
	doc.put("CODIGO", (int) this.getCodigo());
	doc.put("CODIGOANP", this.getCodigoAnp());
	doc.put("CODIGODFC", this.getCodigoDfc());
	doc.put("CODIGOIAGRO", this.getCodigoIAgro());
	doc.put("CODIGOIBGE", (int) this.getCodigoIBGE());
	doc.put("DDD", (String) this.getDdd());
	doc.put("DESCRICAO", this.getDescricao());
	doc.put("IDUNIDADEFEDERATIVA", this.getIdUnidadeFederativa().toJson());
	doc.put("NATURALIDADE", this.getNaturalidade());
	return doc.toString();

    }

    public static Cidade toObject(Document doc) {

	long idCidade = doc.getInteger("IDCIDADE");
	long codigo = doc.getInteger("CODIGO");
	String codigoAnp = doc.getString("CODIGOANP");
	String codigoDfc = doc.getString("CODIGODFC");
	String codigoIAgro = doc.getString("CODIGOIAGRO");
	long codigoIBGE = doc.getInteger("CODIGOIBGE");
	String ddd = doc.getString("DDD");
	String descricao = doc.getString("DESCRICAO");
	Document db = (Document) doc.get("IDUNIDADEFEDERATIVA");
	UnidadeFederativa idUnidadeFederativa = UnidadeFederativa.toObject(db);
	String naturalidade = doc.getString("NATURALIDADE");

	Cidade cidade = new Cidade(idCidade, codigo, codigoAnp, codigoDfc, codigoIAgro, codigoIBGE, ddd, descricao, idUnidadeFederativa, naturalidade);

	return cidade;
    }

    @Override
    public String toString() {
	return "Cidade [idCidade=" + idCidade + ", codigo=" + codigo + ", codigoAnp=" + codigoAnp + ", codigoDfc=" + codigoDfc + ", codigoIAgro=" + codigoIAgro + ", codigoIBGE=" + codigoIBGE + ", ddd=" + ddd + ", descricao=" + descricao + ", idUnidadeFederativa=" + idUnidadeFederativa + ", naturalidade=" + naturalidade + "]";
    }

}