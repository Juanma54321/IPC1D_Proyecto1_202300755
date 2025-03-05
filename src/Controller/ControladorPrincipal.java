
package Controller;

import Model.CrearCuenta;
import static Model.CrearCuenta.bitacora;
import Model.CrearUsuario;
import Model.Saldo;
import Model.Registros;

import View.CrearCuentaVista;
import View.CrearUsuarioVista;
import View.UserVista;
import View.BuscarCuentasVista;
import View.DepositosVista;
import View.RetirosVista;
import View.HistorialVista;
import View.ReporteVista;
import View.BitacoraVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


import static Model.CrearUsuario.usuarios;
import static Model.CrearCuenta.cuentas;
import static Model.InformacionLogin.nombreUsuario;
import java.util.Calendar;



//precionar Boton Registrar Usuario
public class ControladorPrincipal implements ActionListener {
    private UserVista vista;
    public static String Hora;
    
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
        this.vista.btnGenerar.addActionListener(this);
        this.vista.CajaAyuda.addActionListener(this);
    }
    //metodo para iniciar la pestaña principal
    public void iniciarPrincipal(){
        vista.setTitle("Menu Principla (Modo Administrador)");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    //metodo para ingresar datos al combobox de ayuda
    public void ActualizarAyuda(){
        
        vista.CajaAyuda.removeAllItems();
        vista.CajaAyuda.addItem("Ayuda");
        vista.CajaAyuda.addItem("Datos del Estudiante");
        vista.CajaAyuda.addItem("Generacion de Bitacora");
    }
    
    //metodo para registar la hora de cualquier accion
    public static String HoraAccion(){
         //generando las variables para obtener el tiempo 
                Calendar Fecha =  Calendar.getInstance();
                Calendar Hora =  Calendar.getInstance();
                //variables que almacenaran cada dato del tiempo
                int hora, minutos,dia,mes,ano;
                //asignando cada instante en su respectiva variable
                hora=Hora.get(Calendar.HOUR_OF_DAY);
                minutos=Hora.get(Calendar.MINUTE);
                dia=Fecha.get(Calendar.DAY_OF_MONTH);
                mes=Fecha.get(Calendar.MONTH)+1;
                ano=Fecha.get(Calendar.YEAR);
                //concatenando todo en una variable
                String momento;
                momento="["+String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(ano)+"  "+String.valueOf(hora)+":"+String.valueOf(minutos)+"]";
                
                return momento; 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion;
        opcion = e.getActionCommand();
        int index= vista.CajaAyuda.getSelectedIndex();
        
        //navegador entre los botones
        switch(opcion){
            
            //accion del boton Registro de Usuario
            case ("Registro de Usuario"):
                if(usuarios.size()<6){
                CrearUsuarioVista view1 = new CrearUsuarioVista();
                CrearUsuario model1 = new CrearUsuario();
                
                ControladorCrearUsuario control1 = new ControladorCrearUsuario(view1,model1);
                control1.InicializarUsuario();
                view1.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(vista,"Numero maximo de usuarios alcanzado","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    //registrando la accion 
                    bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Registar Usuario - Resultado: Error - Detalles: Numero de Usuarios maximo alcanzados");
                
                }
            break;    
            
            //accion del boton Crear Cuenta
            case ("Crear Cuenta"):
                //verificando que ya existan usuarios registrados
                if(usuarios.size()!=0){
                    CrearCuenta model2= new CrearCuenta();
                    CrearCuentaVista view2 = new CrearCuentaVista();

                    ControladorCrearCuenta control2 = new ControladorCrearCuenta(model2,view2);
                    control2.Actualizar();
                    control2.InicializarCuenta();
                }else{
                    JOptionPane.showMessageDialog(vista,"No Existen Usuarios Registrados","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    //registrando la accion 
                    bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Crear Cuenta - Resultado: Error - Detalles: No existen cuentas Asociadas para acceder");
                
                }
            break;
            
            //accion del boton Retiros
            case ("Retiros"):
                if(cuentas.size()!=0){
                    Saldo model4=new Saldo();
                    RetirosVista view4=new RetirosVista();
                    CrearCuenta model5=new CrearCuenta();
                    
                    ControladorRetiros control4 = new ControladorRetiros(model4,view4,model5);
                    control4.ActualizarRetiros();
                    control4.IniciarRetiro();
                }else{
                    JOptionPane.showMessageDialog(vista,"No Existen Cuentas Asociadas","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    //registrando la accion 
                    bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Retiros - Resultado: Error - Detalles: No existen cuentas Asociadas para acceder");
                }
                
            break;
            //accion del boton Depositos
            case ("Depositos"):
                if(!cuentas.isEmpty()){
                    Saldo model3= new Saldo();
                    DepositosVista view3 = new DepositosVista();  
                    CrearCuenta model4= new CrearCuenta();
                    ControladorDepositos control3 =new ControladorDepositos(model3,view3,model4);
                
                    control3.ActualizarDeposito();
                    control3.IniciarDeposito();
                }else{
                    JOptionPane.showMessageDialog(vista,"No Existen Cuentas Asociadas","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    //registrando la accion 
                    bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Depositos - Resultado: Error - Detalles: No existen cuentas Asociadas para acceder");
                
                }     
            break;
            
            //accion del boton Buscar Cuentas
            case("Buscar Cuentas"):
                if(CrearCuenta.cuentas.size()!=0){
                    BuscarCuentasVista view4 = new BuscarCuentasVista();
                    
                    ControladorBuscar control3 = new ControladorBuscar(view4);
                    control3.RefrescarTabla();
                    control3.IniciarBuscar();
                    
                }else{
                    JOptionPane.showMessageDialog(vista,"No Existen Cuentas Asociadas","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    //registrando la accion 
                    bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Buscar Cuentas Asociadas - Resultado: Error - Detalles: No existen cuentas Asociadas para acceder");
                
                }
            break;
                
            //accion del boton Historial de transacciones
            case ("Historial"):
                if(CrearCuenta.cuentas.size()!=0){
                    HistorialVista view4 = new HistorialVista();
                    CrearCuenta model1 = new CrearCuenta();
                    
                    ControladorHistorial control = new ControladorHistorial(model1,view4);
                    
                    control.IniciarHistorial();
                    
                }else{
                    JOptionPane.showMessageDialog(vista,"No Existen Cuentas Asociadas","AVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    //registrando la accion 
                    bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Acceder al Historial - Resultado: Error - Detalles: No existen cuentas Asociadas para acceder");
                }
            break; 
            //accion del boton Generar reporte
            case("Generar"):
                if (!cuentas.isEmpty()) {
                    Registros model = new Registros();
                    ReporteVista view = new ReporteVista();
                    
                    ControladorGenerarReporte control = new  ControladorGenerarReporte (view, model);
                    
                    control.IngresarUsuarios();
                    control.IniciarRegistro();
                    
                }else{
                    JOptionPane.showMessageDialog(vista, "No Existen Cuentas Asociadas","AVERTENCIA ", JOptionPane.INFORMATION_MESSAGE);
                    //registrando la accion 
                    bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario:"+nombreUsuario+" - Accion: Generar Reportes - Resultado: Error - Detalles: No existen cuentas Asociadas para acceder");
                
                }
            break;
        }
        //opciones del combo box de ayuda
        if (index==2) {
            //opcion de mostrar la bitacora
            BitacoraVista view = new BitacoraVista();
            view.setLocationRelativeTo(null);
            view.setVisible(true);
            //ingresando los datos registrados hasta el momento de la bitacora
            for (int i = 0; i < bitacora.size(); i++) {
                view.TablaBitacora.setValueAt(bitacora.get(i), i, 0);
            }
            index=0;
            vista.CajaAyuda.setSelectedIndex(index);
        }else if(index==1){
            //mostrando datos del estudiante
            JOptionPane.showMessageDialog(vista,"Juan Manuel De León 202300755", "CREDITOS",JOptionPane.INFORMATION_MESSAGE);
            index=0;
            vista.CajaAyuda.setSelectedIndex(index);
        }
        
    
    }
    
}
