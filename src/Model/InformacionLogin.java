
package Model;


public class InformacionLogin {
    public String Contrasena;
    public String nombreUsuario;
    
   
    String user1="AdministradorIPC1D";
    String password1="ipc1D1s2025";
    
    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public boolean ConfirmarInformacion(String nombre, String contrasena){
         return nombre.equals(user1) && contrasena.equals(password1);
    }
    
}
