package modelo;

public class RegistroDados {
	private String id; 
	private String unidade;
	private String mapeamento;
	private String arquivo;
	private String dataVerificacao;
	private String dataModificacao;
	private String tipoBusca;
	private String verificar;

	public RegistroDados() {

	}

	public RegistroDados(String unidade, String mapeamento, String arquivo, String dataVerificacao,
			String dataModificacao, String tipoBusca, String verificar, String id) {
		super();
		this.unidade = unidade;
		this.mapeamento = mapeamento;
		this.arquivo = arquivo;
		this.dataVerificacao = dataVerificacao;
		this.dataModificacao = dataModificacao;
		this.tipoBusca = tipoBusca;
		this.verificar = verificar;
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getMapeamento() {
		return mapeamento;
	}

	public void setMapeamento(String mapeamento) {
		this.mapeamento = mapeamento;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getDataVerificacao() {
		return dataVerificacao;
	}

	public void setDataVerificacao(String dataVerificacao) {
		this.dataVerificacao = dataVerificacao;
	}

	public String getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public String getTipoBusca() {
		return tipoBusca;
	}

	public void setTipoBusca(String tipoBusca) {
		this.tipoBusca = tipoBusca;
	}

	public String getVerificar() {
		return verificar;
	}

	public void setVerificar(String verificar) {
		this.verificar = verificar;
	}

	public String toString(){
       return this.id+";"+this.unidade+";"+this.mapeamento+";"+this.arquivo+";"+
	          this.dataVerificacao+";"+this.dataModificacao+";"+this.tipoBusca+";"+
    		  this.verificar;
	}
	
}
