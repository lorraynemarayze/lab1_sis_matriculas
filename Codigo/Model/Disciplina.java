package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Disciplina implements Serializable {
    private int id;
    private String nome;
    private int periodo;
    private int cargaHoraria; 
    private Boolean isAtivo;
    private Professor professor;
    private List<Aluno> alunos;
    

    // Construtor para registro de disciplina via terminal
    public Disciplina(int id, String nome,  int periodo, int cargaHoraria, 
    boolean isAtivo) {
        this.nome = nome;
        this.id = id;
        this.periodo = periodo;
        this.cargaHoraria = cargaHoraria;
        this.alunos = new ArrayList<>();
        this.isAtivo = true; // Por padrão, a disciplina é ativa
        this.professor = null;
    }

    // Construtor para leitura de arquivo
    public Disciplina(String nome, int id, int periodo, int cargaHoraria, Boolean isAtivo, Professor professor, List<Aluno> alunos) {
        this.nome = nome;
        this.id = id;
        this.periodo = periodo;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = alunos;
        this.isAtivo = isAtivo;
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

    public int getId() {
        return id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Boolean isAtivo() {
        return isAtivo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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
