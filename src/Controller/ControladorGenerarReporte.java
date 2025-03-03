
package Controller;
import static Model.CrearCuenta.cuentas;
import static Model.CrearUsuario.usuarios;
import Model.CrearCuenta;
import Model.Registros;
import View.ReporteVista;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControladorGenerarReporte implements ActionListener {
    ReporteVista view;
    Registros model;

    //generando contructores y acciones a los botones de la vista
    public ControladorGenerarReporte(ReporteVista view, Registros model) {
        this.view = view;
        this.model = model;
        this.view.btnHistorial.addActionListener(this);
        this.view.btndeposito.addActionListener(this);
        this.view.btnretiro.addActionListener(this);
    }
    
    //metodo refrescando tabla con usuarios
    public void IngresarUsuarios(){
        String cui, nombre, apellido;
        byte contador=0;
        
        for (int i = 0; i < usuarios.size(); i++) {
            
            
            cui=String.valueOf(usuarios.get(i).CUI);
            nombre=usuarios.get(i).getNombreCliente();
            apellido=usuarios.get(i).getApellidoCliente();
            
            this.view.tablaUusarios.setValueAt(cui, i, contador);
            contador++;
            this.view.tablaUusarios.setValueAt(nombre, i, contador);
            contador++;
            this.view.tablaUusarios.setValueAt(apellido, i, contador);
            contador=0;
        }
    }
    
   //metodo para iniciar vista generar reporte
    public void IniciarRegistro(){
        this.view.setVisible(true);
        this.view.setLocationRelativeTo(null);
        this.view.setTitle("Generador de Reportes");
    
    }
    
    public void actionPerformed(ActionEvent e){
        String opcion=e.getActionCommand();
        
        
        switch(opcion){
            
            //accion del boton Historial de transacciones
            case("historial"):
                
                Registros model= new Registros();
                long cui=Long.valueOf(view.cajaCUI.getText());
                
                String nombre, apellido;
                nombre="";
                apellido="";
                
                //obteniendo datos del CUI ingresado
                for (int i = 0; i < usuarios.size(); i++) {
                    if (cui==usuarios.get(i).getCUI()) {
                        nombre= usuarios.get(i).getNombreCliente();
                        apellido= usuarios.get(i).getApellidoCliente();
                        break;
                    }
                }
                
                //generando el nombre del pdf con los reportes de transacciones
                String NombreArchivo="HistorialTransacciones"+model.NombrePDf();
                
                //ruta donde se guardara el reporte generado en pdf
                String rutaProyecto = System.getProperty("user.dir");
                //guardando el pdf
                String rutaArchivo = rutaProyecto + File.separator + NombreArchivo+".pdf";
                
                //creando el pdf nuevo
                Document document = new Document();
                try{
                    PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
                    document.open();
                    document.add(new Paragraph("Cuentas del usuario: "+nombre+" "+apellido+". Y CUI: "+cui));
                    for (int i = 0; i < cuentas.size(); i++) {
                        //obteniendo solo las cuentas con el mismo CUI
                        if (cui==cuentas.get(i).getCUI()) {
                            String cuenta;
                            cuenta=cuentas.get(i).getIdentificador();
                            document.add(new Paragraph("cuenta No."+cuenta));
                            
                            for (int j = 0; j < cuentas.get(i).getTransaccion().size(); j++) {
                                String texto;
                                //generando el texto para cada transaccion
                                texto= "["+cuentas.get(i).getID().get(j)+"] "+cuentas.get(i).getHora().get(j)+" - "+cuentas.get(i).getTransaccion().get(j)+"   Q"+cuentas.get(i).getEfectivo().get(j);
                                
                                document.add(new Paragraph(texto));  
                            }
                            document.add(new Paragraph());
                            
                        }
                        
                    }
                    document.add(new Paragraph());
                    document.close();
                    System.out.println("pdf creado");
                }catch(DocumentException | IOException f){
                    f.printStackTrace();
                }
            
            break;
            
            //accion del boton Historial de Depositos
            case("deposito"):
                Registros model1= new Registros();
                long cui1=Long.valueOf(view.cajaCUI.getText());
                //creando variables utilizadas para el manejo de datos
                String nombre1, apellido1;
                nombre1="";
                apellido1="";
                
                //obteniendo datos del CUI ingresado
                for (int i = 0; i < usuarios.size(); i++) {
                    if (cui1==usuarios.get(i).getCUI()) {
                        nombre1= usuarios.get(i).getNombreCliente();
                        apellido1= usuarios.get(i).getApellidoCliente();
                        break;
                    }
                }
                //generando el nombre del pdf con los reportes de transacciones
                String NombreArchivo1="reporteDepositos"+model1.NombrePDf();
                 //ruta donde se guardara el reporte generado en pdf
                String rutaProyecto1 = System.getProperty("user.dir");
                //guardando el pdf
                String rutaArchivo1 = rutaProyecto1 + File.separator + NombreArchivo1+".pdf";
                
                //creando el pdf nuevo
                Document document1 = new Document();
                try{
                    PdfWriter.getInstance(document1, new FileOutputStream(rutaArchivo1));
                    document1.open();
                    document1.add(new Paragraph("Cuentas del usuario: "+nombre1+" "+apellido1+". Y CUI: "+cui1));
                    for (int i = 0; i < cuentas.size(); i++) {
                        //obteniendo las cuentas con el mismo CUI
                        if (cui1==cuentas.get(i).getCUI()) {
                            String cuenta;
                            cuenta=cuentas.get(i).getIdentificador();
                            document1.add(new Paragraph("cuenta No."+cuenta));
                            
                            for (int j = 0; j < cuentas.get(i).getTransaccion().size(); j++) {
                               //obteniendo solo las transacciones con informacion de deposito
                                if (cuentas.get(i).getTransaccion().get(j).equals("Deposito")) {
                                    String texto;
                                    //generando texto para solo los depositos
                                    texto= "["+cuentas.get(i).getID().get(j)+"] "+cuentas.get(i).getHora().get(j)+" - "+cuentas.get(i).getTransaccion().get(j)+"   Q"+cuentas.get(i).getEfectivo().get(j);
                                    document1.add(new Paragraph(texto)); 
                                }
                                
                                 
                            }
                            document1.add(new Paragraph());
                            
                        }
                        
                    }
                    document1.add(new Paragraph());
                    document1.close();
                    System.out.println("pdf creado");
                }catch(DocumentException | IOException g){
                    g.printStackTrace();
                }
                
            break;
            
            //accion del boton Historial de Retiros
            case("retiro"):
                Registros model2= new Registros();
                long cui2=Long.valueOf(view.cajaCUI.getText());
                //creando nuestras variables para el manejo de datos
                String nombre2, apellido2;
                nombre2="";
                apellido2="";
                
                //obteniendo datos del CUI ingresado
                for (int i = 0; i < usuarios.size(); i++) {
                    if (cui2==usuarios.get(i).getCUI()) {
                        nombre2= usuarios.get(i).getNombreCliente();
                        apellido2= usuarios.get(i).getApellidoCliente();
                        break;
                    }
                }
                //generando el nombre del pdf con los reportes de transacciones
                String NombreArchivo2="reporteRetiros"+model2.NombrePDf();
                 //ruta donde se guardara el reporte generado en pdf
                String rutaProyecto2 = System.getProperty("user.dir");
                //guardando el pdf
                String rutaArchivo2 = rutaProyecto2 + File.separator + NombreArchivo2+".pdf";
                
                //creando el pdf nuevo
                Document document2 = new Document();
                try{
                    PdfWriter.getInstance(document2, new FileOutputStream(rutaArchivo2));
                    document2.open();
                    document2.add(new Paragraph("Cuentas del usuario: "+nombre2+" "+apellido2+". Y CUI: "+cui2));
                    for (int i = 0; i < cuentas.size(); i++) {
                        //obteniendo las cuentas con el mismo CUI
                        if (cui2==cuentas.get(i).getCUI()) {
                            String cuenta;
                            cuenta=cuentas.get(i).getIdentificador();
                            document2.add(new Paragraph("cuenta No."+cuenta));
                            
                            for (int j = 0; j < cuentas.get(i).getTransaccion().size(); j++) {
                                //obteniendo solo las transacciones denominadas como retiros
                                if (cuentas.get(i).getTransaccion().get(j).equals("Retiro")) {
                                    String texto;
                                    //generando texto para solo los retiros
                                    texto= "["+cuentas.get(i).getID().get(j)+"] "+cuentas.get(i).getHora().get(j)+" - "+cuentas.get(i).getTransaccion().get(j)+"   Q"+cuentas.get(i).getEfectivo().get(j);
                                    document2.add(new Paragraph(texto)); 
                                }
                                
                                 
                            }
                            document2.add(new Paragraph());
                            
                        }
                        
                    }
                    document2.add(new Paragraph());
                    document2.close();
                    System.out.println("pdf creado");
                }catch(DocumentException | IOException u){
                    u.printStackTrace();
                }
            break;    
        }
        
        
    }
    
    
    
    
}


