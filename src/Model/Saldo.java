
package Model;
import static Model.CrearCuenta.cuentas;

import java.util.ArrayList;
public class Saldo {
    
    //metodo para depositos
    public ArrayList Deposito(float cantidad,String identificador){
        //variables utilizadas para un deposito
        float SaldoInicial;
        String accion="Deposito";
        
        for (int i = 0; i < cuentas.size(); i++) {
            //obteniendo la cuenta con el identificador ingresado
            if (cuentas.get(i).getIdentificador().equals(identificador)) {           
                
                CrearCuenta model= new CrearCuenta();
                //registrando que se esta realizando
                model.Registro(accion, identificador, cantidad);
                //agregando el nuevo slado a la cuenta
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
        //variables utilizadas para un retiro
        float SaldoInicial;
        String accion="Retiro";
        
        for (int i = 0; i < cuentas.size(); i++) {
            //obteniendo la cuenta con el identificador ingresado
            if (cuentas.get(i).getIdentificador().equals(identificador)) {
                
                CrearCuenta model= new CrearCuenta();
                //registrando que se esta realiznado
                model.Registro(accion, identificador, cantidad);
                
                //modificando el saldo
                SaldoInicial=cuentas.get(i).getSaldo();
                SaldoInicial= SaldoInicial-cantidad;
                cuentas.get(i).setSaldo(SaldoInicial);
                break;
            }
        }
        return cuentas;
    }
}
