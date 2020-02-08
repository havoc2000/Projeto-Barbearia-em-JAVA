/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinopc
 */
public class Agendamento {
    
    private int id;
    private Cliente cliente;
    private Servico serviços;
    private float valor;
    private Date data;
    private String observacao;

    public Agendamento(int id, Cliente cliente, Servico serviços, float valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.serviços = serviços;
        this.valor = valor;
        try {
            this.data = new SimpleDateFormat("dd/mm/yyyy hh:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public Agendamento(int id, Cliente cliente, Servico serviços, float valor, String data, String observacao) {
    this(id,cliente,serviços,valor,data);    
    this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServiços() {
        return serviços;
    }

    public void setServiços(Servico serviços) {
        this.serviços = serviços;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public String getHoraFormatada(){
       return new SimpleDateFormat("HH:mm").format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
