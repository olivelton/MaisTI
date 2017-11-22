package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Usuario;
import modelDao.UsuarioDao;

public class CardCadastrarUsuario extends JPanel implements VisualWindow {
	Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel labelNome, labelSenha, labelComfirmaSenha;
	private JTextField jtNome;
	private JPasswordField jpSenha, jpConfirmaSenha;
	private JButton jbCadastrar, jbCancelar, jbLimpar;
	private static int X = 324, Y = 150, WHIDT = 0, HEIGTH = 0;

	public CardCadastrarUsuario() {
		// TODO Auto-generated constructor stub
		setLayout();
		setComponents();
		setEvents();

	}

	@Override
	public void setLayout() {
		// TODO Auto-generated method stub
		setLayout(null);
		setBackground(new Color(224, 255, 255));

	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		labelNome = new JLabel("Digite usuario");
		labelSenha = new JLabel("Digite sua senha:");
		labelComfirmaSenha = new JLabel("Confirme a senha:");

		jtNome = new JTextField();
		jpSenha = new JPasswordField();
		jpConfirmaSenha = new JPasswordField();

		jbCadastrar = new JButton("Cadastrar");
		jbLimpar = new JButton("Limpar");
		jbCancelar = new JButton("Cancelar");
		
		
		
		labelNome.setBounds(110 + X, 50 + Y, 250 + WHIDT, 40 + HEIGHT);
		labelComfirmaSenha.setBounds(110 + X, 150 + Y, 250 + WHIDT, 40 + HEIGHT);
		labelSenha.setBounds(110 + X, 100 + Y, 270 + WHIDT, 40 + HEIGHT);
		jtNome.setBounds(270 + X, 50 + Y, 300 + WHIDT, 40 + HEIGHT);
		jpSenha.setBounds(270 + X, 100 + Y, 300 + WHIDT, 40 + HEIGHT);
		jpConfirmaSenha.setBounds(270 + X, 150 + Y, 300 + WHIDT, 40 + HEIGHT);
		jbCadastrar.setBounds(210 + X, 300 + Y, 120 + WHIDT, 40 + HEIGHT);
		jbCancelar.setBounds(340 + X, 300 + Y, 100 + WHIDT, 40 + HEIGHT);
		jbLimpar.setBounds(450 + X, 300 + Y, 120 + WHIDT, 40 + HEIGHT);

		this.add(labelNome);
		this.add(labelSenha);
		this.add(labelComfirmaSenha);
		this.add(jtNome);
		this.add(jpSenha);
		this.add(jpConfirmaSenha);
		this.add(jbCadastrar);
		this.add(jbCancelar);
		this.add(jpConfirmaSenha);
		this.add(jbLimpar);
		this.add(labelComfirmaSenha);
		
		
		
	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub
		jtNome.addKeyListener(new java.awt.event.KeyListener() {

			public void keyReleased(KeyEvent e) {
				jtNome.setText(new Validations().upperCase(jtNome.getText()));// chama metodo da classe validações e
																				// passa parametro
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		jpConfirmaSenha.addKeyListener(new java.awt.event.KeyListener() {

			public void keyReleased(KeyEvent e) {
				jpConfirmaSenha.setText(new Validations().upperCase(jpConfirmaSenha.getText()));// chama metodo da
																								// classe validações e
																								// passa parametro
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		jpSenha.addKeyListener(new java.awt.event.KeyListener() {

			public void keyReleased(KeyEvent e) {
				jpSenha.setText(new Validations().upperCase(jpSenha.getText()));// chama metodo da classe validações e
																				// passa parametro
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Validations valida = new Validations();
				boolean verificaNome = valida.verificaVazioText(jtNome.getText());
				boolean verificaSenha = valida.verificaVazioText(jpSenha.getText());
				boolean verificaSenha2 = valida.verificaVazioText(jpConfirmaSenha.getText());
				boolean comparaSenha = valida.comparaSenhas(jpSenha.getText(), jpConfirmaSenha.getText());

				if (verificaNome && verificaSenha && comparaSenha && verificaSenha2) {
					Usuario novousuario = new Usuario();
					novousuario.setNome(jtNome.getText());
					novousuario.setSenha(jpSenha.getText());
					novousuario.cadastraUsuarioBanco();
					
					limparCampos();
					
				} else {
					if (comparaSenha) {

					} else {
						jpSenha.setBackground(new Color(255, 71, 54));
						jpConfirmaSenha.setBackground(new Color(255, 71, 54));
					}
					if (verificaNome) {
					} else {
						jtNome.setBackground(new Color(255, 71, 54));
						JOptionPane.showMessageDialog(null,"o campo NOME esta vazio" );
					}
					if (verificaSenha) {
					} else {
						jpSenha.setBackground(new Color(255, 71, 54));
						JOptionPane.showMessageDialog(null,"o campo senha esta vazio" );
					}
					if (verificaSenha2) {
					} else {
						jpConfirmaSenha.setBackground(new Color(255, 71, 54));
						JOptionPane.showMessageDialog(null,"o campo CONFIRME SENHA esta vazio" );
					}
				}

			}
		});

		jbCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		jbLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				limparCampos();
			}
		});

		
		
	}
	
	public void limparCampos() {
		jtNome.setBackground(new Color(255, 255, 255));
		jpSenha.setBackground(new Color(255, 255, 255));
		jpConfirmaSenha.setBackground(new Color(255, 255, 255));
		jtNome.setText("");
		jpSenha.setText("");
		jpConfirmaSenha.setText("");
		
	}

}
