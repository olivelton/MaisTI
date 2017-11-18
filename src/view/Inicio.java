package view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio  extends JPanel implements VisualWindow {
	
	private TelaPrincipal telaPrincipal;
	private JLabel teste;

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
	this.setBackground(new java.awt.Color(244,200, 212));
	setBounds(30, 30, 200, 200);
}

@Override
public void setComponents() {
	// TODO Auto-generated method stub
	teste = new JLabel(" testando esse card inicial ");
	 add(teste);
}

@Override
public void setEvents() {
	// TODO Auto-generated method stub
	
}


}


