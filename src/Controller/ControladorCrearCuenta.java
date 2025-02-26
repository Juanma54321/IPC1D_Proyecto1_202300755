
package Controller;

import Model.CrearCuenta;
import View.CrearCuentaVista;

public class ControladorCrearCuenta {
    private CrearCuenta model;
    private CrearCuentaVista view;

    public ControladorCrearCuenta(CrearCuenta model, CrearCuentaVista view) {
        this.model = model;
        this.view = view;
   
    }
    
    public void InicializarCuenta(){
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
    
    
    
    
    
    
    
    
}
