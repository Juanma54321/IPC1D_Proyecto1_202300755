
package Controller;
import View.DepositosVista;
import Model.Saldo;
import static Model.CrearCuenta.cuentas;
import Model.CrearCuenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorDepositos implements ActionListener{
    private Saldo model;
    private DepositosVista view;
    private CrearCuenta model2;
    
    //generando constructores
    public ControladorDepositos(Saldo model, DepositosVista view, CrearCuenta model2) {
        this.model = model;
        this.model2=model2;
        this.view = view;
        this.view.btnAceptar.addActionListener(this);
    }
    
    //metodo para llamar a la vista
    public void IniciarDeposito(){
        view.setVisible(true);
        view.setTitle("Depositos");
        view.setLocationRelativeTo(null);
    }
    
    //metodo para llenar lista con cuentas
    public void ActualizarDeposito(){
        view.CajaCuenta.removeAllItems();
        
        for (int i = 0; i < cuentas.size(); i++) {
            view.CajaCuenta.addItem(cuentas.get(i).getIdentificador()+" - "+ cuentas.get(i).getNombre()+" "+cuentas.get(i).getApellido());
        }
    }
    
    //accion que realizara el boton Aceptar
    public void actionPerformed(ActionEvent e) {
        float efectivo= Float.parseFloat(view.CajaMonto.getText());
        int contador = view.CajaCuenta.getSelectedIndex();
        
        if(efectivo>0 && cuentas.get(contador).getTransaccion().size()<=24){
            
            model.Deposito(efectivo,cuentas.get(contador).getIdentificador());
            JOptionPane.showMessageDialog(view,"Deposito hecho con Exito","Inf.",JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
        //mostrando error
        }else if(efectivo<=0){
            JOptionPane.showMessageDialog(view,"Cantidad no valida","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(view,"Cantidad max de transacciones para la cuenta","error", JOptionPane.ERROR_MESSAGE);
        
        }
    }
}
