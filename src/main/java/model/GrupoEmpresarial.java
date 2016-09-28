package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class GrupoEmpresarial extends BasicDBObject implements Serializable {

    private long idgrupoempresarial;
    private long codigo;
    private String descricao;
    private long idadministrador;

    public GrupoEmpresarial(long idGrupoEmpresarial, long codigo, String descricao, long idAdministrador) {
	this.idgrupoempresarial = idGrupoEmpresarial;
	this.codigo = codigo;
	this.descricao = descricao;
	this.idadministrador = idAdministrador;
    }

    public GrupoEmpresarial() {
	// TODO Auto-generated constructor stub
    }

    public long getIdGrupoEmpresarial() {
	return idgrupoempresarial;
    }

    public void setIdGrupoEmpresarial(long idGrupoEmpresarial) {
	this.idgrupoempresarial = idGrupoEmpresarial;
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

    public long getIdAdministrador() {
	return idadministrador;
    }

    @Override
    public String toString() {
	return "GrupoEmpresarial [idgrupoempresarial=" + idgrupoempresarial + ", codigo=" + codigo + ", descricao=" + descricao + ", idadministrador=" + idadministrador + "]";
    }

    public void setIdAdministrador(long idAdministrador) {
	this.idadministrador = idAdministrador;
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();
	doc.put("IDGRUPOEMPRESARIAL", (int) this.getIdGrupoEmpresarial());
	doc.put("IDADMINISTRADOR", (int) this.getIdAdministrador());
	doc.put("CODIGO", (int) this.getCodigo());
	doc.put("DESCRICAO", this.getDescricao());
	return doc.toString();

    }

    public static GrupoEmpresarial toObject(Document doc) {

	long idGrupoEmpresarial = doc.getInteger("IDGRUPOEMPRESARIAL");
	long idAdministrador = doc.getInteger("IDADMINISTRADOR");
	long cod = doc.getInteger("CODIGO");
	String desc = doc.getString("DESCRICAO");

	GrupoEmpresarial grupo = new GrupoEmpresarial(idGrupoEmpresarial, cod, desc, idAdministrador);
	return grupo;
    }

}
