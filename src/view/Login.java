package view;

import control.OpenDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 */
public class Login extends JFrame implements VisualWindow {
   Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();//dimension com metodo para captura do tamanho da screen do computador
    private JLabel lbUser;
    private JLabel lbPassword;
    private JPasswordField jpPassword;
    private JTextField jtUser;
    private JButton jbIn;
    private JButton jbOut;
    private JLabel lbStatus;
    private String stat = "";
      private int cont = 3;
//construtor da classe
    public Login(){
        setLayout();//chama o metodo responsavel por layoute  e tamnhos da janela
        setComponents();//chama metodo responsavel por dizer e setar os componentes na screen
        setEvents();// chama o metodos responsavel pelos eventos da screen
        repaintAll();
    }

    @Override
    public void setLayout() {
        //centraliza o jframe pega os valores da screen do pc e divide por 2 e coloca janela la
        // JOptionPane.showMessageDialog(null, screen);
        setLocation((screen.width - 500) / 2, (screen.height - 300) / 2);
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

    @Override
    public void setComponents() {
        //instancia componentes
        lbUser = new JLabel("Usuario:");//instancia novo lebel de usuario
        jtUser = new JTextField();//instancia novo text de usuario
        lbPassword= new JLabel("Senha:");//instancia novo label de senha
        jpPassword = new JPasswordField();//instancia novo caixa de texto de senha
        jbIn = new JButton("Entrar");//instancia botão entrar
        jbOut = new JButton("Cancelar");//instancia botão sair
        lbStatus = new JLabel();//instancia label de dados incorretos

        // trabalha com os tamanhos dos labels e posicionamento
        lbUser.setBounds(110, 50, 120,40); //seta posicionamento e tamanho do label usuario
        jtUser.setBounds(220,50,120,40);//seta posicionamento e tamanho da caixa de texto usuario
        lbPassword.setBounds(110, 100, 120, 40);//seta posicionamento e tamanho do label senha
        jpPassword.setBounds(220,100,120,40);//seta posicionamento e tamanho da caixa de texto senha
        jbIn.setBounds(110, 150, 110,40);//seta tamanho e posião botão entrar
        jbOut.setBounds(230, 150, 110,40);//seta tamanho e posição do botão cancelar
        lbStatus.setBounds(110, 200, 250,40);//posiciona label de dados incoretos
        lbStatus.setForeground(Color.RED);//altera cor do texto de dados incorretos


        //adiciona componentes
        getContentPane().add(lbUser);// add label de usuario
        getContentPane().add(jtUser);//add caixa de texto do usuario
        getContentPane().add(lbPassword);//add label de senha
        getContentPane().add(jpPassword);//add caixa de texto de senha
        getContentPane().add(jbIn);//add botão entrar
        getContentPane().add(jbOut);//add botão cancelar
        getContentPane().add(lbStatus);//adiciona o label de senha errado

    }

    @Override
    public void setEvents() {
    //tratando evento do botão sair eventos dos botões estão sendo tratados

        //
        jbIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //instanciamos a classe openDB que sera classe que vai conectar ao banco
                //cria instancia de opeNDB e verificando usuario nisso ja passamos por parametros os usuario e senha do mysql
                OpenDB login = new OpenDB(jtUser.getText(), jpPassword.getText());
                //criamos uma variavel que vai receber se verdadeiro se banco conectou e falso se não
                boolean status =  login.checkConnection();
                        //tratamos se usuario e senha receberem true continua para o sistema
                        //senão da o alerta e espera novas entradas
                        if(status){
                            new MainWindow();//cria instancia da janela principal do sistema
                            dispose();//fecha janela de login
                        }
                        else{
                            Random ran = new Random(); //classe de numeros randonomicos



                            stat = "Usuario ou senha Icorretos";
                            jpPassword.setBackground(new Color(255, 71, 54));
                            jtUser.setBackground(new Color(255, 71, 54));
                           getContentPane().setBackground(new Color(ran.nextInt(255),ran.nextInt(255), ran.nextInt(255)));
                            lbStatus.setText("você possui mais "+ cont-- +" tentativas ");
                            if(cont<0){
                                System.exit(0);
                            }

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

    private void repaintAll() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                repaint();

            }
        });
    }
}





