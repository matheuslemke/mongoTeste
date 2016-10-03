package mongo.names;

public class EnderecoLocalNames {
	public static final String COLLECTION = "enderecolocal";
	public static final String DATAINICIO = "DATAINICIO";
	public static final String DATAFIM = "DATAFIM";
	public static final String LOCAL = "IDLOCAL";
	public static final String ENDERECO = "IDENDERECO";

	public static final String NUMEROENDERECO = "IDENDERECO.NUMERO";
	public static final String DESCRICAOLOGRADOURO = "IDENDERECO.IDLOGRADOURO.DESCRICAO";
	public static final String DESCRICAOCIDADE = "IDENDERECO.IDLOCALIDADE.IDCIDADE.DESCRICAO";
	public static final String SIGLAUNIDADEFEDERATIVA = "IDENDERECO.IDLOCALIDADE.IDCIDADE.IDUNIDADEFEDERATIVA.SIGLA";
	public static final String NOMEPARCEIRO = "IDLOCAL.IDPARCEIRO.NOME";

	// if juridica
	public static final String CNPJLOCAL = "IDLOCAL.CNPJ";

	// if fisica

}
