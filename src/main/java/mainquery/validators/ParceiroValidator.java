package mainquery.validators;

import org.bson.Document;

import names.ParceiroNames;

public class ParceiroValidator implements Validator {

    private Document parceiroDocument;

    public boolean isValid() {
	return parceiroDocument.getInteger(ParceiroNames.ATIVO) == 1;
    }

    public Document getParceiroDocument() {
	return parceiroDocument;
    }

    public void setParceiroDocument(Document parceiroDocument) {
	this.parceiroDocument = parceiroDocument;
    }

}
