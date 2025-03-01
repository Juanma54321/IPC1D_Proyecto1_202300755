
package Controller;

import Model.CrearUsuario;
import static Model.CrearUsuario.usuarios;
import View.CrearUsuarioVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorCrearUsuario implements ActionListener  {
   
    private CrearUsuarioVista vista;
    private CrearUsuario modelo;

    public ControladorCrearUsuario(CrearUsuarioVista vista, CrearUsuario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnCrear.addActionListener(this);
        
    }
    public void InicializarUsuario(){
        vista.setTitle("Registrando Usuario");
        vista.setLocationRelativeTo(null);
 
    }
    
    public void actionPerformed(ActionEvent f){
        modelo.setNombreCliente(vista.txtNombre.getText());
        modelo.setApellidoCliente(vista.txtApellido.getText());
        
        //verificando si el CUI cumple con los requisitos
        //guardando el cui si cumple con los digitos y si no se repite
        if(modelo.LongitudCUI(vista.txtCUI.getText()) && modelo.VerificadorCUI(vista.txtCUI.getText()) && vista.txtCUI.getText().matches("\\d+")){
            modelo.setCUI(Long.parseLong(vista.txtCUI.getText()));
            modelo.GuardarUsuario(modelo.getCUI(), modelo.getNombreCliente(),modelo.getApellidoCliente());
            JOptionPane.showMessageDialog(vista,"Usuario Registrado con Exito","Inf.",JOptionPane.INFORMATION_MESSAGE);
            vista.dispose();
            
        }
        //alertando si el cui ya fue registrado
        else if(!modelo.VerificadorCUI(vista.txtCUI.getText())){
            JOptionPane.showMessageDialog(vista,"CUI ya registrado","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
        //alerteando que ingresaron un caracter no valido para el cui
        else{
            JOptionPane.showMessageDialog(vista,"El CUI no es valido","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        //borrar este control
        for (int i = 0; i < usuarios.size(); i++) {
           long n=usuarios.get(i).getCUI();
            System.out.println(n);
        }
       
        
    }

    
}
