package model;

import org.bson.Document;

import com.mongodb.BasicDBObject;

public class UnidadeFederativa {
    private long idUnidadeFederativa;
    private long codigoIBGE;
    private String descricao;
    private Pais idPais;
    private String sigla;

    public UnidadeFederativa(long idUnidadeFederativa, long codigoIBGE, String descricao, Pais idPais, String sigla) {
	this.idUnidadeFederativa = idUnidadeFederativa;
	this.codigoIBGE = codigoIBGE;
	this.descricao = descricao;
	this.idPais = idPais;
	this.sigla = sigla;
    }

    public long getIdUnidadeFederativa() {
	return idUnidadeFederativa;
    }

    public void setIdUnidadeFederativa(long idUnidadeFederativa) {
	this.idUnidadeFederativa = idUnidadeFederativa;
    }

    public long getCodigoIBGE() {
	return codigoIBGE;
    }

    public void setCodigoIBGE(long codigoIBGE) {
	this.codigoIBGE = codigoIBGE;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public Pais getIdPais() {
	return idPais;
    }

    public void setIdPais(Pais idPais) {
	this.idPais = idPais;
    }

    public String getSigla() {
	return sigla;
    }

    public void setSigla(String sigla) {
	this.sigla = sigla;
    }

    @Override
    public String toString() {
	return "UnidadeFederativa [idUnidadeFederativa=" + idUnidadeFederativa + ", codigoIBGE=" + codigoIBGE + ", descricao=" + descricao + ", idPais=" + idPais + ", sigla=" + sigla + "]";
    }

    public String toJson() {

	BasicDBObject doc = new BasicDBObject();

	doc.put("IDUNIDADEFEDERATIVA", (int) this.getIdUnidadeFederativa());
	doc.put("CODIGOIBGE", (int) this.getCodigoIBGE());
	doc.put("DESCRICAO", this.getDescricao());
	doc.put("IDPAIS", this.getIdPais().toJson());
	doc.put("SIGLA", this.getSigla());

	return doc.toString();
    }

    public static UnidadeFederativa toObject(Document doc) {

	long idUnidadeFederativa = doc.getInteger("IDUNIDADEFEDERATIVA");
	long codigoIBGE = doc.getInteger("CODIGOIBGE");
	String descricao = doc.getString("DESCRICAO");
	Document db = (Document) doc.get("IDPAIS");
	Pais idPais = Pais.toObject(db);

	String sigla = doc.getString("SIGLA");

	UnidadeFederativa unidadeFederativa = new UnidadeFederativa(idUnidadeFederativa, codigoIBGE, descricao, idPais, sigla);

	return unidadeFederativa;
    }

}
