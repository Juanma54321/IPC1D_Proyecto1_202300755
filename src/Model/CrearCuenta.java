
package Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class CrearCuenta {
    private String Identificador;
    private float Saldo;
    private Long CUI;
    private String Nombre;
    private String Apellido;
    
    private static int contador=0;
    private static int contador2=1000;
    
    private ArrayList<String> hora;
    private ArrayList<Float> Efectivo;
    private ArrayList<String> Transaccion;
    private ArrayList<String> ID;
    

    //array donde estaran todas las cuentas y la bitacora
    public static ArrayList<CrearCuenta> cuentas = new ArrayList<>();
    public static ArrayList<String> bitacora = new ArrayList<>();
    
    //set and get de cada atributo de la clase
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    public ArrayList<Float> getEfectivo() {
        return Efectivo;
    }

    public void setEfectivo(ArrayList<Float> Efectivo) {
        this.Efectivo = Efectivo;
    }
    
    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        CrearCuenta.contador = contador;
    }

    public ArrayList<String> getTransaccion() {
        return Transaccion;
    }

    public void setTransaccion(ArrayList<String> Transaccion) {
        this.Transaccion = Transaccion;
    }

    public ArrayList<String> getHora() {
        return hora;
    }

    public void setHora(ArrayList<String> hora) {
        this.hora = hora;
    }

    public ArrayList<String> getID() {
        return ID;
    }

    public void setID(ArrayList<String> ID) {
        this.ID = ID;
    }

    public static ArrayList<CrearCuenta> getCuentas() {
        return cuentas;
    }

    public static void setCuentas(ArrayList<CrearCuenta> cuentas) {
        CrearCuenta.cuentas = cuentas;
    }
    
    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    public Long getCUI() {
        return CUI;
    }

    public void setCUI(Long CUI) {
        this.CUI = CUI;
    }
    
    //metodo para registrar transaccion
    public void Registro(String accion, String identificador,Float cantidad){
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getIdentificador().equals(identificador)) {
                //variable usada para el ID de cada transaccion
                contador2++;
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
                momento=String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(ano)+"  "+String.valueOf(hora)+":"+String.valueOf(minutos);
                //agregando el tiempo al arraylist de hora
                cuentas.get(i).getHora().add(momento);
                //guardando que tipo de transaccion fue y la cantidad en sus respectivos arraylist
                cuentas.get(i).getTransaccion().add(accion);
                cuentas.get(i).getEfectivo().add(cantidad);
                cuentas.get(i).getID().add(String.valueOf(contador2));
                break;
            }
        } 
    }
    
    //metodo para verificar si un usuario tiene las 40 cuentas
    public boolean ContadordeCuentas(Long cui){
        byte contador2=0;
        for (int i = 0; i < cuentas.size(); i++) {
            if (Objects.equals(cuentas.get(i).getCUI(), cui)) {
                contador2++;
            }
        }
        return contador2<=41;
    }
    
    //metodo para asignarle a cada CUI un identificador unico
    public ArrayList GuardarCuenta(long cui,String nombre, String apellido){
        
        
        contador++;
        CrearCuenta user =new CrearCuenta();
        //guardando todos los datos necesarios para una cuenta 
        user.Transaccion=new ArrayList();
        user.Efectivo=new ArrayList();
        user.ID=new ArrayList();
        user.hora=new ArrayList();
        user.CUI=cui;
        user.Saldo=0;
        user.Nombre=nombre;
        user.Apellido=apellido;
        //codigo unico para cuenta 
        user.Identificador="D2D025"+(nombre+apellido).length()+contador;
        //agregando la nueva cuenta al arraylist
        cuentas.add(user);
        
        return cuentas;
    }
}