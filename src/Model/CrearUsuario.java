
package Model;
import java.util.ArrayList;


public class CrearUsuario {
    public long CUI;
    private String NombreCliente;
    private String ApellidoCliente;
    
    public static ArrayList<CrearUsuario> usuarios = new ArrayList<>();
    
    public long getCUI() {
        return CUI;
    }

    public void setCUI(long CUI) {
        this.CUI = CUI;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getApellidoCliente() {
        return ApellidoCliente;
    }

    public void setApellidoCliente(String ApellidoCliente) {
        this.ApellidoCliente = ApellidoCliente;
    }
    
   //metodo para registrar Usuarios dentro de un arralyst
   public ArrayList GuardarUsuario(long cui, String nombre, String apellido){
       
       CrearUsuario user= new CrearUsuario();
       user.ApellidoCliente=apellido;
       user.CUI=cui;
       user.NombreCliente=nombre;
       
       usuarios.add(user);
       return usuarios;
   }
   //metodo para verificar si el CUI no ha sido usado
   public boolean VerificadorCUI(String cui){
       long n;
       byte v = 0;
       for (int i = 0; i < usuarios.size(); i++) {
           n=usuarios.get(i).getCUI();
           if(n!=Long.parseLong(cui)){
               v++;
           }
       }
       return v==usuarios.size();
   }
   //metodo para verificar la longitud del cui
   public boolean LongitudCUI(String cui){
       return cui.length()==13;
   
   }
}
