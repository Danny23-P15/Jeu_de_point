package vue;


import vue.Panel;
import controlleur.Listener;
import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    Panel panel;
    Color bgc = new Color(253, 250, 250);
    Listener mouseListener;

    public Fenetre(String title, Panel p,Listener mouseListener){
        super(title);
        this.panel=p;
        this.mouseListener = mouseListener;

        this.panel.setBackground(bgc);
        this.panel.addMouseListener(mouseListener);

        this.setSize(735,680);
        this.setResizable(false);
        this.add(panel);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}