package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class InformacaoComplementar extends BasicDBObject implements Serializable {

    private long idInformacaoComplementar;
    private Parceiro idParceiro;

    public InformacaoComplementar(long idInformacaoComplementar, Parceiro idParceiro) {
	this.idInformacaoComplementar = idInformacaoComplementar;
	this.idParceiro = idParceiro;
    }

    public long getIdInformacaoComplementar() {
	return idInformacaoComplementar;
    }

    public void setIdInformacaoComplementar(long idInformacaoComplementar) {
	this.idInformacaoComplementar = idInformacaoComplementar;
    }

    public Parceiro getIdParceiro() {
	return idParceiro;
    }

    public void setIdParceiro(Parceiro idParceiro) {
	this.idParceiro = idParceiro;
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();
	doc.put("IDINFORMACAOCOMPLEMENTAR", (int) this.getIdInformacaoComplementar());
	doc.put("IDPARCEIRO", this.getIdParceiro().toJson());

	return doc.toString();
    }

    public static InformacaoComplementar toObject(Document doc) {

	long idInformacaocomplementar = doc.getInteger("IDINFORMACAOCOMPLEMENTAR");
	Document db = (Document) doc.get("IDPARCEIRO");
	Parceiro idParceiro = Parceiro.toObject(db);

	InformacaoComplementar info = new InformacaoComplementar(idInformacaocomplementar, idParceiro);
	return info;
    }

    @Override
    public String toString() {
	return "InformacaoComplementar [idInformacaoComplementar=" + idInformacaoComplementar + ", idParceiro=" + idParceiro + "]";
    }

}