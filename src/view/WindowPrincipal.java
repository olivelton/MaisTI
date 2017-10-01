package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowPrincipal extends JFrame implements VisualWindow {
private PanelLogin panelLogin;

	public WindowPrincipal() {
		setLayout();
		setComponents();
		setEvents();
		new PanelLogin();
		
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		panelLogin = new PanelLogin();
		add(panelLogin, BorderLayout.CENTER);
		
		

	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLayout() {
		// TODO Auto-generated method stub
		// metodo de tratamento do layout
		setBackground(Color.blue);
		setTitle(" +TI ");
		// falamos qual sera o tamanho do jframe
		setSize(1366, 768);
		// setLocationRelativeTo( null ); para que a tela fique centralizada no monitor
		setLocationRelativeTo(null);
		// torna janela visivel
		setVisible(true);
		// diz para fechar o processo quando clica no X da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setamos o fundo da tela cor
		// getContentPane();
		// setamos o titulo da tela
		setLayout(new CardLayout());
		

	}

}
