package controlleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import vue.Panel;

import javax.swing.*;

import modele.Board;

import java.awt.*;

public class Listener implements MouseListener {
    Panel panel;
    modele.Board matrice;
    controlleur.Joueur j;
    DataOutputStream os;

    public static boolean tour = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = (int) Math.round(e.getX() / 45.0) - 1;
        int y = (int) Math.round(e.getY() / 40.0) - 1;

        if(!(x>14 || x < 0 || y>14 || y < 0)) {
            if(tour && j.place_point(x,y)) {
                try {

                    if(matrice.verif_point(j.getId_Point(), x, y) !=0 ) {
                        // int[][] tab = matrice.trace(j.getId_Point(), x, y);
                        
                        os.writeUTF("perdu");
                        JOptionPane.showMessageDialog(null, "Vous avez gagnez", "Fin de la partie", JOptionPane.PLAIN_MESSAGE);
                        matrice.initGame();
                    }else {
                        os.writeUTF(x+"::"+y+"::"+j.getId_Point());
                    }
                    os.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                tour = false;
                panel.repaint();
            } else {
                JOptionPane.showMessageDialog(null,"It's not your turn");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Out of match grid");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public Listener(Panel panel, controlleur.Joueur j, modele.Board matrice, Socket socket) throws IOException {
        this.panel = panel;
        this.j = j;
        this.matrice = matrice;
        os = new DataOutputStream(socket.getOutputStream());
    }
}