
package Controller;

import Model.CrearCuenta;
import Model.CrearUsuario;
import View.CrearCuentaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorCrearCuenta implements ActionListener{
    private CrearCuenta model;
    private CrearCuentaVista view;

    public ControladorCrearCuenta(CrearCuenta model, CrearCuentaVista view) {
        this.model = model;
        this.view = view;
        this.view.btnCrear.addActionListener(this);
    }
    //metodo para inciar la ventana
    public void InicializarCuenta(){
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
    //metodo para actualizar el combo box
    public void Actualizar(){
        view.btnCliente.removeAllItems();
        
        for (int i = 0; i < CrearUsuario.usuarios.size(); i++) {
            view.btnCliente.addItem(String.valueOf(CrearUsuario.usuarios.get(i).getCUI()+" - "+CrearUsuario.usuarios.get(i).getNombreCliente()+" "+CrearUsuario.usuarios.get(i).getApellidoCliente()));
        }
    
    }
    
    public void actionPerformed(ActionEvent f){
        int Selection;
        
        Selection=view.btnCliente.getSelectedIndex();
        model.GuardarCuenta(CrearUsuario.usuarios.get(Selection).getCUI() ,CrearUsuario.usuarios.get(Selection).getNombreCliente()+" "+ CrearUsuario.usuarios.get(Selection).getApellidoCliente());
    
        JOptionPane.showMessageDialog(view,"Se Creo Correctamente una cuenta para: "+ CrearUsuario.usuarios.get(Selection).getNombreCliente()+" "+CrearUsuario.usuarios.get(Selection).getApellidoCliente(),"Inf.",JOptionPane.INFORMATION_MESSAGE);
        view.dispose();
        
        
        
        
        
        
        
        
        
        
        
        
        //borrar este control
        System.out.println("El Usuario "+ CrearUsuario.usuarios.get(Selection).getNombreCliente() + " tiene estas cuentas");
        for (int i = 0; i <CrearCuenta.cuentas.size(); i++) {
            
            if (CrearUsuario.usuarios.get(Selection).getCUI() == CrearCuenta.cuentas.get(i).getCUI()) {
                System.out.println(CrearCuenta.cuentas.get(i).getCUI() +" "+ CrearCuenta.cuentas.get(i).getIdentificador());
            }
            
        }
        
    
    }
        
        
    
    
    
    
    
    
    
    
    
    
}
