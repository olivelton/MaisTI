package view;

import model.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private int cont = 3;

    //construtor da classe
    public Login() {
        setLayout();//chama o metodo responsavel por layoute  e tamnhos da janela
        setComponents();//chama metodo responsavel por dizer e setar os componentes na screen
        setEvents();// chama o metodos responsavel pelos eventos da screen
        repaintAll();
    }

    //metodos da interface sobreescritos
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

    //metodos da interface sobreescritos
    @Override
    public void setComponents() {
        //instancia componentes
        lbUser = new JLabel("Usuario:");//instancia novo lebel de usuario
        jtUser = new JTextField();//instancia novo text de usuario
        lbPassword = new JLabel("Senha:");//instancia novo label de senha
        jpPassword = new JPasswordField();//instancia novo caixa de texto de senha
        jbIn = new JButton("Entrar");//instancia botão entrar
        jbOut = new JButton("Cancelar");//instancia botão sair
        lbStatus = new JLabel();//instancia label de dados incorretos

        // trabalha com os tamanhos dos labels e posicionamento
        lbUser.setBounds(110, 50, 120, 40); //seta posicionamento e tamanho do label usuario
        jtUser.setBounds(220, 50, 120, 40);//seta posicionamento e tamanho da caixa de texto usuario
        lbPassword.setBounds(110, 100, 120, 40);//seta posicionamento e tamanho do label senha
        jpPassword.setBounds(220, 100, 120, 40);//seta posicionamento e tamanho da caixa de texto senha
        jbIn.setBounds(110, 150, 110, 40);//seta tamanho e posião botão entrar
        jbOut.setBounds(230, 150, 110, 40);//seta tamanho e posição do botão cancelar
        lbStatus.setBounds(110, 200, 250, 40);//posiciona label de dados incoretos
        lbStatus.setForeground(Color.RED);//altera cor do texto de dados incorretos


        //adiciona componentes
        getContentPane().add(lbUser);// add label de usuario
        getContentPane().add(jtUser);//add caixa de texto do usuario
        getContentPane().add(lbPassword);//add label de senha
        getContentPane().add(jpPassword);//add caixa de texto de senha
        getContentPane().add(jbIn);//add botão entrar
        getContentPane().add(jbOut);//add botão cancelar
        getContentPane().add(lbStatus);//adiciona o label de senha errado
        getRootPane().setDefaultButton(jbIn);// adiciona o botão entrat como principal da janela sempre que
        //pressionar enter ele acionara o evento tratado do jbIn
    }

    //metodos da interface sobreescritos
    @Override
    public void setEvents() {

        // tratamento de tecla pressionada onde chamada classe validations e fara tipo de letra e validação nos campos
        jtUser.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                jtUser.setText(new Validations().upperCase(jtUser.getText()));// chama metodo da classe validações e passa parametro
            }

        });

        //evento keylistenner para tratar quando pressiona tecla dentro do password
        jpPassword.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            //trata quando pressiona a tecla
            @Override
            public void keyPressed(KeyEvent e) {

            }

            //trata no soltar a tecla
            @Override
            public void keyReleased(KeyEvent e) {
                // chama metodo da classe validações e passa parametro capturado no campo de senha do login
                jpPassword.setText(new Validations().upperCase(jpPassword.getText()));
            }

        });


        //tratando evento do botão sair eventos dos botões estão sendo tratados
        jbIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inSystem();// metodo responsavel por fazer validadção de dados
                //e comnunicar com outras classes
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

    //criamos o metodo que deve ser chamado nos eventos de logar no sistema ou de kwy press enter
    private void inSystem() {
        //instanciamos classe de validação de usuario do sistema
        UserDao enter = new UserDao();

        //tratamos se usuario e senha receberem true continua para o sistema
        //senão da o alerta e espera novas entradas
        //chama metodo checklogin do DAO usuario
        if (enter.checkLogin(jtUser.getText(), jpPassword.getText())) {

            new MainWindow();//cria instancia da janela principal do sistema
            dispose();//fecha janela de login

        } else {
            jpPassword.setBackground(new Color(255, 71, 54));// muda a cor da caixa texto de senha
            jtUser.setBackground(new Color(255, 71, 54));//muda a cor da caixa de texto usuario
            lbPassword.setForeground(new Color(255, 71, 54));//muda a cor da letra do label senha
            lbUser.setForeground(new Color(255, 71, 54));//muda a cor do label de usuario
            getContentPane().setBackground(new Color(31, 58, 105));//muda cor de fundo da tela chamar atenção user
            lbStatus.setText("você possui mais " + cont-- + " tentativas ");// manda msg de dados incorretos ao label e mostra contador

            //trata contagem onde chegando a zero fecha a tela de login do sistema
            //contador foi pre inicializado com 3 tentativas
            if (cont < 0) {
                System.exit(0);
            }

        }
    }

    // para ajuda com erros no processamento das telas o repintar abaixo corrige alguns bugs de
    //componentes não aparecendo na tela.
    private void repaintAll() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                repaint();

            }
        });
    }
}





