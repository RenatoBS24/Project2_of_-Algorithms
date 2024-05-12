package Inicio.Registrarse;

import Inicio.InicioSesion.IniciarSesion;
import Inicio.PantallaPrincipal.PantallaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Registrarse {
    private JPanel Registro;
    private JButton registrarseButton;
    private JButton iniciarSesionButton;
    private JTextField ingresarNombreDelUsuarioTextField;
    private JTextField ingresarCorreoElectronicoTextField;
    private JTextField ingresarContraseniaTextField;
    private JButton regresarButton;

    public static List<Usuario> listaUsuarios = new ArrayList<>();

    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public JPanel getRegistro() {
        return Registro;
    }

    public JButton getRegistrarseButton() {
        return registrarseButton;
    }

    public JButton getIniciarSesionButton() {
        return iniciarSesionButton;
    }

    public JTextField getIngresarNombreDelUsuarioTextField() {
        return ingresarNombreDelUsuarioTextField;
    }

    public JTextField getIngresarCorreoElectronicoTextField() {
        return ingresarCorreoElectronicoTextField;
    }

    public JTextField getIngresarContraseniaTextField() {
        return ingresarContraseniaTextField;
    }

    public Registrarse() {
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = ingresarNombreDelUsuarioTextField.getText();
                String correoElectronico = ingresarCorreoElectronicoTextField.getText();
                String contrasenia = ingresarContraseniaTextField.getText();
                Usuario nuevoUsuario = new Usuario(nombreUsuario, correoElectronico, contrasenia);
                listaUsuarios.add(nuevoUsuario);

                JOptionPane.showMessageDialog(null, "Usurio Registrado");
            }
        });
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Registro);
                frame.dispose();

                JFrame inicioSesion = new JFrame();
                IniciarSesion iniciarSesion = new IniciarSesion();
                inicioSesion.setContentPane(iniciarSesion.getIniciarSesion());
                inicioSesion.setSize(1280,720);
                inicioSesion.setVisible(true);
                inicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Registro);
                frame.dispose();

                JFrame inicio = new JFrame();
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                inicio.setContentPane(pantallaPrincipal.getPantallaPrincipal());
                inicio.setSize(1280, 720);
                inicio.setVisible(true);
                inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
