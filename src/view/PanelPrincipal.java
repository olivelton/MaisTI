package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelPrincipal extends JPanel implements VisualWindow  {
	public Inicio cardInicial;
	public TelaPrincipal telaprincipal;
	public CardCadastrarUsuario cardCadUsu;
	public CardInfo cardInformacao;
	public static final int INICIO = 1;
	public static final int CADASTROUSUARIO = 2;
	public static final int INFORMACAO = 3;	
	
	public PanelPrincipal(TelaPrincipal principal) {
		this.telaprincipal = principal;
		setLayout();
		setComponents();
		setEvents();
		repaintAll();
		
	}
	@Override
	public void setLayout() {
		// TODO Auto-generated method stub
	setLayout(new CardLayout());
	
	
	
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		cardCadUsu = new CardCadastrarUsuario();
		cardInformacao = new CardInfo();
		cardInicial = new Inicio(telaprincipal);
		
		add(cardInicial, "inicial");
		add(cardCadUsu, "cadastrousuario");
		add(cardInformacao, "informacao");
		
		
		
	}

	@Override
	public void setEvents() {
		// TODO Auto-generated method stub
		
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

