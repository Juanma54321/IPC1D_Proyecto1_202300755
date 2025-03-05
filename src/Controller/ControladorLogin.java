
package Controller;

import Model.InformacionLogin;
import static Model.CrearCuenta.bitacora;
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
    //Accion que realizara el boton login
    public void actionPerformed(ActionEvent e){
        //obteniendo el usuario y la contraseña escritos
        modelo.setNombreUsuario(vista.UsuarioPrincipal.getText());
        modelo.setContrasena(vista.ContrasenaInicio.getText());
        
        //verificando que el usuario y la contraseña sean correctas
        if (modelo.ConfirmarInformacion(modelo.nombreUsuario, modelo.Contrasena)){
            //iniciado el controlador principal
            UserVista view1= new UserVista();
            ControladorPrincipal control1= new ControladorPrincipal(view1); 
            control1.ActualizarAyuda();
            control1.iniciarPrincipal();
            vista.dispose();
            
            //registrando la accion 
            bitacora.add(control1.HoraAccion()+" Usuario:"+modelo.nombreUsuario+" - Accion: inicio de sesion - Resultado: Exito - Detalles: Sesion iniciada correctamente");
            
        //mostrando error si no coinciden el nombre y la contraseña    
        }else{
            UserVista view1= new UserVista();
            ControladorPrincipal control1= new ControladorPrincipal(view1); 
            JOptionPane.showMessageDialog(vista,"Contraseña o Usuario Incorrecto","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
            //registrando la accion 
            bitacora.add(control1.HoraAccion()+" Usuario:"+modelo.nombreUsuario+" - Accion: inicio de sesion - Resultado: Error - Detalles: usuario o contraseña incorrectos");
            
        }
        
    }

    
}
