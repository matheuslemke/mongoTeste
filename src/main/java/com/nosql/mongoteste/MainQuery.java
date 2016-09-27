package com.nosql.mongoteste;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;

import dao.Connector;
import exceptions.InvalidDocumentException;
import finders.EnderecoLocalFinder;
import finders.LocalFinder;
import finders.ParceiroFinder;
import mainquery.validators.EnderecoLocalValidator;
import mainquery.validators.LocalValidator;

public class MainQuery {

    private Connector connector;

    public MainQuery(Connector connector) {
	super();
	this.connector = connector;
    }

    public void mainQuery() throws InvalidDocumentException {
	MongoDatabase db = connector.getDb();

	// Get all the EnderecoLocal
	EnderecoLocalValidator enderecoLocalValidator = new EnderecoLocalValidator();
	EnderecoLocalFinder enderecoLocalFinder = new EnderecoLocalFinder(connector);
	LocalFinder localFinder = new LocalFinder();
	LocalValidator localValidator = new LocalValidator();
	ParceiroFinder parceiroFinder = new ParceiroFinder();
	
	for (Document enderecoLocalDocument : enderecoLocalFinder.findAll()) {
	    // Validate EnderecoLocal dates
	    enderecoLocalValidator.setEnderecoLocalDocument(enderecoLocalDocument);
	    if (!enderecoLocalValidator.isValid())
		throw new InvalidDocumentException();

	    Document localDocument = localFinder.findFromEnderecoLocal(enderecoLocalDocument);
	    localValidator.setLocalDocument(localDocument);
	    if (!localValidator.isValid())
		throw new InvalidDocumentException();

	    Document parceiroDocument = parceiroFinder.findFromLocal(localDocument);
	    
	}
    }
}
