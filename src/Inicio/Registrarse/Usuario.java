package Inicio.Registrarse;

public class Usuario {
    private String nombreUsuario;
    private String correoElectronico;
    private String contrasenia;

    public Usuario(String nombreUsuario, String correoElectronico, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    // Getters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
