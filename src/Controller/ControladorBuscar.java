
package Controller;
import View.BuscarCuentasVista;
import Model.CrearCuenta;
import Model.CrearUsuario;
import static Model.CrearUsuario.usuarios;
import static Model.CrearCuenta.cuentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class ControladorBuscar implements ActionListener {
    private BuscarCuentasVista vista;
    
    
    //generando contructor
    public ControladorBuscar(BuscarCuentasVista vista) {
        this.vista = vista;
        this.vista.BtnBuscar.addActionListener(this);
    }
    
    
    //metodo para ingresar usuarios en la tabla 
    public void RefrescarTabla(){
        CrearUsuario model = new CrearUsuario();
            
        for (byte filas = 0; filas < usuarios.size(); filas++) {
            byte columnas=0;
            model=usuarios.get(filas);
        
            this.vista.Tabla1.setValueAt(model.getCUI(), filas, columnas);
            columnas++;
            this.vista.Tabla1.setValueAt(model.getNombreCliente(), filas, columnas);
            columnas++;
            this.vista.Tabla1.setValueAt(model.getApellidoCliente(), filas, columnas);    
        }
    }
    
    //metodo para refrescar la tabla de cuentas
    public void RegrescarTablaCuentas(){
        int contador=0;
        vista.TablaCuentas.removeAll();
        
        if(cuentas.size()!=0){
            for (int i = 0; i < cuentas.size(); i++) {
                if(Long.parseLong(this.vista.CajaCUI.getText())==cuentas.get(i).getCUI()){
            
                    CrearCuenta model=new CrearCuenta();
            
                    model=cuentas.get(i);
                    this.vista.TablaCuentas.setValueAt(model.getIdentificador(), contador,0);
                    contador++;
                }   
            }
        }
        if(contador==0){
            for (int i = 0; i < cuentas.size(); i++) {
                this.vista.TablaCuentas.setValueAt(" ", i, 0);
            }
            }
    }
    
    //metodo para iniciar la ventana Buscar cuentas
    public void IniciarBuscar(){
        vista.setTitle("Buscador de Cuentas");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    //accion del boton Buscar
    public void actionPerformed(ActionEvent f){
        ControladorBuscar control = new ControladorBuscar(vista);
        control.RegrescarTablaCuentas();
    }
}
