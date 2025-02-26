
package Model;
import java.util.ArrayList;

public class CrearCuenta {
    private String Identificador = "D2D025";
    private int Saldo;
    private String Dueño;
    public static ArrayList<String> cuentas = new ArrayList<>();
    private static int contador=0;
    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public int getSaldo() {
        return Saldo;
    }

    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    public String getDueño() {
        return Dueño;
    }

    public void setDueño(String Dueño) {
        this.Dueño = Dueño;
    }

    public ArrayList GuardarCuenta(){
        contador++;
        this.Identificador= Identificador + String.valueOf(contador);
        cuentas.add(this.Identificador);
        return cuentas;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
