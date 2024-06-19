/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package escalonamentorm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author domin
 */
public class EscalonamentoRM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Tarefa> tarefas = new ArrayList();
        tarefas.add( new Tarefa("A", 4,1));
        tarefas.add( new Tarefa("B", 6,2));
        tarefas.add( new Tarefa("C", 8,3));
        
        AgendadorMonotomicoTaxa agendador = new AgendadorMonotomicoTaxa(tarefas);
        
        agendador.agendador();
        
        
    }
    
}
