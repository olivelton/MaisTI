package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;

import com.sun.glass.events.WindowEvent;
import com.sun.java.swing.plaf.windows.WindowsOptionPaneUI;
import com.sun.javafx.event.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Loading extends JFrame implements VisualWindow {
	
	private JLabel lbLoad;
	

	public Loading() {
		/*
		 * chamamos o set layout no construtor para toda vez que a classe for
		 * instanciada ela venha a assumir os dados de layout e aparecer a tela
		 */

		setLayout();
		setComponents();
		setEvents();
		loadingOut();

	}

	@Override
	public void setComponents() {

		/* sera metodo de tratamento de todos os componentes */
		lbLoad = new JLabel("Carregando...");
		
		
		// alteramos tamanho da fonte e tipo da fonte
		lbLoad.setFont(new Font("Dialog", Font.PLAIN, 36));
		// colocamos o alinhamneto do label como centro
		lbLoad.setHorizontalAlignment((int)CENTER_ALIGNMENT );
		
		// depois adicionamos o label
		add(lbLoad);
		
		

	}

	@Override
	public void setLayout() {
		// metodo de tratamento do layout
		// falamos qual sera o tamanho do jframe
		setSize(600, 300);
		// setLocationRelativeTo( null ); para que a tela fique centralizada no monitor
		setLocationRelativeTo(null);
		// torna janela visivel
		setVisible(true);
		// diz para fechar o processo quando clica no X da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setamos o fundo da tela cor
		// getContentPane();
		// setamos o titulo da tela
		// setTitle("Loading");
		setLayout(new BorderLayout());

	}

	@Override
	public void setEvents() {
	
		
			
	}
	
	public void loadingOut() {
		
		
		//conta 3 segundos e fecha a janela
		int segundos = 2;
		try{
			for (int i = segundos; i > 0; i--){
				
			Thread.sleep(1000); // 1 segundo
			
			}
			new WindowPrincipal();
			dispose();
		} catch (InterruptedException e1){
			JOptionPane.showMessageDialog(null, "erro ocorrido ao carregar o sistema");
		}
	}
}
