package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Logradouro extends BasicDBObject implements Serializable {
    private long idLogradouro;
    private long idCidade;
    private TipoLogradouro idTipoLogradouro;
    private String descricao;
    private long codigo;

    public Logradouro(long idLogradouro, long idCidade, TipoLogradouro idTipoLogradouro, String descricao, long codigo) {
	this.idLogradouro = idLogradouro;
	this.idCidade = idCidade;
	this.idTipoLogradouro = idTipoLogradouro;
	this.descricao = descricao;
	this.codigo = codigo;
    }

    public long getIdLogradouro() {
	return idLogradouro;
    }

    public void setIdLogradouro(long idLogradouro) {
	this.idLogradouro = idLogradouro;
    }

    public long getIdCidade() {
	return idCidade;
    }

    public void setIdCidade(long idCidade) {
	this.idCidade = idCidade;
    }

    public TipoLogradouro getIdTipoLogradouro() {
	return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(TipoLogradouro idTipoLogradouro) {
	this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public long getCodigo() {
	return codigo;
    }

    public void setCodigo(long codigo) {
	this.codigo = codigo;
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();

	doc.put("IDLOGRADOURO", (int) this.getIdLogradouro());
	doc.put("IDCIDADE", (int) this.getIdCidade());
	doc.put("IDTIPOLOGRADOURO", this.getIdTipoLogradouro().toJson());
	doc.put("DESCRICAO", this.getDescricao());
	doc.put("CODIGO", (int) this.getCodigo());

	return doc.toString();
    }

    public static Logradouro toObject(Document doc) {

	long idLogradouro = doc.getInteger("IDLOGRADOURO");
	long idCidade = doc.getInteger("IDCIDADE");
	Document db = (Document) doc.get("IDTIPOLOGRADOURO");
	TipoLogradouro idTipoLogradouro = TipoLogradouro.toObject(db);
	String descricao = doc.getString("DESCRICAO");
	long codigo = doc.getInteger("CODIGO");

	Logradouro log = new Logradouro(idLogradouro, idCidade, idTipoLogradouro, descricao, codigo);
	return log;
    }

    @Override
    public String toString() {
	return "Logradouro [idLogradouro=" + idLogradouro + ", idCidade=" + idCidade + ", idTipoLogradouro=" + idTipoLogradouro + ", descricao=" + descricao + ", codigo=" + codigo + "]";
    }

}
