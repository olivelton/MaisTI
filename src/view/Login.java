package view;

import modelDao.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 */
public class Login extends JFrame implements VisualWindow {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();//dimension com metodo para captura do tamanho da tela do computador
    private JLabel labelUsuario;
    private JLabel labelSenha;
    private JPasswordField jpassSenha;
    private JTextField jtUsuario;
    private JButton jbEntrar;
    private JButton jbCancelar;
    private JLabel labelEstado;
    private int contador = 3;

    //construtor da classe
    public Login() {
        setLayout();//chama o metodo responsavel por layoute  e tamnhos da janela
        setComponents();//chama metodo responsavel por dizer e setar os componentes na tela
        setEvents();// chama o metodos responsavel pelos eventos da tela
        repaintAll();
    }

    //metodos da interface sobreescritos
    @Override
    public void setLayout() {
        //centraliza o jframe pega os valores da tela do pc e divide por 2 e coloca janela la
        // JOptionPane.showMessageDialog(null, tela);
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //metodos da interface sobreescritos
    @Override
    public void setComponents() {
        //instancia componentes
        labelUsuario = new JLabel("Usuario:");//instancia novo lebel de usuario
        jtUsuario = new JTextField();//instancia novo text de usuario
        labelSenha = new JLabel("Senha:");//instancia novo label de senha
        jpassSenha = new JPasswordField();//instancia novo caixa de texto de senha
        jbEntrar = new JButton("Entrar");//instancia botão entrar
        jbCancelar = new JButton("Cancelar");//instancia botão sair
        labelEstado = new JLabel();//instancia label de dados incorretos

        // trabalha com os tamanhos dos labels e posicionamento
        labelUsuario.setBounds(110, 50, 120, 40); //seta posicionamento e tamanho do label usuario
        jtUsuario.setBounds(220, 50, 120, 40);//seta posicionamento e tamanho da caixa de texto usuario
        labelSenha.setBounds(110, 100, 120, 40);//seta posicionamento e tamanho do label senha
        jpassSenha.setBounds(220, 100, 120, 40);//seta posicionamento e tamanho da caixa de texto senha
        jbEntrar.setBounds(110, 150, 110, 40);//seta tamanho e posião botão entrar
        jbCancelar.setBounds(230, 150, 110, 40);//seta tamanho e posição do botão cancelar
        labelEstado.setBounds(110, 200, 250, 40);//posiciona label de dados incoretos
        labelEstado.setForeground(Color.RED);//altera cor do texto de dados incorretos


        //adiciona componentes
        getContentPane().add(labelUsuario);// add label de usuario
        getContentPane().add(jtUsuario);//add caixa de texto do usuario
        getContentPane().add(labelSenha);//add label de senha
        getContentPane().add(jpassSenha);//add caixa de texto de senha
        getContentPane().add(jbEntrar);//add botão entrar
        getContentPane().add(jbCancelar);//add botão cancelar
        getContentPane().add(labelEstado);//adiciona o label de senha errado
        getRootPane().setDefaultButton(jbEntrar);// adiciona o botão entrat como principal da janela sempre que
        //pressionar enter ele acionara o evento tratado do jbEntrar
    }

    //metodos da interface sobreescritos
    @Override
    public void setEvents() {

        // tratamento de tecla pressionada onde chamada classe validations e fara tipo de letra e validação nos campos
        jtUsuario.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                jtUsuario.setText(new Validations().upperCase(jtUsuario.getText()));// chama metodo da classe validações e passa parametro
            }

        });

        //evento keylistenner para tratar quando pressiona tecla dentro do password
        jpassSenha.addKeyListener(new java.awt.event.KeyListener() {

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
                jpassSenha.setText(new Validations().upperCase(jpassSenha.getText()));
            }

        });


        //tratando evento do botão sair eventos dos botões estão sendo tratados
        jbEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entraSistema();// metodo responsavel por fazer validadção de dados
                //e comnunicar com outras classes
            }
        });


        //invocamos um ouvindo action listenner e instanciamos Action listener
        jbCancelar.addActionListener(new ActionListener() {
            @Override
            //criado metodo que realizará a ação depois de clicar no botão
            public void actionPerformed(ActionEvent e) {
                //acão dada ao botão cancelar que ira fehar o sistema

                System.exit(0);
            }
        });

    }

    //criamos o metodo que deve ser chamado nos eventos de logar no sistema ou de kwy press enter
    private void entraSistema() {
        //instanciamos classe de validação de usuario do sistema
        UserDao enter = new UserDao();

        //tratamos se usuario e senha receberem true continua para o sistema
        //senão da o alerta e espera novas entradas
        //chama metodo checklogin do DAO usuario
        if (enter.checkLogin(jtUsuario.getText(), jpassSenha.getText())) {
            new TelaPrincipal(jtUsuario.getText());//cria instancia da janela principal do sistema e passa qual usuario esta usando



           dispose();//fecha janela de login

        } else {
            jpassSenha.setBackground(new Color(255, 71, 54));// muda a cor da caixa texto de senha
            jtUsuario.setBackground(new Color(255, 71, 54));//muda a cor da caixa de texto usuario
            labelSenha.setForeground(new Color(255, 71, 54));//muda a cor da letra do label senha
            labelUsuario.setForeground(new Color(255, 71, 54));//muda a cor do label de usuario
            getContentPane().setBackground(new Color(67, 198, 190));//muda cor de fundo da tela chamar atenção user
            labelEstado.setText("você possui mais " + contador-- + " tentativas ");// manda msg de dados incorretos ao label e mostra contador

            //trata contagem onde chegando a zero fecha a tela de login do sistema
            //contador foi pre inicializado com 3 tentativas
            if (contador < 0) {
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





