package lab1_sis_matriculas.Codigo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Disciplina implements Serializable {
    private String nome;
    private String id;
    private int cargaHoraria; 
    private List<Aluno> alunos;
    private Boolean isAtivo;

    // Construtor para registro de disciplina via terminal
    public Disciplina(String nome, String id, int cargaHoraria) {
        this.nome = nome;
        this.id = id;
        this.cargaHoraria = cargaHoraria;
        this.alunos = new ArrayList<>();
        this.isAtivo = true; // Por padrão, a disciplina é ativa
    }

    // Construtor para leitura de arquivo
    public Disciplina(String nome, String id, int cargaHoraria, List<Aluno> alunos, Boolean isAtivo) {
        this.nome = nome;
        this.id = id;
        this.cargaHoraria = cargaHoraria;
        this.alunos = alunos;
        this.isAtivo = isAtivo;
    }

    // Método para adicionar aluno
    public void adicionarAluno(Aluno aluno) {
        if (isAtivo && !alunos.contains(aluno)) {
            alunos.add(aluno);
        }
    }

    // Método para renomear disciplina
    public void renomear(String nome) {
        this.nome = nome;
    }

    // Método para imprimir alunos
    public void imprimirAlunos() {
        if (!alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                System.out.println(aluno); 
            }
        } else {
            System.out.println("Nenhum aluno registrado na disciplina.");
        }
    }

    // Método para verificar ativação (privado)
    private void verificarAtivacao() {
        if (alunos.isEmpty()) {
            this.isAtivo = false;
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Boolean getIsAtivo() {
        return isAtivo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", isAtivo=" + isAtivo +
                ", alunos=" + alunos +
                '}';
    }
}
