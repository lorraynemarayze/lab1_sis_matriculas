package lab1_sis_matriculas.Codigo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private int qtdeCreditos;
    private List<Disciplina> disciplinas;

    // Construtor
    public Curso(String nome, int qtdeCreditos) {
        this.nome = nome;
        this.qtdeCreditos = qtdeCreditos;
        this.disciplinas = new ArrayList<>();
    }

    // Método para adicionar disciplina ao curso
    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }

    // Método para remover disciplina do curso
    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    // Método para imprimir as disciplinas do curso
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
}
