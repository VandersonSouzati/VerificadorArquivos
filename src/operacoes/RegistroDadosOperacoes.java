package operacoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import modelo.RegistroDados;

public class RegistroDadosOperacoes {

	private String caminho = "c://verificadorArquivos";
	private String arquivo = "registroDados.txt";

	public void inserirDados(RegistroDados registro, boolean manterDados) {
		verificaObjetoDuplicado(registro);
		try {

			File path = new File(caminho);
			File file = new File(path.getPath() + "//" + arquivo);

			if (!path.exists()) {
				path.mkdir();
			}

			FileWriter fw = new FileWriter(file, manterDados);
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
		//Removendo o primeiro registro que o gerarDados cria como null
		listaRegistros.remove(0);
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
		lista2 = lista.stream().filter(p -> lista.contains(registro)).collect(Collectors.toList());
		// System.out.println("Teste: " +lista2.size());
		//lista.stream().forEach(p -> System.out.println(lista.contains(p)));
		//lista2.stream().distinct().forEach(p -> System.out.println(p));
	}

	public void gerarDados() {
        RegistroDados registro = new RegistroDados();
        int totalUnidades = 22;
		String[] unidades = { "001", "002", "003", "004", "005", "006", "007", "008", 
				"009", "010", "011", "012", "013", "014", "015", "016",
				"017", "018", "019", "020", "021", "022" };
		String[] mapeamentos = {"\\serverunl1\\rp\\import\\",
				"\\serverunl2\\rp\\import\\", "\\serverunl3\\rp\\import\\", "\\serverunl4\\rp\\import\\",
				"\\serverunl5\\rp\\import\\", "\\serverunl6\\rp\\import\\", "\\serverunl7\\rp\\import\\",
				"\\serverunl8\\rp\\import\\", "\\serverunl9\\rp\\import\\", "\\serverunl10\\rp\\import\\",
				"\\serverunl11\\rp\\import\\", "\\serverunl12\\rp\\import\\", "\\serverunl13\\rp\\import\\",
				"\\serverunl14\\rp\\import\\", "\\serverunl15\\rp\\import\\", "\\serverunl16\\rp\\import\\",
				"\\serverunl17\\rp\\import\\", "\\serverunl18\\rp\\import\\", "\\serverunl19\\rp\\import\\",
				"\\serverunl20\\rp\\import\\", "\\serverunl21\\rp\\import\\", "\\serverunl22\\rp\\import\\" };
		String[] arquivos = { "tirateima.txt", "itensmgv.txt", "PRODGER.txt" };
		
		// Zerando o arquivo cria uma linha com os valores null;
        inserirDados(registro, false);

        for(int a=0; a< arquivos.length; a++) {
        	for(int c=0; c<unidades.length; c++) {
        		registro.setUnidade(unidades[c]);
        		registro.setArquivo(arquivos[a]);
        		registro.setMapeamento(mapeamentos[c]);
        		registro.setDataModificacao(null);
        		registro.setDataVerificacao(null);
        		registro.setTipoBusca("SIM");
        		registro.setVerificar("SIM");
        		inserirDados(registro, true);
        		registro = new RegistroDados();
        	}
        }
	}
	
	public String buscaDataModificacao(RegistroDados registro) {
		String arquivo    = registro.getArquivo();
		String mapeamento = registro.getMapeamento().replace("\\", "/") + "/";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dataFormatada = null;
		
		File file = new File(mapeamento+"//"+arquivo);
		dataFormatada = sdf.format(file.lastModified());
		return dataFormatada;
	}
}
