/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.AgendaHelper;
import model.DAO.AgendamentoDAO;
import model.DAO.ClienteDAO;
import Servico.Correio;
import View.Agenda;
import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.DAO.ServicoDAO;
import model.Servico;


public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        helper.preencherTabela(agendamentos);
    }
    public void atualizaCliente(){
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        helper.preecherClientes(clientes);
    }
    
    public void atualizaServico(){
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
    }
    public void atualizaValor(){
     Servico   servico = helper.obterServico();
     helper.setarValor(servico.getValor());
    
    }
    
    public void agendar(){
    Agendamento agendamento = helper.obterModelo();
    new AgendamentoDAO().insert(agendamento);
    Correio correio = new Correio();
    correio.NotificarPorEmail(agendamento);
    
    atualizaTabela();
    helper.limpaTela();
    
    
    }
}
