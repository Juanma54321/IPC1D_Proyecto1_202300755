
package Model;

public class CrearUsuario {
    public int CUI;
    public String NombreCliente;
    public String ApellidoCliente;
    public int n=0;
    public boolean ConfirmarNoClientes(int numeroDeCuentas){
         return this.n<=6;
    }
}
