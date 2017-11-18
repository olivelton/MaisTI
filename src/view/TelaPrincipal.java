package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame implements VisualWindow {
	// dimension com classe com metodo para captura do tamanho da tela do computador
	Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	private JMenuBar menuBar;// cria uma barra de menu para o MAINWINDOW
	private String usuarioLogado = "Olivelton";// criamos os componentes que vamos adicionar nesse caso vai armazenar o usuario
									// ativo

	// menus que o jframe possuira
	private JMenu menuSistema;// criamos os componentes que vamos adicionar nesse aqui é o menu sistema
	private JMenu menuImpressora;// menu de impressora
	private JMenu menuPlanosInternet;// menu de planos internet
	private JMenu menuPlanoDados;// menu de plano de dados
	private JMenu menuLogin;// menu de login no sistema
	private JMenu menuDepartametno;
	private JMenu menuFuncionario;// menu de funcionario
	private JMenu menuAjuda;// criamos os componentes que vamos adicionar aqui menu ajuda

	// panel

	private PanelPrincipal painelPrincipal;
	private CardLayout cardLayout;

	// separadores ou espaçadores
	private JSeparator espaco;// criamos os componentes que vamos adicionar aqui um espaçador na barra de
								// menus

	// labels presentes
	private JLabel usuarioAtivo;// criamos os componentes que vamos adicionar aqui um label que mostrara usuario
								// ativo

	// itens de menu
	// sistema
	private JMenuItem cadastrarUsuario; // item de menu criar usuario
	private JMenuItem editarUsuario;
	private JMenuItem consultarUsuario;

	private JMenuItem sair; // item de menu sair do menu sistema
	// ajuda
	private JMenuItem comoUsar; // item de menu como usar
	private JMenuItem sobre; // item de menu informações no menu item
	// inmpressora
	private JMenuItem cadastrarImpressora;
	private JMenuItem editarImpressora;
	private Container panelPrincipal;

	// plano de dados
	// plano de internet
	// login
	// funcionario

	public TelaPrincipal() {
	
		setLayout();
		setComponents();
		setEvents();
		repaintAll();

	}

	@Override
	public void setLayout() {
		// define tamanho da janela buscando o tamanho da tela
		// tela.height- 50 serve para que a janela não se esconda atras da barra de
		// tarefas
		setSize(tela.width, tela.height - 50);

		// seta layout da janela com layoute de card layoute visto que ela
		// vai comportar varios frames
		setLayout(null);

		// Definição do título da janela
		setTitle("MAIS TI - SISTEMA DE CONTROLE INTERNO DE USUARIOS DE REDE");
		setLayout(new BorderLayout());

		// define se a janela sera redimensionavel
		setResizable(true);

		// deixa o frame visivel
		setVisible(true);

		// Define se a janela fechará o sistema ou apenas ela mesma (neste caso apenas
		// ela mesma
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	@Override
	public void setComponents() {
		this.menuBar = new JMenuBar(); // instanciar a barra de menus
		setJMenuBar(menuBar);
		this.menuBar.setSize(tela.width, 100);// seta o tamanho do menubar

		// instancia de menus
		this.menuSistema = new JMenu("Sistema");
		this.menuAjuda = new JMenu("Ajuda");
		this.menuImpressora = new JMenu("Impressora");
		this.menuPlanoDados = new JMenu("Planos de dados");
		this.menuPlanosInternet = new JMenu("Planos de Internet");
		this.menuFuncionario = new JMenu("funcionario");
		this.menuDepartametno = new JMenu("Departamento");

		this.espaco = new JSeparator();// instanciamos o separador
		this.usuarioAtivo = new JLabel("Usuario ativo: " + this.usuarioLogado);// instanciamos o label

		// instancia Jmenuitem
		this.cadastrarUsuario = new JMenuItem("Cadastrar Usuario");
		this.editarUsuario = new JMenuItem("Editar Usuario");
		this.editarUsuario = new JMenuItem("Editar Usuarios");
		this.consultarUsuario = new JMenuItem("Consultar Usuario");
		this.sair = new JMenuItem("Sair");
		// ajuda
		this.comoUsar = new JMenuItem("Como usar +TI");
		this.sobre = new JMenuItem("Sobre");
		// impressora
		// plano de dados
		// planos de internet
		// funcionario
		// departamento

		// add Jmenu menubar
		this.menuBar.add(this.menuSistema);
		this.menuBar.add(this.menuPlanosInternet);
		this.menuBar.add(this.menuPlanoDados);
		this.menuBar.add(this.menuImpressora);
		this.menuBar.add(this.menuDepartametno);
		this.menuBar.add(this.menuFuncionario);
		this.menuBar.add(this.menuAjuda);
		this.menuBar.add(this.espaco);
		this.menuBar.add(this.usuarioAtivo);

		this.menuBar.setBackground(new Color(0x6DAFD2));

		// add submenuitem menu sistema
		this.menuSistema.add(this.cadastrarUsuario);
		this.menuSistema.add(this.editarUsuario);
		this.menuSistema.add(this.consultarUsuario);
		this.menuSistema.add(this.sair);

		// add submenuotem menu ajuda
		this.menuAjuda.add(this.comoUsar);
		this.menuAjuda.add(this.sobre);
		
		
		this.painelPrincipal = new PanelPrincipal(this);
		this.cardLayout = new CardLayout();
		this.cardLayout = (CardLayout) painelPrincipal.getLayout();
		this.add(painelPrincipal, BorderLayout.CENTER);
		
		// trabalhando com panels
		
		
		

	}

	@Override
	public void setEvents() {

		// adicionamos uma ação ao item de menu sair do menu sistema
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// comando para fechar o sistema
			}
		});

		// tratamento de ação do item de menu
		cadastrarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// chamada do painel panelmanageruser
				trocaPanel(painelPrincipal.CADASTROUSUARIO);

			}
		});

		comoUsar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				trocaPanel(painelPrincipal.INFORMACAO);
			}
		});

	}

	public void trocaPanel(int painel) {

		switch (painel) {
		case 1:
					
			cardLayout.show(painelPrincipal, "inicial");
			
			break;
		case 2:
			cardLayout.show(painelPrincipal, "cadastrousuario");
			
			break;
		case 3:
			
			cardLayout.show(painelPrincipal, "informacao");			
			break;

		case 4:


			break;

		case 5:

		

			break;

		case 6:

		

			break;

		case 7:

			

			break;
		default:

			

		}

	}

	private void repaintAll() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				repaint();

			}
		});
	}

}
