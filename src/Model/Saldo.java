
package Model;
import static Model.CrearCuenta.cuentas;

import java.util.ArrayList;
public class Saldo {    
    //metodo para depositos
    public ArrayList Deposito(float cantidad,String identificador){
        float SaldoInicial;
        String accion="Deposito";
        
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getIdentificador().equals(identificador)) {           
                
                CrearCuenta model= new CrearCuenta();
                
                model.Registro(accion, identificador, cantidad);
                
                SaldoInicial=cuentas.get(i).getSaldo();
                SaldoInicial = SaldoInicial + cantidad;
                
                cuentas.get(i).setSaldo(SaldoInicial);
                
                break;
            }
        }
        return cuentas;
    }
    
    //metodo para retiros
    public ArrayList Retiros(float cantidad,String identificador){
        float SaldoInicial;
        String accion="Retiro";
        
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).getIdentificador().equals(identificador)) {
                
                CrearCuenta model= new CrearCuenta();
                
                model.Registro(accion, identificador, cantidad);
                
                
                SaldoInicial=cuentas.get(i).getSaldo();
                SaldoInicial= SaldoInicial-cantidad;
                
                cuentas.get(i).setSaldo(SaldoInicial);
                break;
            }
        }
        return cuentas;
    }
}
