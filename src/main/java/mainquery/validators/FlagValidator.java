package mainquery.validators;

import org.bson.Document;

import names.FlagNames;

public class FlagValidator {

    private Document flagDocument;

    public boolean isPessoaJuridica() {
	return flagDocument.getInteger(FlagNames.IDFLAG) == 174;
    }

}
