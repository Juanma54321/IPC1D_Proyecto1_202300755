
package Controller;

import Model.CrearCuenta;
import static Model.CrearCuenta.bitacora;
import Model.CrearUsuario;
import static Model.InformacionLogin.nombreUsuario;
import static Model.CrearCuenta.cuentas;
import View.CrearCuentaVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorCrearCuenta implements ActionListener{
    private CrearCuenta model;
    private CrearCuentaVista view;
    private static byte contador=0; 

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
    //accion del boton Crear
    public void actionPerformed(ActionEvent f){
        int Selection;
        //se obtiene el index del combo box para identificar al cliente
        Selection=view.btnCliente.getSelectedIndex();
        
        //se obtiene los datos del cliente con el index
        Long cui = CrearUsuario.usuarios.get(Selection).getCUI();
        String nombre = CrearUsuario.usuarios.get(Selection).getNombreCliente();
        String apellido = CrearUsuario.usuarios.get(Selection).getApellidoCliente();
        
        //se verifica si el usuario no a exedido el numero de cuentas
        if (model.ContadordeCuentas(cui)) {
            model.GuardarCuenta(cui, nombre, apellido);
            JOptionPane.showMessageDialog(view,"Se Creo Correctamente una cuenta para: "+ nombre+" "+apellido+". Con el numero: "+ cuentas.get(contador).getIdentificador(),"Inf.",JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            //registrando la accion 
            bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario: "+nombreUsuario+" - Accion: Creacion de Cuenta  - Resultado: Exitoso - Detalles: Cuenta Creada con el nuemero '"+cuentas.get(contador).getIdentificador()+"' saldo inicial: Q0.00");
            contador++;
        }else{
            //notificando que se exedio el numero de cuentas
            JOptionPane.showMessageDialog(view,"El usuario: "+ nombre+" "+apellido+" a exedido el numero de cuentas", "ERROR", JOptionPane.ERROR_MESSAGE);
            //registrando la accion
            bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario: "+nombreUsuario+" - Accion: Creacion de Cuenta  - Resultado: Error - Detalles: Numero de cuentas maximo alcanzado para el usuario "+nombre+" "+apellido+" con CUI "+cui);
        }
    }    
}
