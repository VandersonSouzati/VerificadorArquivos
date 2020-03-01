package tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.RegistroDados;
import operacoes.RegistroDadosOperacoes;

public class TelaPrincipal extends JFrame {
	private JButton btnGerarDados, btnMapeamento, btnArquivos, btnAbrir, btnRestaurar;
	private Container container;
	private JPanel painelTitulo, painelComandos, painelCentral, painelBotoes, painelBotaoRestaurar;
	private static JFrame framePrincipal, frameCadastro, frameSplach;
	private JDialog dialog;
	// PainelCentral
	private JPanel pnPrincipal, pnTable;
	private JButton btRemover, btnNovoRegistro, btnVerificar;
	private JScrollPane scrollTable;
	private JTable table;
	private JCheckBox ckNomeParcial, ckVerificar;
	private JLabel lbNumero, lbTotal, lbUnidade, lbMapeamento, lbNomeParcial, lbArquivo, titulo;
	private JTextField tfNumero, tfTotal, tfUnidade, tfMapeamento, tfArquivo;
	private JComboBox cbUnidades, cbMapeamentos, cbArquivos;
	private Font fontBotoesMenu, fontBotoesPainel;

	// Tela cadastro
	private JLabel lbCadUnidade, lbCadMapeamento, lbCadArquivo;
	private JCheckBox ckParcial;
	private JTextField txUnidade, txMapeamento, txArquivo;
	private JButton btnGravar = new JButton("Gravar");
	// Fim tela Cadastrado

	private String[] GerarDados = { "Todas", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010",
			"011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022" };
	private String[] listaMapeamentos = { "Todos Mapeamentos: ", "\\serverunl1\\rp\\import\\",
			"\\serverunl2\\rp\\import\\", "\\serverunl3\\rp\\import\\", "\\serverunl4\\rp\\import\\",
			"\\serverunl5\\rp\\import\\", "\\serverunl6\\rp\\import\\", "\\serverunl7\\rp\\import\\",
			"\\serverunl8\\rp\\import\\", "\\serverunl9\\rp\\import\\", "\\serverunl10\\rp\\import\\",
			"\\serverunl11\\rp\\import\\", "\\serverunl12\\rp\\import\\", "\\serverunl13\\rp\\import\\",
			"\\serverunl14\\rp\\import\\", "\\serverunl15\\rp\\import\\", "\\serverunl16\\rp\\import\\",
			"\\serverunl17\\rp\\import\\", "\\serverunl18\\rp\\import\\", "\\serverunl19\\rp\\import\\",
			"\\serverunl20\\rp\\import\\", "\\serverunl21\\rp\\import\\", "\\serverunl22\\rp\\import\\" };
	private String[] listaArquivos = { "Todos Arquivos", "Tirateima.txt", "ItensMGV.txt", "ProdGer.exp(Parcial)", };
	private DecimalFormat df = new DecimalFormat("#,###.00");
	private RegistroDadosOperacoes op = new RegistroDadosOperacoes();

	public TelaPrincipal() {
		inicializarComponentesPainelCentral();
		inicializarComponentes();
		definirEventosPainelCentral();
	}

	/***************************************************************************/

	public void inicializarComponentes() {
		setTitle("Verificador de Arquivos");
		setBounds(0, 0, 810, 620);
		setLayout(new BorderLayout());
		container = getContentPane();
		container.add("Center", pnPrincipal);
		container.validate();

	}

	/********************************************************************************/

