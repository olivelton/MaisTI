package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import javafx.scene.Group;
import model.Usuario;
import modelDao.UsuarioDao;

public class CardEditaUsuario extends JPanel implements VisualWindow {
	private int campoId;
	private int colCel, lineCel;
	private String campoNome;
	private String campoSenha;
	
	
	
	
	private JLabel lbPesquisar;
	private JTextField jtPesquisa;
	private JButton jbPesquisar;
	private JButton jbExcluir;
	private JTextField jtNomeEditar;
	private JTextField jpSenhaEditar;
	private JTextField jpSenhaVerifica;
	private JButton jbEditar;
	private JLabel lbNomeEditar;
	private JLabel lbSenhaEditar;
	private JLabel lbSenhaVerifica;
	
	private JTable tabelaUsuarios;
	private JScrollPane rolagem;

	public Object[][] dados;
	public String [] colunas = {"código","Nome"};
	public DefaultTableModel modelo;
	
	private BufferedImage img = null;
	private File arquivo;
	private JLabel lbFundo;
	
	private static int X = 324, Y = 0, WHIDT = 0, HEIGTH = 0;
	
	public CardEditaUsuario() {
		// TODO Auto-generated constructor stub
		setLayout();
		setComponents();
		setEvents();
	}
	
	@Override
	public void setLayout() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		lbPesquisar = new JLabel("Nome Usuario:");
		jtPesquisa = new JTextField();
		jbPesquisar = new JButton("Pesquisar");
		jbExcluir = new JButton("Excluir");
		jbEditar = new JButton("Salvar Edição");
		jtNomeEditar = new JTextField();
		jpSenhaEditar = new JPasswordField();
		jpSenhaVerifica = new JPasswordField();
		lbNomeEditar = new JLabel("Nome");
		lbSenhaEditar = new JLabel("Senha");
		lbSenhaVerifica = new JLabel("Confirma senha");
		
		
	
