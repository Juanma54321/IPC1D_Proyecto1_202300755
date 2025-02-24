
package Controller;
import View.CrearUsuarioVista;
import View.UserVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//precionar Boton Registrar Usuario
public class ControladorPrincipal implements ActionListener {
    private UserVista vista2;
    public ControladorPrincipal(UserVista vista1) {
        this.vista2 = vista1;
        this.vista2.btnRegistro.addActionListener(this);
    }
     public void actionPerformed(ActionEvent e){
         vista2.dispose();
         
         CrearUsuarioVista vista3 = new CrearUsuarioVista();
         vista3.setVisible(true);
         
     }
    
}
