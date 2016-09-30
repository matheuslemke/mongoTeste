package mongo.mainquery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.bson.Document;

import util.Parser;
import mongo.dao.Connector;
import mongo.exceptions.DocumentNotFoundException;
import mongo.names.*;
import mongo.query.DocumentFinder;
import mongo.query.MongoQuerier;
import mongo.query.MongoQueryResult;

public class MainQuery implements MongoQuerier {

	private Connector connector;
	private Document enderecoLocalDocument;
	private Document localDocument;
	private Document parceiroDocument;
	private Document grupoEmpresarialDocument;
	private Document flagDocument;
	private Document infoComplementarDocument;
	private Document pessoaFisicaDocument;
	private Document parceiroAssociadoDocument;
	private Document enderecoDocument;
	private Document logradouroDocument;
	private Document tipoLogradouroDocument;
	private Document localidadeDocument;
	private Document cidadeDocument;
	private Document unidadeFederativaDocument;
	private Document paisDocument;
	private boolean isPessoaJuridica;

	public MainQuery(Connector connector) {
		super();
		this.connector = connector;
	}

	public MongoQueryResult query() {
		DocumentFinder finder = new DocumentFinder(connector);
		MongoQueryResult result = new MongoQueryResult(MainQueryConstants.fields);
		for (Document enderecoLocalDocument : finder.findAll(EnderecoLocalNames.COLLECTION, new EnderecoLocalFilter())) {
			isPessoaJuridica = false;
			this.enderecoLocalDocument = enderecoLocalDocument;
			try {
				localDocument = finder.getOneByForeign(enderecoLocalDocument, EnderecoLocalNames.LOCAL, LocalNames.ATIVO, 1);
				parceiroDocument = finder.getOneByForeign(localDocument, LocalNames.PARCEIRO, ParceiroNames.ATIVO, 1);
				grupoEmpresarialDocument = finder.getOneByForeign(parceiroDocument, ParceiroNames.GRUPOEMPRESARIAL, GrupoEmpresarialNames.ID, 1);
				flagDocument = finder.getOneByForeign(parceiroDocument, ParceiroNames.FLAG);
				if (flagDocument.getInteger(FlagNames.IDFLAG) == 174)
					isPessoaJuridica = true;
				else {
					infoComplementarDocument = finder.findOneByForeign(InformacaoComplementarNames.COLLECTION, InformacaoComplementarNames.PARCEIRO, parceiroDocument.getInteger(ParceiroNames.ID));
					pessoaFisicaDocument = finder.findOneByForeign(PessoaFisicaNames.COLLECTION, PessoaFisicaNames.INFORMACAOCOMPLEMENTAR, infoComplementarDocument.getInteger(InformacaoComplementarNames.ID));
					parceiroAssociadoDocument = finder.findOneByForeign(ParceiroAssociadoNames.COLLECTION, ParceiroAssociadoNames.PARCEIRO, parceiroDocument.getInteger(ParceiroNames.ID), ParceiroAssociadoNames.ATIVO, 1);
				}
				enderecoDocument = finder.getOneByForeign(enderecoLocalDocument, EnderecoLocalNames.ENDERECO);
				logradouroDocument = finder.getOneByForeign(enderecoDocument, EnderecoNames.LOGRADOURO);
				tipoLogradouroDocument = finder.getOneByForeign(logradouroDocument, LogradouroNames.TIPOLOGRADOURO);
				localidadeDocument = finder.getOneByForeign(enderecoDocument, EnderecoNames.LOCALIDADE);
				cidadeDocument = finder.getOneByForeign(localidadeDocument, LocalidadeNames.CIDADE);
				unidadeFederativaDocument = finder.getOneByForeign(cidadeDocument, CidadeNames.UNIDADEFEDERATIVA);
				paisDocument = finder.getOneByForeign(unidadeFederativaDocument, UnidadeFederativaNames.PAIS);

				defineRow(result);
			} catch (DocumentNotFoundException e) {
				e.printStackTrace();
			} catch (ClassCastException e2) {

			}
		}
		return result;
	}

	public void defineRow(MongoQueryResult result) {
		ArrayList<Object> values = new ArrayList<Object>(MainQueryConstants.fields.length);
		values.add(parceiroDocument.getInteger(ParceiroNames.ID));
		values.add(parceiroDocument.getString(ParceiroNames.NOME));
		values.add(parceiroDocument.getInteger(ParceiroNames.CODIGO));
		values.add(parceiroDocument.getInteger(ParceiroNames.FLAG));
		values.add(localDocument.getInteger(LocalNames.ID));
		values.add(localDocument.getInteger(LocalNames.CODIGO));
		values.add(localDocument.getString(LocalNames.DESCRICAO));
		values.add(cidadeDocument.getInteger(CidadeNames.ID));
		values.add(cidadeDocument.getString(CidadeNames.DESCRICAO));
		values.add(unidadeFederativaDocument.getInteger(UnidadeFederativaNames.ID));
		values.add(unidadeFederativaDocument.getString(UnidadeFederativaNames.SIGLA));
		values.add(paisDocument.getInteger(PaisNames.ID));
		values.add(paisDocument.getString(PaisNames.SIGLA));
		values.add(tipoLogradouroDocument.getString(TipoLogradouroNames.DESCRICAO));
		values.add(logradouroDocument.getString(LogradouroNames.DESCRICAO));
		values.add(enderecoDocument.getString(EnderecoNames.NUMERO));
		values.add(localidadeDocument.getString(LocalidadeNames.DESCRICAO));
		values.add(parceiroDocument.getInteger(ParceiroNames.FLAG));
		result.getValues().add(values);
	}

	public List<Document> query(String text) {
		Document regQuery = new Document();
		regQuery.append("$regex", "^(?)" + Pattern.quote(text));
		regQuery.append("$options", "i");

		Document findQuery = new Document();
		findQuery.append("DESCRICAO", regQuery);
		return Parser.toList(connector.getDb().getCollection("cidade.IDUNIDADEFEDERATIVA").find(findQuery));
	}
}
