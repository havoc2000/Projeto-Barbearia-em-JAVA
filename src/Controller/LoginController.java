/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import model.DAO.UsuarioDAO;
import View.Login;
import View.MenuPrincipal;
import javax.swing.text.View;
import model.Usuario;

/**
 *
 * @author getic2
 */
public class LoginController {
    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNosSistema(){
    Usuario usuario = helper.obterModelo();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
    
    if(usuarioAutenticado != null){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        this.view.dispose();
    }else{
     view.exibeMensagem("Usuario ou senha invalidos");
    }
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do bando de dados");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
