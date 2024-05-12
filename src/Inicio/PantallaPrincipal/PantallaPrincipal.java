package Inicio.PantallaPrincipal;

import Inicio.InicioSesion.IniciarSesion;
import Inicio.Registrarse.Registrarse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal {
    private JLabel titulo;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;
    private JPanel PantallaPrincipal;

    public JLabel getTitulo () {
        return titulo;
    }

    public JButton getIniciarSesionButton() {
        return iniciarSesionButton;
    }

    public JButton getRegistrarseButton() {
        return registrarseButton;
    }

    public JPanel getPantallaPrincipal() {
        return PantallaPrincipal;
    }

    public PantallaPrincipal() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame inicioSesion = new JFrame();
                IniciarSesion iniciarSesion = new IniciarSesion();
                inicioSesion.setContentPane(iniciarSesion.getIniciarSesion());
                inicioSesion.setSize(1280,720);
                inicioSesion.setVisible(true);
                inicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registro = new JFrame();
                Registrarse registrarse = new Registrarse();
                registro.setContentPane(registrarse.getRegistro());
                registro.setSize(1280, 720);
                registro.setVisible(true);
                registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

}
