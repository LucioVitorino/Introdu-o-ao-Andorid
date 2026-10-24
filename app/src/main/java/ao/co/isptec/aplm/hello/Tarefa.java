package ao.co.isptec.aplm.hello;

public class Tarefa {
    private String nome;
    private String prioridade;
    private String dataLimite;
    private boolean concluida;

    public Tarefa(String nome, String prioridade, String dataLimite) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.dataLimite = dataLimite;
        this.concluida = false;
    }

    public String getNome() {
        return nome;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
