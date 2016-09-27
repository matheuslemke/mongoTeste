package finders;

import org.bson.Document;

import names.LocalNames;

public class ParceiroFinder {
    public Document findFromLocal(Document LocalDocument) {
	return (Document) LocalDocument.get(LocalNames.PARCEIRO);
    }
}
