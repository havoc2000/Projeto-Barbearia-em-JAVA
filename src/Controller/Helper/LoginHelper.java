/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import View.Login;
import model.Usuario;


/**
 *
 * @author getic2
 */
public class LoginHelper implements IHelper{
    
    private final Login View;

    public LoginHelper(Login View) {
        this.View = View;
    }

   public Usuario obterModelo(){
   String nome = View.getTextUsuario().getText();
    String senha = View.getTextSenha().getText();
    Usuario modelo = new Usuario (0, nome, senha);
    return modelo;
   }
   
   public void setarModelo(Usuario modelo){
       String nome = modelo.getNome();
       String senha = modelo.getSenha();
       
       View.getTextUsuario().setText(nome);
       View.getTextSenha().setText(senha);
   }
   
   public void limpaTela(){
       View.getTextUsuario().setText("");
       View.getTextSenha().setText("");
   }
}
