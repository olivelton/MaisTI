package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelLogin extends JPanel implements VisualWindow {
	private JLabel user;
	private JLabel lbPass;
	private JTextField jtUser;
	private JPasswordField jpPass;
	private JButton jbLogin, jbOut;

	public PanelLogin() {
		setLayout();
		setComponents();
		setEvents();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		user = new JLabel("Usuario: ");
		lbPass = new JLabel("Senha: ");
		jtUser = new JTextField();
		jpPass = new JPasswordField("");
		jbLogin = new JButton("Login");
		jbOut = new JButton("Sair");

		// x,y, width, height
		user.setBounds(600, 340, 100, 40);
		lbPass.setBounds(600, 380, 100, 40);
		jtUser.setBounds(700, 350, 100, 25);
		jpPass.setBounds(700, 390, 100, 25);
		jbLogin.setBounds(600, 450, 100, 50);
		jbOut.setBounds(750, 450, 100, 50);

		add(user);
		add(lbPass);
		add(jpPass);
		add(jtUser);
		add(jbLogin);
		add(jbOut);
	}



	@Override
	public void setLayout() {
		// TODO Auto-generated method stub
		
		// seta o tamanho da janela
				setSize(300, 300);
				// torna janela visivel
				setVisible(true);
				// diz para fechar o processo quando clica no X da janela

				// setamos o fundo da tela cor

				setLayout(null);
		

	}
	@Override
	public void setEvents() {

		jbOut.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			System.exit(0);
		});

	}

}
