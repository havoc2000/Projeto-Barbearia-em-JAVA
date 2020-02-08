/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import model.Agendamento;
import model.Cliente;
import model.Servico;


public class AgendaHelper implements IHelper{
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
       DefaultTableModel tablemodel = (DefaultTableModel) view.getTableAgendamentos().getModel();
       tablemodel.setNumRows(0);
       
       for(Agendamento agendamento : agendamentos) {
                tablemodel.addRow(new Object[]{
                    agendamento.getId(), agendamento.getCliente().getNome(),
                    agendamento.getServiços().getDescricao(),
                    agendamento.getValor(),
                    agendamento.getDataFormatada(),
                    agendamento.getHoraFormatada(),
                    agendamento.getObservacao()
                });
            }
        
        
    }

    public void preecherClientes(ArrayList<Cliente> clientes) {
      DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        for (Cliente cliente : clientes) {
        comboBoxModel.addElement(cliente);
        }
    
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
     DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
    
        for (Servico servico : servicos) {
        comboBoxModel.addElement(servico);
        }
    
    }
    public Cliente obterCliente() {
    return(Cliente) view.getjComboBoxCliente().getSelectedItem();
    }
    
    
    public Servico obterServico() {
    return(Servico) view.getjComboBoxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
    view.getTextValor().setText(valor+"");
    }

    @Override
    public Agendamento obterModelo() {
    
    String idString = view.getTextId().getText();
    int id = Integer.parseInt(idString);
    Cliente cliente = obterCliente();
    Servico servico = obterServico();
    String valorString = view.getTextValor().getText();
    float valor = Float.parseFloat(valorString);
    String data = view.getTextFormatedData().getText();
    String hora = view.getTextFormatedHora().getText();
    String dataHora = data + " " + hora;
    String observacao = view.getTextObservacao().getText();
    
    Agendamento agendamento = new Agendamento(id,cliente,servico,valor,dataHora,observacao);
    return agendamento;
    }

    @Override
    public void limpaTela() {
        view.getTextId().setText("0");
        view.getTextFormatedData().setText("");
        view.getTextFormatedHora().setText("");
        view.getTextObservacao().setText("");
    }
    
    
}
