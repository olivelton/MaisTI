package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class CardCadastrarUsuario extends JPanel implements VisualWindow{

	

	public CardCadastrarUsuario() {
		// TODO Auto-generated constructor stub
		setLayout();
		setComponents();
		setEvents();
	
	}
	
	@Override
	public void setLayout() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		setBackground(new Color(2, 10, 255));
		
		setVisible(true);
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
