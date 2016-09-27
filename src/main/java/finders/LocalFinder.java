package finders;

import org.bson.Document;

import names.EnderecoLocalNames;

public class LocalFinder {

    public Document findFromEnderecoLocal(Document enderecoLocalDocument) {
	return (Document) enderecoLocalDocument.get(EnderecoLocalNames.LOCAL);
    }
}
