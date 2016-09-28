package mongo.mainquery;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import mongo.names.*;
import util.DateParser;

public class EnderecoLocalFilter implements Filter {
    private FindIterable<Document> documents;

    public void setDocuments(FindIterable<Document> documents) {
	this.documents = documents;
    }

    public List<Document> filtrate() {
	List<Document> filteredList = new LinkedList<Document>();
	for (Document enderecoLocalDocument : documents) {
	    Date enderecoLocalDataInicio = DateParser
		    .toUniversalFormat(enderecoLocalDocument.getString(EnderecoLocalNames.DATAINICIO));
	    String enderecoLocalDataFimStr = enderecoLocalDocument.getString(EnderecoLocalNames.DATAFIM);
	    Date enderecoLocalDataFim = enderecoLocalDataFimStr.isEmpty() ? null
		    : DateParser.toUniversalFormat(enderecoLocalDataFimStr);
	    Date today = new Date();
	    if (enderecoLocalDataInicio.before(today)
		    && (enderecoLocalDataFim == null || enderecoLocalDataFim.after(today)))
		filteredList.add(enderecoLocalDocument);
	}
	return filteredList;
    }
}
