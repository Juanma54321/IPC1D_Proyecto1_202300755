
package Model;
import static Model.CrearCuenta.cuentas;
import java.util.ArrayList;


public class Saldo {
    
    //metodo para depositos
    public ArrayList Deposito(int cantidad,String identificador){
        int SaldoInicial;
        
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getIdentificador().equals(identificador)) {
                
                SaldoInicial=cuentas.get(i).getSaldo();
                SaldoInicial = SaldoInicial + cantidad;
                
                cuentas.get(i).setSaldo(SaldoInicial);
                break;
            }
        }
        return cuentas;
    }
    
    //metodo para retiros
    public ArrayList Retiros(int cantidad,String identificador){
        int SaldoInicial;
        
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getIdentificador().equals(identificador)) {
                
                SaldoInicial=cuentas.get(i).getSaldo();
                SaldoInicial= SaldoInicial-cantidad;
                
                cuentas.get(i).setSaldo(SaldoInicial);
                break;
            }
        }
        return cuentas;
    }
}
