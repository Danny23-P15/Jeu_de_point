package main;

import controlleur.Listener;
import modele.Board;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ReceivePoint extends Thread {
    private boolean loop = true;
    DataInputStream in;
    vue.Panel panel;
    modele.Board board;


    public ReceivePoint(modele.Board board, vue.Panel panel, Socket socket) throws IOException {
        in = new DataInputStream(socket.getInputStream());
        this.panel = panel;
        this.board = board;

        start();
    }

    @Override
    public void run() {
        while (loop) {
            try {
                String point = in.readUTF();

                if(point.equals("perdu")) { 
                    JOptionPane.showMessageDialog(null, "Vous avez perdu", "Fin de la partie", JOptionPane.PLAIN_MESSAGE);
                    board.initGame();
                } else {
                    int x
                     = Integer.parseInt(point.split("::")[0]);
                    int y = Integer.parseInt(point.split("::")[1]);
                    int id = Integer.parseInt(point.split("::")[2]);

                    board.getMatricePoint()[y][x]=id;
                }
                panel.repaint();
                Listener.tour = true;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
