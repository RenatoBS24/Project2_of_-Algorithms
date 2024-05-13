package Inicio.App;

import Inicio.PantallaPrincipal.PantallaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame inicio = new JFrame();
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
        inicio.setContentPane(pantallaPrincipal.getPantallaPrincipal());
        inicio.setSize(1280, 720);
        inicio.setVisible(true);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Hola");
    }
}
