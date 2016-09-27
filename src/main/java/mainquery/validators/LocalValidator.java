package mainquery.validators;

import org.bson.Document;

import names.LocalNames;

public class LocalValidator implements Validator {

    private Document localDocument;

    public boolean isValid() {
	return localDocument.getInteger(LocalNames.ATIVO) == 1;
    }

    public Document getLocalDocument() {
	return localDocument;
    }

    public void setLocalDocument(Document localDocument) {
	this.localDocument = localDocument;
    }

}
