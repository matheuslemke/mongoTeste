package mainquery.validators;

import java.util.Date;
import org.bson.Document;

import names.EnderecoLocalNames;
import util.DateParser;

public class EnderecoLocalValidator implements Validator {

    private Document enderecoLocalDocument;

    public boolean isValid() {
	Date enderecoLocalDataInicio = DateParser
		.toUniversalFormat(enderecoLocalDocument.getString(EnderecoLocalNames.DATAINICIO));
	String enderecoLocalDataFimStr = enderecoLocalDocument.getString(EnderecoLocalNames.DATAFIM);
	Date enderecoLocalDataFim = enderecoLocalDataFimStr.isEmpty() ? null
		: DateParser.toUniversalFormat(enderecoLocalDataFimStr);
	Date today = new Date();
	if (enderecoLocalDataInicio.before(today)
		&& (enderecoLocalDataFim == null || enderecoLocalDataFim.after(today)))
	    return true;
	return false;
    }

    public Document getEnderecoLocalDocument() {
	return enderecoLocalDocument;
    }

    public void setEnderecoLocalDocument(Document enderecoLocalDocument) {
	this.enderecoLocalDocument = enderecoLocalDocument;
    }

}
