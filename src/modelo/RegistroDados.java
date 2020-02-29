package modelo;

public class RegistroDados {
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
			String dataModificacao, String tipoBusca, String verificar) {
		super();
		this.unidade = unidade;
		this.mapeamento = mapeamento;
		this.arquivo = arquivo;
		this.dataVerificacao = dataVerificacao;
		this.dataModificacao = dataModificacao;
		this.tipoBusca = tipoBusca;
		this.verificar = verificar;
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
       return this.unidade+";"+this.mapeamento+";"+this.arquivo+";"+
	          this.dataVerificacao+";"+this.dataModificacao+";"+this.tipoBusca+";"+
    		  this.verificar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquivo == null) ? 0 : arquivo.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + ((dataVerificacao == null) ? 0 : dataVerificacao.hashCode());
		result = prime * result + ((mapeamento == null) ? 0 : mapeamento.hashCode());
		result = prime * result + ((tipoBusca == null) ? 0 : tipoBusca.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		result = prime * result + ((verificar == null) ? 0 : verificar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroDados other = (RegistroDados) obj;
		if (arquivo == null) {
			if (other.arquivo != null)
				return false;
		} else if (!arquivo.equals(other.arquivo))
			return false;
		if (dataModificacao == null) {
			if (other.dataModificacao != null)
				return false;
		} else if (!dataModificacao.equals(other.dataModificacao))
			return false;
		if (dataVerificacao == null) {
			if (other.dataVerificacao != null)
				return false;
		} else if (!dataVerificacao.equals(other.dataVerificacao))
			return false;
		if (mapeamento == null) {
			if (other.mapeamento != null)
				return false;
		} else if (!mapeamento.equals(other.mapeamento))
			return false;
		if (tipoBusca == null) {
			if (other.tipoBusca != null)
				return false;
		} else if (!tipoBusca.equals(other.tipoBusca))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		if (verificar == null) {
			if (other.verificar != null)
				return false;
		} else if (!verificar.equals(other.verificar))
			return false;
		return true;
	}
	
	
}