	/****** Painel Central ******************************************************/
	private void inicializarComponentesPainelCentral() {
		fontBotoesMenu = new Font("Arial", fontBotoesMenu.PLAIN, 12);
		lbUnidade = new JLabel("Unidade:");

		lbArquivo = new JLabel("Arquivo:");
		lbNomeParcial = new JLabel("NomeParcial");
		lbMapeamento = new JLabel("Mapeamento:");

		tfUnidade = new JTextField();
		tfArquivo = new JTextField();

		cbUnidades = new JComboBox(GerarDados);
		cbMapeamentos = new JComboBox(listaMapeamentos);
		cbArquivos = new JComboBox(listaArquivos);

		btnNovoRegistro = new JButton("Adicionar");
		btnNovoRegistro.setToolTipText("Filtra registros apresentados no Grid");
		btRemover = new JButton("Remover");
		btRemover.setToolTipText("Remove os itens selecionados");
		btnVerificar = new JButton("Verificar");
		btnAbrir = new JButton("Abrir Pasta");
		btnRestaurar = new JButton("Aplicativo Old");
		btnGerarDados = new JButton("Restaurar Dados");

		lbUnidade.setBounds(15, 10, 100, 25);
		cbUnidades.setBounds(15, 35, 80, 25);

		lbArquivo.setBounds(110, 10, 120, 25);
		cbArquivos.setBounds(110, 35, 150, 25);

		lbMapeamento.setBounds(275, 10, 120, 25);
		cbMapeamentos.setBounds(275, 35, 250, 25);

		btnVerificar.setBounds(560, 35, 100, 25);
		btnVerificar.setFont(fontBotoesPainel);

		btnAbrir.setBounds(670, 35, 100, 25);
		btnAbrir.setFont(fontBotoesPainel);

		btnNovoRegistro.setBounds(560, 80, 100, 25);
		btRemover.setBounds(670, 80, 100, 25);
		btnRestaurar.setBounds(645, 540, 120, 30);
		btnGerarDados.setBounds(500, 540, 130, 30);

		pnPrincipal = new JPanel();
		pnPrincipal.setLayout(null);
		pnPrincipal.setBounds(0, 40, 810, 530);
		pnPrincipal.add(lbUnidade);
		pnPrincipal.add(cbUnidades);
		pnPrincipal.add(lbArquivo);
		pnPrincipal.add(cbArquivos);
		pnPrincipal.add(lbMapeamento);
		pnPrincipal.add(cbMapeamentos);
		pnPrincipal.add(btnVerificar);
		pnPrincipal.add(btnAbrir);
		pnPrincipal.add(btnRestaurar);
		pnPrincipal.add(btnGerarDados);
		pnPrincipal.add(btnNovoRegistro);
		pnPrincipal.add(btRemover);
		pnTable = new JPanel(new BorderLayout());
		pnTable.setBorder(new TitledBorder("Arquivos"));
		scrollTable = new JScrollPane();
		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		DefaultTableModel tableModel = new DefaultTableModel(
				new String[] { "Id", "Unidade", "Mapeamento", "Arquivo", "Data Modificação" }, 0);
		table = new JTable(tableModel);
		DefaultTableCellRenderer alinhaCentro = new DefaultTableCellRenderer();
		alinhaCentro.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer alinhaEsquerda = new DefaultTableCellRenderer();
		alinhaEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setResizable(false);
		// table.getColumnModel().getColumn(1).setCellRenderer(alinhaCentro);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(165);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setCellRenderer(alinhaCentro);
		// table.getColumnModel().set
		table.getColumnModel().getColumn(4).setPreferredWidth(180);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setCellRenderer(alinhaCentro);

		table.getTableHeader().setReorderingAllowed(false);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBackground(Color.decode("#AAFFAA"));
		scrollTable.setViewportView(table);
		pnTable.add(scrollTable);
		pnTable.setBounds(10, 100, 760, 430);
		pnPrincipal.add(pnTable);
		add(pnPrincipal);
	}

	/*************************************************************************/

