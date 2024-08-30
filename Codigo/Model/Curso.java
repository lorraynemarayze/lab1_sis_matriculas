package Model;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private int qtdeCreditos;
    private List<Disciplina> disciplinas;
    private boolean periodoMatricula; 


    // Construtor
    public Curso(int id, String nome, int qtdeCreditos) {
        this.id = id;
        this.nome = nome;
        this.qtdeCreditos = qtdeCreditos;
        this.disciplinas = new ArrayList<>();
        this.periodoMatricula = true; //padrão é true
    }

    // Método para imprimir as disciplinas do curso
    // Mudar pra ToString()
    public void imprimirDisciplinas() {
        if (!disciplinas.isEmpty()) {
            for (Disciplina disciplina : disciplinas) {
                System.out.println(disciplina); 
            }
        } else {
            System.out.println("Nenhuma disciplina cadastrada neste curso.");
        }
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdeCreditos() {
        return qtdeCreditos;
    }

    public void setQtdeCreditos(int qtdeCreditos) {
        this.qtdeCreditos = qtdeCreditos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public boolean isPeriodoMatricula() {
        return periodoMatricula;
    }

    public void setPeriodoMatricula(boolean periodoMatricula) {
        this.periodoMatricula = periodoMatricula;
    }

}
