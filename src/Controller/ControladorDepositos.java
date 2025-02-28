
package Controller;
import View.DepositosVista;
import Model.Saldo;
import static Model.CrearCuenta.cuentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorDepositos implements ActionListener{
    Saldo model;
    DepositosVista view;
    
    //generando constructores
    public ControladorDepositos(Saldo model, DepositosVista view) {
        this.model = model;
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
            view.CajaCuenta.addItem(cuentas.get(i).getIdentificador()+" - "+ cuentas.get(i).getDueño());
        }
    }
    
    //accion que realizara el boton Aceptar
    public void actionPerformed(ActionEvent e) {
        
        if(Integer.parseInt(view.CajaMonto.getText())>0){
            model.Deposito(Integer.parseInt(view.CajaMonto.getText()),cuentas.get(view.CajaCuenta.getSelectedIndex()).getIdentificador());
            JOptionPane.showMessageDialog(view,"Deposito hecho con Exito","Inf.",JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
        //mostrando error
        }else{
            JOptionPane.showMessageDialog(view,"Cantidad no valida","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
