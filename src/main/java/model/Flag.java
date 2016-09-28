package model;

import java.io.Serializable;

import org.bson.Document;

import com.mongodb.BasicDBObject;

@SuppressWarnings("serial")
public class Flag extends BasicDBObject implements Serializable {

    private long idFlag;
    private String descricao;
    private String entityName;
    private String atributeName;

    public Flag(long idFlag, String descricao, String entityName, String atributeName) {
	this.idFlag = idFlag;
	this.descricao = descricao;
	this.entityName = entityName;
	this.atributeName = atributeName;
    }

    public long getIdFlag() {
	return idFlag;
    }

    public void setIdFlag(long idFlag) {
	this.idFlag = idFlag;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getEntityName() {
	return entityName;
    }

    public void setEntityName(String entityName) {
	this.entityName = entityName;
    }

    public String getAtributeName() {
	return atributeName;
    }

    public void setAtributeName(String atributeName) {
	this.atributeName = atributeName;
    }

    @Override
    public String toString() {
	return "Flag [idFlag=" + idFlag + ", descricao=" + descricao + ", entityName=" + entityName + ", atributeName=" + atributeName + "]";
    }

    public String toJson() {
	BasicDBObject doc = new BasicDBObject();

	doc.put("IDFLAG", (int) this.getIdFlag());
	doc.put("DESCRICAO", this.getDescricao());
	doc.put("ENTITYNAME", this.getEntityName());
	doc.put("ATRIBUTENAME", this.getAtributeName());

	return doc.toString();

    }

    public static Flag toObject(Document doc) {

	long idFlag = doc.getInteger("IDFLAG");
	String descricao = doc.getString("DESCRICAO");
	String entityName = doc.getString("ENTITYNAME");
	String atributeName = doc.getString("ATRIBUTENAME");

	Flag flag = new Flag(idFlag, descricao, entityName, atributeName);

	return flag;
    }

}
