package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CardCadastraPlanoNet extends JPanel implements VisualWindow {
   private JLabel lbDescricao, lbNome, lbVelocidade, lbKbps;
   private JTextField jtNome, jtVelocidade;
   private JTextField jtDescricao;
   private JButton jbCadastrar;
   private JButton jbLimpar;
   
   private BufferedImage img = null;
	private File arquivo;
	private JLabel lbFundo;
	
  
   
	
	
	public CardCadastraPlanoNet() {
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
		lbNome = new JLabel("Nome Do Plano");
		lbKbps = new JLabel("Mb/s");
		lbVelocidade= new JLabel("Velociade do Plano");
		lbDescricao = new JLabel("descrição do Plano ");
		jtNome = new JTextField();
		jtVelocidade = new JTextField();
		jtDescricao = new JTextField();
		
		jbCadastrar = new JButton("Cadastrar");
		jbLimpar = new JButton("limpar");
		 
		lbNome.setBounds(480, 50 , 250 , 40);
		lbVelocidade.setBounds(480, 150, 250, 40);
		lbKbps.setBounds(780, 100, 100, 40);
		lbDescricao.setBounds(480, 100, 270, 40);
		jtNome.setBounds(630, 50, 130, 40);
		jtVelocidade.setBounds(630, 100, 130, 40);
		jtDescricao.setBounds(630, 150, 500, 40);
		jbCadastrar.setBounds(480, 200, 150, 40);
		jbLimpar.setBounds(650, 200, 100, 40);
		
		add(jtDescricao);
		add(lbNome);
		add(lbVelocidade);
		add(lbDescricao);
		add(jtNome);
		add(jtVelocidade);
		add(lbKbps);
		add(jbCadastrar);
		add(jbLimpar);
		
		
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
		jtVelocidade.addKeyListener(new KeyListener() {
			
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				new Validations().ValidaNumero(jtVelocidade);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			
				
			}
		});
		
		
	}
	

	
	
	
	

	

}