		//gambiarra para desativar edição na tabela 
		modelo = new DefaultTableModel(dados, colunas){  
            public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }  
        };  


		
		tabelaUsuarios = new JTable(modelo);
		
		lbPesquisar.setSize(getPreferredSize());
		lbPesquisar.setBounds(110 + X, 50 + Y, 250 + WHIDT, 40 + HEIGHT);
		lbNomeEditar.setBounds(110 + X, 320, 250, 40);
		lbSenhaEditar.setBounds(110 + X, 370, 250, 40);
		lbSenhaVerifica.setBounds(110 + X, 420, 250, 40);
		lbSenhaEditar.setVisible(false);
		lbSenhaVerifica.setVisible(false);
		lbNomeEditar.setVisible(false);
		
		
		
		jtPesquisa.setBounds(230 + X, 50 + Y, 250 + WHIDT, 40 + HEIGHT);
		jtNomeEditar.setBounds(350 + X, 320, 250, 40);
		jpSenhaEditar.setBounds(350 + X, 370, 250, 40);
		jpSenhaVerifica.setBounds(350 + X, 420, 250, 40);
		jpSenhaEditar.setVisible(false);
		jpSenhaVerifica.setVisible(false);
		jtNomeEditar.setVisible(false);
		
		tabelaUsuarios.setBackground(new Color(	169,	169,	169));
		tabelaUsuarios.setBounds(330, 100, 730, 200);
		
		jbPesquisar.setBounds(820, 50, 150, 40);
		
		jbEditar.setBounds(350 + X, 500, 150, 40 );
		jbExcluir.setBounds(650 + X, 500, 150, 40 );
		jbExcluir.setBackground(Color.RED);
		
		jbExcluir.setVisible(false);
		jbEditar.setVisible(false);
		
		
		
		
		tabelaUsuarios.setModel(modelo);
		
	
		rolagem = new JScrollPane(tabelaUsuarios);
		
		
		add(jbExcluir);
		add(jbEditar);
		add(jbPesquisar);
		
		add(tabelaUsuarios);
		
		add(lbPesquisar);
		add(lbNomeEditar);
		add(lbSenhaEditar);
		add(lbSenhaVerifica);
		
		add(jtPesquisa);
		add(jtNomeEditar);
		add(jpSenhaEditar);
		add(jpSenhaVerifica);
					
		
		try {
			arquivo = new File("src/resources/cads.jpg");
			img = ImageIO.read(arquivo);
			}
			catch(Exception exp1){
				JOptionPane.showMessageDialog(null, "impossivel Carregar imagem de fundo"+ exp1);
			}
		
		lbFundo = new JLabel(new ImageIcon(img));
		add(lbFundo, BorderLayout.CENTER);
	
	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub
		 //evento keylistenner para tratar quando pressiona tecla dentro do password
        jtPesquisa.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            	
            }

            //trata quando pressiona a tecla
            @Override
            public void keyPressed(KeyEvent e) {
            	
            }

            
           
            //trata no soltar a tecla
            @Override
            public void keyReleased(KeyEvent e) {
                // chama metodo da classe validações e passa parametro capturado no campo de senha do login
            	 jtPesquisa.setText(new Validations().upperCase(jtPesquisa.getText()));
            	 dadosComCampoPesquisar();
            	 }

        });
		
		
		
		
		jbPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				if(jtPesquisa.getText().isEmpty()) {
					dadosPesquisarEmBranco();
				
				}else {
					
					dadosComCampoPesquisar();
					
				}
					 
				 
				
				
				//lembre-se um "" para cada coluna na tabela
				
				
			}
		});
		
	
		tabelaUsuarios.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jtNomeEditar.setVisible(true);
				jpSenhaEditar.setVisible(true);
				jpSenhaVerifica.setVisible(true);
				lbNomeEditar.setVisible(true);
				lbSenhaEditar.setVisible(true);
				lbSenhaVerifica.setVisible(true);
				jbExcluir.setVisible(true);
				jbEditar.setVisible(true);
				colCel = tabelaUsuarios.getSelectedColumn();
				lineCel = tabelaUsuarios.getSelectedRow();
				campoId = (int)tabelaUsuarios.getValueAt(lineCel, 0);
				campoNome = (String)tabelaUsuarios.getValueAt(lineCel, 1);
				
				jtNomeEditar.setText(campoNome);
				jpSenhaEditar.setText("");
				jpSenhaVerifica.setText("");
           	    jtNomeEditar.setEditable(false);
           
				
				
			}
		});
      
	
		
		jbExcluir.addActionListener(new ActionListener() {
			 	
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int confirma  = JOptionPane.showConfirmDialog(null, "tem certeza que deseja Excluir o usuario:" + campoNome, "Confirma Eclusão", JOptionPane.YES_NO_OPTION);
				if(confirma == 0 && campoId != 1) {
				Usuario usuario = new Usuario();
				usuario.setId_user(campoId);
				usuario.setNome(campoNome);
				usuario.deletarUsuario();
				dadosComCampoPesquisar();
				}else {
					JOptionPane.showMessageDialog(null, "Impossivel excluir o usuario: "+ campoNome);
				}
				
			}
		
		});
	
		jbEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Usuario editaUsuario = new Usuario();
				Validations valida = new Validations();
				boolean verificaNome = valida.verificaVazioText(jtNomeEditar.getText());
				boolean verificaSenha = valida.verificaVazioText(jpSenhaEditar.getText());
				boolean verificaSenha2 = valida.verificaVazioText(jpSenhaEditar.getText());
				boolean comparaSenha = valida.comparaSenhas(jpSenhaEditar.getText(), jpSenhaVerifica.getText());

				if (verificaNome && verificaSenha && comparaSenha && verificaSenha2) {
					editaUsuario.setNome(jtNomeEditar.getText());
					editaUsuario.setSenha(jpSenhaEditar.getText());
					editaUsuario.editarUsuario(campoId);
					
					dadosComCampoPesquisar();
					
				} else {
					if (comparaSenha) {

					} else {
						jpSenhaEditar.setBackground(new Color(255, 71, 54));
						jpSenhaVerifica.setBackground(new Color(255, 71, 54));
					}
					if (verificaNome) {
					} else {
						jtNomeEditar.setBackground(new Color(255, 71, 54));
						JOptionPane.showMessageDialog(null,"Usuario não selecionado" );
					}
					if (verificaSenha) {
					} else {
						jpSenhaEditar.setBackground(new Color(255, 71, 54));
						JOptionPane.showMessageDialog(null,"o campo senha esta vazio" );
					}
					if (verificaSenha2) {
					} else {
						jpSenhaVerifica.setBackground(new Color(255, 71, 54));
						JOptionPane.showMessageDialog(null,"o campo CONFIRME SENHA esta vazio" );
					}
				}

				
			}
		});
	
	}

	
	
	
	
	
	
	
	public void dadosPesquisarEmBranco() {
		
		UsuarioDao usuario = new UsuarioDao();
		this.modelo.setNumRows(0);
		for (Usuario u : usuario.consultar()) {
		Object [] data = {u.getId_user(), u.getNome()};
		modelo.addRow(data);
	}
		}
	
	public void dadosComCampoPesquisar() {
		UsuarioDao usuario = new UsuarioDao();
		this.modelo.setNumRows(0);
		for (Usuario u : usuario.consultarNome(jtPesquisa.getText())) {
		Object [] data = {u.getId_user(), u.getNome()};
		modelo.addRow(data);
		
	}
		
		
	}
	
	
	
	
		





}
