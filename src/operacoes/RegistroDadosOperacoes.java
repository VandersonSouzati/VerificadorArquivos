package operacoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.RegistroDados;

public class RegistroDadosOperacoes {
	private String caminhoArquivo = "c://verificadorArquivos//registroDados.txt";

	public void inserirDados(RegistroDados registro) {
		try {

			File file = new File(caminhoArquivo);

			if (!file.exists()) {
				file.mkdir();
			}

			FileWriter fw = new FileWriter(file, true);
			fw.write(registro.toString());
			fw.close();
		} catch (IOException e) {
			String mensagem = "Houve um erro ao escrever no arquivo";
			javax.swing.JOptionPane.showMessageDialog(null, mensagem);
		}
	}

	public List<RegistroDados> lerDados() {
		List<RegistroDados> listaRegistros = new ArrayList<>();
		RegistroDados registro = new RegistroDados();
		try {

			File file = new File(caminhoArquivo);
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String[] dados;
			String linha = "";
			while ((linha = bf.readLine()) != null) {
				dados = linha.split(";");
				for (int c = 0; c < dados.length; c++) {

					registro.setId(dados[0]);
					registro.setUnidade(dados[1]);
					registro.setMapeamento(dados[2]);
					registro.setArquivo(dados[3]);
					registro.setDataModificacao(dados[4]);
					registro.setDataVerificacao(dados[5]);
					registro.setTipoBusca(dados[6]);
					registro.setVerificar(dados[7]);

					listaRegistros.add(registro);
				}
			}

		} catch (IOException e) {
			String mensagem = "Houve um erro ao ler o arquivo";
			javax.swing.JOptionPane.showMessageDialog(null, mensagem);
		}
		return listaRegistros;
	}
	
	public List<RegistroDados> lerDadosFiltro(String unidade, String mapeamento, String arquivo){
		List<RegistroDados> lista = lerDados();
		List<RegistroDados> listaRetorno = new ArrayList<>();
		
		return lista;
	}
}
