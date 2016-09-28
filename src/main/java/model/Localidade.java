package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Localidade extends BasicDBObject implements Serializable {
    private long idLocalidade;
    private Cidade idCidade;
    private long codigo;
    private String descricao;

    public Localidade(long idLocalidade, Cidade idCidade, long codigo, String descricao) {
	this.idLocalidade = idLocalidade;
	this.idCidade = idCidade;
	this.codigo = codigo;
	this.descricao = descricao;
    }

    public long getIdLocalidade() {
	return idLocalidade;
    }

    public void setIdLocalidade(long idLocalidade) {
	this.idLocalidade = idLocalidade;
    }

    public Cidade getIdCidade() {
	return idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
	this.idCidade = idCidade;
    }

    public long getCodigo() {
	return codigo;
    }

    public void setCodigo(long codigo) {
	this.codigo = codigo;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();

	doc.put("IDLOCALIDADE", (int) this.getIdLocalidade());
	doc.put("IDCIDADE", this.getIdCidade().toJson());
	doc.put("CODIGO", (int) this.getCodigo());
	doc.put("DESCRICAO", this.getDescricao());

	return doc.toString();
    }

    public static Localidade toObject(Document doc) {

	long idLocalidade = doc.getInteger("IDLOCALIDADE");
	Document db = (Document) doc.get("IDCIDADE");
	Cidade idCidade = Cidade.toObject(db);
	long codigo = doc.getInteger("CODIGO");
	String descricao = doc.getString("DESCRICAO");

	Localidade loc = new Localidade(idLocalidade, idCidade, codigo, descricao);

	return loc;
    }

    @Override
    public String toString() {
	return "Localidade [idLocalidade=" + idLocalidade + ", idCidade=" + idCidade + ", codigo=" + codigo + ", descricao=" + descricao + "]";
    }
}
