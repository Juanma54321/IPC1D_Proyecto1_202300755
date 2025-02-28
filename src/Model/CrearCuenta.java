
package Model;
import java.util.ArrayList;

public class CrearCuenta {
    private String Identificador;
    private int Saldo;
    private Long CUI;
    private String Dueño;
    private static int contador=0;
    
    //array donde estaran todas las cuentas
    public static ArrayList<CrearCuenta> cuentas = new ArrayList<>();
    
    public String getIdentificador() {
        return Identificador;
    }

    public String getDueño() {
        return Dueño;
    }

    public void setDueño(String Dueño) {
        this.Dueño = Dueño;
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

    public Long getCUI() {
        return CUI;
    }

    public void setCUI(Long CUI) {
        this.CUI = CUI;
    }

    
    //metodo para asignarle a cada CUI un identificador unico
    public ArrayList GuardarCuenta(long cui,String dueño){
        contador++;
        CrearCuenta user =new CrearCuenta();
        
        user.CUI=cui;
        user.Saldo=0;
        user.Dueño=dueño;
        user.Identificador="D2D025"+dueño.length()+contador;
        
        cuentas.add(user);
        
        return cuentas;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
