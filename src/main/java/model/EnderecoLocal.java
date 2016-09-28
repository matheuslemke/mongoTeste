package model;

import java.io.Serializable;
import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class EnderecoLocal extends BasicDBObject implements Serializable {
    private long idEnderecoLocal;
    private Date dataFim;
    private Date dataInicio;
    private Endereco idEndereco;
    private Local idLocal;

    public EnderecoLocal(long idEnderecoLocal, Date dataFim, Date dataInicio, Endereco idEndereco, Local idLocal) {
	this.idEnderecoLocal = idEnderecoLocal;
	this.dataFim = dataFim;
	this.dataInicio = dataInicio;
	this.idEndereco = idEndereco;
	this.idLocal = idLocal;
    }

    public long getIdEnderecoLocal() {
	return idEnderecoLocal;
    }

    public void setIdEnderecoLocal(long idEnderecoLocal) {
	this.idEnderecoLocal = idEnderecoLocal;
    }

    public Date getDataFim() {
	return dataFim;
    }

    public void setDataFim(Date dataFim) {
	this.dataFim = dataFim;
    }

    public Date getDataInicio() {
	return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
    }

    public Endereco getIdEndereco() {
	return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
	this.idEndereco = idEndereco;
    }

    public Local getIdLocal() {
	return idLocal;
    }

    public void setIdLocal(Local idLocal) {
	this.idLocal = idLocal;
    }

    @Override
    public String toString() {
	return "EnderecoLocal [idEnderecoLocal=" + idEnderecoLocal + ", dataFim=" + dataFim + ", dataInicio=" + dataInicio + ", idEndereco=" + idEndereco + ", idLocal=" + idLocal + "]";
    }

    public String toJson() {
	BasicDBObject doc = new BasicDBObject();

	doc.put("IDENDERECOLOCAL", (int) this.getIdEnderecoLocal());
	doc.put("DATAFIM", (Date) this.getDataFim());
	doc.put("DATAINICIO", this.getDataInicio());
	doc.put("IDENDERECO", this.getIdEndereco().toJson());
	doc.put("IDLOCAL", this.getIdLocal().toJson());

	return doc.toString();
    }

    public EnderecoLocal toObject(Document doc) {

	long idEnderecoLocal = doc.getInteger("IDENDERECOLOCAL");
	Date dataFim = doc.getDate("DATAFIM");
	Date dataInicio = doc.getDate("DATAINICIO");
	Document db = (Document) doc.get("IDENDERECO");
	Endereco idEndereco = Endereco.toObject(db);
	db = (Document) doc.get("IDLOCAL");
	Local idLocal = Local.toObject(db);

	EnderecoLocal enderecoLocal = new EnderecoLocal(idEnderecoLocal, dataFim, dataInicio, idEndereco, idLocal);

	return enderecoLocal;
    }

}
