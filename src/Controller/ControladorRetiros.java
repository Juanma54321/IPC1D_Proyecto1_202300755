
package Controller;
import Model.CrearCuenta;
import static Model.CrearCuenta.bitacora;
import static Model.CrearCuenta.cuentas;
import Model.Saldo;
import static Model.InformacionLogin.nombreUsuario;
import View.RetirosVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorRetiros implements ActionListener {
    
    Saldo model;
    CrearCuenta model2;
    RetirosVista view;
    
    //generando constructores
    public ControladorRetiros(Saldo model, RetirosVista view, CrearCuenta model2) {
        this.model = model;
        this.view = view;
        this.model2=model2;
        this.view.btnAceptar.addActionListener(this);
    }
    //metodo para llamar a la vista
    public void IniciarRetiro(){
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setTitle("Retiros");
    }
    
    //metodo para llenar lista con cuentas
    public void ActualizarRetiros(){
        view.CajaCuenta.removeAllItems();
        
        for (int i = 0; i < cuentas.size(); i++) {
            view.CajaCuenta.addItem(cuentas.get(i).getIdentificador()+" - "+ cuentas.get(i).getNombre()+" "+cuentas.get(i).getApellido());
        }
    }
    //accion que realizasa el boton aceptar
    public void actionPerformed(ActionEvent e){
        
        float efectivo = Float.parseFloat(view.CajaMonto.getText());
        int contador = view.CajaCuenta.getSelectedIndex();
        
        //veririfacando fondos, si la cantidad ingresada es correcta y el numero de transaccion
        if(efectivo>0 && cuentas.get(contador).getSaldo()>=efectivo && cuentas.get(contador).getTransaccion().size()<=24){
            model.Retiros(efectivo, cuentas.get(contador).getIdentificador());
            JOptionPane.showMessageDialog(view,"Retiro hecho con Exito. Saldo Disponible: Q"+cuentas.get(contador).getSaldo(),"Inf.",JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
            //registrando la accion
            bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Retiro - Resultado: Exitoso - Detalles: Se retiro: Q"+view.CajaMonto.getText()+" a la cuenta: "+view.CajaCuenta.getItemAt(contador)+" saldo: Q" +cuentas.get(contador).getSaldo());  
            
        //saldo Insuficiente para el retiro
        }else if(cuentas.get(contador).getSaldo()<=efectivo){
            JOptionPane.showMessageDialog(view,"Saldo Insuficiente","ERROR",JOptionPane.ERROR_MESSAGE);
            //registrando la accion
            bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Retiro - Resultado: Error - Detalles: saldo insuficiente, se intento retirar: Q"+view.CajaMonto.getText()+" a la cuenta: "+view.CajaCuenta.getItemAt(contador)+" saldo: Q" +cuentas.get(contador).getSaldo());  
        //cantidad ingresada invalida  
        }else if(efectivo<=0){
            JOptionPane.showMessageDialog(view,"Cantidad invalida","error", JOptionPane.ERROR_MESSAGE);
            //registrando la accion
            bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Retiro - Resultado: Error - Detalles: cantidad ingresada invalida");
        }else{
            JOptionPane.showMessageDialog(view,"Cantidad max de transacciones para la cuenta","error", JOptionPane.ERROR_MESSAGE);
            //registrando la accion
            bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Retiro - Resultado: Error - Detalles: Cuenta alcanzo su numero maximo de transacciones");
        }
    }
    
}
