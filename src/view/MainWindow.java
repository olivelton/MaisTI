package view;

import org.omg.IOP.ExceptionDetailMessage;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements VisualWindow {
    //dimension com classe com metodo para captura do tamanho da screen do computador
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private JMenuBar menuBar;//cria uma barra de menu para o MAINWINDOW
    private String userLogin;//criamos os componentes que vamos adicionar nesse caso vai armazenar o usuario ativo
    private JMenu systemMenu;//criamos os componentes que vamos adicionar nesse aqui é o menu sistema
    private JMenu helpMenu;//criamos os componentes que vamos adicionar aqui menu ajuda
    private JSeparator space;//criamos os componentes que vamos adicionar aqui um espaçador na barra de menus
    private JLabel activeUser;//criamos os componentes que vamos adicionar aqui um label que mostrara usuario ativo

    public MainWindow(String userLogin){
        this.userLogin = userLogin;
        setLayout();
        setComponents();
        setEvents();
        repaintAll();

    }


    @Override
    public void setLayout() {
        //define tamanho da janela buscando o tamanho da screen
        //screen.height- 50 serve para que a janela não se esconda atras da barra de tarefas
        setSize(screen.width, screen.height-50);

        // seta layout da janela com layoute de card layoute visto que ela
        //vai comportar varios frames
        setLayout(new CardLayout());

        //Definição do título da janela
        setTitle("MAIS TI - SISTEMA DE CONTROLE INTERNO DE USUARIOS DE REDE");

        //define se a janela sera redimensionavel
        setResizable(true);

        //deixa o frame visivel
        setVisible(true);

        //Define se a janela fechará o sistema ou apenas ela mesma (neste caso apenas ela mesma
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void setComponents(){

       setJMenuBar(menuBar);//adiciona o menu ao frame Mainwidow
        //menuBar.setBorderPainted(true);

        // Define e adiciona dois menus drop down na barra de menus
        systemMenu = new JMenu("Sistema"); //criamos os menus do manubar e damos um apelido
        helpMenu = new JMenu("Ajuda");//criamos os menus do manubar e damos um apelido
        space = new JSeparator();//instanciamos o separador
        activeUser = new JLabel("Usuario ativo: "+ userLogin );// instanciamos o label


        //adicionamos ao menu bar os menus

        menuBar.add(systemMenu);//diz que menu bar adiciona o item Jmenu systeMenu ou sistema
        menuBar.add(helpMenu);//diz que menubar adiciona o item Jmenu helpMenu ou o Ajuda
        menuBar.add(space);//colocams espaço para separar menus dos labels
        menuBar.add(activeUser);// adicionamos label contendo usuario que esta logado no sistema

        // Cria e adiciona um item simples para o menu
        JMenuItem createUser = new JMenuItem("Cadastrar Usuario");//cria submenu de cadastrar usuario
        JMenuItem exit = new JMenuItem("Sair");//cria submenu de sair
        JMenuItem howToUse = new JMenuItem("Como usar +TI");//cria submenu como usar
        JMenuItem info = new JMenuItem("Sobre");//cria menu de informações do projeto como versão e licensa

        //adiciona se aos menus os submenus
        systemMenu.add(createUser);//adiciona submenu criar usuario ao menu sistema
        systemMenu.add(exit);//adiciona submenu sair ao menu sistema
        helpMenu.add(howToUse);//adiciona o submenu ao menu ajuda
        helpMenu.add(info);// adiciona submenu sobre ao menu ajuda


    }

    @Override
    public void setEvents() {

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
