package mongo.mainquery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.Function;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import util.Parser;
import mongo.dao.Connector;
import mongo.exceptions.DocumentNotFoundException;
import mongo.names.*;
import mongo.query.DocumentFinder;
import mongo.query.MongoQuerier;
import mongo.query.MongoNestedFilder;
import mongo.query.MongoQueryResult;

public class MainQuery {

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

	public MongoQueryResult queryInsideDocsWithoutFilter() {
		int i = 0;
		DocumentFinder finder = new DocumentFinder(connector);
		MongoQueryResult result = new MongoQueryResult(MainQueryConstants.fields);
		System.out.println("Encontrar ELs");
		for (Document enderecoLocalDocument : finder
				.findAll(EnderecoLocalNames.COLLECTION)) {// , new
															// EnderecoLocalFilter()))
															// {
			System.out.println(++i);

			isPessoaJuridica = false;
			this.enderecoLocalDocument = enderecoLocalDocument;
			try {
				localDocument = finder.getOneByForeign(enderecoLocalDocument,
						EnderecoLocalNames.LOCAL, LocalNames.ATIVO, 1);
				parceiroDocument = finder.getOneByForeign(localDocument,
						LocalNames.PARCEIRO, ParceiroNames.ATIVO, 1);
				grupoEmpresarialDocument = finder.getOneByForeign(parceiroDocument,
						ParceiroNames.GRUPOEMPRESARIAL, GrupoEmpresarialNames.ID, 1);
				flagDocument = finder.getOneByForeign(parceiroDocument,
						ParceiroNames.FLAG);
				if (flagDocument.getInteger(FlagNames.IDFLAG) == 174)
					isPessoaJuridica = true;
				else {
					infoComplementarDocument = finder.findOneByForeign(
							InformacaoComplementarNames.COLLECTION,
							InformacaoComplementarNames.PARCEIRO,
							parceiroDocument.getInteger(ParceiroNames.ID));
					pessoaFisicaDocument = finder.findOneByForeign(
							PessoaFisicaNames.COLLECTION,
							PessoaFisicaNames.INFORMACAOCOMPLEMENTAR,
							infoComplementarDocument
									.getInteger(InformacaoComplementarNames.ID));
					parceiroAssociadoDocument = finder.findOneByForeign(
							ParceiroAssociadoNames.COLLECTION,
							ParceiroAssociadoNames.PARCEIRO,
							parceiroDocument.getInteger(ParceiroNames.ID),
							ParceiroAssociadoNames.ATIVO, 1);
				}
				enderecoDocument = finder.getOneByForeign(enderecoLocalDocument,
						EnderecoLocalNames.ENDERECO);
				logradouroDocument = finder.getOneByForeign(enderecoDocument,
						EnderecoNames.LOGRADOURO);
				tipoLogradouroDocument = finder.getOneByForeign(logradouroDocument,
						LogradouroNames.TIPOLOGRADOURO);
				localidadeDocument = finder.getOneByForeign(enderecoDocument,
						EnderecoNames.LOCALIDADE);
				cidadeDocument = finder.getOneByForeign(localidadeDocument,
						LocalidadeNames.CIDADE);
				unidadeFederativaDocument = finder.getOneByForeign(cidadeDocument,
						CidadeNames.UNIDADEFEDERATIVA);
				paisDocument = finder.getOneByForeign(unidadeFederativaDocument,
						UnidadeFederativaNames.PAIS);

				defineRow(result);
			} catch (DocumentNotFoundException e) {
				e.printStackTrace();
			} catch (ClassCastException e2) {

			}
		}
		return result;
	}

