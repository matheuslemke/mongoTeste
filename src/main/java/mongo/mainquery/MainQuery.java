package mongo.mainquery;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import org.bson.Document;

import mongo.dao.Connector;
import mongo.dao.DocumentFinder;
import mongo.dao.MongoQuerier;
import mongo.exceptions.DocumentNotFoundException;
import mongo.names.*;

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

    public List<HashMap<String, Object>> query() {
	DocumentFinder finder = new DocumentFinder(connector);
	List<HashMap<String, Object>> result = new LinkedList<HashMap<String, Object>>();
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

		result.add(defineRow());
	    } catch (DocumentNotFoundException e) {
		e.printStackTrace();
	    } catch (ClassCastException e2) {

	    }
	}
	return result;
    }

    public HashMap<String, Object> defineRow() {
	HashMap<String, Object> row = new HashMap<String, Object>();
	row.put(ParceiroNames.ID, parceiroDocument.getInteger(ParceiroNames.ID));
	row.put(ParceiroNames.NOME, parceiroDocument.getString(ParceiroNames.NOME));
	row.put(ParceiroNames.CODIGO, parceiroDocument.getInteger(ParceiroNames.CODIGO));
	row.put(ParceiroNames.FLAG, parceiroDocument.getInteger(ParceiroNames.FLAG));
	row.put(LocalNames.ID, localDocument.getInteger(LocalNames.ID));
	row.put(LocalNames.CODIGOALIAS, localDocument.getInteger(LocalNames.CODIGO));
	row.put(LocalNames.DESCRICAOALIAS, localDocument.getString(LocalNames.DESCRICAO));
	row.put(CidadeNames.IDALIAS, cidadeDocument.getInteger(CidadeNames.ID));
	row.put(CidadeNames.DESCRICAOALIAS, cidadeDocument.getString(CidadeNames.DESCRICAO));
	row.put(UnidadeFederativaNames.ID, unidadeFederativaDocument.getInteger(UnidadeFederativaNames.ID));
	row.put(UnidadeFederativaNames.SIGLAALIAS, unidadeFederativaDocument.getString(UnidadeFederativaNames.SIGLA));
	row.put(PaisNames.ID, paisDocument.getInteger(PaisNames.ID));
	row.put(PaisNames.SIGLAALIAS, paisDocument.getString(PaisNames.SIGLA));
	row.put(TipoLogradouroNames.DESCRICAOALIAS, tipoLogradouroDocument.getString(TipoLogradouroNames.DESCRICAO));
	row.put(LogradouroNames.DESCRICAOALIAS, logradouroDocument.getString(LogradouroNames.DESCRICAO));
	row.put(EnderecoNames.NUMEROALIAS, enderecoDocument.getString(EnderecoNames.NUMERO));
	row.put(LocalidadeNames.DESCRICAOALIAS, localidadeDocument.getString(LocalidadeNames.DESCRICAO));
	row.put(ParceiroNames.FLAG, parceiroDocument.getInteger(ParceiroNames.FLAG));
	if (isPessoaJuridica) {
	    row.put(MainQueryNames.MATRICULA, null);
	    row.put(MainQueryNames.CNPJCPF, localDocument.getString(LocalNames.CNPJ));
	} else {
	    row.put(MainQueryNames.MATRICULA, parceiroAssociadoDocument.getInteger(ParceiroAssociadoNames.NUMEROMATRICULA));
	    row.put(MainQueryNames.CNPJCPF, pessoaFisicaDocument.getString(PessoaFisicaNames.CPF));
	}
	return row;
    }
}
