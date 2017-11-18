package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CardInfo extends JPanel implements VisualWindow{


	public CardInfo() {
		// TODO Auto-generated constructor stub
		setLayout();
		setComponents();
		setEvents();
		
	}
	
	@Override
	public void setLayout() {
		// TODO Auto-generated method stub
		setLayout(new BorderLayout());
		//setBackground(new Color(100, 100, 100));
		setBounds(30, 30, 20, 20);
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
