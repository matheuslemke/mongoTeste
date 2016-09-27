package mainquery.validators;

import org.bson.Document;

public class GrupoEmpresarialValidator implements Validator {

    private Document grupoEmpresarialDocument;

    public boolean isValid() {
	return grupoEmpresarialDocument.getInteger("IDGRUPOEMPRESARIAL") == 1;
    }

    public Document getGrupoEmpresarialDocument() {
	return grupoEmpresarialDocument;
    }

    public void setGrupoEmpresarialDocument(Document grupoEmpresarialDocument) {
	this.grupoEmpresarialDocument = grupoEmpresarialDocument;
    }

}
