package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Pais extends BasicDBObject implements Serializable {
    private long idPais;
    private String codigoAnp;
    private long codigoSiscomex;
    private String descricao;
    private GrupoEmpresarial idGrupoEmpresarial;
    private String nacionalidade;
    private String sigla;

    public Pais(long idPais, String codigoAnp, long codigoSiscomex, String descricao, GrupoEmpresarial idGrupoEmpresarial, String nacionalidade, String sigla) {
	this.idPais = idPais;
	this.codigoAnp = codigoAnp;
	this.codigoSiscomex = codigoSiscomex;
	this.descricao = descricao;
	this.idGrupoEmpresarial = idGrupoEmpresarial;
	this.nacionalidade = nacionalidade;
	this.sigla = sigla;
    }

    public long getIdPais() {
	return idPais;
    }

    public void setIdPais(long idPais) {
	this.idPais = idPais;
    }

    public String getCodigoAnp() {
	return codigoAnp;
    }

    public void setCodigoAnp(String codigoAnp) {
	this.codigoAnp = codigoAnp;
    }

    public long getCodigoSiscomex() {
	return codigoSiscomex;
    }

    public void setCodigoSiscomex(long codigoSiscomex) {
	this.codigoSiscomex = codigoSiscomex;
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

    public String getNacionalidade() {
	return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
	this.nacionalidade = nacionalidade;
    }

    public String getSigla() {
	return sigla;
    }

    public void setSigla(String sigla) {
	this.sigla = sigla;
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();

	doc.put("IDPAIS", (int) this.getIdPais());
	doc.put("CODIGOANP", this.getCodigoAnp());
	doc.put("CODIGOSISCOMEX", this.getCodigoSiscomex());
	doc.put("DESCRICAO", this.getDescricao());
	doc.put("IDGRUPOEMPRESARIAL", this.getIdGrupoEmpresarial().toJson());
	doc.put("NACIONALIDADE", this.getNacionalidade());
	doc.put("SIGLA", this.getSigla());

	return doc.toString();
    }

    public static Pais toObject(Document doc) {

	long idPais = doc.getInteger("IDPAIS");
	String codigoAnp = doc.getString("CODIGOANP");
	long codigoSiscomex = doc.getInteger("CODIGOSISCOMEX");
	String descricao = doc.getString("DESCRICAO");
	Document db = (Document) doc.get("IDGRUPOEMPRESARIAL");
	GrupoEmpresarial idGrupoEmpresarial = GrupoEmpresarial.toObject(db);
	String nacionalidade = doc.getString("NACIONALIDADE");
	String sigla = doc.getString("SIGLA");

	Pais p = new Pais(idPais, codigoAnp, codigoSiscomex, descricao, idGrupoEmpresarial, nacionalidade, sigla);

	return p;
    }

    @Override
    public String toString() {
	return "Pais [idPais=" + idPais + ", codigoAnp=" + codigoAnp + ", codigoSiscomex=" + codigoSiscomex + ", descricao=" + descricao + ", idGrupoEmpresarial=" + idGrupoEmpresarial + ", nacionalidade=" + nacionalidade + ", sigla=" + sigla + "]";
    }

}
