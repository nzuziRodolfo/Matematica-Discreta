/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escalonamentorm;

/**
 *
 * @author domin
 */
public class Tarefa {
    private String nome;
    private int periodo;
    private int tempo_de_execucao;
    private int tempo_restante;

    public Tarefa(String nome, int periodo, int tempo_de_execucao) {
        this.nome = nome;
        this.periodo = periodo;
        this.tempo_de_execucao = tempo_de_execucao;
        this.tempo_restante = tempo_de_execucao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getTempo_de_execucao() {
        return tempo_de_execucao;
    }

    public void setTempo_de_execucao(int tempo_de_execucao) {
        this.tempo_de_execucao = tempo_de_execucao;
    }

    public int getTempo_restante() {
        return tempo_restante;
    }

    public void setTempo_restante(int tempo_restante) {
        this.tempo_restante = tempo_restante;
    }
    
    
    public void reiniciar(){
        this.tempo_restante=tempo_de_execucao;
    }
    
    public String imprirInformaoesDaTarefa(){
        String info = "Tarefa : " + getNome()  +""
                + " | período : " + getPeriodo() + " | tempo de execução : " + getTempo_de_execucao() + " | tempo restante : " + getTempo_restante() ;
        return info;
    }
    
}
