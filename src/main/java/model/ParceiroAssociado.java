package model;

import java.io.Serializable;
import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class ParceiroAssociado extends BasicDBObject implements Serializable {
    private long idParceiroAssociado;
    private long associado;
    private Date dataAdmissao;
    private Date dataDemissao;
    private Date dataPedidoDemissao;
    private long idEmpresa;
    private long idMotivoDesligamento;
    private Parceiro idParceiro;
    private long idTipoDemissao;
    private long numeroCotas;
    private long numeroMatricula;

    public ParceiroAssociado(long idParceiroAssociado, long associado, Date dataAdmissao, Date dataDemissao, Date dataPedidoDemissao, long idEmpresa, long idMotivoDesligamento, Parceiro idParceiro, long idTipoDemissao, long numeroCotas, long numeroMatricula) {

	this.idParceiroAssociado = idParceiroAssociado;
	this.associado = associado;
	this.dataAdmissao = dataAdmissao;
	this.dataDemissao = dataDemissao;
	this.dataPedidoDemissao = dataPedidoDemissao;
	this.idEmpresa = idEmpresa;
	this.idMotivoDesligamento = idMotivoDesligamento;
	this.idParceiro = idParceiro;
	this.idTipoDemissao = idTipoDemissao;
	this.numeroCotas = numeroCotas;
	this.numeroMatricula = numeroMatricula;
    }

    public long getIdParceiroAssociado() {
	return idParceiroAssociado;
    }

    public void setIdParceiroAssociado(long idParceiroAssociado) {
	this.idParceiroAssociado = idParceiroAssociado;
    }

    public long getAssociado() {
	return associado;
    }

    public void setAssociado(long associado) {
	this.associado = associado;
    }

    public Date getDataAdmissao() {
	return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
	this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
	return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
	this.dataDemissao = dataDemissao;
    }

    public Date getDataPedidoDemissao() {
	return dataPedidoDemissao;
    }

    public void setDataPedidoDemissao(Date dataPedidoDemissao) {
	this.dataPedidoDemissao = dataPedidoDemissao;
    }

    public long getIdEmpresa() {
	return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
	this.idEmpresa = idEmpresa;
    }

    public long getIdMotivoDesligamento() {
	return idMotivoDesligamento;
    }

    public void setIdMotivoDesligamento(long idMotivoDesligamento) {
	this.idMotivoDesligamento = idMotivoDesligamento;
    }

    public Parceiro getIdParceiro() {
	return idParceiro;
    }

    public void setIdParceiro(Parceiro idParceiro) {
	this.idParceiro = idParceiro;
    }

    public long getIdTipoDemissao() {
	return idTipoDemissao;
    }

    public void setIdTipoDemissao(long idTipoDemissao) {
	this.idTipoDemissao = idTipoDemissao;
    }

    public long getNumeroCotas() {
	return numeroCotas;
    }

    public void setNumeroCotas(long numeroCotas) {
	this.numeroCotas = numeroCotas;
    }

    public long getNumeroMatricula() {
	return numeroMatricula;
    }

    public void setNumeroMatricula(long numeroMatricula) {
	this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();

	doc.put("IDPARCEIROASSOCIADO", (int) this.getIdParceiroAssociado());
	doc.put("ASSOCIADO", (int) this.getAssociado());

	doc.put("DATAADMISSAO", this.getDataAdmissao());
	doc.put("DATADEMISSAO", this.getDataDemissao());
	doc.put("DATAPEDIDODEMISSAO", this.getDataPedidoDemissao());

	doc.put("IDEMPRESA", (int) this.getIdEmpresa());
	doc.put("IDMOTIVODESLIGAMENTO", (int) this.getIdMotivoDesligamento());
	doc.put("IDPARCEIRO", this.getIdParceiro().toJson());
	doc.put("IDTIPODEMISSAO", (int) this.getIdTipoDemissao());
	doc.put("NUMEROCOTAS", (int) this.getNumeroCotas());
	doc.put("NUMEROMATRICULA", (int) this.getNumeroMatricula());

	return doc.toString();

    }

    public ParceiroAssociado toObject(Document doc) {

	long idParceiroAssociado = doc.getInteger("IDPARCEIROASSOCIADO");
	long associado = doc.getInteger("ASSOCIADO");
	Date dataAdmissao = doc.getDate("DATAADMISSAO");
	Date dataDemissao = doc.getDate("DATADEMISSAO");
	Date dataPedidoDemissao = doc.getDate("DATAPEDIDODEMISSAO");
	long idEmpresa = doc.getInteger("IDEMPRESA");
	long idMotivoDesligamento = doc.getInteger("IDMOTIVODESLIGAMENTO");
	Document db = (Document) doc.get("IDPARCEIRO");
	Parceiro idParceiro = Parceiro.toObject(db);
	long idTipoDemissao = doc.getInteger("IDTIPODEMISSAO");
	long numeroCotas = doc.getInteger("NUMEROCOTAS");
	long numeroMatricula = doc.getInteger("NUMEROMATRICULA");

	ParceiroAssociado parceiroAssociado = new ParceiroAssociado(idParceiroAssociado, associado, dataAdmissao, dataDemissao, dataPedidoDemissao, idEmpresa, idMotivoDesligamento, idParceiro, idTipoDemissao, numeroCotas, numeroMatricula);

	return parceiroAssociado;
    }

}
