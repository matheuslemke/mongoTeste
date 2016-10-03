package mongo.mainquery;

import java.util.LinkedList;
import java.util.List;

import mongo.dao.Connector;

import org.bson.Document;

import com.mongodb.Block;

public class BlockParceiroAssociadoPessoaFisica implements Block<Document> {
	private Connector connector;
	private List<Document[]> result = new LinkedList<Document[]>();
	private int i = 0;

	public BlockParceiroAssociadoPessoaFisica(Connector connector) {
		super();
		this.connector = connector;
	}

	public void apply(Document document) {
		System.out.println(++i);
		List<Document> row = new LinkedList<Document>();
		row.add(document);
		if (((Document) ((Document) ((Document) document.get("IDLOCAL"))
				.get("IDPARCEIRO")).get("IDFLAGTIPOPESSOA")).getInteger("IDFLAG") != 174) {
			int idParceiro = ((Document) ((Document) document.get("IDLOCAL"))
					.get("IDPARCEIRO")).getInteger("IDPARCEIRO");
			row.add(connector
					.getDb()
					.getCollection("parceiroassociado")
					.find(new Document().append("IDPARCEIRO.IDPARCEIRO", idParceiro)
							.append("ASSOCIADO", 1)).first());
			row.add(connector
					.getDb()
					.getCollection("pessoafisica")
					.find(new Document(
							"IDINFORMACAOCOMPLEMENTAR.IDINFORMACAOCOMPLEMENTAR",
							idParceiro)).first());
		}
		result.add(row.toArray(new Document[row.size()]));
	}

	public List<Document[]> getResult() {
		return result;
	}

}
