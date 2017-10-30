package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements VisualWindow {
    //dimension com classe com metodo para captura do tamanho da screen do computador
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();


    public MainWindow(){
        setLayout();
        setComponents();
        setEvents();
    }


    @Override
    public void setLayout() {
        //define tamanho da janela buscando o tamanho da screen
        //screen.height- 50 serve para que a janela não se esconda atras da barra de tarefas
        setSize(screen.width, screen.height-50);
        //deixa o frame visivel
        setVisible(true);
        // seta borda invcando instancia border layout
        setLayout(null);
        //Definição do título da janela
        setTitle("MAIS TI - SISTEMA DE CONTROLE INTERNO DE USUARIOS DE REDE");
        //define se a janela sera redimensionavel
        setResizable(true);
        //Define se a janela fechará o sistema ou apenas ela mesma (neste caso apenas ela mesma
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void setComponents() {

    }

    @Override
    public void setEvents() {

    }
}
