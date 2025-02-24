
package Controller;

import Model.InformacionLogin;
import View.LoginVista;
import View.UserVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {
    private LoginVista vista;
    private InformacionLogin modelo;
    

    public ControladorLogin(LoginVista vista, InformacionLogin modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.BtnLogin.addActionListener(this);
    }
    
    public void iniciarLogin(){
        vista.setTitle("Inicio de Sesion");
        vista.setLocationRelativeTo(null);
    
    }
    public void actionPerformed(ActionEvent e){
        modelo.setNombreUsuario(vista.UsuarioPrincipal.getText());
        modelo.setContrasena(vista.ContrasenaInicio.getText());
        
        
        if (modelo.ConfirmarInformacion(modelo.nombreUsuario, modelo.Contrasena)) {
            vista.dispose();
            UserVista vista2= new UserVista();
            
            vista2.setTitle("Pagina Principal");
            vista2.setLocationRelativeTo(null);
            vista2.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(vista,"Contraseña o Usuario Incorrecto","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
        
    }

    
}
