
package proyecto1;

import Controller.ControladorLogin;
import Controller.ControladorPrincipal;
import Model.InformacionLogin;
import View.LoginVista;
import View.UserVista;

public class MCV {

    public static void main(String[] args) {
        //llamando al controlador login para iniciar el programa
        InformacionLogin info = new InformacionLogin();
        LoginVista vista1 = new LoginVista();
        ControladorLogin control1= new ControladorLogin(vista1,info);
        
        control1.iniciarLogin();
        vista1.setVisible(true);
    }    
}
