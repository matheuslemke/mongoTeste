package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class TipoLogradouro extends BasicDBObject implements Serializable {
    private long idTipoLogradouro;
    private long codigo;
    private String descricao;
    private GrupoEmpresarial idGrupoEmpresarial;

    public TipoLogradouro(long idTipoLogradouro, long codigo, String descricao, GrupoEmpresarial idGrupoEmpresarial) {

	this.idTipoLogradouro = idTipoLogradouro;
	this.codigo = codigo;
	this.descricao = descricao;
	this.idGrupoEmpresarial = idGrupoEmpresarial;
    }

    public long getIdTipoLogradouro() {
	return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(long idTipoLogradouro) {
	this.idTipoLogradouro = idTipoLogradouro;
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

    public GrupoEmpresarial getIdGrupoEmpresarial() {
	return idGrupoEmpresarial;
    }

    public void setIdGrupoEmpresarial(GrupoEmpresarial idGrupoEmpresarial) {
	this.idGrupoEmpresarial = idGrupoEmpresarial;
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();

	doc.put("IDTIPOLOGRADOURO", (int) this.getIdTipoLogradouro());
	doc.put("CODIGO", (int) this.getCodigo());
	doc.put("DESCRICAO", this.getDescricao());
	doc.put("IDGRUPOEMPRESARIAL", this.getIdGrupoEmpresarial().toJson());

	return doc.toString();

    }

    public static TipoLogradouro toObject(Document doc) {

	long idTipoLogradouro = doc.getInteger("IDTIPOLOGRADOURO");
	long codigo = doc.getInteger("CODIGO");
	String descricao = doc.getString("DESCRICAO");
	Document db = (Document) doc.get("IDGRUPOEMPRESARIAL");
	GrupoEmpresarial idGrupoEmpresarial = GrupoEmpresarial.toObject(db);

	TipoLogradouro tipolog = new TipoLogradouro(idTipoLogradouro, codigo, descricao, idGrupoEmpresarial);

	return tipolog;
    }

    @Override
    public String toString() {
	return "TipoLogradouro [idTipoLogradouro=" + idTipoLogradouro + ", codigo=" + codigo + ", descricao=" + descricao + ", idGrupoEmpresarial=" + idGrupoEmpresarial + "]";
    }

}
