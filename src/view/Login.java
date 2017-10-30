package view;

import control.OpenDB;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class Login extends JFrame implements VisualWindow {
   Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel lbUser;
    private JLabel lbPassword;
    private JTextField jtPassword;
    private JTextField jtUser;
    private JButton jbIn;
    private JButton jbOut;
    private JLabel lbStatus;

    public Login(){
        setLayout();
        setComponents();
        setEvents();

    }


    @Override
    public void setComponents() {
        //instancia componentes
        lbUser = new JLabel("Usuario:");//instancia novo lebel de usuario
        jtUser = new JTextField();//instancia novo text de usuario
        lbPassword= new JLabel("Senha:");//instancia novo label de senha
        jtPassword = new JTextField();//instancia novo caixa de texto de senha
        jbIn = new JButton("Entrar");
        jbOut = new JButton("Cancelar");


        // trabalha com os tamanhos dos labels e posicionamento
        lbUser.setBounds(100, 50, 120,40); //seta posicionamento e tamanho do label usuario
        jtUser.setBounds(210,50,120,40);//seta posicionamento e tamanho da caixa de texto usuario
        lbPassword.setBounds(100, 100, 120, 40);//seta posicionamento e tamanho do label senha
        jtPassword.setBounds(210,100,120,40);//seta posicionamento e tamanho da caixa de texto senha
        jbIn.setBounds(100, 150, 110,40);//seta tamanho e posião botão entrar
        jbOut.setBounds(220, 150, 110,40);//seta tamanho e posição do botão cancelar

        //adiciona componentes
        getContentPane().add(lbUser);// add label de usuario
        getContentPane().add(jtUser);//add caixa de texto do usuario
        getContentPane().add(lbPassword);//add label de senha
        getContentPane().add(jtPassword);//add caixa de texto de senha
        getContentPane().add(jbIn);//add botão entrar
        getContentPane().add(jbOut);//add botão cancelar

    }

    @Override
    public void setEvents() {
    //tratando evento do botão sair eventos dos botões estão sendo tratados

        //
        jbIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                OpenDB login = new OpenDB(jtUser.getText(), jtPassword.getText());
                 boolean status =  login.checkConnection();

                        if(status){
                            JOptionPane.showMessageDialog(null,"voce entrou no sistema");
                        }
                        else{

                            lbStatus = new JLabel("Dados incorretos");
                            lbStatus.setBounds(100, 200, 100,25);
                            lbStatus.setForeground(Color.RED);
                            getContentPane().add(lbStatus);
                        }
            }
        });


        //invocamos um ouvindo action listenner e instanciamos Action listener
        jbOut.addActionListener(new ActionListener() {
            @Override
            //criado metodo que realizará a ação depois de clicar no botão
            public void actionPerformed(ActionEvent e) {
                //acão dada ao botão cancelar que ira fehar o sistema

                System.exit(0);
            }
        });



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
        setLayout(null);
        //Definição do título da janela
        setTitle("Login");
        //Definição do tamanho da janela
        setSize(500, 300);
        //define se a janela sera redimensionavel
        setResizable(true);

        //Define se a janela fechará o sistema ou apenas ela mesma (neste caso apenas ela mesma
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}





