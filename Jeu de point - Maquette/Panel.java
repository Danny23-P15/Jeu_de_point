package vue;

import javax.swing.*;
import modele.Board;

import java.awt.*;

public class Panel extends JPanel {
    Board matrice;
    Color color_j1 = new Color(255, 0, 70);
    Color color_j2 = new Color(75,50,255);
    Color color_grille = new Color(58, 55, 55);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Grille
        g2d.setColor(color_grille);
        for (int i=1; i<=matrice.getMatricePoint().length;i++){
            g2d.drawLine(10,i*40,705,i*40);
        }
        for (int j=1; j<=matrice.getMatricePoint()[0].length;j++) {
            g2d.drawLine(j*45,10,j*45,620);
        }

        for (int y=0; y<matrice.getMatricePoint().length;y++){
            for (int x=0; x<matrice.getMatricePoint()[y].length;x++){
                switch (matrice.getMatricePoint()[y][x]) {
                    case 1:
                        g2d.setColor(color_j1);
                        g2d.fillOval(x*45+40,y*40+35,10,10);
                        break;
                    case 2:
                        g2d.setColor(color_j2);
                        g2d.fillOval(x*45+40,y*40+35,10,10);
                        break;
                }
            }
        }
    }

    public Panel(Board b){
        this.matrice = b;
    }
}