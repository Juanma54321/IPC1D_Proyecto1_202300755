/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.InformacionLogin;
import View.LoginVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author manum
 */
public class ControladorLogin implements ActionListener {
    private LoginVista vista;
    private InformacionLogin modelo;

    public ControladorLogin(LoginVista vista, InformacionLogin modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.BtnLogin.addActionListener(this);
    }
    
    public void iniciarLogin(){
        vista.setTitle("Inicio de Sesion");
        vista.setLocationRelativeTo(null);
    
    } 
    
    public void actionPerformed(ActionEvent e){
        modelo.setNombreUsuario(vista.UsuarioPrincipal.getText());
        modelo.setContrasena(vista.ContrasenaPrincipal.getText());
        
        
        if (modelo.ConfirmarInformacion(modelo.nombreUsuario, modelo.Contrasena)) {
            vista.ContrasenaPrincipal.setText("hola");
        }
        
    }

    
}
