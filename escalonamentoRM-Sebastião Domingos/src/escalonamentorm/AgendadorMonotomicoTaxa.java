/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escalonamentorm;
import java.util.List;
import java.util.Comparator;

/**
 *
 * @author domin
 */
public class AgendadorMonotomicoTaxa {
    private List<Tarefa> tarefas;
    private int macro_ciclo;

    public AgendadorMonotomicoTaxa(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
        this.macro_ciclo = calcularMacro_ciclo(tarefas);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public int getMacro_ciclo() {
        return macro_ciclo;
    }

    public void setMacro_ciclo(int macro_ciclo) {
        this.macro_ciclo = macro_ciclo;
    }
    
    private int calcularMaximoDivisorComum(int a, int b) {
        return b == 0 ? a : calcularMaximoDivisorComum(b, a % b);
    }
    
    private int calcularMinimoMultiploComum(int a, int b) {
        return a * (b / calcularMaximoDivisorComum(a, b));
    }
    
    
    private int calcularMacro_ciclo(List<Tarefa> tarefas){
        int hiperPeriodo = 1;
        for( Tarefa tarefa : tarefas){
            hiperPeriodo = calcularMinimoMultiploComum(hiperPeriodo, tarefa.getPeriodo());
        }
        
        return hiperPeriodo;
    }
    
    private Tarefa PegarTarefaComMaiorPrioridade(int tempo){
        tarefas.sort(Comparator.comparingInt(tarefa -> tarefa.getPeriodo()));
        for( Tarefa tarefa : tarefas){
            int modulo_tempo = tempo% tarefa.getPeriodo() ;
            if(modulo_tempo== 0 && tarefa.getTempo_restante() != tarefa.getTempo_de_execucao()){
                tarefa.reiniciar();
            }
            
            if(tarefa.getTempo_restante()>0){
                return tarefa;
            }
        }
        return null;
    }

    private void excutarTarefa(Tarefa tarefa, int tempo){
        tarefa.setTempo_restante(tarefa.getTempo_restante()-1);
        System.out.println("Tempo "+tempo+" : executando a tarefa "+tarefa.getNome());
    }
    
    private void verificarDeadLine(int tempo){
        for(Tarefa tarefa : tarefas){
             int modulo_tempo = tempo% tarefa.getPeriodo() ;
            if(modulo_tempo ==0 && tarefa.getTempo_restante()>0){
                System.out.println("Tempo "+tempo+" : prazo perdido para tarefa "+tarefa.getNome());
            }
        }
    }
    
    public void agendador(){
        for(int tempo =0 ; tempo< this.macro_ciclo ; tempo++){
            Tarefa tarefaAtual = PegarTarefaComMaiorPrioridade(tempo);
            
            if(tarefaAtual != null){
                excutarTarefa(tarefaAtual, tempo);
            }
            verificarDeadLine(tempo);
        }
    }
    
}
