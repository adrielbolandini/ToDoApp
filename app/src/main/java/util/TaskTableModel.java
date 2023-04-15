/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author adriel
 */
public class TaskTableModel extends AbstractTableModel{

    String[] columns = {"Nome", "Descricao","Prazo", "Foi Concluido?", "EDITAR", "EXCLUIR"};
    List<Task> tasks = new ArrayList();
    
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public boolean isCellEditable(int i, int i1){
        return i1 == 3;
    }
    
    @Override
    public Class<?> getColumnClass(int i1){
        if (tasks.isEmpty()) {
            return Object.class;
        }
        
        return this.getValueAt(0, i1).getClass();
    }
    
    @Override
    public void setValueAt(Object value, int i, int i1){
        tasks.get(i).setIsCompleted((boolean) value);
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return tasks.get(i).getName();
                
            case 1:
                return tasks.get(i).getDescription();
                
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(i).getDeadline());
                
            case 3:
                return tasks.get(i).getIsCompleted();
             
            case 4:
                return "";
            
            case 5:
                return "";
                
            default:
                return "Dados não encontrados";
        }
    }
    
    @Override
    public String getColumnName(int column){
        return columns[column];
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
}
