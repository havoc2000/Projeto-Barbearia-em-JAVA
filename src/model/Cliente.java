/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Dinopc
 */
public class Cliente extends Pessoa{
    
    
    private String endereco;
    private String cep;

    public Cliente(int id, String nome, char sexo, String datanascimento, String telefone, String email, String rg, String endereco, String cep) {
        super(id, nome, sexo, datanascimento, telefone, email, rg);
        this.endereco = endereco;
        this.cep = cep;
    }

    /**
     *
     * @param id
     * @param nome
     * @param endereco
     * @param cep
     */
    public Cliente(int id, String nome, String endereco, String cep) {
        super(id, nome);
        this.endereco = endereco;
        this.cep = cep;
    }

    
    
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString(){
       return getNome(); 
    }
    
    
}
