package com.nosql.mongoteste;

import org.bson.Document;
import dao.Connector;
import dao.Finder;
import exceptions.InvalidDocumentException;
import mainquery.validators.EnderecoLocalValidator;
import mainquery.validators.FlagValidator;
import mainquery.validators.GrupoEmpresarialValidator;
import mainquery.validators.LocalValidator;
import mainquery.validators.ParceiroValidator;
import names.EnderecoLocalNames;
import names.LocalNames;
import names.ParceiroNames;

public class MainQuery {

    private Connector connector;

    public MainQuery(Connector connector) {
	super();
	this.connector = connector;
    }

    public void mainQuery() throws InvalidDocumentException {
	Finder finder = new Finder(connector);

	EnderecoLocalValidator enderecoLocalValidator = new EnderecoLocalValidator();
	LocalValidator localValidator = new LocalValidator();
	ParceiroValidator parceiroValidator = new ParceiroValidator();
	GrupoEmpresarialValidator grupoEmpresarialValidator = new GrupoEmpresarialValidator();
	FlagValidator flagValidator = new FlagValidator();

	for (Document enderecoLocalDocument : finder.findAll(EnderecoLocalNames.ENDERECOLOCAL)) {
	    // Validate EnderecoLocal dates
	    enderecoLocalValidator.setEnderecoLocalDocument(enderecoLocalDocument);
	    if (!enderecoLocalValidator.isValid())
		throw new InvalidDocumentException();

	    Document localDocument = finder.findFrom(enderecoLocalDocument, EnderecoLocalNames.LOCAL);
	    localValidator.setLocalDocument(localDocument);
	    if (!localValidator.isValid())
		throw new InvalidDocumentException();

	    Document parceiroDocument = finder.findFrom(localDocument, LocalNames.PARCEIRO);
	    parceiroValidator.setParceiroDocument(parceiroDocument);
	    if (!parceiroValidator.isValid())
		throw new InvalidDocumentException();

	    Document grupoEmpresarialDocument = finder.findFrom(parceiroDocument, ParceiroNames.GRUPOEMPRESARIAL);
	    grupoEmpresarialValidator.setGrupoEmpresarialDocument(grupoEmpresarialDocument);
	    if (!grupoEmpresarialValidator.isValid())
		throw new InvalidDocumentException();

	    Document flagDocument = finder.findFrom(parceiroDocument, ParceiroNames.FLAG);
	    if (flagValidator.isPessoaJuridica())
		;
	    else {
		// ENCONTRAR A INFOCOMPLEMENTAR TAL QUE O IDPARTCEIRO SEJA IGUAL
		// AO PARCEIRO ATUAL
	    }

	}
    }
}
