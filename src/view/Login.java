package view;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Login extends JFrame implements VisualWindow {
   Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel lbUser, lbPassword;
    private JTextField jtPassword, jtUser;

    public Login(){

        setLayout();
        setComponents();
        setEvents();
    }


    @Override
    public void setComponents() {
        //instancia componentes
        lbUser = new JLabel("usuario:");
        lbPassword= new JLabel("senha:");
        jtPassword = new JTextField("dois");
        jtUser = new JTextField("teste");
        // trabalha com os tamanhos dos labels
        lbUser.setBounds(100, 10, 100,40);
        lbPassword.setBounds(100, 55, 100, 40);
        jtUser.setBounds(200,10,50,40);
        jtPassword.setBounds(200,65,50,40);
        //adiciona componentes
        getContentPane().add(lbUser);
        getContentPane().add(lbPassword);
        getContentPane().add(jtUser);
        getContentPane().add(jtPassword);

    }

    @Override
    public void setEvents() {

    }

    @Override
    public void setLayout() {
        //centraliza o jframe pega os valores da tela do pc e divide por 2 e coloca janela la
        // JOptionPane.showMessageDialog(null, tela);
        setLocation((tela.width - 500) / 2, (tela.height - 300) / 2);
        //setLocationRelativeTo(null);
                //deixa o frame visivel
        setVisible(true);
        // seta borda invcando instancia border layout
        setLayout(new BorderLayout());
        //Definição do título da janela
        setTitle("Login");
        //Definição do tamanho da janela
        setSize(500, 300);
        //Define se a janela fechará o sistema ou apenas ela mesma (neste caso apenas ela mesma
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}





