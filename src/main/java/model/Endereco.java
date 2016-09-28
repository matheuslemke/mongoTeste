package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Endereco extends BasicDBObject implements Serializable {
    private long idEndereco;
    private String caixaPostal;
    private long cep;

    private String complemento;
    private Localidade idLocalidade;
    private Logradouro idLogradouro;
    private int numero;

    public Endereco(long idEndereco, String caixaPostal, long cep, String complemento, Localidade idLocalidade, Logradouro idLogradouro, int numero) {
	this.idEndereco = idEndereco;
	this.caixaPostal = caixaPostal;
	this.cep = cep;
	this.complemento = complemento;
	this.idLocalidade = idLocalidade;
	this.idLogradouro = idLogradouro;
	this.numero = numero;
    }

    public long getIdEndereco() {
	return idEndereco;
    }

    public void setIdEndereco(long idEndereco) {
	this.idEndereco = idEndereco;
    }

    public String getCaixaPostal() {
	return caixaPostal;
    }

    public void setCaixaPostal(String caixaPostal) {
	this.caixaPostal = caixaPostal;
    }

    public long getCep() {
	return cep;
    }

    public void setCep(long cep) {
	this.cep = cep;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }

    public Localidade getIdLocalidade() {
	return idLocalidade;
    }

    public void setIdLocalidade(Localidade idLocalidade) {
	this.idLocalidade = idLocalidade;
    }

    public Logradouro getIdLogradouro() {
	return idLogradouro;
    }

    public void setIdLogradouro(Logradouro idLogradouro) {
	this.idLogradouro = idLogradouro;
    }

    public int getNumero() {
	return numero;
    }

    public void setNumero(int numero) {
	this.numero = numero;
    }

    public String toJson() {

	BasicDBObject doc = new BasicDBObject();
	doc.put("IDENDERECO", (int) this.getIdEndereco());
	doc.put("CAIXAPOSTAL", this.getCaixaPostal());
	doc.put("CEP", this.getCep());
	doc.put("COMPLEMENTO", this.getComplemento());
	doc.put("IDLOCALIODADE", this.getIdLocalidade().toJson());
	doc.put("IDLOGRADOURO", this.getIdLogradouro().toJson());
	doc.put("NUMERO", this.getNumero());

	return doc.toString();

    }

    public static Endereco toObject(Document doc) {

	long idEndereco = doc.getInteger("IDENDERECO");
	String caixaPostal = doc.getString("CAIXAPOSTAL");
	long cep = doc.getInteger("CEP");
	String complemento = doc.getString("COMPLEMENTO");
	Document db = (Document) doc.get("IDLOCALIDADE");
	Localidade idLocalidade = Localidade.toObject(db);
	db = (Document) doc.get("IDLOGRADOURO");
	Logradouro idLogradouro = Logradouro.toObject(db);
	int numero = doc.getInteger("NUMERO");

	Endereco endereco = new Endereco(idEndereco, caixaPostal, cep, complemento, idLocalidade, idLogradouro, numero);
	return endereco;
    }

    @Override
    public String toString() {
	return "Endereco [idEndereco=" + idEndereco + ", caixaPostal=" + caixaPostal + ", cep=" + cep + ", complemento=" + complemento + ", idLocalidade=" + idLocalidade + ", idLogradouro=" + idLogradouro + ", numero=" + numero + "]";
    }
}