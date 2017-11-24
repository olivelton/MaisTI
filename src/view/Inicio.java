package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.image.Image;


public class Inicio  extends JPanel implements VisualWindow {
	
	private TelaPrincipal telaPrincipal;
	
	
	
	private BufferedImage imagem = null;
	private File file;
	private JLabel lbplanoFundo;

	public Inicio(TelaPrincipal principal) {
		this.telaPrincipal = principal;
	setLayout();
	setComponents();
	setEvents();

}

@Override
public void setLayout() {
	// TODO Auto-generated method stub
	this.setLayout(new FlowLayout());
	this.setVisible(true);
	
	setBounds(30, 30, 200, 200);
	
	
	
		
		
}

@Override
public void setComponents() {
	// TODO Auto-generated method stub
	
	
	
	
	
	try {
		file = new File("src/resources/bemvindo.png");
		imagem = ImageIO.read(file);
		}
		catch(Exception exp1){
			JOptionPane.showMessageDialog(null, "impossivel Carregar imagem de fundo"+ exp1);
		}
	
	lbplanoFundo = new JLabel(new ImageIcon(imagem));
	add(lbplanoFundo, BorderLayout.CENTER);
	 
			
		
}

@Override
public void setEvents() {
	// TODO Auto-generated method stub
	
}


}


