
package proyecto1;

import Controller.ControladorLogin;
import Model.InformacionLogin;
import View.LoginVista;


public class MCV {

    public static void main(String[] args) {
        InformacionLogin info = new InformacionLogin();
        LoginVista vista1 = new LoginVista();
        ControladorLogin control1= new ControladorLogin(vista1,info);
        
        control1.iniciarLogin();
        vista1.setVisible(true);
        
        System.out.println(info.Contrasena);
        
    }    
}
