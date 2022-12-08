package main;

import controlleur.Joueur;
import controlleur.Listener;
import modele.Board;
import vue.Fenetre;
import vue.Panel;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.http.WebSocket;

public class Affichage {
    private static final int port = 7878;

    public static void main(String[] args) throws IOException {
        int reponse = JOptionPane.showConfirmDialog(null, "Host ?", "choice", JOptionPane.YES_NO_OPTION);

        Socket socket;
        int id = 1;
        String nom;
        if (reponse == JOptionPane.YES_OPTION) {
            ServerSocket sc = new ServerSocket(port);
            System.out.println("En attente de connexion");
            socket = sc.accept();
            Listener.tour = true;

            nom = "Host";

        }else {
            String ip = JOptionPane.showInputDialog("Adresse ip du server");
            System.out.println("Initialisation du connexion au serveur");
            socket = new Socket(ip,port);
            id = 2;

            nom = "Join";
        }

        Board board = new Board();
        Panel p = new Panel(board);
        Joueur j = new Joueur("Serveur",id,board);
        Listener listener = new Listener(p,j,board,socket);
        new ReceivePoint(board, p, socket);
        new Fenetre(nom, p, listener);
    }
}