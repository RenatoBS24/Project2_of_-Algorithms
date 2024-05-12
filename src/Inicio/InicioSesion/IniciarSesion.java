package Inicio.InicioSesion;

import Inicio.PantallaPrincipal.PantallaPrincipal;
import Inicio.Registrarse.Registrarse;
import Inicio.Registrarse.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesion {
    private JPasswordField ingresarContraseniaPasswordField;
    private JTextField ingresarNombreUsuarioTextField;
    private JButton registrarseButton;
    private JButton iniciarSesionButton;
    private JPanel IniciarSesion;
    private JButton regresarButton;
    private JCheckBox verContraseniaCheckBox;

    public JPasswordField getIngresarContraseniaPasswordField() {
        return ingresarContraseniaPasswordField;
    }

    public JTextField getIngresarNombreUsuarioTextField() {
        return ingresarNombreUsuarioTextField;
    }

    public JButton getRegistrarseButton() {
        return registrarseButton;
    }

    public JButton getIniciarSesionButton() {
        return iniciarSesionButton;
    }

    public JPanel getIniciarSesion() {
        return IniciarSesion;
    }

    public IniciarSesion() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = ingresarNombreUsuarioTextField.getText();
                String contrasenia = new String(ingresarContraseniaPasswordField.getPassword());

                boolean inicioSesionExitoso = false;
                for (Usuario usuario : Registrarse.getListaUsuarios()) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                        inicioSesionExitoso = true;
                        break;
                    }
                }
                if (inicioSesionExitoso) {
                    JOptionPane.showMessageDialog(null, "Usuario Validado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario NO valido");
                }
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(IniciarSesion);
                frame.dispose();

                JFrame registro = new JFrame();
                Registrarse registrarse = new Registrarse();
                registro.setContentPane(registrarse.getRegistro());
                registro.setSize(1280, 720);
                registro.setVisible(true);
                registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(IniciarSesion);
                frame.dispose();

                JFrame inicio = new JFrame();
                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                inicio.setContentPane(pantallaPrincipal.getPantallaPrincipal());
                inicio.setSize(1280, 720);
                inicio.setVisible(true);
                inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        verContraseniaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verContraseniaCheckBox.isSelected();
                if(verContraseniaCheckBox.isSelected()){
                    ingresarContraseniaPasswordField.setEchoChar((char) 0);
                } else{
                    ingresarContraseniaPasswordField.setEchoChar('*');
                }
            }
        });
    }
}