	private void definirEventosPainelCentral() {

		btnGerarDados.addActionListener(p -> gerarDados());

		btRemover.addActionListener(p -> removeSelecionados());

		cbUnidades.addActionListener(p -> atualizaDadosComboBox("unidade"));

		cbArquivos.addActionListener(p -> atualizaDadosComboBox("arquivo"));

		cbMapeamentos.addActionListener(p -> atualizaDadosComboBox("mapeamento"));

		btnNovoRegistro.addActionListener(p -> telaCadastro());

		btnVerificar.addActionListener(p -> mensagem());

		table.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent tecla) {
				if (tecla.getKeyChar() == KeyEvent.VK_ENTER) {

				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				int linha = table.getSelectedRow();
				int coluna = table.getSelectedColumn();

				// System.out.println(table.getSelectedRow());
				JOptionPane.showMessageDialog(null, table.getSelectedRow());
				// JOptionPane.showMessageDialog(null, table.getValueAt(linha, coluna));

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

	private void gerarDados() {
		// Limpa os dados e reconstroi com o padrão
		op.gerarDados();
		carregaDadosTabela();
	}

	private void removeSelecionados() {
		int[] linhas = table.getSelectedRows();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (int i = (linhas.length - 1); i >= 0; --i) {
			dtm.removeRow(linhas[i]);
		}
	}

	// Removendo todos os itens do Table
	private void removeTodasLinhas() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (int i = (dtm.getRowCount() - 1); i >= 0; --i) {
			dtm.removeRow(i);
		}
	}

	private void carregaDadosTabela() {
		List<RegistroDados> listaRegistros = op.lerDados();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		removeTodasLinhas();
		listaRegistros.stream().forEach(p -> adicionaLinhaTabela(dtm, p));

	}

	private void atualizaDadosComboBox(String filtro) {
		List<RegistroDados> listaRegistros = op.lerDados();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		removeTodasLinhas();
		listaRegistros.stream()
		              .filter(registro -> validaFiltro(registro, filtro))
				      .forEach(registro -> adicionaLinhaTabela(dtm, registro));
	}

	private boolean validaFiltro(RegistroDados p, String filtro) {
		  String unidade    = cbUnidades.getSelectedItem().toString();
		  String arquivo    = cbArquivos.getSelectedItem().toString();
		  String mapeamento = cbMapeamentos.getSelectedItem().toString();
		  boolean retorno   = false;
          if(filtro == "unidade") {
        	  retorno =
        			 (p.getUnidade().equalsIgnoreCase(unidade) || unidade.equalsIgnoreCase("Todas")) 
         			 && 
         			 (p.getArquivo().equalsIgnoreCase(arquivo) || arquivo.equalsIgnoreCase("Todos Arquivos"));
          }
          if(filtro =="arquivo") {
        	  retorno = 
        			  (p.getArquivo().equalsIgnoreCase(arquivo) || arquivo.equalsIgnoreCase("Todos Arquivos"))
        	          &&
        	          (p.getUnidade().equalsIgnoreCase(unidade) || unidade.equalsIgnoreCase("Todas")); 
          }
          /*
          if(filtro == "mapeamento"){
        	  retorno = (mapeamento.equalsIgnoreCase("Todos Mapeamentos"))?true:
        	         p.getUnidade().equalsIgnoreCase(unidade) && 
        			 p.getArquivo().equalsIgnoreCase(arquivo) && 
        			 p.getMapeamento().equalsIgnoreCase(mapeamento);
          }
          */
          return retorno;
	}

	private void adicionaLinhaTabela(DefaultTableModel dtm, RegistroDados p) {
		String unidade = "Undidade: " + p.getUnidade();
		String caminho = p.getMapeamento();
		String arquivo = p.getArquivo();
		String dataModificacao = op.buscaDataModificacao(p);
		dtm.addRow(new Object[] { "109", unidade, caminho, arquivo, dataModificacao, "26/01/20 20:20:20" });
	}

	private void limparCampos() {
		tfUnidade.setText("");
		tfArquivo.setText("1");
		tfUnidade.requestFocus();
	}

	public void telaCadastro() {
		if (frameCadastro != null) {
			frameCadastro.dispose();
		}
		frameCadastro = new JFrame();
		frameCadastro.setLayout(null);
		frameCadastro.setBounds(0, 0, 500, 200);

		lbCadUnidade = new JLabel("Unidade:");
		lbCadMapeamento = new JLabel("Mapeamento:");
		lbCadArquivo = new JLabel("Arquivo:");
		ckParcial = new JCheckBox("Buscar por parte do nome ?");
		txUnidade = new JTextField();
		txMapeamento = new JTextField();
		txArquivo = new JTextField();
		btnGravar = new JButton("Gravar");

		lbCadUnidade.setBounds(10, 10, 70, 20);
		txUnidade.setBounds(100, 10, 80, 20);
		lbCadMapeamento.setBounds(10, 40, 100, 20);
		txMapeamento.setBounds(100, 40, 240, 20);
		lbCadArquivo.setBounds(10, 70, 70, 20);
		txArquivo.setBounds(100, 70, 170, 20);
		ckParcial.setBounds(280, 70, 200, 20);
		btnGravar.setBounds(330, 130, 150, 30);
		frameCadastro.add(lbUnidade);
		frameCadastro.add(txUnidade);
		frameCadastro.add(lbMapeamento);
		frameCadastro.add(txMapeamento);
		frameCadastro.add(lbArquivo);
		frameCadastro.add(txArquivo);
		frameCadastro.add(ckParcial);
		frameCadastro.add(btnGravar);
		frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastro.setLocationRelativeTo(framePrincipal);
		frameCadastro.setVisible(true);

		btnGravar.addActionListener(p -> inserirDados());

	}

	public void inserirDados() {
		RegistroDados registro = new RegistroDados();
		registro.setUnidade(txUnidade.getText());
		registro.setMapeamento(txMapeamento.getText());
		registro.setArquivo(txArquivo.getText());
		registro.setDataModificacao(null);
		registro.setDataVerificacao(null);
		registro.setTipoBusca((ckParcial.isEnabled()) ? "SIM" : "NAO");
		registro.setVerificar("SIM");

		RegistroDadosOperacoes operacoes = new RegistroDadosOperacoes();
		operacoes.inserirDados(registro, true);

	}

	public void mensagem() {
		if (dialog != null) {
			dialog.dispose();
		}
		dialog = new JDialog();
		dialog.setLayout(null);
		dialog.setBounds(0, 0, 500, 100);
		dialog.setLocationRelativeTo(framePrincipal.getContentPane());
		JLabel label = new JLabel();
		JButton btnEncerrar = new JButton("Encerrar");
		label.setText("Processando Arquivos.....");
		label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 35));
		label.setForeground(Color.blue);
		label.setBounds(10, -15, 400, 90);
		// btnEncerrar.setBounds(390,40,100,20);
		dialog.setTitle("|------PROCESSANDO ARQUIVOS------|");
		dialog.add(label);
		// dialog.add(btnEncerrar);
		dialog.repaint();
		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		// dialog.setModal(true);
		dialog.setVisible(true);

	}

	public static void abrir() {
		framePrincipal = new TelaPrincipal();
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		int largura = (tela.width - framePrincipal.getSize().width) / 2;
		int altura = (tela.height - framePrincipal.getSize().height) / 2;
		framePrincipal.setLocation(largura, altura);
		framePrincipal.setVisible(true);
	}

}
