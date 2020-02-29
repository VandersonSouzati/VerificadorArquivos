package operacoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import modelo.RegistroDados;

public class RegistroDadosOperacoes {

	private String caminho = "c://verificadorArquivos";
	private String arquivo = "registroDados.txt";

	public void inserirDados(RegistroDados registro) {
		verificaObjetoDuplicado(registro);
		try {

			File path = new File(caminho);
			File file = new File(path.getPath() + "//" + arquivo);

			if (!path.exists()) {
				path.mkdir();
			}

			FileWriter fw = new FileWriter(file, true);
			fw.write(registro.toString() + "\n");
			fw.close();
		} catch (IOException e) {
			String mensagem = "Houve um erro ao escrever no arquivo " + e.getMessage();
			javax.swing.JOptionPane.showMessageDialog(null, mensagem);
		}
	}

	public List<RegistroDados> lerDados() {
		List<RegistroDados> listaRegistros = new ArrayList<>();
		RegistroDados registro = new RegistroDados();
		try {

			File file = new File(caminho + "//" + arquivo);
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String[] dados;
			String linha = "";
			while ((linha = bf.readLine()) != null) {
				dados = linha.split(";");
				System.out.println(dados[0]);
				System.out.println(dados[1]);
				System.out.println(dados[2]);
				System.out.println(dados[3]);
				System.out.println(dados[4]);
				System.out.println(dados[5]);
				System.out.println(dados[6]);

				registro.setUnidade(dados[0]);
				registro.setMapeamento(dados[1]);
				registro.setArquivo(dados[2]);
				registro.setDataModificacao(dados[3]);
				registro.setDataModificacao(dados[4]);
				registro.setTipoBusca(dados[5]);
				registro.setVerificar(dados[6]);
                
				listaRegistros.add(registro);
				registro = new RegistroDados();
			}

		} catch (IOException e) {
			String mensagem = "Houve um erro ao ler o arquivo " + e.getMessage();
			javax.swing.JOptionPane.showMessageDialog(null, mensagem);
		}
		return listaRegistros;
	}

	public List<RegistroDados> lerDadosFiltro(String unidade, String mapeamento, String arquivo) {
		List<RegistroDados> lista = lerDados();
		List<RegistroDados> listaRetorno = new ArrayList<>();

		return lista;
	}

	public void verificaObjetoDuplicado(RegistroDados registro) {
		List<RegistroDados> lista = lerDados();
		List<RegistroDados> lista2;
		lista2 =lista.stream().filter(p->lista.contains(registro)).collect(Collectors.toList());
		// System.out.println("Teste: " +lista2.size());
		lista.stream().forEach(p->System.out.println(lista.contains(p)));
		lista2.stream().distinct().forEach(p -> System.out.println(p));
	}
}
