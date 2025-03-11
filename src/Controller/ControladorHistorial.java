
package Controller;
import View.HistorialVista;
import Model.CrearCuenta;
import static Model.CrearCuenta.bitacora;
import static Model.CrearCuenta.cuentas;
import static Model.InformacionLogin.nombreUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorHistorial implements ActionListener {
    
    private CrearCuenta model;
    private HistorialVista view;

    //generando constructor para el controlador
    public ControladorHistorial(CrearCuenta model, HistorialVista view) {
        this.model = model;
        this.view = view;
        this.view.btnBuscar.addActionListener(this);
    }
    
    //metodo para llamar a la pestaña historial
    public void IniciarHistorial(){
        view.setLocationRelativeTo(null);
        view.setTitle("Historial de Transacciones");
        view.setVisible(true);
        view.TablaInfo.removeAll();
    }
    //accion que realisara el boton buscar
    public void actionPerformed(ActionEvent e){
        String identificador = view.cajaIdentificador.getText();
        byte ContadorDinamico = 0;
        //vaciando todas las celdas de la tablaInfo
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 6; j++) {
                view.TablaInfo.setValueAt(" ",i,j);
            }
        }
        
        
        //ingresando valores a las variables de la tabla
        for (int i = 0; i < cuentas.size(); i++) {
            //buscando la cuenta en el arraylist de cuentas
            if (cuentas.get(i).getIdentificador().equals(identificador)) {
                //generando varaibles utilizadas para llenar la tabla de informacion
                String id, fecha, detalle, debito, credito,nombre,apellido,cui;
                float saldodisponible=0;
                
                
                int contadortamano = cuentas.get(i).getID().size();
                //buscando todas las transacciones de la cuenta solicitada
                for (int j = 0; j < contadortamano; j++) {
                    id=cuentas.get(i).getID().get(j);
                    fecha=cuentas.get(i).getHora().get(j);
                    detalle=cuentas.get(i).getTransaccion().get(j);
                    
                    //ingresando las transacciones de deposito
                    if (detalle.equals("Deposito")) {
                        credito=String.valueOf(cuentas.get(i).getEfectivo().get(j));
                            byte contador=0;
                        
                            this.view.TablaInfo.setValueAt(id,j, contador);
                            contador++;
                            this.view.TablaInfo.setValueAt(fecha, j, contador);
                            contador++;
                            this.view.TablaInfo.setValueAt(detalle, j, contador);
                            contador++;
                            this.view.TablaInfo.setValueAt("0.00", j, contador);
                            contador++;
                            this.view.TablaInfo.setValueAt(credito, j, contador);
                            contador++;
                            saldodisponible= saldodisponible + Float.parseFloat(credito);
                            this.view.TablaInfo.setValueAt(String.valueOf(saldodisponible),j,contador);
                            ContadorDinamico++;
                    //ingresando las transacciones de retiro
                    }else{
                        debito=String.valueOf(cuentas.get(i).getEfectivo().get(j));
                            byte contador=0;
                            
                            this.view.TablaInfo.setValueAt(id, j, contador);
                            contador++;
                            this.view.TablaInfo.setValueAt(fecha, j, contador);
                            contador++;
                            this.view.TablaInfo.setValueAt(detalle, j, contador);
                            contador++;
                            this.view.TablaInfo.setValueAt(debito,j,contador);
                            contador++;
                            this.view.TablaInfo.setValueAt("0.00",j,contador);
                            contador++;
                            saldodisponible= saldodisponible -Float.valueOf(debito);
                            this.view.TablaInfo.setValueAt(String.valueOf(saldodisponible),j,contador);
                            ContadorDinamico++;
                            
                    } 
                    
                }
                //actualizando cajas que contienen el CUI, nombre y apellido
                nombre=cuentas.get(i).getNombre();
                apellido=cuentas.get(i).getApellido();
                cui=String.valueOf(cuentas.get(i).getCUI());
                
                view.cajaCUI.setText(cui);
                view.cajaNombre.setText(nombre);
                view.cajaApellido.setText(apellido);
                //registrando la accion
                bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario: "+nombreUsuario+" - Accion: Buscar Transacciones - Resultado: Exitoso - Detalles: Historial encontrado para la cuenta "+view.cajaIdentificador.getText());
                
                
                break;
            }
        }
        if (ContadorDinamico==0) {
            view.cajaApellido.setText("*******************************");
            view.cajaNombre.setText("*****************");
            view.cajaCUI.setText("******************************");
            JOptionPane.showMessageDialog(view,"No existen transacciones para la cuenta seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            //registrando la accion
            bitacora.add(ControladorPrincipal.HoraAccion()+" Usuario: "+nombreUsuario+" - Accion: Buscar Transacciones - Resultado: Error- Detalles: Historial no encontrado para la cuenta "+view.cajaIdentificador.getText());
                
        }
        
        
        
        
        
    }

    
    
    
    
    
}