	public void defineRow(MongoQueryResult result) {
		ArrayList<Object> values = new ArrayList<Object>(
				MainQueryConstants.fields.length);
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

	public MongoQueryResult queryInsideDocsWithFilter() {
		int i = 0;
		DocumentFinder finder = new DocumentFinder(connector);
		MongoQueryResult result = new MongoQueryResult(MainQueryConstants.fields);
		System.out.println("Encontrar ELs");
		for (Document enderecoLocalDocument : finder.findAll(
				EnderecoLocalNames.COLLECTION, new EnderecoLocalFilter())) {
			System.out.println(++i);

			isPessoaJuridica = false;
			this.enderecoLocalDocument = enderecoLocalDocument;
			try {
				localDocument = finder.getOneByForeign(enderecoLocalDocument,
						EnderecoLocalNames.LOCAL, LocalNames.ATIVO, 1);
				parceiroDocument = finder.getOneByForeign(localDocument,
						LocalNames.PARCEIRO, ParceiroNames.ATIVO, 1);
				grupoEmpresarialDocument = finder.getOneByForeign(parceiroDocument,
						ParceiroNames.GRUPOEMPRESARIAL, GrupoEmpresarialNames.ID, 1);
				flagDocument = finder.getOneByForeign(parceiroDocument,
						ParceiroNames.FLAG);
				if (flagDocument.getInteger(FlagNames.IDFLAG) == 174)
					isPessoaJuridica = true;
				else {
					infoComplementarDocument = finder.findOneByForeign(
							InformacaoComplementarNames.COLLECTION,
							InformacaoComplementarNames.PARCEIRO,
							parceiroDocument.getInteger(ParceiroNames.ID));
					pessoaFisicaDocument = finder.findOneByForeign(
							PessoaFisicaNames.COLLECTION,
							PessoaFisicaNames.INFORMACAOCOMPLEMENTAR,
							infoComplementarDocument
									.getInteger(InformacaoComplementarNames.ID));
					parceiroAssociadoDocument = finder.findOneByForeign(
							ParceiroAssociadoNames.COLLECTION,
							ParceiroAssociadoNames.PARCEIRO,
							parceiroDocument.getInteger(ParceiroNames.ID),
							ParceiroAssociadoNames.ATIVO, 1);
				}
				enderecoDocument = finder.getOneByForeign(enderecoLocalDocument,
						EnderecoLocalNames.ENDERECO);
				logradouroDocument = finder.getOneByForeign(enderecoDocument,
						EnderecoNames.LOGRADOURO);
				tipoLogradouroDocument = finder.getOneByForeign(logradouroDocument,
						LogradouroNames.TIPOLOGRADOURO);
				localidadeDocument = finder.getOneByForeign(enderecoDocument,
						EnderecoNames.LOCALIDADE);
				cidadeDocument = finder.getOneByForeign(localidadeDocument,
						LocalidadeNames.CIDADE);
				unidadeFederativaDocument = finder.getOneByForeign(cidadeDocument,
						CidadeNames.UNIDADEFEDERATIVA);
				paisDocument = finder.getOneByForeign(unidadeFederativaDocument,
						UnidadeFederativaNames.PAIS);

				defineRow(result);
			} catch (DocumentNotFoundException e) {
				e.printStackTrace();
			} catch (ClassCastException e2) {

			}
		}
		return result;
	}

	// public List<Document> query(MongoNestedFilder mongoNestedFilder, String
	// text) {
	// boolean foundedFilteredDoc;
	// DocumentFinder finder = new DocumentFinder(connector);
	// MongoQueryResult result = new
	// MongoQueryResult(MainQueryConstants.fields);
	// for (Document enderecoLocalDocument :
	// finder.findAllEnderecoLocalByText(mongoNestedFilder, new
	// EnderecoLocalFilter(), text)) {
	// isPessoaJuridica = false;
	// foundedFilteredDoc = false;
	// this.enderecoLocalDocument = enderecoLocalDocument;
	// try {
	// localDocument = finder.getOneByForeign(this.enderecoLocalDocument,
	// EnderecoLocalNames.LOCAL, LocalNames.ATIVO, 1);
	// parceiroDocument = finder.getOneByForeign(localDocument,
	// LocalNames.PARCEIRO, ParceiroNames.ATIVO, 1);
	// flagDocument = finder.getOneByForeign(parceiroDocument,
	// ParceiroNames.FLAG);
	// if (flagDocument.getInteger(FlagNames.IDFLAG) == 174)
	// isPessoaJuridica = true;
	// else {
	// infoComplementarDocument =
	// finder.findOneByForeign(InformacaoComplementarNames.COLLECTION,
	// InformacaoComplementarNames.PARCEIRO,
	// parceiroDocument.getInteger(ParceiroNames.ID));
	// pessoaFisicaDocument =
	// finder.findOneByForeignAndByText(PessoaFisicaNames.COLLECTION,
	// PessoaFisicaNames.INFORMACAOCOMPLEMENTAR,
	// infoComplementarDocument.getInteger(InformacaoComplementarNames.ID), new
	// MongoNestedFilder(new ArrayList<String>(){PessoaFisicaNames},
	// fieldNames));
	// parceiroAssociadoDocument =
	// finder.findOneByForeign(ParceiroAssociadoNames.COLLECTION,
	// ParceiroAssociadoNames.PARCEIRO,
	// parceiroDocument.getInteger(ParceiroNames.ID),
	// ParceiroAssociadoNames.ATIVO, 1);
	// }
	//
	//
	//
	// // Posso fazer depois, pois já foi filtrado
	// enderecoDocument = finder.getOneByForeign(this.enderecoLocalDocument,
	// EnderecoLocalNames.ENDERECO);
	// logradouroDocument = finder.getOneByForeign(enderecoDocument,
	// EnderecoNames.LOGRADOURO);
	// tipoLogradouroDocument = finder.getOneByForeign(logradouroDocument,
	// LogradouroNames.TIPOLOGRADOURO);
	// localidadeDocument = finder.getOneByForeign(enderecoDocument,
	// EnderecoNames.LOCALIDADE);
	// cidadeDocument = finder.getOneByForeign(localidadeDocument,
	// LocalidadeNames.CIDADE);
	// unidadeFederativaDocument = finder.getOneByForeign(cidadeDocument,
	// CidadeNames.UNIDADEFEDERATIVA);
	// paisDocument = finder.getOneByForeign(unidadeFederativaDocument,
	// UnidadeFederativaNames.PAIS);
	//
	//
	//
	//
	// grupoEmpresarialDocument = finder.getOneByForeign(parceiroDocument,
	// ParceiroNames.GRUPOEMPRESARIAL, GrupoEmpresarialNames.ID, 1);
	//
	// defineRow(result);
	// } catch (DocumentNotFoundException e) {
	// e.printStackTrace();
	// } catch (ClassCastException e2) {
	//
	// }
	// }
	// return result;
	//
	// }

	// Document regQuery = new Document();
	// regQuery.append("$regex", "(?)" + Pattern.quote(text));
	// regQuery.append("$options", "i");
	//
	// Document findQuery = new Document();
	// findQuery.append("DESCRICAO", regQuery);
	// return
	// Parser.toList(connector.getDb().getCollection("cidade").find(findQuery));
	// }

	public List<Document[]> queryBlockForeach() {
		FindIterable<Document> elIt = connector
				.getDb()
				.getCollection("enderecolocal")
				.find(new Document()
						.append("IDLOCAL.ATIVO", 1)
						.append("IDLOCAL.IDPARCEIRO.ATIVO", 1)
						.append("IDLOCAL.IDPARCEIRO.IDGRUPOEMPRESARIAL.IDGRUPOEMPRESARIAL",
								1));
		BlockParceiroAssociadoPessoaFisica block = new BlockParceiroAssociadoPessoaFisica(
				connector);
		elIt.forEach(block);
		return block.getResult();
	}

	public void queryIndividualsDocsWithoutFilter() {
		int i = 0;
		FindIterable<Document> el = connector.getDb().getCollection("enderecolocal")
				.find();
		for (Document elDoc : el) {
			FindIterable<Document> e = connector.getDb().getCollection("endereco")
					.find(new Document("IDENDERECO", elDoc.get("IDENDERECO")));
			for (Document eDoc : e) {
				System.out.println(++i);
				System.out.println(eDoc);
			}
		}
	}
}
