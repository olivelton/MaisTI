package view;

import java.awt.*;
import java.util.EventListener;

import javax.swing.*;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class Loading extends JWindow implements VisualWindow {

	private int duration;

	public Loading(int d) {
		duration = d;
		showLoadingAndExit();
	}

	// Este é um método simples para mostrar uma tela de apresentção
	// no centro da tela durante a quantidade de tempo passada no construtor
	public void setLayout() {
		JPanel panelContent = (JPanel) getContentPane();
		panelContent.setBackground(Color.white);

		// Configura a posição e o tamanho da janela
		int width = 700;
		int height = 300;

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;

		setBounds(x, y, width, height);

		// Constrói o splash screen
		JLabel label = new JLabel(new ImageIcon("logo.png"));
		JLabel lbAutor = new JLabel("Projeto +TI -UTFPR 2017", JLabel.CENTER);
		lbAutor.setFont(new Font("Arial", Font.BOLD, 30));
		panelContent.add(label, BorderLayout.CENTER);
		panelContent.add(lbAutor, BorderLayout.SOUTH);
		// falamos da cor da borda em rgb
		Color oraRed = new Color(100, 149, 237, 255);
		// dizemos qual a largura de borda deve ter
		panelContent.setBorder(BorderFactory.createLineBorder(oraRed, 2));
		// Torna visível
		setVisible(true);

		// Espera ate que os recursos estejam carregados
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}
		setVisible(false);
	}

	public void showLoadingAndExit() {
		setLayout();
		dispose();

		new WindowPrincipal();
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub
	
		
	}

}