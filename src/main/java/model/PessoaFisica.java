package model;

import java.io.Serializable;
import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class PessoaFisica extends BasicDBObject implements Serializable {
    private InformacaoComplementar idInformacaoComplementar;
    private String celular;
    private String contaCorrenteFunRural;
    private String cpf;

    private Date dataAdmissaoTrabalho;
    private Date dataExpedicao;
    private Date dataNascimento;

    private long empregador;
    private String foneTrabalho;
    private long idCargo;
    private long idCidadeNascimento;
    private long idEstadoCivil;

    public PessoaFisica(InformacaoComplementar idInformacaoComplementar, String celular, String contaCorrenteFunRural, String cpf, Date dataAdmissaoTrabalho, Date dataExpedicao, Date dataNascimento, long empregador, String foneTrabalho, long idCargo, long idCidadeNascimento, long idEstadoCivil) {

	this.idInformacaoComplementar = idInformacaoComplementar;
	this.celular = celular;
	this.contaCorrenteFunRural = contaCorrenteFunRural;
	this.cpf = cpf;
	this.dataAdmissaoTrabalho = dataAdmissaoTrabalho;
	this.dataExpedicao = dataExpedicao;
	this.dataNascimento = dataNascimento;
	this.empregador = empregador;
	this.foneTrabalho = foneTrabalho;
	this.idCargo = idCargo;
	this.idCidadeNascimento = idCidadeNascimento;
	this.idEstadoCivil = idEstadoCivil;
    }

    public InformacaoComplementar getIdInformacaoComplementar() {
	return idInformacaoComplementar;
    }

    public void setIdInformacaoComplementar(InformacaoComplementar idInformacaoComplementar) {
	this.idInformacaoComplementar = idInformacaoComplementar;
    }

    public String getCelular() {
	return celular;
    }

    public void setCelular(String celular) {
	this.celular = celular;
    }

    public String getContaCorrenteFunRural() {
	return contaCorrenteFunRural;
    }

    public void setContaCorrenteFunRural(String contaCorrenteFunRural) {
	this.contaCorrenteFunRural = contaCorrenteFunRural;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
    }

    public Date getDataAdmissaoTrabalho() {
	return dataAdmissaoTrabalho;
    }

    public void setDataAdmissaoTrabalho(Date dataAdmissaoTrabalho) {
	this.dataAdmissaoTrabalho = dataAdmissaoTrabalho;
    }

    public Date getDataExpedicao() {
	return dataExpedicao;
    }

    public void setDataExpedicao(Date dataExpedicao) {
	this.dataExpedicao = dataExpedicao;
    }

    public Date getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public long getEmpregador() {
	return empregador;
    }

    public void setEmpregador(long empregador) {
	this.empregador = empregador;
    }

    public String getFoneTrabalho() {
	return foneTrabalho;
    }

    public void setFoneTrabalho(String foneTrabalho) {
	this.foneTrabalho = foneTrabalho;
    }

    public long getIdCargo() {
	return idCargo;
    }

    public void setIdCargo(long idCargo) {
	this.idCargo = idCargo;
    }

    public long getIdCidadeNascimento() {
	return idCidadeNascimento;
    }

    public void setIdCidadeNascimento(long idCidadeNascimento) {
	this.idCidadeNascimento = idCidadeNascimento;
    }

    public long getIdEstadoCivil() {
	return idEstadoCivil;
    }

    public void setIdEstadoCivil(long idEstadoCivil) {
	this.idEstadoCivil = idEstadoCivil;
    }

    @Override
    public String toString() {
	return "PessoaFisica [idInformacaoComplementar=" + idInformacaoComplementar + ", celular=" + celular + ", contaCorrenteFunRural=" + contaCorrenteFunRural + ", cpf=" + cpf + ", dataAdmissaoTrabalho=" + dataAdmissaoTrabalho + ", dataExpedicao=" + dataExpedicao + ", dataNascimento=" + dataNascimento + ", empregador=" + empregador + ", foneTrabalho=" + foneTrabalho + ", idCargo=" + idCargo + ", idCidadeNascimento=" + idCidadeNascimento + ", idEstadoCivil=" + idEstadoCivil + "]";
    }

    @Override
    public String toJson() {

	BasicDBObject doc = new BasicDBObject();
	doc.put("IDINFORMACAOCOMPLEMENTAR", this.getIdInformacaoComplementar().toJson());
	doc.put("CELULAR", this.getCelular());
	doc.put("CONTACORRENTEFUNRURAL", this.getContaCorrenteFunRural());
	doc.put("CPF", this.getCpf());
	doc.put("DATAADMISSAOTRABALHO", this.getDataAdmissaoTrabalho());
	doc.put("DATAEXPEDICAO", this.getDataExpedicao());
	doc.put("DATANASCIMENTO", this.getDataNascimento());
	doc.put("EMPREGADOR", (int) this.getEmpregador());
	doc.put("FONETRABALHO", this.getFoneTrabalho());
	doc.put("IDCARGO", (int) this.getIdCargo());
	doc.put("IDCIDADENASCIMENTO", (int) this.getIdCidadeNascimento());
	doc.put("IDESTADOCIVIL", (int) this.getIdEstadoCivil());

	return doc.toString();

    }

    public PessoaFisica toObject(Document doc) {

	Document db = (Document) doc.get("IDINFORMACAOCOMPLEMENTAR");
	InformacaoComplementar idInformacaoComplementar = InformacaoComplementar.toObject(db);
	String celular = doc.getString("CELULAR");
	String contaCorrenteFunRural = doc.getString("CONTACORRENTEFUNRURAL");
	String cpf = doc.getString("CPF");

	Date dataAdmissaoTrabalho = doc.getDate("DATAADMISSAOTRABALHO");
	Date dataExpedicao = doc.getDate("DATAEXPEDICAO");
	Date dataNascimento = doc.getDate("DATANASCIMENTO");

	long empregador = doc.getInteger("EMPREGADOR");
	String foneTrabalho = doc.getString("FONETRABALHO");
	long idCargo = doc.getInteger("IDCARGO");
	long idCidadeNascimento = doc.getInteger("IDCIDADENASCIMENTO");
	long idEstadoCivil = doc.getInteger("IDESTADOCIVIL");

	PessoaFisica parceiroAssociado = new PessoaFisica(idInformacaoComplementar, celular, contaCorrenteFunRural, cpf, dataAdmissaoTrabalho, dataExpedicao, dataNascimento, empregador, foneTrabalho, idCargo, idCidadeNascimento, idEstadoCivil);

	return parceiroAssociado;
    }

}
