
package Controller;
import Model.CrearCuenta;
import Model.CrearUsuario;
import View.CrearCuentaVista;
import View.CrearUsuarioVista;
import View.UserVista;
import View.BuscarCuentasVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;




//precionar Boton Registrar Usuario
public class ControladorPrincipal implements ActionListener {
    private UserVista vista;
    
    //constructor del controlador Principal
    public ControladorPrincipal(UserVista vista){
        this.vista = vista;
        
        //agregando eventos a cada boton del menu principal
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnDepositos.addActionListener(this);
        this.vista.btnRegistro.addActionListener(this);
        this.vista.btnRetiros.addActionListener(this);
        this.vista.btnBuscarCuentas.addActionListener(this);
        this.vista.btnHistorial.addActionListener(this);
    }
    //metodo para iniciar la pestaña principal
    public void iniciarPrincipal(){
        vista.setTitle("Menu Principla (Modo Administrador)");
        vista.setLocationRelativeTo(null);
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
        String opcion;
        opcion = e.getActionCommand();
        
        //borrar este control 
        System.out.println(opcion);
        
        //navegador entre los botones
        switch(opcion){
            
            //accion del boton Registro de Usuario
            case ("Registro de Usuario"):
                if(CrearUsuario.usuarios.size()<6){
                CrearUsuarioVista view1 = new CrearUsuarioVista();
                CrearUsuario model1 = new CrearUsuario();
                
                ControladorCrearUsuario control1 = new ControladorCrearUsuario(view1,model1);
                control1.InicializarUsuario();
                view1.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(vista,"Numero maximo de usuarios alcanzado","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }
            break;    
            
            //accion del boton Crear Cuenta
            case ("Crear Cuenta"):
                //verificando que ya existan usuarios registrados
                if(CrearUsuario.usuarios.size()!=0){
                    CrearCuenta model2= new CrearCuenta();
                    CrearCuentaVista view2 = new CrearCuentaVista();

                    ControladorCrearCuenta control2 = new ControladorCrearCuenta(model2,view2);
                    control2.Actualizar();
                    control2.InicializarCuenta();
                }else{
                    JOptionPane.showMessageDialog(vista,"No Existen Usuarios Registrados","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }
            break;
            
            //accion del boton Retiros
            case ("Retiros"):
                
                
                
                
            break;
            
            case("Buscar Cuentas"):
                if(CrearCuenta.cuentas.size()!=0){
                    BuscarCuentasVista view4 = new BuscarCuentasVista();
                    
                    ControladorBuscar control3 = new ControladorBuscar(view4);
                    control3.RefrescarTabla();
                    control3.IniciarBuscar();
                    
                }else{
                    JOptionPane.showMessageDialog(vista,"No Existen Usuarios Registrados","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                }
                
                
        }
        
        
    
    }
}
